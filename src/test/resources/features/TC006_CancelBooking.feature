
Feature: OMR Branch Cancel Booking Functionality
  This feature verifies the cancel booking functionality of the OMR Branch hotel application,
  including cancel booking flows for Card and UPI payments.

  Background:
    Given User is on the OMR Branch hotel page
    When User enters "ash.naveen.kv@gmail.com" and "Naveen90!"
    Then User should verify success message after login "Welcome Naveenraj"
    When User search hotel "Tamil Nadu", "Chennai", "Suite", "01-09-2026", "02-09-2026", "1-One", "2-Two" and "1"
    Then User should validate after search hotel success message "Select Hotel"
@Ignore
  Scenario Outline: Verify cancel created Order ID using card payment with GST and special request
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
    When User search the Order ID
    Then User should verify same booked Order ID is present or not
    When User should Cancel the new order ID
    Then User should verify after cancel booking success message "Your booking cancelled successfully"

    Examples:
      | Select Salutation | First Name | Last Name | Mobile No. | Email                   | Enter Registration No. | Enter Company Name     | Enter Company Address | Request      | Card Type  | Modify Date |
      | Mr                | Naveenraj  | Rajendran | 9952040520 | ash.naveen.kv@gmail.com | 9043592058             | Greens Tech OMR Branch | Thoraipakkam          | Need parking | debit_card | 30-09-2026  |

  @Ignore
  Scenario Outline: Verify cancel created Order ID using UPI payment with GST and special request
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
    When User should Cancel the new order ID
    Then User should verify after cancel booking success message "Your booking cancelled successfully"

    Examples:
      | Select Salutation | First Name | Last Name | Mobile No. | Email                   | Enter Registration No. | Enter Company Name     | Enter Company Address | Request      | UPI ID               | Modify Date |
      | Mr                | Naveenraj  | Rajendran | 9952040520 | ash.naveen.kv@gmail.com | 9043592058             | Greens Tech OMR Branch | Thoraipakkam          | Need parking | seleniumtraining@vbc | 30-09-2026  |

  @Ignore
  Scenario Outline: Verify cancel existing Order ID
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User should Cancel the existing order ID "<Order ID>"
    Then User should verify after cancel booking success message "Your booking cancelled successfully"

    Examples:
      | Order ID    |
      | #YPJCO46488 |

  @Ignore
  Scenario: Verify cancel first displayed Order ID
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User should Cancel the first order ID
    Then User should verify after cancel booking success message "Your booking cancelled successfully"

  @Ignore
  Scenario: Verify cancel last displayed Order ID
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User should Cancel the last order ID
    Then User should verify after cancel booking success message "Your booking cancelled successfully"
