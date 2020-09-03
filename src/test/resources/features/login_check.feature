Feature: Login check
  Successful login check

  Scenario: Authorization with right credentials
    Given Aliexpress Main Page
    When I login in with right credentials
    Then I should be authorised