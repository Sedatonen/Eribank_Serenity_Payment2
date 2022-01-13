Feature:User make a payment

  #Background:
   # Given I login with username company and password company

  Scenario: Make payments with three different clients
    Given Open browser and homepage screen
    When Login with company username "company" and password "company"
    And Make payment with random phone,name,payments and countries
    Then Should see that log out page



    #make a payment to three different client
# client countries CN, USA, JPN
# client amounts 10, 20, 30
# for each payment user's balance should be checked.

# scenario
# make payment for each country in countries list


#appium.udid = emulator-5554
#appium.app =  \Users\SERHAT\Desktop\EriBank.apk
#logout test

