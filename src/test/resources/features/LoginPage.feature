@smoke
Feature: User should be able to log in

  Background:
    Given user is on the login page

  Scenario: Login as a user
    When user log-in
    Then user should be able to log-in to the "WordPress.com"