@UATTesting6
Feature: Kitchen file picker
  Scenario: Uploading a file
    Given Open a Chrome browser with URL
    When upload a jpg file to website
    Then image is being displayed
