Feature: Placing bets and getting odds and returns calculated

Scenario: Navigate to Euro-2016 football event place bet and assert odds and returns
Given I am on the William Hill Sports webpage
And I go to Euro 2016 & International page
And I go to "Slovakia" v "England" match bets page
When I place a £"0.05" bet on "Slovakia"
Then I see a £"0.24" estimated return




