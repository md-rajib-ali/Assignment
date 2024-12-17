Feature: Create an account

  As a new user
  I want to create an account on the Magento website
  So that I can access my account and shop online.

  Background:
    Given I am on the Magento homepage
    When I click on "Create an Account" link
    And I land on "Create New Customer Account" page

  Scenario: Successful account creation with valid details
    When I enter my first name "John"
    And I enter my last name "Doe"
    And I enter a valid email address
    And I enter a valid password "Password123!"
    And I confirm the password "Password123!"
    And I click the 'Create An Account' button
    Then I should be redirected to the "My Account" page
    And I should see a welcome message "Thank you for registering with Main Website Store."

  Scenario: Sign Up attempt with an already registered email
    When I enter my first name "John"
    And I enter my last name "Doe"
    And I enter an email address "john.doe.1@example.com" that is already registered
    And I enter a valid password "Password123!"
    And I confirm the password "Password123!"
    And I click the 'Create An Account' button
    Then I should see an error message "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account."

  @skip
  Scenario: Sign Up attempt with mismatched passwords
    When I enter my first name "Jane"
    And I enter my last name "Smith"
    And I enter a valid email address "jane.smith@example.com"
    And I enter a password "Password123!"
    And I confirm the password "Password456!"
    And I click the 'Create An Account' button
    Then I should see password mismatch error message "Please enter the same value again."

  @skip
  Scenario: Sign Up attempt with missing required fields
    When I leave the first name field blank
    And I enter my last name "Doe"
    And I enter a valid email address "john.doe@example.com"
    And I enter a valid password "Password123!"
    And I confirm the password "Password123!"
    And I click the 'Create An Account' button
    Then I should see first name error message "This is a required field."

  @skip
  Scenario: Sign Up with invalid email format
    When I enter my first name "John"
    And I enter my last name "Doe"
    And I enter an invalid email address "john.doe@com"
    And I enter a valid password "Password123!"
    And I confirm the password "Password123!"
    And I click the 'Create An Account' button
    Then I should see email error message "Please enter a valid email address (Ex: johndoe@domain.com)."

  @skip
  Scenario: Password strength validation during Sign Up
    When I enter my first name "Emily"
    And I enter my last name "Clark"
    And I enter a valid email address "emily.clark@example.com"
    And I enter a weak password "12345"
    And I confirm the password "12345"
    And I click the 'Create An Account' button
    Then I should see password strength error message "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored."