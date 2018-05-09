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
  Scenario Outline: Enable only one filtering option
    Given I access the landing page of COS
    When  I choose the filtering "<enableFilter>" option and choose "<disabledFilter>" option
    Then In all the rows, the source column should have only  the text "<expectedText>"
    Examples:
    | enableFilter | disabledFilter | expectedText |
    | "Facebook"   | "Linkedin"     | "Facebook"   |
    | "Linkedin"   | "Facebook"     | "Linkedin"   |

  @noerror
  Scenario : Enable two filtering option
    Given I access the landing page of COS
    When  I enable the two filtering options
    Then In all the rows, the source column should have the text "Facebook" or "Linkedin"

  @noerror
  Scenario: Disable filtering options
    Given I access the landing page of COS
    When  I disable the filtering options
    Then the table will have no data
  @noerror
  Scenario: Count the contacts when I enable the two filtering options
    Given I access the landing page of COS
    When  I enable the two filtering options
    Then The number of table rows should match the number of contacts shown on the field "num-contacts"
  @noerror
  Scenario Outline: Click on the details button by id
    Given I access the landing page of COS
    When  I choose the filtering "<enableFilter>" option and choose "<disabledFilter>" option and click on the detail button with "<id>"
    Then Details Page should have "<Source>" on the twelveth row and the <"id"> in the firt one
    Examples:
      | enableFilter | disabledFilter | Source | id|
      | "Facebook"   | "Linkedin"     | "Facebook"   | "d47f5d81-5376-4b2d-a3a3-7ec92qw246f8" |
      | "Linkedin"   | "Facebook"     | "Linkedin"   | "d47f5d81-5376-4b2d-a3a3-7ec92qw246qw" |
