@UATTest
  Feature: Youtube Search validations
    Scenario: Youtube search and page settings scenario
      Given Open chrome browser and enter url
      When Enter search criteria
      Then Click on search button
      Then click on first link
      Then enter fullscreen, turn subtitles
      Then select info and click on official video
