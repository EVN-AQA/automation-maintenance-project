@Regression @cart
Feature: Shopping cart Page
   As a user
   I want to see all Shopping cart page elements
   So that I can verify Shopping cart page works well

   Background:
      Given I open the home page of DemoWebShop website
      When I click the login hyperlink on Header page
      When I input value for email "superman1912@gmail.com" and password "12345678", then click login button

   Scenario Outline:  MP0018 Add product to cart - (home page)
      When I add product "<productTitle>" to cart
      Then I should see success notification bar displayed
      When I navigate to shopping cart from link in the notification bar
      Then I should see the added product "<productTitle>" in the shopping cart
      Then I should see the price "1590.00", quantity "1", total "1590.00" of product "<productTitle>" displayed correctly
      When I remove all items in the shopping cart
      Then I should see text informing the shopping cart is empty
      Examples:
         | productTitle     |
         | 14.1-inch Laptop |

   Scenario Outline:  MP0019	Add product to cart - (Product sub-category page)
      When I navigate to product sub-category "<productSubCategory>" page of category "<productCategory>"
      When I add product "<productTitle>" to cart
      Then I should see success notification bar displayed
      When I navigate to shopping cart from link in the notification bar
      Then I should see the added product "<productTitle>" in the shopping cart
      When I remove all items in the shopping cart
      Then I should see text informing the shopping cart is empty
      Examples:
         | productTitle     | productCategory | productSubCategory |
         | 14.1-inch Laptop | Electronics     | Cell phones        |

   Scenario Outline:  MP0020	Add product to cart - (Product details page)
      When I navigate to product category "<productCategory>"
      When I open product details page "<productTitle>"
      When I choose option "9" in dropdown list "Size"
      When I click on Add to cart button in product details page
      Then I should see success notification bar displayed
      When I navigate to shopping cart from link in the notification bar
      Then I should see the added product "<productTitle>" in the shopping cart
      When I remove all items in the shopping cart
      Then I should see text informing the shopping cart is empty
      Examples:
         | productTitle           | productCategory |
         | Blue and green Sneaker | Apparel & Shoes |

   Scenario Outline:  MP0021, MP0022	Add multiple products to cart
      When I navigate to product category "<productCategory1>"
      When I add product "<productTitle1>" to cart
      When I navigate to product sub-category "<productSubCategory>" page of category "<productCategory2>"
      When I add product "<productTitle2>" to cart
      Then I should see success notification bar displayed
      When I navigate to shopping cart from link in the notification bar
      Then I should see the added product "<productTitle1>" in the shopping cart
      Then I should see the added product "<productTitle2>" in the shopping cart
      Then I should see the subtotal before tax of products displayed correctly
      When I remove all items in the shopping cart
      Then I should see text informing the shopping cart is empty
      Examples:
         | productTitle1 | productTitle2    | productCategory1 | productSubCategory | productCategory2 |
         | Fiction       | 14.1-inch Laptop | Books            | Notebooks          | Computers        |