


Feature: iOS Native App: Scroll Validation

#	@scrollTest @Regression
  Scenario Outline: Scroll Validation
    Given I launch the app <appName>
    When I scroll to <scrollPoint>
    And I click on Web View
    And I navigate back to homepage
    And I click on Picker View
    And I set the values for <red> <green> and <blue>
    Then I verify the values set for <red> <green> and <blue>

    Examples: 
      | appName      |scrollPoint |	red|green|blue|
      | UIKitCatalog |Web View    |  80|220  |105 |

