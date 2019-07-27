Feature: User asks for music recommendations
  To listen my favorite music
  As a registered user
  I would like to received recommendations about what music should listen

  @recommendations
  Scenario: Aks for music recommendations
    Given Sergey is a registered user
    And he is logged
    When he asks for recommendations about what music to listen
  #  Then he should see a list of music recommended based on their musical taste