Feature: Access to the Solve Duplicated Problems Page
  As a user
  I want to access to the Solve Duplicated Page clicking the Solve Duplicate Button of the principal page
  So that I can see the  duplicated contacts to solve throughout clicking on an action button

  @noerror
  Scenario: Solve Duplicated Page's title
    Given I access the landing page of COS
    When I click the Solve Duplicated Button
    Then the title of the  review page should be "Solve Duplicated Problems"
  @noerror
  Scenario: Columns name of Solve Duplicated Problems page
    Given I access the landing page of COS
    When I click the Solve Duplicated Button
    Then The page appears with the columns "Repeated Field", "Times" , "Actions"

  @noerror
  Scenario: The  duplicated data is not empty and I can click on the Solve or Cancel button
    Given I access the landing page of COS
    When I click the Solve Duplicated Button
    When The page appears with more than one row
    Then The first row in the action column contains the buttons "Solve" and "Cancel"
  @noerror
  Scenario: Go Back Button return to the landing page of COS
    Given I access the landing page of COS
    When I click the Solve Duplicated Button
    When I click the Go Back Button
    Then I access the to the landing page of COS


  @noerror
  Scenario: The Manage Duplicate Contact Page appears when I click on the Solve Button
    Given I access the landing page of COS
    When I click the Solve Duplicated Button
    When I click on the Button "Solve" of the first row
    Then The Manage Duplicate Contact Page appear

  Scenario: The Duplicate Contact is  saved in temporal data  when I click on the Cancel Button
    Given I access the landing page of COS
    When I click the Solve Duplicated Button
    When I click on the Button "Cancel" of the first row
    Then The contact is saved in temporal data to be exported

  @noerror
  Scenario: Export Contacts Data in CVS format
    Given I access the landing page of COS
    When I click the Solve Duplicated Button
    When I click the Go Export
    Then I can download a CVS file

