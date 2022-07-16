
  Feature: Etsy Search Functionality Title Verification

    Background:
      Given User is on etsy home page


    Scenario:Title Verification
      When User types Wooden Spoon in the search box
      When User clicks search button
      Then User sees Wooden Spoon is in the title



    Scenario: Title verification with parameterization
      When User types "Wooden Spoon" in the search box
      And User clicks search button
      Then User sees "Wooden spoon - Etsy" is in the title