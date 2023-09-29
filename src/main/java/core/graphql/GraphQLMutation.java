package core.graphql;

import core.graphql.model.CommandResultTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphQLMutation extends GraphQLCommand {
    protected List<CommandResultTypes> commandResultTypes;
    protected GraphQLMutation() {
        setCommandType(GraphQLCommandType.MUTATION);
        commandResultTypes = new ArrayList<>();
    }

    protected void setCommandResultTypes(CommandResultTypes...types) {
        commandResultTypes.addAll(Arrays.asList(types));
    }

    @Override
    public String build() {
        return null;
    }
}
