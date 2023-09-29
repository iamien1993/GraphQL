package core.graphql.model.components.variables.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import core.graphql.model.components.variables.Variable;

public class PageInfoInput implements Variable, Paginateable {
    @JsonProperty
    String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String convertToString() {
        return value;
    }
}
