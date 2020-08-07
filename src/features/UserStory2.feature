@User2
Feature: My Health Bridge Leadership Team User Story

  Background:
    Given user navigated to the myhealthbridge url "https://myhealthbridge.com"

  Scenario: To Verify whether the Leadership Team link is working and page is loaded
    And user check the "Leadership" hyper link
    When user clicks on the "Leadership"
    Then user will be navigate to the "Leadership" page

  Scenario: To Validate whether the image is matching
    When user clicks on the "Leadership"
    And  user capture the image "Greg"
    Then the "Greg.png" image should be same as expected
