package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C://Users//david//IdeaProjects//Test2//src//test//java//Resources//test.feature",
                 glue = "stepDefinitions",
                 tags="@Smoketest and @Integrationtest")

public class testRunner {

}
