# API-AUTOMATION

Assignment from Sure Pay!

Requirement:

I. Tests
  1. To create a test automation framework skeleton.
  2. To perform the validations for the comments for the post made by aspecific user.
II. Expectation
  1. Granular commits – we want to see your thinking process. 
  2. Best Coding Practics
  3. Modern tools are to be used.
  4. Clean, maintainable code.
  5. Leverage design patterns.
  6. Upload your tests to GitHub
  7. Execute the tests on the Circle CI tool.
  8. Test documentation is created
  9. The solution must be cross-platform.
  10. The solution must be scalable, extendable and maintainable.

Solution:

The solution is build using Rest- assured (java) and solution is uploaded to Github location: https://github.com/pranavchembath/API-AUTOMATION.git

Accomplished Tasks:
·         Created Maven Project with Cucumber and Rest Dependencies
·         Defined Project Structure with Cucumber Framework Setup
·         Created Feature File with the Test cases to automate
·         Implemented smart Step Definitions
·         Builded Utils Class to define all reusable components
·         Builded Pojo Class for Serialization and Deserialization Json Payload
·         Implemented logging into Framework to log request and response details
·         Developed Test with all validation and assertions
·         Defined Global properties for driving all the global variables from Properties
·         Defined Enum class with constants to centralize all resources details
·         Implemented Data driven Mechanism and Parameterization to run tests with multiple data sets using Cucumber Example Keyword
·         Generated simple html reports for Test Execution results
·         Integrated and uploaded the tests on GitHub
	URL: https://github.com/pranavchembath/API-AUTOMATION.git
·         Executed the tests on CircleCI tool

Test Cases:
1.	Get all existing users from the server and display in the console
2.	Create a posts by the user id  (multiple iterations)
3.	Validate email address format on Comments posted.

Improvement Areas:
·         Implement Pre and Post conditions for tests with Cucumber Hooks
·         Report generation can be updated further using Extend Reports or cucumber-reporting


