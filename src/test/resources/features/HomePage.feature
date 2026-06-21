Feature: Home page interactions
# TO DO look into different permutations of the scenario going through the flow.
  Background:
    Given I open a browser
    And I navigate to https://www.enact.co.uk/

# experiement without given when then?  everyone hates it.
  Scenario: Instant Quote submission user flow: Inputs accepted and Conveyancing Costs, Quote Summary and key elements are correct
    And I accept cookies
    When I complete the following fields
    # consider changing to I complete these Instant Quote fields on the home page
        #consider submit button being seperate step or added as text
      | purchasePrice | purchaseStage  | firstTimeBuyer | name             | email                | phone        | postcode | consent |
      | 200000.00     | Offer accepted | Yes            | Test User Ignore | test@testemail.co.uk | 07824 441111 | SW1A 2AA | No      |

    Then I verify the system generated Total costs are correct on the Quote screen
      | totalConveyancingFees | totalFeeAndSearchPack | estimatedTotal |
      | £1,068.00            | £1,471.20             | £1,770.20      |

    And I verify the Quote Summary section has correct values matching the user inputs
      | purchasePriceQuote | tenure   |
      | £200,000        | Freehold |


    And I verify the Quote Number is displayed and is 7 digits long
    # Value was 1033626 21/06
    And I verify the Instruct Now button is displayed (and is clickable?)
    And I verify the Document Signing element is displayed


    #And I check these business important elements are displayed
     # | elementName                                   |
      #| Heading saying team will call the user        |
      #| Instruct Now Button                           |
      #| Your Track Progress Icon (could be hard rich) |

