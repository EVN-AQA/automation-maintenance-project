@Regression @register
Feature: Register Page
  As a user
  I want to see all Register page elements
  So that I can verify Register page works well

  Background:
    Given I open the home page of DemoWebShop website
    When I click the register hyperlink on Header page

  Scenario:  MP0012	Register - Verify register form of register page
    Then I verify the register form of register page is displayed

  Scenario Outline: MP0013	Register - Verify error when enter not match passwords in register page
    When I input values with not match passwords in the register form
    When I click on Register button
    Then I verify the error message "<Expected message>" when passwords not match
    Examples:
      | Expected message                                     |
      | The password and confirmation password do not match. |

  Scenario: MP0014	Register - Verify register successfully
    When I input valid values in the register form
    When I click on Register button
    Then I verify registration successful