package kata.tennis.tests.cucumber;

import static org.junit.Assert.assertEquals;

import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import kata.tennis.MockScoreBoard;
import kata.tennis.TennisGame;

public class TennisSteps {

	private TennisGame game;
	private MockScoreBoard sb;
	private  final static String PLAYERONE = "player one";
	private  final static String PLAYERTWO = "player two";
	
	@Before
	public void setUp() {
		game = new TennisGame();
		sb = new MockScoreBoard();
		game.attach(sb);
	}
	
	@Given("^no points have been scored$")
	public void no_points_have_been_scored() throws Throwable {
	}

	@Then("^scoreboard displays \"([^\"]*)\"$")
	public void scoreboard_displays(String score) throws Throwable {
		assertEquals(score, sb.currentScore);
	}

	@When("^I mark (\\d+) points to \"([^\"]*)\"$")
	public void I_mark_points_to(int points, String player) throws Throwable {
		incrementGameScore(player , points);
	}
	
	@Given("^\"([^\"]*)\" has the score of \"([^\"]*)\"$")
	public void has_the_score_of(String player, String score) throws Throwable {
		game.setPlayWithAdv(true);
		incrementGameScore(player , game.getScoresDefs().indexOf(score));
	}
	
	@Given("^\"([^\"]*)\" has the score without adv of \"([^\"]*)\"$")
	public void has_the_score_without_adv_of(String player, String score) throws Throwable {
		game.setPlayWithAdv(false);
		incrementGameScore(player , game.getScoresDefs().indexOf(score));
	}
	
	@Given("^no game have been scored$")
	public void no_game_have_been_scored() throws Throwable {
	}
	
	@Then("^set scoreboard displays \"([^\"]*)\"$")
	public void set_scoreboard_displays(String score) throws Throwable {
		assertEquals(score, game.getSetScore());
	}

	@When("^I mark (\\d+) game to \"([^\"]*)\"$")
	public void I_mark_game_to(int _game, String player) throws Throwable {
		incremnteSetScore(player, _game);
	}

	@Given("^\"([^\"]*)\" has the game score of \"([^\"]*)\"$")
	public void has_the_game_score_of(String player, String score) throws Throwable {
		incremnteSetScore(player, Integer.valueOf(score));
	}
	

	@Then("^winner of this game is \"([^\"]*)\"$")
	public void winner_of_this_game_is(String winner) throws Throwable {
		assertEquals(winner, game.getWinner());
	}

	@Given("^no points have been scored in set$")
	public void no_points_have_been_scored_in_set() throws Throwable {
	}
	
	
	@Then("^winner of this set is \"([^\"]*)\"$")
	public void winner_of_this_set_is(String winner) throws Throwable {
		assertEquals(winner, game.getWinner());
	}
	
	@Then("^tiebrek scoreboard displays \"([^\"]*)\"$")
	public void tiebrek_scoreboard_displays(String score) throws Throwable {
		assertEquals(score, game.getTiebrekScore());
	}
	@When("^I mark (\\d+) tiebrek point to \"([^\"]*)\"$")
	public void I_mark_tiebrek_point_to(int tiebrekPoint, String player) throws Throwable {
		incrementTiebrekScore(player, tiebrekPoint);
	}

	@Given("^\"([^\"]*)\" has the tiebrek score of \"([^\"]*)\"$")
	public void has_the_tiebrek_score_of(String player, String score) throws Throwable {
		incrementTiebrekScore(player, Integer.valueOf(score));
	}
	
	@Then("^winner of this match is \"([^\"]*)\"$")
	public void winner_of_this_match_is(String winner) throws Throwable {
		assertEquals(winner, game.getWinner());
	}
	
	private void incremnteSetScore(String player, int score)  {
		if (player.equals(PLAYERONE)) {
			incrementPlayerOneSetScore(score);
		}
		if (player.equals(PLAYERTWO)) {
			incrementPlayerTwoSetScore(score);
		}
	}
	
	private void incrementPlayerOneSetScore(int score) {
		for (int i=0; i < score; i++) {
			game.playerOneWinsGame();
		}
	}
	
	private void incrementPlayerTwoSetScore(int score) {
		for (int i=0; i < score; i++) {
			game.playerTwoWinsGame();
		}
	}
	
	private void incrementTiebrekScore(String player, int score) {
		if (player.equals(PLAYERONE)) {
			incrementPlayerOneTiebrekScore(score);
		}
		if (player.equals(PLAYERTWO)) {
			incrementPlayerTwoTiebrekScore(score);
		}
	}
	
	private void incrementPlayerOneTiebrekScore(int score) {
		for (int i=0; i < score; i++) {
			game.playerOneWinsTiebrekPoint();
		}
	}
	
	private void incrementPlayerTwoTiebrekScore(int score) {
		for (int i=0; i < score; i++) {
			game.playerTwoWinsTiebrekPoint();
		}
	}
	
	private void incrementGameScore(String player , int score) {
		if (player.equals(PLAYERONE)) {
			incrementPlayerOneGameScore(score);
		}
		if (player.equals(PLAYERTWO)) {
			incrementPlayerTwoGameScore(score);
		}
	}
	
	private void incrementPlayerOneGameScore(int score) {
		for (int i=0; i < score; i++) {
			game.playerOneScoresPoint();
		}
	}
	
	private void incrementPlayerTwoGameScore(int score) {
		for (int i=0; i < score; i++) {
			game.playerTwoScoresPoint();
		}
	}
}
