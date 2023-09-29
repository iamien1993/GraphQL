package core.graphql.service;

import core.graphql.GraphQLCommand;
import io.restassured.response.Response;

public interface IGraphQLService {
    Response sendRequest(GraphQLCommand graphQLCommand);
}
