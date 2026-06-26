Feature: Enact.co.uk Home page interactions

  Background:
    Given I open a browser
    And I navigate to the platform
    And I accept cookies

  Scenario: Submit Instant Quote - verify figures and key fields show
    When I submit an Instant Quote with the following details:
      | purchasePrice | purchaseStage  | firstTimeBuyer | name             | email                | phone        | postcode | consent |
      | 200000.00     | Offer accepted | Yes            | Test User Ignore | test@testemail.co.uk | 07824 441111 | SW1A 2AA | No      |
    Then the system-generated Total costs are correct on the Quote screen:
      | totalConveyancingFees | totalFeeAndSearchPack | estimatedTotal |
      | £1,068.00             | £1,471.20             | £1,770.20      |
    And the Quote Summary section matches the user inputs:
      | purchasePrice | tenure   |
      | £200,000      | Freehold |
    And the Quote Number is displayed and is 7 digits long
    And the Instruct Now link is displayed

