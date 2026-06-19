Feature: My registration form completion

  Background:
    Given I open a browser
    And I navigate to https://www.enact.co.uk/


  Scenario: Complete form
    And I accept cookies
    When I complete the following
     | firstName | lastName | emailAdress        | gender | mobNumber  | dob        | testingSkills | cvFile                               | workPreference            | postalAddress                   | country          |
     | John      | Salmon   | john.s@example.com | Other  | 1234567890 | 1999-01-01 | Java          | src/main/resources/Test_Document.txt | Fully Remote/Home Working | 123 Main St, Anytown, Yorkshire | Northern Ireland |
