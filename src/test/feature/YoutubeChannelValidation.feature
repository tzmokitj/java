@UATTest
Feature: Youtube channel name validation
  Scenario: Youtube channel name validations
    Given Open Chrome browser with URL
    When Search gameranxtv
    And Click on channel name
    Then Validate channel name

