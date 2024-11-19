Feature:  all login scenario

  Scenario: to test the functionality of login button for valid input
    Given I am on login page
 #   When I enter correct username and password
    When I enter username as "admin" and password as "admin"
    And I click on login button
    Then I should be redirected to home page

  Scenario: to test the functionality of login button for invalid input
    Given I am on login page
  #  When I enter incorrect username and password
    When I enter username as "dsdsd" and password as "ddsds"
    And I click on login button
    Then I should get an error

  Scenario: to test the functionality of login button for blank input
    Given I am on login page
  #  When I enter blank username and password
    When I enter username as "" and password as ""
    And I click on login button
    Then I should get an error