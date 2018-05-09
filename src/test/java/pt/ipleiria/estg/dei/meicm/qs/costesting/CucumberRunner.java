package pt.ipleiria.estg.dei.meicm.qs.costesting;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:reports/test-report"},
features = "src/test/java/resources" )
public class CucumberRunner { }
