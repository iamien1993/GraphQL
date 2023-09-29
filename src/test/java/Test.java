import core.graphql.model.Command;
import core.graphql.model.components.Variables;
import core.graphql.model.components.variables.Variable;
import core.graphql.model.components.variables.filter.FilterInput;
import core.graphql.model.components.variables.page.PageInfoInput;
import service.SerializationUtil;

public class Test {
    @org.testng.annotations.Test
    public void test() {
        FilterInput filter = new FilterInput();
        filter.setFilter("1");
        PageInfoInput page = new PageInfoInput();
        page.setValue("2");

        Command model = Command.builder()
                .withOperationName("test")
                .withQuery("Query is here")
                .withVariables(
                        Variables.builder()
                            .withFilter(filter)
                            .withPage(page)
                ).build();

        System.out.println(SerializationUtil.asJsonString(model));
    }

    @org.testng.annotations.Test
    public void test2() {

    }

}
