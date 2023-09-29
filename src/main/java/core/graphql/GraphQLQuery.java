package core.graphql;

public class GraphQLQuery extends GraphQLCommand {
    protected GraphQLQuery() {
        setCommandType(GraphQLCommandType.QUERY);
    }

    @Override
    public String build() {
        return null;
    }
}
