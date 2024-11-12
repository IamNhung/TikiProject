Feature: Login
  @DRBP-001
  Scenario: Login successfully
    Given User access URL
    And User close promotion
    And User click on Account link
    And User click on Login by email
    When User input right credentials
    And User click on Login button
    And User solves CAPTCHA manually
    Then User login successfully

    @DRBP-002
  Scenario: Login unsuccessfully
    Given User access URL
    And User close promotion
    And User click on Account link
    And User click on Login by email
    When User input wrong credentials
    And User click on Login button
    And User solves CAPTCHA manually
    Then Error message is displayed as expected