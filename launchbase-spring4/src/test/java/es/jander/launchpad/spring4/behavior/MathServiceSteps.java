package es.jander.launchpad.spring4.behavior;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class MathServiceSteps extends SpringTestConfig {

  int result;

  @When("^I run the math operation (-?\\d+) plus (-?\\d+)$")
  public void addition(int a, int b) {
     result = mathService.add(a, b);
  }

  @Then("^the math operation result must be (-?\\d+)$")
  public void checkResult(int expected) {
    assertThat(result).isEqualTo(expected);
  }
}
