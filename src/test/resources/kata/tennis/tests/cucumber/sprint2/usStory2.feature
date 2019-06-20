Feature: Tiebrek Score counting And Winning Rules : SPRINT 2 US Story 1

Scenario: Check Tiebrek activation
        Given "player one" has the game score of "6"
        And "player two" has the game score of "5"
        When I mark 1 game to "player two"
        Then scoreboard displays "0-0"
        And  set scoreboard displays "6-6"
        And  tiebrek scoreboard displays "0-0"

 Scenario Outline: Score Tiebrek counting
	   When I mark <p1> tiebrek point to "player one"
	   And  I mark <p2> tiebrek point to "player two"
	   Then tiebrek scoreboard displays <score>
	   
	   Examples:
	       | p1 | p2 | score | 
	       |  0 | 0  | "0-0" |
	       |  1 | 0  | "1-0" |
           |  2 | 0  | "2-0" |
           |  2 | 1  | "2-1" |
           |  3 | 1  | "3-1" |
           |  3 | 2  | "3-2" |
           |  3 | 3  | "3-3" | 
           |  4 | 2  | "4-2" | 
           |  5 | 1  | "5-1" | 
           |  6 | 6  | "6-6" | 
           |  1 | 6  | "1-6" |
           |  6 | 7  | "6-7" |
           
      Scenario: Winning Tiebrek at 5-6
        Given "player one" has the game score of "6"
        And  "player two" has the game score of "6"
        And  "player one" has the tiebrek score of "5"
        And  "player two" has the tiebrek score of "6"
        When  I mark 1 tiebrek point to "player two"
        Then scoreboard displays "0-0"
        And  set scoreboard displays "6-7"
        And  tiebrek scoreboard displays "0-0"
        And  winner of this match is "player two wins the set and match"
        
    Scenario: Winning Tiebrek at 7-6
        Given "player one" has the game score of "6"
        And  "player two" has the game score of "6"
        And "player one" has the tiebrek score of "7"
        And   "player two" has the tiebrek score of "6"
        When I mark 1 tiebrek point to "player one"
        Then scoreboard displays "0-0"
        And  set scoreboard displays "7-6"
        And  tiebrek scoreboard displays "0-0"
        And  winner of this match is "player one wins the set and match"
        
    Scenario: Winning Tiebrek at 9-10
        Given "player one" has the game score of "6"
        And  "player two" has the game score of "6" 
        And "player one" has the tiebrek score of "9"
        And   "player two" has the tiebrek score of "10"
        When I mark 1 tiebrek point to "player two"
        Then scoreboard displays "0-0"
        And  set scoreboard displays "6-7"
        And  tiebrek scoreboard displays "0-0"
        And  winner of this match is "player two wins the set and match"
           