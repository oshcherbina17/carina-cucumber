Feature: Sauce Demo Order Process

  Scenario Outline: Order items from Sauce Demo
    Given User logged in to Sauce Demo with "<username>" credentials from the database
    When User is on the Homepage
    And User "<username>" adds products to cart <orderId>
    And User opens cart
    Then User checks the order details
    And User "<username>" proceed to checkout
    Then User verify that the ordering was successful

    Examples:
      | username      | orderId |
      | standard_user | 1       |
      | visual_user   | 2       |