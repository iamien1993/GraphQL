package core.graphql.model.components.variables.filter;

import core.graphql.model.components.variables.Variable;

public class FilterInput implements Variable, Filterable {
    String filter;

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    @Override
    public String convertToString() {
        return filter;
    }
}
