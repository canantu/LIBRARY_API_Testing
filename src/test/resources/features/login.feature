Feature: As a user I should be able to login using valid credentials

  Scenario Outline: Verify successful login with valid credentials
    Given I send a request to the "login" endpoint as "<role>" using "<valid credentials>"
    When I receive response from API
    Then The status code should be "200"
    Examples:
      | role      | valid credentials |
      | student   |                   |
      | librarian |                   |

  Scenario Outline: Verify successful login returns a valid access token
    Given I send a request to the "login" endpoint as "<role>" using "<valid credentials>"
    When I receive response from API
    Then API returns a valid authentication token
    Examples:
      | role      | valid credentials |
      | student   |                   |
      | librarian |                   |

  Scenario Outline: Verify unsuccessful login with invalid credentials
    Given I send a request to the "login" endpoint as "<role>" using "<invalid credentials>"
    When I receive response from API
    Then The status code should be "404"
    Examples:
      | role      |invalid credentials|
      | student   |                   |
      | librarian |                   |

  Scenario Outline: Verify unsuccessful login returns an error message
    Given I send a request to the "login" endpoint as "<role>" using invalid credentials
    When I receive response from API
    Then I receive error message "Sorry Wrong Email or Password"
    Examples:
      | role      |invalid credentials|
      | student   |                   |
      | librarian |                   |

  Scenario Outline: Verify user information from api and database for login
    Given I send a request to the "login" endpoint as "<role>" using "<valid credentials>"
    When I receive response from API
    Then Firstname, lastname and role information from API and database should match
    Examples:
      | role      | valid credentials |
      | student   |                   |
      | librarian |                   |

  Scenario Outline: Verify user information from api, database and ui for login
    Given I log in the application as "<role>" using "<valid credentials>"
    And I send a request to the "login" endpoint as "<role>" using "<valid credentials>"
    When I receive response from API
    Then Firstname, lastname and role information from UI, API and database should match
    Examples:
      | role      | valid credentials |
      | student   |                   |
      | librarian |                   |





