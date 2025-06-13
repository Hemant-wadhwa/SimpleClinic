Feature: Simple Clinic App Flow

  Scenario: Navigate Home Screen
    Given I am on the home screen
    When I tap on NEXT
    And I tap on GET STARTED
    And I tap on AGREE AND CONTINUE
    And I select country as "India"
    And I select state as "Goa"
    Then I should be navigated to the login screen

  Scenario Outline: User successfully logs in
    Given I am on login page
    When Enter the phoneNo "<mobile>"
    And Click on next button
    And Enter the pin "<pin>"
    Then User is on dashboard page

    Examples:
      | mobile     | pin  |
      | 1234567890 | 1234 |

  Scenario: Register patient using Excel
    Given user is on dashboard
    When user click on allow
    And click on search icon
    And click on register as new patient
    And enter the patient details from row "1"
    Then patient added successfully
