@UATTest
  Feature: Youtube successfull login
    Scenario: Loging into your youtube account
  Given Open Chrome browser with URL
  When click on sign in button
  And click on suggested logged out user
  And provide password, click next
  Then user should be logged in
