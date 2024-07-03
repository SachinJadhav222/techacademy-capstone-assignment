# Feature: Capstone Project
# This feature contains scenarios for verifying page titles, texts, dropdown selections, and hyperlink presence on various pages of the internet Heroku app.

Feature: Capstone Project

  # Scenario: Verify page title
  # This scenario verifies that the title of the homepage is "The Internet".
  Scenario: Verify page title
    Given I launch the URL "http://the-internet.herokuapp.com/"
    Then the title of the page should be "The Internet"

  # Scenario: Verify A/B Test page text
  # This scenario verifies the text on the A/B Test page.
  Scenario: Verify A/B Test page text
    When I click on "A/B Testing" link
    Then the text on the page should be "A/B Test Variation 1"

  # Scenario: Select option from dropdown
  # This scenario selects an option from a dropdown and verifies the selected option.
  Scenario: Select option from dropdown
    When I navigate back to the home page
    And I click on "Dropdown" link
    And I select "Option 1" from the dropdown
    Then "Option 1" should be selected

  # Scenario: Verify hyperlinks on Frames page
  # This scenario verifies the presence of hyperlinks on the Frames page.
  Scenario: Verify hyperlinks on Frames page
    When I navigate back to the home page
    And I click on "Frames" link
    Then "Nested Frames" link should be present
    And "iFrame" link should be present
