@Regression
Feature: Book

  Scenario: TC05 - Get list of book - Verify get list of books successfully
    When I get list of books
    Then I verify get list of book successfully

  Scenario Outline: TC06 - Add list of books - Verify add list of books successfully
    Given I create user with password as <password>
    And I verify create user successfully
    And I generate token
    And I verify generate token successfully
    And I get list of books
    And I verify get list of book successfully
    When I add a book to a collection
    Then I verify add book to a collection successfully

    Examples:
      | password |
      | Thao@123 |

  Scenario Outline: TC07 - Add list of books - Verify error display when miss token
    Given I create user with password as <password>
    And I verify create user successfully
    And I get list of books
    And I verify get list of book successfully
    When I add a book to a collection
    Then I verify error user not authorized display

    Examples:
      | password |
      | Thao@123 |