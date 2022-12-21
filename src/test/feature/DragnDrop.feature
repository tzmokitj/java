@UATTesting1
Feature: Drag and Drop
  Scenario: Few elements are dragged and dropped and then verify the message is displayed or not
    Given  Open a chrome browser and enter demo guru url
    When dragging and dropping elements
    Then verifying if it was successfull