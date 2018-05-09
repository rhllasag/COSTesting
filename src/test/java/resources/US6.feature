Feature: Access to the Solve Duplicated Problems page
  As a user
  I want to access to the Solve Duplicated Problems page
  So that I can solve one contact duplicated, triplicated, etc for prioritizing the existing values

  @noerror
  Scenario: Solve Duplicated Problems page's title
    Given I access the Duplicated Problems page
    Then the title of the  review page should be "Solve Duplicated Problems"
