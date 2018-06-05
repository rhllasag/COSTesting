Feature: Access to the Duplicate Contact Page
  As a user
  I want to access the Duplicate Contact Page
  So that I can choose the valid repeated data of the contact to save and export

  @noerror
  Scenario: Solve duplicate title
    Given I access the Duplicate Contact page with a clean session
    When I click on the first Solve Button
    Then the title should be "Contacts Orchestrator Solution - Solve duplicated contact"

  @noerror
  Scenario: Go to the previous page
    Given I access the Duplicate Contact page with a clean session
    When I click on the first Solve Button
    And I click on the go back button
    Then the manage duplicate contacts page should appear

  @noerror
  Scenario: Save solved contact
    Given I access the Duplicate Contact page with a clean session
    When I click on the first Solve Button
    And I click on the go save button
    Then the manage duplicate contacts page should appear without the solved duplicate "Estevan Rodrigues"

  @noerror
  Scenario: Solve duplicate fields
    Given I access the Duplicate Contact page with a clean session
    When I click on the first Solve Button
    Then I can see the fields "Name", "Photo", "Email", "Birthday", "Company", "City", "Occupation", "Source" and "Street Address"

  @noerror
  Scenario: Duplicated field is really duplicated
    Given I access the Duplicate Contact page with a clean session
    When I click on the first Solve Button
    Then The name field should have the same data