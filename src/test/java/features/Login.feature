Feature: Login To Application Want to check various functionalities on Swag search products

  #An End-to End Scenario to search for a product:-
  #1. Launch the application
  #2. click on search product toolbar
  #3. Search for a product
  #4. Now validate if the searched product is available

@smoke
   Scenario Outline: Verification Of Login with Invalid Credential
    Given Launch the Application
    When Enter credentials username as "<UserName>" and password as "<Password>" and login application
    Then An error message should be dsiplayed for invalid credentials
    And Verify the Error message <ErrorMessage>
  Examples: 
      | UserName       |Password    |ErrorMessage                                        |
      | locked_out_user|secret_sauce|Sorry, this user has been locked out.|

 