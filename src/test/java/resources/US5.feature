Feature: Access to the Manage Duplicate Contact Page
  As a user
  I want to access to the Manage Duplicate Contact Page
  So that I can choose the valid repeated data of the contact to save and export

  @noerror
  Scenario: The Manage Duplicate Contact Page Title
    Given I access the landing page of COS
    When I click the Solve Duplicated Button
    And I click on the Button "Solve" of the first row
    Then The Manage Duplicate Contact Page appear with the title "Manage Duplicate Contact"

  @noerror
  Scenario: The Manage Duplicate Contact receives repeated contacts of the previous page
    Given I access the landing page of COS
    When I click the Solve Duplicated Button
    And I click on the Button "Solve" of the first row
    Then I have a no empty combo box in the header of the second column with Names of the contact repeated

  @noerror
  Scenario: The Rows for the Table
    Given I access the landing page of COS
    When I click the Solve Duplicated Button
    And I click on the Button "Solve" of the first row
    Then the table should have the rows: "Name", "Email", "Number", "Birthday", "City", "Company", "Occupation", "Photo", "Source" and "Street Address"

  @noerror
  Scenario: The Contact can be selected by the Combo Box options
    Given I access the landing page of COS
    When I click the Solve Duplicated Button
    And I click on the Button "Solve" of the first row
    And I change the user selected
    Then the table show another data

  @noerror
  Scenario: The Contact Information can be saved
    Given I access the landing page of COS
    When I click the Solve Duplicated Button
    And I click on the Button "Solve" of the first row
    And I click on the "Save" button
    Then The contact is saved in temporal data to be exported

  @noerror
  Scenario: Return to the Solve Duplicated Problems Page
    Given I access the landing page of COS
    When I click the Solve Duplicated Button
    And I click on the Button "Solve" of the first row
    And I click on the "Go Back" button
    Then I can see the Solve Duplicated Problems Page without saving data to be exported