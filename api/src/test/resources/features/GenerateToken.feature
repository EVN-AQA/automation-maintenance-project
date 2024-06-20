@Regression
Feature: Generate token

  Scenario Outline: TC01 - Generate token - Verify token generate successfully
    When I generate token with username as <username> and password as <password>
    Then I verify generate token successfully
    Examples:
      | username | password |
      | ThaoNgo  | thao@123 |

  Scenario Outline: TC02 - Generate token - Verify token generate failed
    When I generate token with username as <username> and password as <password>
    Then I verify generate token failed
    Examples:
      | username        | password        |
      | InvalidUsername | ThaoNgo@123     |
      | ThaoNgo         | InvalidPassword |
