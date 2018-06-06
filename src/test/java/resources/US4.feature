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
  Scenario: Export a CVS File with contacts
    Given I access the Duplicate Contact page
    When I click on the Export Button
    Then The file cvs is downloaded
  @noerror
  Scenario: Actions Solve and Cancel Duplicated contact Buttons
    Given I access the Duplicate Contact page
    Then For each duplicated contact i have the options to "Solve" and " Cancel"

  @noerror
  Scenario Outline: Clicking on Solve by name, the Solve duplicate information page appears

    Given I access the Duplicate Contact page
    Given I click on the "Solve" Button of the row name "<firstname>" with the "<surname>"
    Given I send the "<firstname>" and "<surname>" which parameters in the url
    Then I receive "<firstname>" "<surname>" in the View
    Examples:
      |firstname| surname|
      |Estevan|Rodrigues|
      |Sophia|Barros|
      |Joao|Santos|
      |Bruno|Carvalho|
      |Luis|Silva|
  @noerror
  Scenario Outline: Clicking on Solve by number, the Solve duplicate information page appears

    Given I access the Duplicate Contact page
    Given I click on the "Solve" Button of the row number "<number>"
    Then I send the "<number>" which parameters in the url
    Examples:
      |number|
      |232582789|
      |244534398|
      |244163484|
  @noerror
  Scenario Outline: Clicking on Solve by email, the Solve duplicate information page appears

    Given I access the Duplicate Contact page
    Given I click on the "Solve" Button of the row email "<email>"
    Then I send the email "<email>" which parameters in the url
    Examples:
      |email|
      |EstevanRibeiroRodrigues@cuvox.de|
      |JoaoRibeiroSantos@teleworm.us|
      |SophiaFernandesBarros@cuvox.de|
  @noerror
  Scenario Outline: Clicking on Cancel, the rows with the same information disappear of the table
    Given I access the Duplicate Contact page
    Given I click on the "Cancel" Button with the "<resource>"
    Then The rows of "<resource>" disappear
    Examples:
      |resource|
      |Name: Estevan Rodrigues|
