Feature:  all login scenario

  Background: open the browser
  #  Given open the browser
   # And I maximixe it

  @login @valid
  Scenario: to test the functionality of login button for valid input
    Given I am on login page
 #   When I enter correct username and password
    When I enter username as "admin" and password as "admin"
    And I click on login button
    Then I should be redirected to home page

  @login @invalid
  Scenario: to test the functionality of login button for invalid input
    Given I am on login page
  #  When I enter incorrect username and password
    When I enter username as "dsdsd" and password as "ddsds"
    And I click on login button
    Then I should get an error

  @login @invalid
  Scenario: to test the functionality of login button for blank input
    Given I am on login page
  #  When I enter blank username and password
    When I enter username as "" and password as ""
    And I click on login button
    Then I should get an error


    @DataTableParam1
    Scenario: to test the functionality pf submit button on contact us form
      Given I am on contact us page
      When I enter below data
        | 898989898 | amol@gmail.com | hi amol |
      And I click on submit button


  @DataTableParam2
  Scenario Outline: to test the functionality pf submit button on contact us form
    Given I am on contact us page
    When I enter <number> , <email> ,<msg>
    And I click on submit button
    Examples:
      | number     | email            | msg            |
      | 1234567890 | amol@gmail.com   | hi i am amol   |
      | 0987654321 | saloni@gmail.com | hi i am saloni |
      | 1478523069 | pratik@gmail.com | hi i am pratik |


    @addCustomer
    Scenario Outline: to test the add button on add customer page for multiple data set
      Given I am logged in with valid credentials
      And I go to add customer page
      When I add this data <name> , <address> , <contact1> , <contact2>
      And I click on add button
      Examples:
        | name          | address               | contact1 | contact2 |
        | Alice Johnson | 123 Maple Street, NY  | 5550100  | 5550101  |
        | Bob Smith     | 456 Oak Avenue, CA    | 5550200  | 5550201  |
        | Clara Davis   | 789 Pine Road, TX     | 5550300  | 5550301  |
        | David Wilson  | 321 Elm Boulevard, FL | 5550400  | 5550401  |