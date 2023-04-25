

Feature: iOS Native App: Slider Validation

#	@sliderTest @Regression @bs_ios @bs
  Scenario Outline: Slider Validation
    Given I launch the app <appName>
    When I click on Slider
    And I set the slider value to <value1>
    And I set the slider value to <value2>
    And I set the slider value to <value3>
    Then I verify set value in the slider

    Examples: 
      | appName      |data |	valu1|value2|value3|
      | UIKitCatalog |hello|  0%   |0.5%  |1%    |

