Feature: Verify Adactin details

  Scenario Outline: Verify Adactin login with valid credentials
    Given User should login by using "<username>", "<password>" and click login button
    And User should enter the "<Location>","<Hotels>","<Room type>","<Number of rooms>","<check in date>","<check out date>","<adults per room>","<children per room>" and click search button
    Then User should click the checkbox and Search button
    And User should enter some details like "<First Name>","<Last Name>","<Billing Address>","<credit card no>","<Credit card type>","<expiry month>","<expiry year>","<cvv>" and click Book Now button
    Then User should validate the Booking Confirmation

    Examples: 
      | username    | password | Location | Hotels      | Room type | Number of rooms | Check in date | Check out date | adults per room | Childrens per room | First Name   | Last Name   | Billing Address  | Credit card no   | Credit card type | expiry month | expiry year | cvv |
      | Vasanthuser | Password | Sydney   | Hotel Creek | Standard  | 1 - One         | 10/02/2021    | 10/04/2021     | 1 - One         | 2 -One             | Vasanthkumar | Arunachalam | TamilNadu, India | 9876543210328948 | American Express | November     |        2025 | 333 |
