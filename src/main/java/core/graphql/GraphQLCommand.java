package core.graphql;

public abstract class GraphQLCommand {
    protected enum GraphQLCommandType {QUERY, MUTATION}
    protected String commandType;
    protected String commandName;
    protected String operationName;
    protected void setCommandType(GraphQLCommandType graphQLCommandType) {
        if (graphQLCommandType.equals(GraphQLCommandType.QUERY)) {
            this.commandType = "query";
        }

        if (graphQLCommandType.equals(GraphQLCommandType.MUTATION)) {
            this.commandType = "mutation";
        }
    }

    public String getCommandType() {
        return commandType;
    }

    protected void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    protected String getOperationName() {
        return operationName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

    public abstract String build();
}
