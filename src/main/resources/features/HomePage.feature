Feature: Home page interactions

  Background:
    Given I open a browser
    And I navigate to https://www.enact.co.uk/


  Scenario: Purchase Price quote Home Page form submission
    And I accept cookies
    When I complete the following fields
    #need to update consent to no
      | purchasePrice | purchaseStage  | firstTimeBuyer | name             | email                | phone        | postcode | consent |
      | 200000.00     | Offer accepted | Yes            | Test User Ignore | test@testemail.co.uk | 07824 441111 | SW1A 2AA | N       |
