Feature: Access to the Contacts Review Page
  As a user
  I want to access to the contacts review page
  So that I can see the contacts of one user for then solve duplicated contacts

  @noerror
  Scenario: Contacts Review page's title
    Given I access the contacts review page
    Then the title of the  review page should be "Contacts Review"
  @noerror
  Scenario: Contacts Review page's subtitle
    Given I access the contacts review page
    Then the subtitle of details the page should be "Duplicated Contacts"
  @noerror
  Scenario Outline: Columns name of Review Contacts page
    Given I access the landing page of COS
    When  I choose the filtering "<enableFilter>" option and choose "<disabledFilter>" option and click on the detail button with "<id>"
    Given I access the details page of COS with "<id>"
    When I click the Contacts Review button
    Then The Contacts Review page appears with the columns "ID", "Name" , "Email" ,"Source" and "Action"
    Examples:
      | enableFilter | disabledFilter | id|
      | "Facebook"   | "Linkedin"     | "d47f5d81-5376-4b2d-a3a3-7ec92qw246f8" |
  @noerror
  Scenario Outline: Review Contacts page for a specific source
    Given I access the landing page of COS
    When  I choose the filtering "<enableFilter>" option and choose "<disabledFilter>" option and click on the detail button with "<id>"
    Given I access the details page of COS with "<id>"
    When I click the Contacts Review button
    Then The Contacts Review page appears with all rows of the fifth column with the value "<source>"
    Examples:
      | enableFilter | disabledFilter | source | id|
      | "Facebook"   | "Linkedin"     | "Facebook"   | "d47f5d81-5376-4b2d-a3a3-7ec92qw246f8" |
      | "Linkedin"   | "Facebook"     | "Linkedin"   | "d47f5d81-5376-4b2d-a3a3-7ec92qw246qw" |
  @noerror
  Scenario Outline: Review Contacts page have a action button to solve duplicated contacts
    Given I access the landing page of COS
    When  I choose the filtering "<enableFilter>" option and choose "<disabledFilter>" option and click on the detail button with "<id>"
    Given I access the details page of COS with "<id>"
    When I click the Contacts Review button
    Then The Contacts Review page appears with all the contacts independent of the source and a clickable button "Solve Duplicated" in the fifth column
    Examples:
      | enableFilter | disabledFilter | id|
      | "Facebook"   | "Linkedin"     | "d47f5d81-5376-4b2d-a3a3-7ec92qw246f8" |
      | "Linkedin"   | "Facebook"     | "d47f5d81-5376-4b2d-a3a3-7ec92qw246qw" |

  Scenario Outline: Clicking on the button for Solve Duplicated  by Source, the user access to the Solve Duplicated Page
    Given I access the landing page of COS
    When  I choose the filtering "<enableFilter>" option and choose "<disabledFilter>" option and click on the detail button with "<id>"
    Given I access the details page of COS with "<id>"
    When I click the Contacts Review button
    Given The Contacts Review page appears with a clickable button Solve Duplicated, and click it with the "<name>"
    Then I access to the Solve Duplicated Problems page of COS
    Examples:
      | enableFilter | disabledFilter | id| name|
      | "Facebook"   | "Linkedin"     | "d47f5d81-5376-4b2d-a3a3-7ec92qw246f8" | "Emilly"|
      | "Linkedin"   | "Facebook"     | "d47f5d81-5376-4b2d-a3a3-7ec92qw246qw" | "Emilly"|

  @noerror
  Scenario Outline: Return to Details page form Contacts Review page
    Given I access the landing page of COS
    When  I choose the filtering "<enableFilter>" option and choose "<disabledFilter>" option and click on the detail button with "<id>"
    Given I access the details page of COS with "<id>"
    When I click the Contacts Review button
    Given I access the contacts review page
    Then I return to the details page of COS with "<id>"
    Examples:
      | enableFilter | disabledFilter | id|
      | "Facebook"   | "Linkedin"     | "d47f5d81-5376-4b2d-a3a3-7ec92qw246f8" |
      | "Linkedin"   | "Facebook"     | "d47f5d81-5376-4b2d-a3a3-7ec92qw246qw" |