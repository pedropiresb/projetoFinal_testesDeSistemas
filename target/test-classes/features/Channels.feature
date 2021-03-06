@test @channels
Feature: Channels actions

  Scenario: Subscribe to a channel
    Given I open the youtube main page
    And I login with email "testdesistemas.dipr@gmail.com" and password "r3m3mb3r"
    When I search for a video called "CanalCanalha"
    And I subscribe to the channel "CanalCanalha"
    And I select the option "Subscriptions" in the lateral menu
    And I click on the manage button
    Then I should see the channel "CanalCanalha" in the channel list
    And the subscribe button of the channel "CanalCanalha" has the text "SUBSCRIBED"