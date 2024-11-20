package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature"
, glue = "stepdefinition"
        , tags = "@addCustomer"
)
public class TestRunner {
}
