Feature: Access to the Contact Details Page
  As a user
  I want to access to the contact detail page
  So that I can see the details of the selected contact for then review a contact list

  @noerror
  Scenario Outline: Detail page's title
    Given I access the details page of COS with "<id>"
    Then the title of details the page should be "Contacts Orchestrator Solution - Contact details"
    Examples:
      | id |
      | d4f8d88d-afe1-4c63-821a-278883d6bb49 |

  @noerror
  Scenario Outline: Table rows number
    Given I access the details page of COS with "<id>"
    Then the table should have twelve rows
    Examples:
      | id |
      | d4f8d88d-afe1-4c63-821a-278883d6bb49 |

  @noerror
  Scenario Outline: Go back to landing page
    Given I access the details page of COS with "<id>"
    When I click the Go back button
    Then the landing page appears
    Examples:
      | id |
      | d4f8d88d-afe1-4c63-821a-278883d6bb49 |

  @noerror
  Scenario Outline: Go to review contacts to landing page
    Given I access the details page of COS with "<id>"
    When I click the Contacts Review button
    Then the Contacts Review page appears
    Examples:
      | id |
      | d4f8d88d-afe1-4c63-821a-278883d6bb49 |

