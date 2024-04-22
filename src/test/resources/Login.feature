Feature: Facebook Login
  Scenario: Login with valid credentials
    Given User launch the browser
    When Navigate into face book url as "https://www.facebook.com/"
    And Enter the mobilenumber as "9381531244" and password as "Shaiksha@1234"
    And Click on login button
    And Page title should be "(20+) Facebook"
    And Click on logout button
    Then Close the browser

#
#    Scenario Outline: Login Data Driven
#      Given User launch the browser
#      When Navigate into face book url as "https://www.facebook.com/"
#      And Enter the mobilenumber as "<mobilenumber>" and password as "<password >"
#      And Click on login button
#      And Page title should be "(20+) Facebook"
#      And Click on logout button
#      Then Close the browser
#
#      Examples:
#        | mobilenumber | password      |  |
#        | 9381531244   | Shaiksha@1234 |  |
#        | 9381531244   | shaiksha@1122 |  |

