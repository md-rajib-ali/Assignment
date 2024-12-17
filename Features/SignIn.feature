Feature: Sign in

  As a user of the Magento demo site
  I want to sign in successfully
  So that I can access my account features

  Background:
    Given I am on the Magento homepage
    When I click on the "Sign In" link

  Scenario: Successful login with valid credentials
    When I enter a valid email "john.doe.1@example.com" and password "Password123!"
    And I click the 'Sign In' button
    Then I should be see the message "Welcome, John Doe!"

  Scenario: Unsuccessful login with invalid credentials
    When I enter an invalid email "invaliduser@example.com" and password "wrongpassword"
    And I click the 'Sign In' button
    Then I should see sign in error message "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."

  Scenario: Attempt login with empty credentials
    When I leave the email and password fields empty
    And I click the 'Sign In' button
    Then I should see validation errors for both fields:
      | Email Address | This is a required field. |
      | Password      | This is a required field. |

  Scenario: Sign In with invalid email format
    When I enter an invalid email format "john.doe.1@com" and password "Password123!"
    And I click the 'Sign In' button
    Then I should see invalid email error message "Please enter a valid email address (Ex: johndoe@domain.com)."