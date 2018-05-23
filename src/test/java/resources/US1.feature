Feature: Access to the Contacts Orchestrator Solution's (COS) Landing Page
  As a user
  I want to access to the URL address provided for the landing page
  So that I can see the list of the contacts available

  @noerror
  Scenario: Landing page's title
    Given I access the landing page of COS
    Then the title of the page should be "Contacts Orchestrator Solution"

  @noerror
  Scenario: Table contains four columns
    Given I access the landing page of COS
    Then the table should have five columns

  @noerror
  Scenario: Click on the details button
    Given I access the landing page of COS
    When I click the details button
    Then Details Page appears

  @noerror
  Scenario: Click on the details button by id
    Given I access the landing page of COS
    When I click the details button for the user with "d4f8d88d-afe1-4c63-821a-278883d6bb49"
    Then Details Page should have "d4f8d88d-afe1-4c63-821a-278883d6bb49" on the second row


  @noerror
  Scenario: Number o contacts on the list
    Given I access the landing page of COS
    Then The number of table rows should match the number of contacts shown on the field "num-contacts"

  @noerror
  Scenario: Emails is valid
    Given I access the landing page of COS
    Then the email field has a valid email for the user with "d4f8d88d-afe1-4c63-821a-278883d6bb49"


    @noerror
    Scenario: GUID is valid
      Given I access the landing page of COS
      Then the guid field has a valid guid for the user with "d4f8d88d-afe1-4c63-821a-278883d6bb49"
