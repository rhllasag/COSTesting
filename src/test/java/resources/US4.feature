Feature: Access to the Duplicate Contact Page
  As a user
  I want to access to the  Duplicate Contact Page
  So that I can choose the valid repeated data of the contact to save and export

  @noerror
  Scenario: The Manage Duplicate Contact Page Title
    Given I access the Duplicate Contact page
    Then The Manage Duplicate Contact Page appear with the title "Contacts Orchestrator Solution - Duplicated contacts"

  @noerror
  Scenario: The Rows for the Table
    Given I access the Duplicate Contact page
    Then The table should have the columns: "Duplicate field: duplicate value", "Number of duplicates" and "Actions"
  @noerror
  Scenario: Return to the landing page
    Given I access the Duplicate Contact page
    When I click on the Back Button
    Then the landing page of should appear
  @noerror
  Scenario: Actions Solve and Cancel Duplicated contact Buttons
    Given I access the Duplicate Contact page
    Then For the duplicated contact I have the options to "Solve" and "Cancel"
  @noerror
  Scenario: Clicking on Solve, the Solve duplicate information page appears
    Given I access the Duplicate Contact page
    When I click on the Solve Button of the first row
    Then I have "Estevan Rodrigues" in the solve duplicate view
  @noerror
  Scenario: Clicking on Cancel, the rows with the same information disappear
    Given I access the Duplicate Contact page
    And I click on the cancel button of the first row
    Then The row of "Estevan Rodrigues" disappear