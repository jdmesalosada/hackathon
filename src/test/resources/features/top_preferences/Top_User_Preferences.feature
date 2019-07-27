Feature: User asks for top artists and tracks
  To listen the top artists and music I listen
  As a registered user
  I would like to get the top of music based on my preferences

  @top_preferences
  Scenario Outline: User should not be able to access to top preferences
    User should not have permissions to access to their top preferences due doesn't have configured the scopes.
    Given Sergey is a registered user
    And he is logged
    When he asks for the top <filter> based on their preferences
    Then he should not be able to see the top preferences
    Examples:
      | filter  |
      | artists |
      | tracks  |