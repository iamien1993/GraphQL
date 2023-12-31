package service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Map;

public class SerializationUtil {
    public static final ObjectMapper OBJECT_MAPPER = buildObjectMapper();
    public static final ObjectMapper MAPPER = new ObjectMapper();

    private SerializationUtil() {}

    public static <T> T asObject(String stringJson, Class<?> parametrized, Class<?>... parameterClasses) {
        OBJECT_MAPPER.findAndRegisterModules();

        JavaType type = OBJECT_MAPPER.getTypeFactory().constructParametricType(parametrized, parameterClasses);
        try {
            return OBJECT_MAPPER.readValue(stringJson, type);
        } catch (IOException e) {
            throw new RuntimeException("Error translating string to object: " + stringJson, e);
        }
    }

    public static <T> T asObject(String stringJson, Class<T> targetClass) {
        OBJECT_MAPPER.findAndRegisterModules();
        try {
            return OBJECT_MAPPER.readValue(stringJson, targetClass);
        } catch (IOException e) {
            System.out.println("Deserialization Error: " + e.getMessage());
            throw new RuntimeException("Error translating string to object: " + stringJson, e);
        }
    }

    public static Map<String, String> asMap(Object object) {
        try {
            OBJECT_MAPPER.findAndRegisterModules();
            return OBJECT_MAPPER.convertValue(object, Map.class);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error converting object properties to a map.", e);

        }
    }

    public static String asJsonString(Object object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error translating object to string.", e);
        }
    }

    public static <T> T asObjectFrom(String jsonPath, Class<T> targetClass) {
        OBJECT_MAPPER.findAndRegisterModules();
        try {
            URL jsonFile = SerializationUtil.class.getClassLoader().getResource(jsonPath);
            return OBJECT_MAPPER.readValue(Paths.get(jsonFile.toURI()).toFile(), targetClass);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Error translating json from file to object.", e);
        }
    }

    public static JsonNode asJsonNodeFromString(String json) {
        try {
            return OBJECT_MAPPER.readTree(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error translating json from string to jsonNode.", e);
        }
    }

    public static <T> T asObjectFromJsonNode(JsonNode node, Class<T> targetClass) {
        try {
            return OBJECT_MAPPER.treeToValue(node, targetClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error translating JsonNode from jsonNode.", e);
        }
    }

    public static String addParentNodeToJson(Map<String, Object> addItemsNode) {
        return SerializationUtil.asJsonString(addItemsNode);
    }

    private static ObjectMapper buildObjectMapper() {
        boolean includeFlag = false;
        JsonInclude.Include includeRule;

        if (includeFlag) {
            includeRule = JsonInclude.Include.ALWAYS;
        } else includeRule = JsonInclude.Include.NON_NULL;

        var mapper = JsonMapper.builder()
                .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
                .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .build()
                .setDefaultPropertyInclusion(includeRule);






        return mapper.registerModule(new JodaModule());
    }

    public static Map<String, ?> convertQueryParams(Object queryParams) {
        return (Map<String, ?>) MAPPER.convertValue(queryParams, new TypeReference<>() {
        });
    }

    public static void changeObjectMapperConfiguration(DeserializationFeature feature, boolean state) {
        OBJECT_MAPPER.configure(feature, state);
    }
}
