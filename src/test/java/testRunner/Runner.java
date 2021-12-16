package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features =".//Features/Customers.feature",
				 glue = "stepDefinitions",
    			 tags= "@AddCustomer or ~@SearchCustomers",
				 dryRun = false,
				 monochrome=true,
				 plugin = {"pretty","html:target/cucumber-reports"}
		
		)

public class Runner {
}
