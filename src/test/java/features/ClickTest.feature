

Feature: iOS Native App: Click action and Text Field Validation

#@clickTest @Regression
  Scenario Outline: Click action and Text Field Validation
    Given I launch the app <appName>
    When I click on Alert Views
    And I click on Text Field
    And I pass the value <data>
    And I click on Confirm
    Then I verify the message

    Examples: 
      | appName      			|data |	
      | UIKitCatalog 			|hello|  
      #| UIKitCatalogReal 	|hello| 
      #| UIKitCatalog |!@$&| 
