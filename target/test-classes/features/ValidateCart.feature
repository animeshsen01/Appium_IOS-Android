

Feature: android Native App: Validate Cart

#@ValidateCart @bs_android @Regression @bs
  Scenario Outline: Validate Sum Total of the items in the Cart
    Given I launch the android app <appName>
    And I select <countryName> from country dropdown
    When I sign in as <userName>
    And I add products to the cart
    And I navigate to Cart
    Then I validate the total amount

    Examples: 
      | appName         | userName | countryName    |
      | GeneralStoreApp | Ana      | Canada					|

