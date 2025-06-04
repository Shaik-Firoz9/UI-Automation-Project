Feature: Swap Labs Login feature
  The Login feature allows users to log into their corresponding user accounts.

  @execute
  Scenario: User tries to access user account using only username
    Given User is on the Login page
    When User enters only the username but leaves the password field empty
    And clicks on Login
    Then Epic sadface: Password is required message should display

  @execute
  Scenario: User tries to access user account using only password
    Given User is on the Login page
    When User enters only the password but leaves the username field empty
    And clicks on Login
    Then Epic sadface: Username is required message should display

  @execute
  Scenario: User tries to access user account using invalid username
    Given User is on the Login page
    When User enters a wrong username but correct password
      | userName | password    |
      | wrong    | secret_sauce|
    And clicks on Login
    Then Epic sadface: Username and password do not match any user in this service message should display

  @execute
  Scenario: User tries to access user account using invalid password
    Given User is on the Login page
    When User enters the correct username but the wrong password
      | userName       | password |
      | standard_user  | secret   |
    And clicks on Login
    Then Epic sadface: Username and password do not match any user in this service message should display

  @execute
  Scenario: User tries to access user account using valid username and password
    Given User is on the Login page
    When User enters the correct username and password
      | userName       | password    |
      | standard_user  | secret_sauce|
    And clicks on Login
    Then User should successfully login
