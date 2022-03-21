@smoke
Feature: User should be able to use and make changes in My Profile page

  Background:
    Given user is on the login page
    When user log-in

  Scenario:
    When user click My Profile button
    Then user is on the "My Profile — WordPress.com" page


  Scenario:
    Given user is on the My Profile page
    When user update first name to "Fhilipp" and last name to "Dyatlov"
    And user submit changes with Save profile details button
    Then user verify that changes was successful by seeing popup text "Settings saved successfully!"


    Scenario:
      Given user is on the My Profile page
      When user click Add button and click add URL button
      And user add URL "https://github.com/44chan" and description "Hello this is my GitHub" to the fields
      And user click Add Site button
      Then user verify that changes was successful by seeing description "Hello this is my GitHub"

