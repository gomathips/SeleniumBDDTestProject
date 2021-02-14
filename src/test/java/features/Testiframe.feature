Feature: Testiframe
    Verify if user is able to enter text inside iframe
  Scenario: Launch Url and test iframe
    Given User is on Iframe window
    When User navigate into the single iframe window
    Then Enter the text message "first message"
    And User navigate into the multiple iframe window
    Then Enter the text message for inner frame "second message"
