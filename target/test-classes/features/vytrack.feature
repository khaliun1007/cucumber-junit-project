

  Feature: Verifying as a user I should be able to see Export Grid dropdown, Refresh, Reset and Grid setting buttons

    Background:
      Given User is already logged in Vytrack and on all cars page

      Scenario: User should see Export Grid dropdown on the left of the page able to click the dropdown
        When User moves to the left of the page I'd see Export grid dropdown
        And User click the dropdown
        Then User sees 2 options and can select them

    @wip
      Scenario:User should see Refresh button on the left side of Reset button and click Refresh button
        When User verifies that Refresh button is next to Reset button
        And User clicks Refresh button
        Then User sees page reloads


      Scenario: User should see Reset button Reset button next to Grid setting button and be able to click the Reset button
        When User verifies that Reset button is next to Grid setting button
        And User clicks the Reset button
        Then User should see
