import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"StepDefinition"},
        tags = "@Sprint-1",
        // Due to my cucumber config, use following:
        // "and" -> TC with both tags
        // "or" -> TC with one or other tag
        // "not" -> TC with one tag but not other
        // Documentation: https://cucumber.io/docs/cucumber/api/#tags
        plugin = {"pretty", "html:reports/default.html"}

        /*
          Terminal command for tags and property file:
              mvn clean test -Dcucumber.options="--tags @tag1,@tag2"
              mvn clean test -Dcucumber.options="--tags @tag1" -DrunOn=sauce
              mvn clean test -Dcucumber.options="--tags @tag1" -DrunOn=local

              Remember, if u forget to set browser version to latest in properties, firefox won't work on sauce labs
       */
)

public class TestRunner {
}