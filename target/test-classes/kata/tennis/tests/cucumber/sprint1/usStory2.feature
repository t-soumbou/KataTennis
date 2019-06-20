Feature: Rule Of  Advantage : SPRINT 1 US Story 2 
    Scenario: Gaining advantage
        Given "player one" has the score of "40"
        And "player two" has the score of "40"
        When I mark 1 points to "player one"
        Then scoreboard displays "adv-40"

    Scenario: Losing advantage
        Given "player two" has the score of "40"
        And "player one" has the score of "adv"      
        When I mark 1 points to "player two"
        Then scoreboard displays "40-40" 
        
    Scenario: Winning after advantage
        Given "player one" has the score of "40"
        And "player two" has the score of "adv"
        When I mark 1 points to "player two"
        Then scoreboard displays "0-0" 
        And  winner of this game is "player two wins the game" 