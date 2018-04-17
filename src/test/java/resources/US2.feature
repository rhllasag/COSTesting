Feature: Access to the Contact Details Page
  As a user
  I want to access to the contact detail page
  So that I can see the details of the selected contact

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
    Then the table should have eleven rows
    Examples:
      | id |
      | d4f8d88d-afe1-4c63-821a-278883d6bb49 |

  @noerror
  Scenario Outline: Table data
    Given I access the details page of COS with "<id>"
    Then the "<rownumber>" should have "<rowvalue>" on the second column
    Examples:
      | id | rownumber | rowvalue |
      | d4f8d88d-afe1-4c63-821a-278883d6bb49 | 2 | d4f8d88d-afe1-4c63-821a-278883d6bb49 |
      | d4f8d88d-afe1-4c63-821a-278883d6bb49 | 3 | Estevan |
      | d4f8d88d-afe1-4c63-821a-278883d6bb49 | 4 | Rodrigues |
      | 021a1dc3-5b75-4868-bb03-333170ce9acb| 2 | 021a1dc3-5b75-4868-bb03-333170ce9acb |
      | 021a1dc3-5b75-4868-bb03-333170ce9acb| 3 | Joao |
      | 021a1dc3-5b75-4868-bb03-333170ce9acb| 4 | Santos |

  @noerror
  Scenario Outline: Go back to landing page
    Given I access the details page of COS with "<id>"
    When I click the Go back button
    Then the landing page appears
    Examples:
      | id |
      | d4f8d88d-afe1-4c63-821a-278883d6bb49 |

    @error
    Scenario Outline: Invalid user guid
      Given I access the details page of COS with "<id>"
      Then the message "User not found" should be present
      Examples:
        | id |
        | invalid-id |

  @error
  Scenario: User Guid empty
    Given I access the details page of COS with no guid
    Then the message "User guid is required" should be present