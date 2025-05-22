Feature: Google Search

  Scenario: Search for something on Google
    Given Chrome is open
    When browsing for "https://www.selenium.dev"
    Then the title should be "Selenium"