@Regression
Feature: Create user

  Scenario Outline: TC03 - Create user - Verify get user info successfully
    When I create user with password as <password>
    Then I verify create user successfully
    Examples:
      | password |
      | Thao@123 |

  Scenario Outline: TC04 - Create user - Verify get user info failed with invalid password
    When I create user with password as <password>
    Then I verify create user failed with invalid password
    Examples:
      | password    |
      | invalidPass |
