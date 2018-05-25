Feature: Access to the Contact Details Page
  As a user
  I want to access to the contact detail page
  So that I can see the details of the selected contact

  
  @noerror
  Scenario: Detail page's title
    Given I access the details page of COS with "d4f8d88d-afe1-4c63-821a-278883d6bb49"
    Then the title of details the page should be "Contacts Orchestrator Solution - Contact details"

  @noerror
  Scenario: Table rows number
    Given I access the details page of COS with "d4f8d88d-afe1-4c63-821a-278883d6bb49"
    Then the table should have twelve rows

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
      Scenario: Phone number is not empty
      Given I access the details page of COS with "d4f8d88d-afe1-4c63-821a-278883d6bb49"
      Then the field phone shouldn't be empty

  @noerror
  Scenario: Go back to landing page
    Given I access the details page of COS with "d4f8d88d-afe1-4c63-821a-278883d6bb49 "
    When I click the Go back button
    Then the landing page appears

    @error
    Scenario: Invalid user guid
      Given I access the details page of COS with "invalid-id"
      Then the message "User not found" should be present

  @error
  Scenario: User Guid empty
    Given I access the details page of COS with no guid
    Then the message "User guid is required" should be present

  @noerror
  Scenario: Valid Date format
    Given I access the details page of COS with "d4f8d88d-afe1-4c63-821a-278883d6bb49"
    Then the date format should be "MM/dd/yyyy"

  @noerror
  Scenario: Valid email format
    Given I access the details page of COS with "d4f8d88d-afe1-4c63-821a-278883d6bb49"
    Then the value on the email field should be a valid email

  @noerror
  Scenario: Phone has only numbers
    Given I access the details page of COS with "d4f8d88d-afe1-4c63-821a-278883d6bb49"
    Then the value on the phone field should be valid
    
  @noerror
  Scenario: GUID is valid
    Given I access the details page of COS with "d4f8d88d-afe1-4c63-821a-278883d6bb49"
    Then the value on the guid field should be a valid

  @noerror
  Scenario Outline: Source field on details page
    Given I access the landing page with a clean session
    When I choose the to disable the "<disabledFilter>" option to list only "<source>"
    And I click on the detail button
    Then the table should have the value "<source>" on the source field
    Examples:
      | disabledFilter | source |
      | LinkedIn     | Facebook   |
      | Facebook     | LinkedIn   |