Feature: Cart functionality
@DRBP-007
Scenario: Add product to cart
  Given User choose product
  When User clicks on Add to cart button
  Then Message is displayed
  And Product is displayed on cart
