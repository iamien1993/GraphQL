package core.graphql.model;

public enum CommandResultTypes {
    SUCCESS("isSuccess"),
    PAYLOAD("payload"),
    VALIDATION_FAILURES("""
            validationFailures {
                message
                validationFailures {
                    message
                }
            }"""
    ),
    EXCEPTION("""
            exception {
                message
                innerException {
                    message
                }
            }""");

    private final String commandResultType;

    CommandResultTypes(String commandResultType) {
        this.commandResultType = commandResultType;
    }

    @Override
    public String toString() {
        return commandResultType;
    }

}
