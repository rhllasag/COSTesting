Feature: Access to the Contact Details Page
  As a user
  I want to access to filter contacts by Source Facebook or Linkedin
  So, selecting disconnected or connected option the correct contacts appear

  @noerror
  Scenario: Landing page's title
    Given I access the landing page of COS
    Then the title of the page should be "Contacts Orchestrator Solution"

  @noerror
  Scenario: Disconnected and connected filtering options
    Given I access the landing page of COS
    Then The filtering options should be "Facebook" and "Linkedin"

  @noerror
  Scenario: The columns of the filtering table
    Given I access the landing page of COS
    Then The names of the columns of the filtering table are "ID", "Name", "Email", "Action" and "Source"

  @noerror
  Scenario Outline: Enable only filtering Facebook option
    Given I access the landing page of COS
    When  I enable the filtering "<enableFilter>" option and disable "<disabledFilter>" option
    Then In all the rows, the source column should have only  the text "<expectedText>"
    Examples:
    | enableFilter | disabledFilter | expectedText |
    | "Facebook"   | "Linkedin"     | "Facebook"   |
    | "Linkedin"   | "Facebook"     | "Linkedin"   |

  @noerror
  Scenario: Disable filtering options
    Given I access the landing page of COS
    When  I disable the filtering options
    Then the table will have no data
  @noerror
  Scenario: Enable the two filtering options
    Given I access the landing page of COS
    When  I enable the two filtering options
    Then The number of table rows should match the number of contacts shown on the field "num-contacts"


