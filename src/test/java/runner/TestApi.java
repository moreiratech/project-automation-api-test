package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        glue = {"steps"},
        plugin = {"pretty",
                "html:target/html/cucumber.html",
                "json:target/cucumber-report/cucumber.json"},
        monochrome = true,
        strict = true,
        stepNotifications = true,
        tags = "@all"
)
public class TestApi {

}


