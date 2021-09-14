import com.codeborne.selenide.Selenide;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.*;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

import static com.codeborne.selenide.Selenide.screenshot;


@RunWith(Cucumber.class)
public class StepDefinitions {

    @After
    public void after(Scenario s) {
        if(s.isFailed()) screenshot("fail");
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