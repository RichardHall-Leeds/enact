Feature: Home page interactions

  Background:
    Given I open a browser
    And I navigate to https://www.enact.co.uk/

# experiement without given when then?  everyone hates it.
  Scenario: Purchase Price quote Home Page form submission
    And I accept cookies
    When I complete the following fields
    #consider submit button being seperate step or added as text
      | purchasePrice | purchaseStage  | firstTimeBuyer | name             | email                | phone        | postcode | consent |
      | 200000.00     | Offer accepted | Yes            | Test User Ignore | test@testemail.co.uk | 07824 441111 | SW1A 2AA | No      |

    Then I verify the Your Quote screen has the following values
    | purchasePriceQuote |
    | £200,000           |

    #| purchasePriceQuote | tenure   | totalConveyancingFee | totalFeeAndSearchPack | estimatedTotal |
    #| 200000              | Freehold | £1,068.00            | £1,471.20             | £1,770.20      |


    #And I check these business important elements are displayed
     # | elementName                                   |
      #| Heading saying team will call the user        |
      #| Instruct Now Button                           |
      #| Your Track Progress Icon (could be hard rich) |

