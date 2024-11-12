Feature: Payment functionality
  @DRBP-008
  Scenario: Check payment screen
    Given User added product to cart
    When User clicks on Buy
    Then Payment screen is displayed
