Feature: Score counting up to 5 And Winning Rules : SPRINT 2 US Story 1
	
	Scenario: Start Game at 0-0
	   Given no points have been scored in set
	   Then scoreboard displays "0-0"
	   And set scoreboard displays "0-0"
	   
	Scenario Outline: Score of Set counting up to advantage
	   When I mark <p1> points to "player one"
	   And I mark <p2> points to "player two"
	   Then scoreboard displays <score>
	   And set scoreboard displays <scoreSet>
	   
	   Examples:
	       | p1| p2| score  | scoreSet |
	       |  0| 0 | "0-0"  |   "0-0"  |
           |  1| 0 | "15-0" |   "0-0"  |
           |  2| 0 | "30-0" |   "0-0"  |
           |  1| 2 |"15-30" |   "0-0"  |
           |  3| 1 |"40-15" |   "0-0"  |
           |  2| 1 |"30-15" |   "0-0"  |
           |  2| 2 |"30-30" |   "0-0"  |
           |  3| 3 |"40-40" |   "0-0"  |
           |  3| 4 |"40-adv"|   "0-0"  |
        
    Scenario: Winning Game straight at 40-0 when starting Set
        Given "player one" has the score of "40"
        And "player two" has the score of "0"
        When I mark 1 points to "player one"
        Then scoreboard displays "0-0"
        And  set scoreboard displays "1-0"
        And  winner of this game is "player one wins the game"
        
    Scenario: Winning Game straight at 15-40 when starting Set
        Given "player one" has the score of "15"
        And "player two" has the score of "40"
        When I mark 1 points to "player two"
        Then scoreboard displays "0-0"
        And  set scoreboard displays "0-1"
        And  winner of this game is "player two wins the game"
        
    Scenario: Winning Game straight at 40-30 when starting Set
        Given "player one" has the score of "40"
        And "player two" has the score of "30"
        When I mark 1 points to "player one"
        Then scoreboard displays "0-0"
        And  set scoreboard displays "1-0"
        And  winner of this game is "player one wins the game" 
        
    Scenario: Winning Game straight at 40-adv when starting Set
        Given "player one" has the score of "40"
        And "player two" has the score of "adv"
        When I mark 1 points to "player two"
        Then scoreboard displays "0-0"
        And  set scoreboard displays "0-1"
        And  winner of this game is "player two wins the game"  
        
    Scenario Outline: Score Set counting up to 5
	   When I mark <p1> game to "player one"
	   And I mark <p2> game to "player two"
	   Then set scoreboard displays <score>
	   
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
           |  5 | 5  | "5-5" |    
           
           
     Scenario: Winning Set straight at 5-1
        Given "player one" has the game score of "5"
        And "player two" has the game score of "1"
        When I mark 1 game to "player one"
        Then scoreboard displays "0-0"
        And  set scoreboard displays "6-1"
        And  winner of this set is "player one wins the set"
        
    Scenario: Winning Set straight at 2-5
        Given "player one" has the game score of "2"
        And "player two" has the game score of "5"
        When I mark 1 game to "player two"
        Then scoreboard displays "0-0"
        And  set scoreboard displays "2-6"
        And  winner of this set is "player two wins the set"
        
    Scenario: Winning Set straight at 5-3
        Given "player one" has the game score of "5"
        And "player two" has the game score of "3"
        When I mark 1 game to "player one"
        Then scoreboard displays "0-0"
        And  set scoreboard displays "6-3"
        And  winner of this set is "player one wins the set"
        
    Scenario: Winning Set straight at 4-5
        Given "player one" has the game score of "4"
        And "player two" has the game score of "5"
        When I mark 1 game to "player two"
        Then scoreboard displays "0-0"
        And  set scoreboard displays "4-6"
        And  winner of this set is "player two wins the set"
    
   Scenario: Winning Set straight at 6-5
        Given "player one" has the game score of "6"
        And "player two" has the game score of "5"
        When I mark 1 game to "player one"
        Then scoreboard displays "0-0"
        And  set scoreboard displays "7-5"
        And  winner of this set is "player one wins the set"
        
   Scenario: Winning Set After Lead Set at 5-4 and Lead game at 40-0
        Given "player one" has the game score of "5"
        And   "player two" has the game score of "4"
        And   "player one" has the score of "40"
        And   "player two" has the score of "0"
        When  I mark 1 points to "player one"
        Then scoreboard displays "0-0"
        And  set scoreboard displays "6-4"
        And  winner of this set is "player one wins the set"
        
   Scenario: Winning Set After Lead Set at 5-3 and Lead game at 40-30
        Given "player one" has the game score of "5"
        And   "player two" has the game score of "3"
        And   "player one" has the score of "40"
        And   "player two" has the score of "30"
        When  I mark 1 points to "player one"
        Then scoreboard displays "0-0"
        And  set scoreboard displays "6-3"
        And  winner of this set is "player one wins the set"
        
   Scenario: Egality Set After Lead Set at 6-5 and Lead game at 15-40
        Given "player one" has the game score of "6"
        And   "player two" has the game score of "5"
        And   "player one" has the score of "15"
        And   "player two" has the score of "40"
        When  I mark 1 points to "player two"
        Then scoreboard displays "0-0"
        And  set scoreboard displays "6-6"
        
   Scenario: Winning Set After Lead Set at 5-6 and Lead game at 40-adv
        Given "player one" has the game score of "5"
        And   "player two" has the game score of "6"
        And   "player one" has the score of "40"
        And   "player two" has the score of "adv"
        When  I mark 1 points to "player two"
        Then scoreboard displays "0-0"
        And  set scoreboard displays "5-7"
        And  winner of this set is "player two wins the set"
        
   Scenario: Player one Break in Set After Lead Set at 3-2 and Lead game at 40-30
        Given "player one" has the game score of "3"
        And   "player two" has the game score of "2"
        And   "player one" has the score of "40"
        And   "player two" has the score of "30"
        When  I mark 1 points to "player one"
        Then scoreboard displays "0-0"
        And  set scoreboard displays "4-2"
