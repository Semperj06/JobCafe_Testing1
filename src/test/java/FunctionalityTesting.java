import Pages.FindJob_Page;
import Pages.LoginRegister_Page;
import Pages.PostJob_Page;
import Tools.TestRunner;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class FunctionalityTesting extends TestRunner {

    private static LoginRegister_Page homePage;
    @BeforeAll
    public static void classSetUp(){TestRunner.setupMain();}

    @AfterAll
    public static void classCancel(){
        CloseDriver();
    }
    @ParameterizedTest
    @ValueSource(strings = {"QA", "Developer", "Project Manager"})
    public void FindtJobTesting1(String position){
        LoginRegister_Page.NavigateToHome_Page();
        FindJob_Page.NavigateToJOB_Page();
        FindJob_Page.Position_EditBox(position);
        LogsTest();
    }
    @ParameterizedTest
    @ValueSource(strings = {"Toronto", "Tel-Aviv", "Chicago", "New-York"})
    public void FindtJobTesting2(String location){
        LoginRegister_Page.NavigateToHome_Page();
        FindJob_Page.NavigateToJOB_Page();
        FindJob_Page.Location_EditBox(location);
        LogsTest();
    }
    @ParameterizedTest
    @ValueSource(strings = {"Apple", "Facebook", "Google"})
    public void FindtJobTesting3(String company){
        LoginRegister_Page.NavigateToHome_Page();
        FindJob_Page.NavigateToJOB_Page();
        FindJob_Page.Company_EditBox(company);
        LogsTest();
    }
    @Test
    public void FindtJobTestingFunctional(){
        LoginRegister_Page.NavigateToHome_Page();
        FindJob_Page.NavigateToJOB_Page();
        FindJob_Page.FunctionalTesting("Project Manager", "Google", "USA");
        LogsTest();
    }
    @Test
    public void FindtJobTestingFunctionalNegative(){
        LoginRegister_Page.NavigateToHome_Page();
        FindJob_Page.NavigateToJOB_Page();
        FindJob_Page.FunctionalTesting("<>?<>", ".", "4");
        FindJob_Page.FunctionalTesting("634634643634", "6346346", "64356");
        FindJob_Page.FunctionalTesting("реав", "оп", "оа");
        FindJob_Page.FunctionalTesting("", "weqdqwzd", "wrewqeqw");
        LogsTest();
    }
    @Test
    public void FindtJobTestingReset(){
        LoginRegister_Page.NavigateToHome_Page();
        FindJob_Page.NavigateToJOB_Page();
        FindJob_Page.FunctionalTesting("<>?<>", ".", "4");
        FindJob_Page.Reset();
        LogsTest();
    }


    @Test
    public void PostJobTesting(){
        PostJob_Page.NavigateToPostJob_Page();
        TestRunner.LogsTest();
    }
    @Test
    public void Login_Register() {
        LoginRegister_Page.NavigateToHome_Page();
        TestRunner.LogsTest();
        LoginRegister_Page.VerifyIMGHome_Page();
      }
    @ParameterizedTest
    @MethodSource("provideData")
    public void testErrorMessage(String search, String location) {
        LoginRegister_Page.NavigateToHome_Page();
        LoginRegister_Page.NegativeTesting_EditBox(search, location);
        TestRunner.LogsTest();
    }

    private static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of("true", "true"),
                Arguments.of("", "true"),
                Arguments.of("email@qwe.com", ""),
                Arguments.of("email@qwe.com", "123456"),
                Arguments.of("><?>?<><>?", "><?<>?<>"),
                Arguments.of("email@qwe.com", ""),
                Arguments.of("", "asdzxc74@@@"),
                Arguments.of("email@qwe.com", "ujsdfahkfuydsvgbjkcnhkasdhckajhsbfkabencbasjhcbjhsabejhcbasebcjhasbfdjeancjknqaecbfhehjkasbfjhdkbasjfbneascjnbeascjbheasbfbasjbcbncbaskj"),
                Arguments.of("ujsdfahkfuydsvgbjkcnhkasdhckajhsbfkabencbasjhcbjhsabejhcbasebcjhasbfdjeancjknqaecbfhehjkasbfjhdkbasjfbneascjnbeascjbheasbfbasjbcbncbaskj", "asdzxc74@")
        );
    }

}

