@TC_005
Feature: OMR Branch Change Booking Functionality
  This feature verifies the change booking functionality of the OMR Branch hotel application,
  including modifying check-in date for created bookings using Card and UPI payments.

  Background:
    Given User is on the OMR Branch hotel page
    When User enters "ash.naveen.kv@gmail.com" and "Naveen90!"
    Then User should verify success message after login "Welcome Naveenraj"
    When User search hotel "Tamil Nadu", "Chennai", "Suite", "25-07-2026", "26-07-2026", "1-One", "2-Two" and "1"
    Then User should validate after search hotel success message "Select Hotel"

  Scenario Outline: Verify modify created Order ID using card payment with GST and special request
    When User save the last hotel name and hotel price
    And User select the last hotel and accept the alert
    Then User should verify after select success message "Book Hotel"
    When User add Guest Details "<Select Salutation>", "<First Name>", "<Last Name>", "<Mobile No.>" and "<Email>"
    And User add GST Details "<Enter Registration No.>", "<Enter Company Name>" and "<Enter Company Address>" and User add Special Request "<Request>"
    And User enter payment details, proceed with Card Type "<Card Type>"
      | Select Card | Card No          | Card Name | Month | Year | CVV |
      | Visa        | 5555555555552222 | Naveenraj | July  | 2035 | 123 |
      | MasterCard  | 5555555555552222 | Naveenraj | July  | 2035 | 123 |
      | Amex        | 5555555555552222 | Naveenraj | July  | 2035 | 123 |
      | Discover    | 5555555555552222 | Naveenraj | July  | 2035 | 123 |
    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User search the Order ID
    Then User should verify same booked Order ID is present or not
    And User should verify same booked Hotel Name is present or not
    And User should verify same booked Hotel Price is present or not
    When User edit the Check-in Date "<Modify Date>"
    Then User should verify after modify check-in date success message "Booking updated successfully"

    Examples:
      | Select Salutation | First Name | Last Name | Mobile No. | Email                   | Enter Registration No. | Enter Company Name     | Enter Company Address | Request      | Card Type  | Modify Date |
      | Mr                | Naveenraj  | Rajendran | 9952040520 | ash.naveen.kv@gmail.com | 9043592058             | Greens Tech OMR Branch | Thoraipakkam          | Need parking | debit_card | 30-07-2026  |

  Scenario Outline: Verify modify created Order ID using UPI payment with GST and special request
    When User save the last hotel name and hotel price
    And User select the last hotel and accept the alert
    Then User should verify after select success message "Book Hotel"
    When User add Guest Details "<Select Salutation>", "<First Name>", "<Last Name>", "<Mobile No.>" and "<Email>"
    And User add GST Details "<Enter Registration No.>", "<Enter Company Name>" and "<Enter Company Address>" and User add Special Request "<Request>"
    And User enter upi details "<UPI ID>" and click submit
    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User search the Order ID
    Then User should verify same booked Order ID is present or not
    And User should verify same booked Hotel Name is present or not
    And User should verify same booked Hotel Price is present or not
    When User edit the Check-in Date "<Modify Date>"
    Then User should verify after modify check-in date success message "Booking updated successfully"

    Examples:
      | Select Salutation | First Name | Last Name | Mobile No. | Email                   | Enter Registration No. | Enter Company Name     | Enter Company Address | Request      | UPI ID               | Modify Date |
      | Mr                | Naveenraj  | Rajendran | 9952040520 | ash.naveen.kv@gmail.com | 9043592058             | Greens Tech OMR Branch | Thoraipakkam          | Need parking | seleniumtraining@vbc | 30-07-2026  |

  Scenario Outline: Verify modify created Order ID using card payment without GST and with special request
    When User save the last hotel name and hotel price
    And User select the last hotel and accept the alert
    Then User should verify after select success message "Book Hotel"
    When User add Guest Details "<Select Salutation>", "<First Name>", "<Last Name>", "<Mobile No.>" and "<Email>"
    And User skipping GST Details and User add Special Request "<Request>"
    And User enter payment details, proceed with Card Type "<Card Type>"
      | Select Card | Card No          | Card Name | Month | Year | CVV |
      | Visa        | 5555555555552222 | Your name | July  | 2045 | 123 |
    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User search the Order ID
    Then User should verify same booked Order ID is present or not
    When User edit the Check-in Date "<Modify Date>"
    Then User should verify after modify check-in date success message "Booking updated successfully"

    Examples:
      | Select Salutation | First Name | Last Name | Mobile No. | Email                   | Request      | Card Type  | Modify Date |
      | Mr                | Greens     | Tech      | 9952040520 | ash.naveen.kv@gmail.com | Need parking | debit_card | 30-07-2026  |

  Scenario Outline: Verify modify created Order ID using card payment with GST and without special request
    When User save the last hotel name and hotel price
    And User select the last hotel and accept the alert
    Then User should verify after select success message "Book Hotel"
    When User add Guest Details "<Select Salutation>", "<First Name>", "<Last Name>", "<Mobile No.>" and "<Email>"
    And User add GST Details "<Enter Registration No.>", "<Enter Company Name>" and "<Enter Company Address>"
    And User enter payment details, proceed with Card Type "<Card Type>"
      | Select Card | Card No          | Card Name | Month | Year | CVV |
      | Visa        | 5555555555552222 | Naveenraj | July  | 2035 | 123 |
    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User search the Order ID
    Then User should verify same booked Order ID is present or not
    When User edit the Check-in Date "<Modify Date>"
    Then User should verify after modify check-in date success message "Booking updated successfully"

    Examples:
      | Select Salutation | First Name | Last Name | Mobile No. | Email                   | Enter Registration No. | Enter Company Name     | Enter Company Address | Card Type  | Modify Date |
      | Mr                | Naveenraj  | Rajendran | 9952040520 | ash.naveen.kv@gmail.com | 9043592058             | Greens Tech OMR Branch | Thoraipakkam          | debit_card | 30-07-2026  |

  @Ignore
  Scenario Outline: Verify modify existing Order ID check-in date
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User search the Order ID
    Then User should verify same booked Order ID is present or not
    When User edit the Check-in Date "<Modify Date>"
    Then User should verify after modify check-in date success message "Booking updated successfully"

    Examples:
      | Modify Date |
      | 30-07-2026  |

  @Ignore
  Scenario Outline: Verify modify first displayed Order ID check-in date
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User edit the Check-in Date for the first displayed Order ID "<Modify Date>"
    Then User should verify after modify check-in date success message "Booking updated successfully"

    Examples:
      | Modify Date |
      | 30-07-2026  |

  @Ignore
  Scenario Outline: Verify modify last displayed Order ID check-in date
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User edit the Check-in Date for the last displayed Order ID "<Modify Date>"
    Then User should verify after modify check-in date success message "Booking updated successfully"

    Examples:
      | Modify Date |
      | 30-07-2026  |
