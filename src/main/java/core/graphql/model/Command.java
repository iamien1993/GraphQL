package core.graphql.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import core.graphql.model.components.Variables;

import java.util.Objects;

public class Command {
    @JsonProperty("operationName")
    private String operationName;
    @JsonProperty("variables")
    private Variables variables;
    @JsonProperty("query")
    private String query;

    public Command() {}

    private Command(CommandBuilder builder) {
        setQuery(builder.query);
        setOperationName(builder.operationName);

        setVariables(Objects.requireNonNullElseGet(builder.variables, Variables::new));
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public Variables getVariables() {
        return variables;
    }

    public void setVariables(Variables variables) {
        this.variables = variables;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public static CommandBuilder builder() {
        return new CommandBuilder();
    }
    public static class CommandBuilder {
        private String operationName;
        private Variables variables;
        private String query;

        public CommandBuilder withOperationName(String operationName) {
            this.operationName = operationName;

            return this;
        }

        public CommandBuilder withVariables(Variables variables) {
            this.variables = variables;

            return this;
        }

        public CommandBuilder withVariables(Variables.VariablesBuilder variables) {
            this.variables = variables.build();

            return this;
        }

        public CommandBuilder withQuery(String query) {
            this.query = query;

            return this;
        }

        public Command build() {
            return new Command(this);
        }
    }

}
