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
    Then the table should have four columns

    @noerror
  Scenario: Click on the details button
    Given I access the landing page of COS
    When I click the details button
    Then Details Page appears

  @noerror
  Scenario Outline: Table values
    Given I access the landing page of COS
    Then In the "<rownumber>" should be the values "<id>", "<name>" and "<email>"
    Examples:
    | rownumber | id | name | email |
    | 1         | d4f8d88d-afe1-4c63-821a-278883d6bb49 | Estevan | 	EstevanRibeiroRodrigues@cuvox.de |
    | 2         | 021a1dc3-5b75-4868-bb03-333170ce9acb | Joao    | JoaoRibeiroSantos@teleworm.us     |
    | 3         | 24789e26-a833-402d-9800-0f9f1433ba79 | Sophia  | SophiaFernandesBarros@cuvox.de    |



