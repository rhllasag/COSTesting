Feature: Access to the Contacts Orchestrator Solution's (COS) Landing Page
  As a user
  I want to access to the URL address provided for the landing page
  So that I can see the list of the contacts available
  Scenario: Landing page's title and text contains "Contacts Orchestrator Solution"
    Given I access the landing page of COS
    Then the title of the page should be "Contacts Orchestrator Solution"
    And I can see the text "Contacts Orchestrator Solution"
  Scenario: Table contains the header "Contact List"
    Given I access the landing page of COS
    Then the table should have the header "Contact List"
  Scenario: Table contains two columns
    Given I access the landing page of COS
    Then the table should have the column "name"
    And the table should have the column "action"

  Scenario: Table has the correct number of contacts
    Given I access the landing page of COS
    When the contact numbers is "number"
    Then the table should have "number" of rows

  Scenario: Click on the details button
    Given I access the landing page of COS
    When I click the details button
    Then Details Page appears



