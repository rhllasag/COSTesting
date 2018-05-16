Feature: Access to the Contact Details Page
  As a user
  I want to access to the contact detail page
  So that I can see the details of the selected contact


  @noerror
  Scenario Outline: Table rows names
    Given I access the landing page of COS
    When  I choose the filtering "<enableFilter>" option and choose "<disabledFilter>" option and click on the detail button with "<id>"
    Given I access the details page of COS with "<id>"
    Then the table should have the rows: "GUID", "Given Name", "Surname", "Birthday", "Phone", "Email", "Street Addres" ,"City" , "Occupation", "Company" and "<Source>"
    Examples:
      | enableFilter | disabledFilter | Source | id|
      | "Facebook"   | "Linkedin"     | "Facebook"   | "d47f5d81-5376-4b2d-a3a3-7ec92qw246f8" |
      | "Linkedin"   | "Facebook"     | "Linkedin"   | "d47f5d81-5376-4b2d-a3a3-7ec92qw246qw" |

  @noerror
  Scenario Outline: Go back to landing page
    Given I access the landing page of COS
    When  I choose the filtering "<enableFilter>" option and choose "<disabledFilter>" option and click on the detail button with "<id>"
    Given I access the details page of COS with "<id>"
    When I click the Go back button
    Then the landing page appears
    Examples:
      | enableFilter | disabledFilter | id|
      | "Facebook"   | "Linkedin"     | "d47f5d81-5376-4b2d-a3a3-7ec92qw246f8" |

