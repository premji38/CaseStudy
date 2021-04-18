Feature: Registration and user validation
This feature includes scenario that would validate the following feature 
1) Register as new user and Validate the registration confirmation message


@Register
Scenario: Register as new user and Validate the registration confirmation message
Given User should able to click the sign up button and go to the registration page
When I enter the firstname as "<firstname>"
And I enter the Lastname as "<Lastname>"
And I enter the email as "<Email>"
And I enter the username as "<username>"
And I enter the password as "<password>"
And I enter the Confirm Password "<confirmpass>"
And I clicked the Register button
And I should see the username as "Premkumar S"
And click on the profile icon with the registered id
And user should click on the image on the profile option and compare the id
And Navigate to homepage and click on compose email option
And write a message to another user
Then Verify whether the message has sent to another user

Examples:
|firstname|Lastname|            Email|username|  password|confirmpass|
|Premkumar|Shanmugam|shan17@gmail.com|premji17|Diyaprem16|Diyaprem16|

