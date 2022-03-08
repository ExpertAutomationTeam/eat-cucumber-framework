Feature: login feature

  Background:
    Given user opens browser and navigates to "https://classic.freecrm.com/login.cfm"
    When user is on login page with title "CRMPRO Log In Screen"

  @Positive @Smoke @Regression
  Scenario: user logs in to the appication succefully
    Then user enters username "jacksp"
    And user enters password "test123"
    And user clicks on login button
    Then user should be logged to the application "CRMPRO : Upgrade to Pro Account"

  @Regression @E2E
  Scenario Outline: user logs in with invalid credentials
    Then user enters username "<username>"
    And user enters password "<password>"
    And user clicks on login button
    Then user should not be logged to the application and stays on the same page "Free CRM - CRM software for customer relationship management, sales, and support."

    Examples:
      | username  | password  |
      | incorrect | incorrect |
      | jacksp    | incorrect |
      | incorrect | test123   |