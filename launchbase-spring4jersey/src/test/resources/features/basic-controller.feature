Feature: Basic controller is available and responds to requests
  Scenario: Service responds to basic get requests
    When I send a GET request to /basic
    Then the response has status code 200
  Scenario: Get the application name
    When I send a GET request to /basic/name
    Then the response has status code 200
    And the response path content has value spring4jersey
