Feature: Check product checkout functionality
 
  #An End-to End Scenario to search for a product:-
  #1. Launch the application
  #2. click on search product toolbar
  #3. Search for a product
  #4. Now validate if the searched product is available
  #5. 
  #Background: 
    #Given User Opens the App
   # And Successfully registered
    #Then User is on dashboard
   Background:
	Given Launch the Application
     When Enter credentials username as "standard_user" and password as "secret_sauce" and login application
    Then User should be successfully logged in
    
  @smoke
  Scenario Outline: Check the search functionality
  Given Already registered customer
    When Search Product <Product> in the list of Product displayed on Product screen and Click on ADD TO CART
    And Click Cart Button
    Then User must be re-directed to the product description page
    And Click the CHECKOUT button
    And Enter Checkout Information <FIRST NAME>, <LAST NAME>, <ZIP CODE>
    And Click Continue Button
    And Checkout Overview Screen is dispalyed
    And Product <Product> is displayed
    And Click on Finish Button
    And Checkout Complete Screen is dispalyed
 Examples: 
    | UserName       |Password    | Product  |FIRST NAME |LAST NAME|ZIP CODE|
    | standard_user|secret_sauce|Sauce Labs Bike Light| Shilpi|Agrawal|4353663|
 
 #Defect Checkout Button should be disabled after Removing the Added Product in cart but we are able to complete checkout
@regression
  Scenario Outline: Check the search functionality
  Given Already registered customer
    When Search Product <Product> in the list of Product displayed on Product screen and Click on ADD TO CART
    And Click Cart Button
    And Click on REMOVE button on Your Cart Page
    Then Verify Checkout Button should be disabled
    
      Examples: 
   | Product  			|
   |Sauce Labs Bike Light|
    