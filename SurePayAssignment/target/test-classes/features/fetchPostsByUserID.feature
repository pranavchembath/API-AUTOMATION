Feature: Get all Existing User from Server

@GetExistingUser
Scenario:  Get all existing users and print them in console
	Given todos resource
	When user calls "GetTodosAPI" with "Get" http request
	Then the API call is success with status code 200
	And Print all unique existing users in console

@CreatePost
Scenario Outline: Create a Post by UserId
	Given posts payload with "<title>" "<userid>" "<body>"
	When user calls "CreatePostAPI" with "Post" http request
	Then the API call is success with status code 201
	And Validate key "userId" with value as 1
	And Validate key "id" with value as 101
	
	Examples:
	|title |body |userid|
	|foo3  |bar3 |1|
	|f004  |bar4 |2|

@ValidateEmail	
Scenario: Validate Email Address Format on Comments posted by UserId 
	Given comments resource with userId 1
	When user calls "GetCommentsAPI" with "Get" http request
	Then the API call is success with status code 200
	And Validate the email address format
	And Print the status in console