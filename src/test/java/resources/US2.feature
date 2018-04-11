Feature: Access to the Contact Details Page
  As a user
  I want to access to the contact detail page
  So that I can see the details of the selected contact
  Scenario: Detail page's title and text contains "Contact Detail"
    Given I access the details page of COS
    Then the title of the page should be "Contact Detail"
    And I can see the text "Contact Detail"
  Scenario: Detail page's contains an image
    Given I access the details page of COS
    Then the "image" is loaded
    And I can see the "image"
  Scenario: Table contains the header "Contact Detail"
    Given I access the details page of COS
    Then the table should have the header "Contact Detail"
  Scenario: Table contains nine rows on the first column
    Given I access the details page of COS
    Then the table should have the row "name"
    And the table should have the row "surname"
    And the table should have the row "birthday"
    And the table should have the row "phone"
    And the table should have the row "email"
    And the table should have the row "street_address"
    And the table should have the row "city"
    And the table should have the row "occupation"
    And the table should have the row "company"

  Scenario: Table information of the contact is present on the second column
    Given I access the details page of COS
    Then the table should have the row "name_detail"
    When the row "name_detail" is not empty


    And the table should have the row "surname"
    And the table should have the row "birthday"
    And the table should have the row "phone"
    And the table should have the row "email"
    And the table should have the row "street_address"
    And the table should have the row "city"
    And the table should have the row "occupation"
    And the table should have the row "company"