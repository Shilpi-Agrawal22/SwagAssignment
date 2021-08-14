$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ProductCheckout.feature");
formatter.feature({
  "line": 1,
  "name": "Check product checkout functionality",
  "description": "",
  "id": "check-product-checkout-functionality",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 37,
  "name": "Check the search functionality",
  "description": "",
  "id": "check-product-checkout-functionality;check-the-search-functionality",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 36,
      "name": "@smoke2"
    }
  ]
});
formatter.step({
  "line": 38,
  "name": "Already registered customer",
  "keyword": "Given "
});
formatter.step({
  "line": 39,
  "name": "Search Product \u003cProduct\u003e in the list of Product displayed on Product screen and Click on ADD TO CART",
  "keyword": "When "
});
formatter.step({
  "line": 40,
  "name": "Click Cart Button",
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "Click on REMOVE button on Your Cart Page",
  "keyword": "And "
});
formatter.step({
  "line": 42,
  "name": "Verify Checkout Button should be disabled",
  "keyword": "Then "
});
formatter.examples({
  "line": 44,
  "name": "",
  "description": "",
  "id": "check-product-checkout-functionality;check-the-search-functionality;",
  "rows": [
    {
      "cells": [
        "Product"
      ],
      "line": 45,
      "id": "check-product-checkout-functionality;check-the-search-functionality;;1"
    },
    {
      "cells": [
        "Sauce Labs Bike Light"
      ],
      "line": 46,
      "id": "check-product-checkout-functionality;check-the-search-functionality;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "comments": [
    {
      "line": 3,
      "value": "#An End-to End Scenario to search for a product:-"
    },
    {
      "line": 4,
      "value": "#1. Launch the application"
    },
    {
      "line": 5,
      "value": "#2. click on search product toolbar"
    },
    {
      "line": 6,
      "value": "#3. Search for a product"
    },
    {
      "line": 7,
      "value": "#4. Now validate if the searched product is available"
    },
    {
      "line": 8,
      "value": "#5."
    },
    {
      "line": 9,
      "value": "#Background:"
    },
    {
      "line": 10,
      "value": "#Given User Opens the App"
    },
    {
      "line": 11,
      "value": "# And Successfully registered"
    },
    {
      "line": 12,
      "value": "#Then User is on dashboard"
    }
  ],
  "line": 13,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 14,
  "name": "Launch the Application",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "Enter credentials username as \"standard_user\" and password as \"secret_sauce\" and login application",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "User should be successfully logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDef.launch_the_application()"
});
formatter.result({
  "duration": 16725422900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "standard_user",
      "offset": 31
    },
    {
      "val": "secret_sauce",
      "offset": 63
    }
  ],
  "location": "LoginStepDef.enter_credentials_username_as_and_password_as_and_login_application(String,String)"
});
formatter.result({
  "duration": 2634606199,
  "status": "passed"
});
formatter.match({
  "location": "ProductCheckoutStepDef.user_should_be_successfully_logged_in()"
});
formatter.result({
  "duration": 1554071700,
  "status": "passed"
});
formatter.scenario({
  "line": 46,
  "name": "Check the search functionality",
  "description": "",
  "id": "check-product-checkout-functionality;check-the-search-functionality;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 36,
      "name": "@smoke2"
    }
  ]
});
formatter.step({
  "line": 38,
  "name": "Already registered customer",
  "keyword": "Given "
});
formatter.step({
  "line": 39,
  "name": "Search Product Sauce Labs Bike Light in the list of Product displayed on Product screen and Click on ADD TO CART",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 40,
  "name": "Click Cart Button",
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "Click on REMOVE button on Your Cart Page",
  "keyword": "And "
});
formatter.step({
  "line": 42,
  "name": "Verify Checkout Button should be disabled",
  "keyword": "Then "
});
formatter.match({
  "location": "ProductCheckoutStepDef.already_registered_customer()"
});
formatter.result({
  "duration": 209202300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sauce Labs Bike Light",
      "offset": 15
    }
  ],
  "location": "ProductCheckoutStepDef.search_product_in_the_list_of_product_displayed_on_product_screen(String)"
});
formatter.result({
  "duration": 1558849900,
  "status": "passed"
});
formatter.match({
  "location": "ProductCheckoutStepDef.click_cart_button()"
});
formatter.result({
  "duration": 64900,
  "status": "passed"
});
formatter.match({
  "location": "ProductCheckoutStepDef.click_on_remove_button_on_your_cart_page()"
});
formatter.result({
  "duration": 1311242600,
  "status": "passed"
});
formatter.match({
  "location": "ProductCheckoutStepDef.verify_checkout_button_should_be_disabled()"
});
formatter.result({
  "duration": 784590900,
  "error_message": "java.lang.AssertionError: expected [false] but found [true]\r\n\tat org.testng.Assert.fail(Assert.java:99)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:1037)\r\n\tat org.testng.Assert.assertFalse(Assert.java:67)\r\n\tat org.testng.Assert.assertFalse(Assert.java:77)\r\n\tat PageObjects.CheckoutPage.verifyCheckOutButtonDisabled(CheckoutPage.java:50)\r\n\tat stepDefinations.ProductCheckoutStepDef.verify_checkout_button_should_be_disabled(ProductCheckoutStepDef.java:145)\r\n\tat ✽.Then Verify Checkout Button should be disabled(ProductCheckout.feature:42)\r\n",
  "status": "failed"
});
});