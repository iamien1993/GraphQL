package core.graphql.model.components;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import core.graphql.model.components.variables.*;
import core.graphql.model.components.variables.filter.Filterable;
import core.graphql.model.components.variables.filter.JsonFilterable;
import core.graphql.model.components.variables.page.Paginateable;
import core.graphql.model.components.variables.sort.Sortable;

public class Variables {
    @JsonProperty("filter")
    private Variable filter;
    @JsonProperty("sort")
    private Variable sort;
    @JsonProperty("page")
    private Variable page;
    @JsonProperty("filterJson")
    private Variable filterJson;

    public Variables() {}

    private Variables(VariablesBuilder builder) {
        setFilter(builder.filter);
        setPage(builder.page);
        setSort(builder.sort);
        setFilterJson(builder.filterJson);
    }

    public String getFilter() {
        if (filter == null) {
            return null;
        } else return filter.convertToString();
    }

    @JsonIgnore
    public Variable getFilterObject() {
        return this.filter;
    }

    public void setFilter(Filterable filter) {
        this.filter = (Variable) filter;
    }

    public String getSort() {
        if (sort == null) {
            return null;
        } else return sort.convertToString();
    }

    @JsonIgnore
    public Variable getSortObject() {
        return this.sort;
    }

    public void setSort(Sortable sort) {
        this.sort = (Variable) sort;
    }

    public String getPage() {
        if (page == null) {
            return null;
        } else return page.convertToString();
    }

    @JsonIgnore
    public Variable getPageObject() {
        return this.page;
    }

    public void setPage(Paginateable page) {
        this.page = (Variable) page;
    }

    public String getFilterJson() {
        if (filterJson == null) {
            return null;
        } else return filterJson.convertToString();
    }

    @JsonIgnore
    public Variable getFilterJsonObject() {
        return this.filterJson;
    }

    public void setFilterJson(JsonFilterable filterJson) {
        this.filterJson = (Variable) filterJson;
    }

    public static VariablesBuilder builder() {
        return new VariablesBuilder();
    }

    public static class VariablesBuilder {
        private Filterable filter;
        private Sortable sort;
        private Paginateable page;
        private JsonFilterable filterJson;

        public VariablesBuilder withFilter(Filterable filter) {
            this.filter = filter;

            return this;
        }

        public VariablesBuilder withSort(Sortable sort) {
            this.sort = sort;

            return this;
        }

        public VariablesBuilder withPage(Paginateable page) {
            this.page = page;

            return this;
        }

        public VariablesBuilder withFilterJson(JsonFilterable filterJson) {
            this.filterJson = filterJson;

            return this;
        }

        public Variables build() {
            return new Variables(this);
        }
    }
}
