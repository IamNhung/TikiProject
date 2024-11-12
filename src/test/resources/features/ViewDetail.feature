Feature: Detail functionality
  @DRBP-005
  Scenario: View detail product
    Given User searches for a keyword
    And User click on product
    Then Product's detail is displayed

  @DRBP-006
  Scenario: Calculate price of a product
    Given User is on detail page
    When User adds the quantity of the product
    Then Product's price is calculate correctly



