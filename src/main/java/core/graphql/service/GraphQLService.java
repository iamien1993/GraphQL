package core.graphql.service;

import core.graphql.GraphQLCommand;
import io.restassured.response.Response;

import java.util.Map;

public class GraphQLService implements IGraphQLService {
    protected String domain;
    protected String path;
    protected Map<String, String> headers;

    public Response sendRequest(GraphQLCommand graphQLCommand) {
        graphQLCommand.build();
        return null;
    }
}
