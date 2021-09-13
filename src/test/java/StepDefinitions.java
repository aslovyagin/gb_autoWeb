import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefinitions {
    @After
    public void after() {
        Selenide.closeWebDriver();
    }

    @Before
    public void setBrowser() {
        //Configuration.browser = "safari";
        //Configuration.timeout = 10000;
        //Configuration.headless = true;
        //not supporteed in safari
    }
}