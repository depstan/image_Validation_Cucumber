Feature: My Health Bridge Join The Team User Story

    Background:
      Given user navigated to the myhealthbridge url "https://myhealthbridge.com"

      Scenario: To Verify and Validate whether the Join The Team link is working and Join The Team page is loaded
        And user check the "Join The Team" hyper link
        When user clicks on the "Join The Team"
        Then user will be navigate to the "Join The Team" page

      Scenario: To Verify and Validate whether the fields are working and search is returning a value
        When user clicks on the "Join The Team"
        And  user enter "Senior QA Automation" in the keyword field
        And  user select the category as "Quality"
        And  user select the jobtype as "Quality"
        And  user select the location as "MI"
        And  user click the search button
        Then user should be able to view the results

      Scenario: To Verify and Validate whether the Read More button is active and user able to proceed
        When user clicks on the "Join The Team"
        And  user enter "Senior QA Automation" in the keyword field
        And  user click the search button
        And  user click "Read More" button under "Senior QA Automation"
        Then user should be able to view the Senior QA Automation page

      Scenario: To Verify and Validate whether user able to upload the doc and submit the   application
        When user clicks on the "Join The Team"
        And  user enter "Senior QA Automation" and click the search button
        And  user click "Read More" button under "Senior QA Automation"
        And  user click "Browse" button to select the document
        And  user click "Submit" button
        Then user should get the success message "Your application has been received. We will get back to you soon."

