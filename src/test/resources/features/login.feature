Feature: As a user I should be able to login using valid credentials

  Scenario Outline: Verify successful login with valid credentials
    Given I send a request to the login endpoint as "<role>" using valid credentials
    Then The status code should be "200"
    Examples:
      | role      |
      | student   |
      | librarian |

  Scenario Outline: Verify successful login returns a valid access token
    Given I send a request to the login endpoint as "<role>" using valid credentials
    Then API returns a valid authentication token
    Examples:
      | role      |
      | student   |
      | librarian |

  Scenario Outline: Verify unsuccessful login with invalid credentials
    Given I send a request to the login endpoint as "<role>" using invalid credentials
    Then The status code should be "404"
    Examples:
      | role      |
      | student   |
      | librarian |

  Scenario Outline: Verify unsuccessful login returns an error message
    Given I send a request to the login endpoint as "<role>" using invalid credentials
    Then I receive error message "Sorry, Wrong Email or Password"
    Examples:
      | role      |
      | student   |
      | librarian |






