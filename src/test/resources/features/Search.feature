Feature: Search functionality
  @DRBP-003
  Scenario: Search with a valid keyword
    Given User is on the homepage
    When User searches for a valid keyword
    Then Results related to keyword are displayed

  @DRBP-004
  Scenario: Search with a invalid keyword
    Given User is on the homepage
    When User searches for a valid keyword
    Then System show error message

