package es.jander.launchpad.spring4.behavior;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/", plugin = {"pretty"}, monochrome = true)
public class BehaviorTests {
  // any junit @BeforeClass or such can be put in here
}
