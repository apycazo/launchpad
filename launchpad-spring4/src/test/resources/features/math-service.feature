Feature: A simple math service is instanced and provides basic operations
  Scenario Outline: I want to add two numbers
    When I run the math operation <a> plus <b>
    Then the math operation result must be <result>
    Examples:
    | a  | b  | result |
    | 5  | 4  | 9      |
    | 5  | -4 | 1      |
    | -5 | 4  | -1     |
    | -5 | -4 | -9     |
