package core.graphql.model.components.variables.filter;

import core.graphql.model.components.variables.Variable;

public class FilterJson implements Variable, Filterable {
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
