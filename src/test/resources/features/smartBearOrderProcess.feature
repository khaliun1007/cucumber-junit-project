
#  Feature: Smartbear order process
#
#   # @wip
#    Scenario Outline: Order verification
#    Given User is logged into SmartBear Tester account and on Order page
#    When User fills out the form as followed from the table below:
#    And User selects "<product>" from product dropdown
#    And User enters "<quantity>" to quantity
#    And User enters "<customer name>" to costumer name
#    And User enters "<street>" to street
#    And User enters "<city>" to city
#    And User enters "<state>" to state
#    And User enters "<zip>" to zip
#    And User selects "<cardType>" as card type
#    And User enters "<card number>" to card number
#    And User enters "<expiration date>" to expiration date
#    And User clicks process button
#    Then User verifies "<costumer name>" is in the list
#
#      Examples:
#        | Key             | Value        |
#        | product         | MyMoney      |
#        | quantity        | 1            |
#        | customer name   | Ken Adams    |
#        | street          | State st     |
#        | city            | Chicago      |
#        | state           | IL           |
#        | zip             | 60312        |
#        | cardType        | Visa         |
#        | card number     | 313313133315 |
#        | expiration date | 60312        |
#        | expected name   | Visa         |
