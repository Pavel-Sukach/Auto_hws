Feature: Is it Friday today?
  everybody wants to know whet it's Friday

  Scenario: Thursday isn't Friday
    Given today is Sunday
    When I ask whether it's Friday yet
    Then I should be told "Nope"