Feature: As a User I should able to create teacher
  @smoke
  Scenario: As a User I should able to create teacher
    Given User is on home school page
    Then user navigate to teacher module
    Then user clicks on button to create teacher
    Then user fill out all information about teacher
    Then user clicks on button submit to submit teacher info
    Then verifying that teacher's info matching database info
