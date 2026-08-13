@TC_004
Feature: OMR Branch Book Hotel Functionality
  This feature verifies hotel booking with Card and UPI payment,
  including GST, special request, payment validation, and booking confirmation.

  Background:
    Given User is on the OMR Branch hotel page
    When User enters "ash.naveen.kv@gmail.com" and "Naveen90!"
    Then User should verify success message after login "Welcome Naveenraj"
    When User search hotel "Tamil Nadu", "Chennai", "Suite", "01-08-2026", "02-08-2026", "1-One", "2-Two" and "1"
    Then User should validate after search hotel success message "Select Hotel"

  Scenario Outline: Verify book hotel with GST, card payment and special request
    When User save the last hotel name and hotel price
    And User select the last hotel and accept the alert
    Then User should verify after select success message "Book Hotel"
    When User add Guest Details "<Select Salutation>", "<First Name>", "<Last Name>", "<Mobile No.>" and "<Email>"
    And User add GST Details "<Enter Registration No.>", "<Enter Company Name>" and "<Enter Company Address>" and User add Special Request "<Request>"
    And User enter payment details, proceed with Card Type "<Card Type>"
      | Select Card | Card No          | Card Name | Month | Year | CVV |
      | Visa        | 5555555555552222 | Naveenraj | July  | 2035 | 123 |
      | Visa        | 5555555555552222 | Kamaraj   | July  | 2035 | 123 |
      | Visa        | 5555555555552222 | Karthik   | July  | 2035 | 123 |
      | Visa        | 5555555555552222 | Dilip     | July  | 2035 | 123 |
    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not

    Examples:
      | Select Salutation | First Name | Last Name | Mobile No. | Email                   | Enter Registration No. | Enter Company Name     | Enter Company Address | Request      | Card Type  |
      | Mr                | Naveenraj  | Rajendran | 9952040520 | ash.naveen.kv@gmail.com | 9043592058             | Greens Tech OMR Branch | Thoraipakkam          | Need parking | debit_card |

  Scenario Outline: Verify book hotel with GST, card payment and without special request
    When User save the last hotel name and hotel price
    And User select the last hotel and accept the alert
    Then User should verify after select success message "Book Hotel"
    When User add Guest Details "<Select Salutation>", "<First Name>", "<Last Name>", "<Mobile No.>" and "<Email>"
    And User add GST Details "<Enter Registration No.>", "<Enter Company Name>" and "<Enter Company Address>"
    And User Skipping Special Request
    And User enter payment details, proceed with Card Type "<Card Type>"
      | Select Card | Card No          | Card Name | Month | Year | CVV |
      | Visa        | 5555555555552222 | Your name | July  | 2035 | 123 |
      | Mastercard  | 5555555555552222 | Your name | July  | 2035 | 123 |
      | Amex        | 5555555555552222 | Your name | July  | 2035 | 123 |
      | Discover    | 5555555555552222 | Your name | July  | 2035 | 123 |
    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not

    Examples:
      | Select Salutation | First Name | Last Name | Mobile No. | Email                   | Enter Registration No. | Enter Company Name     | Enter Company Address | Request      | Card Type  |
      | Mr                | Naveenraj  | Rajendran | 9952040520 | ash.naveen.kv@gmail.com | 9043592058             | Greens Tech OMR Branch | Thoraipakkam          | Need parking | debit_card |

  Scenario Outline: Verify book hotel without GST ,card payment and with special request
    When User save the last hotel name and hotel price
    And User select the last hotel and accept the alert
    Then User should verify after select success message "Book Hotel"
    When User add Guest Details "<Select Salutation>", "<First Name>", "<Last Name>", "<Mobile No.>" and "<Email>"
    And User skipping GST Details and User add Special Request "<Request>"
    And User enter payment details, proceed with Card Type "<Card Type>"
      | Select Card | Card No          | Card Name | Month | Year | CVV |
      | Visa        | 5555555555552222 | Naveenraj | July  | 2035 | 123 |
      | Mastercard  | 5555555555552222 | Kamaraj   | July  | 2035 | 123 |
      | Amex        | 5555555555552222 | Rajendran | July  | 2035 | 123 |
      | Discover    | 5555555555552222 | Dilip     | July  | 2035 | 123 |
    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not

    Examples:
      | Select Salutation | First Name | Last Name | Mobile No. | Email                   | Request      | Card Type  |
      | Mr                | Naveenraj  | Rajendran | 9952040520 | ash.naveen.kv@gmail.com | Need parking | debit_card |

  Scenario Outline: Verify book hotel without GST, card payment and without special request
    When User save the last hotel name and hotel price
    And User select the last hotel and accept the alert
    Then User should verify after select success message "Book Hotel"
    When User add Guest Details "<Select Salutation>", "<First Name>", "<Last Name>", "<Mobile No.>" and "<Email>"
    And User skipping GST Details and Special Request
    And User enter payment details, proceed with Card Type "<Card Type>"
      | Select Card | Card No          | Card Name | Month | Year | CVV |
      | Visa        | 5555555555552222 | Naveenraj | July  | 2035 | 123 |
      | Mastercard  | 5555555555552222 | Naveenraj | July  | 2035 | 123 |
      | Amex        | 5555555555552222 | Naveenraj | July  | 2035 | 123 |
      | Discover    | 5555555555552222 | Naveenraj | July  | 2035 | 123 |
    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not

    Examples:
      | Select Salutation | First Name | Last Name | Mobile No. | Email                   | Card Type  |
      | Mr                | Naveenraj  | Rajendran | 9952040520 | ash.naveen.kv@gmail.com | debit_card |

  Scenario Outline: Verify card payment error messages without entering payment details
    When User save the last hotel name and hotel price
    And User select the last hotel and accept the alert
    Then User should verify after select success message "Book Hotel"
    When User add Guest Details "<Select Salutation>", "<First Name>", "<Last Name>", "<Mobile No.>" and "<Email>"
    And User add GST Details "<Enter Registration No.>", "<Enter Company Name>" and "<Enter Company Address>" and User add Special Request "<Request>"
    And User click credit card
    And User click submit without entering payment details
    Then User should verify after payment details error message "Please select your card type", "Please select your card", "Please provide your card number", "Please provide name on your card", "Please provide your Card Expiry Date" and "Please provide your Card's security code"

    Examples:
      | Select Salutation | First Name | Last Name | Mobile No. | Email                   | Enter Registration No. | Enter Company Name     | Enter Company Address | Request      |
      | Mr                | Naveenraj  | Rajendran | 9952040520 | ash.naveen.kv@gmail.com | 9043592058             | Greens Tech OMR Branch | Thoraipakkam          | Need parking |

  Scenario Outline: Verify book hotel with GST UPI payment and special request
    When User save the last hotel name and hotel price
    And User select the last hotel and accept the alert
    Then User should verify after select success message "Book Hotel"
    When User add Guest Details "<Select Salutation>", "<First Name>", "<Last Name>", "<Mobile No.>" and "<Email>"
    And User add GST Details "<Enter Registration No.>", "<Enter Company Name>" and "<Enter Company Address>" and User add Special Request "<Request>"
    And User enter upi details "<UPI ID>" and click submit
    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not

    Examples:
      | Select Salutation | First Name | Last Name | Mobile No. | Email                   | Enter Registration No. | Enter Company Name     | Enter Company Address | Request      | UPI ID               |
      | Mr                | Naveenraj  | Rajendran | 9952040520 | ash.naveen.kv@gmail.com | 9043592058             | Greens Tech OMR Branch | Thoraipakkam          | Need parking | seleniumtraining@vbc |

  Scenario Outline: Verify book hotel with GST UPI payment and without special request
    When User save the last hotel name and hotel price
    And User select the last hotel and accept the alert
    Then User should verify after select success message "Book Hotel"
    When User add Guest Details "<Select Salutation>", "<First Name>", "<Last Name>", "<Mobile No.>" and "<Email>"
    And User add GST Details "<Enter Registration No.>", "<Enter Company Name>" and "<Enter Company Address>"
    And User enter upi details "<UPI ID>" and click submit
    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not

    Examples:
      | Select Salutation | First Name | Last Name | Mobile No. | Email          | Enter Registration No. | Enter Company Name     | Enter Company Address | UPI ID               |
      | Mr                | Naveenraj  | Rajendran | 9952040520 | test@gmail.com | 9043592058             | Greens Tech OMR Branch | Thoraipakkam          | seleniumtraining@vbc |

  Scenario Outline: Verify book hotel without GST UPI payment and with special request
    When User save the last hotel name and hotel price
    And User select the last hotel and accept the alert
    Then User should verify after select success message "Book Hotel"
    When User add Guest Details "<Select Salutation>", "<First Name>", "<Last Name>", "<Mobile No.>" and "<Email>"
    And User skipping GST Details and User add Special Request "<Request>"
    And User enter upi details "<UPI ID>" and click submit
    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not

    Examples:
      | Select Salutation | First Name | Last Name | Mobile No. | Email                   | Request      | UPI ID               |
      | Mr                | Naveenraj  | Rajendran | 9952040520 | ash.naveen.kv@gmail.com | Need parking | seleniumtraining@vbc |

  Scenario Outline: Verify book hotel without GST UPI payment and without special request
    When User save the last hotel name and hotel price
    And User select the last hotel and accept the alert
    Then User should verify after select success message "Book Hotel"
    When User add Guest Details "<Select Salutation>", "<First Name>", "<Last Name>", "<Mobile No.>" and "<Email>"
    And User skipping GST Details and Special Request
    And User enter upi details "<UPI ID>" and click submit
    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not

    Examples:
      | Select Salutation | First Name | Last Name | Mobile No. | Email                   | UPI ID               |
      | Mr                | Naveenraj  | Rajendran | 9952040520 | ash.naveen.kv@gmail.com | seleniumtraining@vbc |

  Scenario Outline: Verify UPI payment error message without entering UPI ID
    When User save the last hotel name and hotel price
    And User select the last hotel and accept the alert
    Then User should verify after select success message "Book Hotel"
    When User add Guest Details "<Select Salutation>", "<First Name>", "<Last Name>", "<Mobile No.>" and "<Email>"
    And User add GST Details "<Enter Registration No.>", "<Enter Company Name>" and "<Enter Company Address>" and User add Special Request "<Request>"
    And User click upi
    And User click submit without entering payment details
    Then User should verify after payment details error message "Please provide your UPI ID"

    Examples:
      | Select Salutation | First Name | Last Name | Mobile No. | Email                   | Enter Registration No. | Enter Company Name     | Enter Company Address | Request      |
      | Mr                | Naveenraj  | Rajendran | 9952040520 | ash.naveen.kv@gmail.com | 9043592058             | Greens Tech OMR Branch | Thoraipakkam          | Need parking |
