package core.graphql.model.components.variables.sort;

import com.fasterxml.jackson.annotation.JsonProperty;
import core.graphql.model.components.variables.Variable;

public class FieldSortInput implements Variable, Sortable {
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
