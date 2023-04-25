

Feature: iOS Native App: LongTap Validation

#@longTapTest @Regression
  Scenario Outline: LongTap Validation
    Given I launch the app <appName>
    When I longpress on LongTap button
    And I disable Name option
    And I disable Email option


    Examples: 
      | appName |
      | LongTap |

