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
    Then I access the landing page of COS
  @noerror
  Scenario: Export a CVS File with contacts
    Given I access the Duplicate Contact page
    When I click on the Export Button
    Then The file cvs is downloaded
  @noerror
  Scenario: Actions Solve and Cancel Duplicated contact Buttons
    Given I access the Duplicate Contact page
    Then For each duplicated contact i have the options to "Solve" and " Cancel"
  @noerror
  Scenario: Clicking on Solve, the Solve duplicate information page appears
    Given I access the Duplicate Contact page
    Given I click on the Solve Button
    Then I access the Solve duplicate page
  @noerror
  Scenario: Clicking on Cancel, the rows with the same information disappear
    Given I access the Duplicate Contact page
    Given I click on the Cancel Button
    Then The rows with the same information solved disappear
  @noerror
  Scenario: Identify duplicated contacts
    Given I access the Duplicate Contact page
    Then The can see contacts duplicated