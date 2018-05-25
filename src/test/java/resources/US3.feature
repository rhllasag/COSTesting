Feature: Access to the Contact Details Page
  As a user
  I want to access to filter contacts by Source Facebook or Linkedin
  So, selecting disconnected or connected option the correct contacts appear

  @noerror
  Scenario: Available filtering options
    Given I access the landing page without saved data
    Then The filtering options should be "Facebook" and "LinkedIn"

  @noerror
  Scenario: The columns of the filtering table
    Given I access the landing page without saved data
    Then The names of the columns of the filtering table are "ID", "Name", "Email", "Actions" and "Source"

  @noerror
  Scenario: The Solve Duplicated Button go to the Solve Duplicated Page
    Given I access the landing page without saved data
    When I click the Solve Duplicated Button
    Then I access the Solve Duplicated Page

  @noerror
  Scenario Outline: Enable only one toggle option switching the options
    Given I access the landing page without saved data
    When  I choose disable the "<disabledFilter>" filter to show contacts with "<expectedText>" on source field
    Then In all the rows the source column should have only  the text "<expectedText>"
    Examples:
      | disabledFilter | expectedText |
      | LinkedIn    | Facebook   |
      | Facebook    | LinkedIn  |

  @noerror
  Scenario: Enable both toggles
    Given I access the landing page without saved data
    Then In all the rows the source column can have the text "Facebook" or "LinkedIn"

  @noerror
  Scenario: Disable both toggles options
    Given I access the landing page without saved data
    When  I disable the filtering options of the switches
    Then the table will have the value "No contacts found"

  @noerror
  Scenario Outline: Enable only one filtering option by clicking the text
    Given I access the landing page without saved data
    When  I click the  text "<option>"
    Then In all the rows the source column should have only  the text "<expectedText>"
    Examples:
      | option | expectedText |
      | Facebook  | Facebook   |
      | LinkedIn | LinkedIn   |

  @noerror
  Scenario Outline: Disable on toggle and click on the text link
    Given I access the landing page without saved data
    When I choose disable the "<disabledFilter>" filter to show contacts with "<expectedText>" on source field
    And I click the  text "<option>"
    Then In all the rows the source column should have only  the text "<option>"
    Examples:
      | disabledFilter | expectedText| option |
      | Facebook  | LinkedIn    | Facebook   |
      | LinkedIn |   Facebook     |LinkedIn   |


  @noerror
  Scenario Outline: Count the contacts after filtering
    Given I access the landing page without saved data
    When  I choose disable the "<disabledFilter>" filter to show contacts with "<expectedText>" on source field
    Then The number of table rows should be the same as the field "num-contacts"
    Examples:
      | disabledFilter | expectedText|
      | Facebook  | LinkedIn    |
      | LinkedIn |   Facebook  |

  @noerror
  Scenario Outline: Save the filtering options
    Given I access the landing page without saved data
    When  I click the  text "<option>"
    And I access the landing page again
    Then In all the rows the source column should have only  the text "<expectedText>"
    Examples:
      | option | expectedText |
      | Facebook  | Facebook   |
      | LinkedIn | LinkedIn   |
