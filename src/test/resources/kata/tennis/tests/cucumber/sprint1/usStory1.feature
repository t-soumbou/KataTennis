Feature: Score counting up to 40 And Winning Rules : SPRINT 1 US Story 1
	
	Scenario: Start Game at 0-0
	   Given no points have been scored
	   Then scoreboard displays "0-0"
				
	Scenario Outline: Score counting up to 40
	   When I mark <p1> points to "player one"
	   And I mark <p2> points to "player two"
	   Then scoreboard displays <score>
	   
	   Examples:
	       | p1 | p2 | score   | 
	       |  0 | 0  | "0-0"   |
	       |  1 | 0  | "15-0"  |
           |  2 | 0  | "30-0"  |
           |  2 | 1  | "30-15" |
           |  3 | 1  | "40-15" |
           |  3 | 2  | "40-30" |
           |  3 | 3  | "40-40" |    
        
    Scenario: Winning straight at 40-0
        Given "player one" has the score of "40"
        And "player two" has the score of "0"
        When I mark 1 points to "player one"
        Then scoreboard displays "0-0"
        And  winner of this game is "player one wins the game"
        
    Scenario: Winning straight at 15-40
        Given "player one" has the score of "15"
        And "player two" has the score of "40"
        When I mark 1 points to "player two"
        Then scoreboard displays "0-0"
        And  winner of this game is "player two wins the game"
        
    Scenario: Winning straight at 40-30
        Given "player one" has the score of "40"
        And "player two" has the score of "30"
        When I mark 1 points to "player one"
        Then scoreboard displays "0-0"
        And  winner of this game is "player one wins the game"
           
     Scenario: Winning at Deuce
        Given "player one" has the score without adv of "40"
        And   "player two" has the score without adv of "40"
        When I mark 1 points to "player two"
        Then scoreboard displays "0-0"
        And  winner of this game is "player two wins the game"