Feature: Access to the Contacts Review Page
  As a user
  I want to access to the contacts review page
  So that I can see the contacts of one user for then solve duplicated contacts

  @noerror
  Scenario: Contacts Review page's title
    Given I access the contacts review page
    Then the title of details the page should be "Contacts Review"
  @noerror
  Scenario: Contacts Review page's subtitle
    Given I access the contacts review page
    Then the subtitle of details the page should be "Duplicated Contacts"
  @noerror
  Scenario: The columns of the filtering table
    Given I access the landing page of COS
    Then The names of the columns of the filtering table are "ID", "Name", "Email" , "Social"and "Action"


