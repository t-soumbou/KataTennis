package kata.tennis.tests.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import kata.tennis.TennisGame;

public class TennisGameTest {

	private TennisGame game;
	private static final String PLAYERONEWINSGAME = "player one wins the game";
	private static final String PLAYERTWOWINSGAME = "player two wins the game";
	private static final String PLAYERONEWINSSET = "player one wins the set";
	private static final String PLAYERTWOWINSSET = "player two wins the set";
	private static final String PLAYERONEWINSMATCH = "player one wins the set and match";
	private static final String PLAYERTWOWINSMATCH = "player two wins the set and match";
	
	@Before
	public void setUp() {
		game = new TennisGame();
	}
	
	@Test
	public void gameBeginsFrom0_0() {
		assertEquals("0-0", game.getGameScore());
		assertEquals("0-0", game.getSetScore());
	}
	
	@Test
	public void playerOneScoresOnce() {
		game.playerOneScoresPoint();
		assertEquals("15-0", game.getGameScore());
		assertEquals("0-0", game.getSetScore());
	}

	@Test
	public void playerOneScoresTwice() {
		setScores(2,0);
		assertEquals("30-0", game.getGameScore());	
		assertEquals("0-0", game.getSetScore());
	}

	@Test
	public void playerTwoScoresOnce() {
		game.playerTwoScoresPoint();
		assertEquals("0-15", game.getGameScore());	
		assertEquals("0-0", game.getSetScore());
	}

	@Test
	public void playerTwoScoresThrice() {
		setScores(0,3);
		assertEquals("0-40", game.getGameScore());	
		assertEquals("0-0", game.getSetScore());
	}
	
	@Test
	public void bothPlayersScores3Times() {
		setScores(3,3);
		assertEquals("40-40", game.getGameScore());
		assertEquals("0-0", game.getSetScore());
	}
	
	@Test
	public void playerOneGainsAdvantage() {
		setScores(3,3);
		game.playerOneScoresPoint();
		assertEquals("adv-40", game.getGameScore());
		assertEquals("0-0", game.getSetScore());
	}
	
	@Test
	public void palyerOneLosesAdvantage() {
		setScores(3,3);
		game.playerOneScoresPoint();
		game.playerTwoScoresPoint();		
		assertEquals("40-40", game.getGameScore());
		assertEquals("0-0", game.getSetScore());
	}

	@Test
	public void playerTwoGainsAdvantage() {
		setScores(3,3);
		game.playerTwoScoresPoint();
		assertEquals("40-adv", game.getGameScore());
		assertEquals("0-0", game.getSetScore());
	}
	
	@Test
	public void palyerTwoLosesAdvantage() {
		setScores(3,3);
		game.playerTwoScoresPoint();
		game.playerOneScoresPoint();		
		assertEquals("40-40", game.getGameScore());
		assertEquals("0-0", game.getSetScore());
	}
	
	@Test
	public void playerOneWins() {
		setScores(3,0);
		game.playerOneScoresPoint();		
		assertEquals("0-0", game.getGameScore());
		assertEquals("1-0", game.getSetScore());
		assertEquals(PLAYERONEWINSGAME, game.getWinner());
	}
	
	@Test
	public void playerTwoWins() {
		setScores(1,3);
		game.playerTwoScoresPoint();		
		assertEquals("0-0", game.getGameScore());
		assertEquals("0-1", game.getSetScore());
		assertEquals(PLAYERTWOWINSGAME, game.getWinner());
	}
	
	@Test
	//sprint 1 us 1
	public void playerOneWinsWhenGameHaveNotAdvantage() {
		game.setPlayWithAdv(false);
		setScores(3,3);
		assertEquals("40-40", game.getGameScore());
		game.playerOneScoresPoint();		
		assertEquals("0-0", game.getGameScore());
		assertEquals("1-0", game.getSetScore());
		assertEquals(PLAYERONEWINSGAME, game.getWinner());
	}
	
	@Test
	//sprint 1 us 1
	public void playerTwoWinsWhenGameHaveNotAdvantage() {
		game.setPlayWithAdv(false);
		setScores(3,3);
		assertEquals("40-40", game.getGameScore());
		game.playerTwoScoresPoint();		
		assertEquals("0-0", game.getGameScore());
		assertEquals("0-1", game.getSetScore());
		assertEquals(PLAYERTWOWINSGAME, game.getWinner());
	}

	@Test
	public void playerOneWinsAfterAdvantage() {
		setScores(3,3);
		game.playerOneScoresPoint();
		game.playerOneScoresPoint();
		assertEquals("0-0", game.getGameScore());
		assertEquals("1-0", game.getSetScore());
		assertEquals(PLAYERONEWINSGAME, game.getWinner());
	}
	
	@Test
	public void playerTwoWinsAfterAdvantage() {
		setScores(3,3);
		game.playerTwoScoresPoint();
		game.playerTwoScoresPoint();
		assertEquals("0-0", game.getGameScore());
		assertEquals("0-1", game.getSetScore());
		assertEquals(PLAYERTWOWINSGAME, game.getWinner());
	}
	
	//Test Increment Game Win

	@Test
	public void playerOneScoresGameOnce() {
		game.playerOneWinsGame();
		assertEquals("1-0", game.getSetScore());		
	}

	@Test
	public void playerOneScoresGameTwice() {
		setScoresOfSet(2,0);
		assertEquals("2-0", game.getSetScore());		
	}

	@Test
	public void playerTwoScoresGameOnce() {
		game.playerTwoWinsGame();
		assertEquals("0-1", game.getSetScore());		
	}

	@Test
	public void playerTwoScoresGameThrice() {
		setScoresOfSet(0,3);
		assertEquals("0-3", game.getSetScore());		
	}
	
	@Test
	public void bothPlayersScoresGame3Times() {
		setScoresOfSet(3,3);
		assertEquals("3-3", game.getSetScore());
	}
	
	@Test
	public void bothPlayersScoresGame5Times() {
		setScoresOfSet(5,5);
		assertEquals("5-5", game.getSetScore());
	}
	
	@Test
	public void PlayerOneScoresGame5TimesAndOtherPlayerScoresGame6Times() {
		setScoresOfSet(5,6);
		assertEquals("5-6", game.getSetScore());
	}
	
	@Test
	public void PlayerOneScoresGame4TimesAndOtherPlayerScoresGame2Times() {
		setScoresOfSet(4,2);
		assertEquals("4-2", game.getSetScore());
	}
	
	// Test Good score of set when both have winned many gammes
	
	@Test
	public void scoreOfSetWhenPlayerOneWinsGameAfterBothPlayerWinGame3Times() {
		setScoresOfSet(4,2);
		setScores(3,0);
		game.playerOneScoresPoint();		
		assertEquals("5-2", game.getSetScore());
	}
	
	@Test
	public void scoreOfSetWhenPlayerTwoWinsAfterOnePlayerWinGame3TimesAndOttherWinsGame5Times() {
		setScoresOfSet(5,5);
		setScores(1,3);
		game.playerTwoScoresPoint();		
		assertEquals("5-6", game.getSetScore());
	}
	
	@Test
	public void scoreOfSetWhenPlayerTwoWinsAfterOnePlayerWinGame4TimesAndOttherWinsGame5Times() {
		setScoresOfSet(4,5);
		setScores(1,2);
		game.playerTwoScoresPoint();		
		assertEquals("4-5", game.getSetScore());
	}
	
	@Test
	public void scoreOfSetWhenPlayerTwoWinsAfterOnePlayerWinGame6TimesAndOttherWinsGame5Times() {
		setScoresOfSet(6,5);
		setScores(3,3);
		game.playerTwoScoresPoint();
		game.playerTwoScoresPoint();
		assertEquals("6-6", game.getSetScore());
		assertEquals("0-0", game.getTiebrekScore()); //test tiebrek activation
	}
	
	
	//test winning set
	@Test
	public void playerOneWinningSetAfterPlayerOneWins5TimeAndPlayerTwo4Times() {
		setScoresOfSet(5,4);
		setScores(3,3);
		game.playerOneScoresPoint();
		game.playerOneScoresPoint();
		assertEquals("0-0", game.getGameScore());
		assertEquals("6-4", game.getSetScore());
		assertEquals(PLAYERONEWINSSET, game.getWinner());
	}
	
	@Test
	public void playerTwoWinningSetAfterPlayerOneWins4TimeAndPlayerTwo5Times() {
		setScoresOfSet(4,5);
		setScores(1,3);
		game.playerTwoScoresPoint();
		assertEquals("0-0", game.getGameScore());
		assertEquals("4-6", game.getSetScore());
		assertEquals(PLAYERTWOWINSSET, game.getWinner());
	}
	
	@Test
	public void playerOneWinningSetAfterPlayerOneWins6TimeAndPlayerTwo5Times() {
		setScoresOfSet(6,5);
		setScores(3,3);
		game.playerOneScoresPoint();
		game.playerOneScoresPoint();
		assertEquals("0-0", game.getGameScore());
		assertEquals("7-5", game.getSetScore());
		assertEquals(PLAYERONEWINSSET, game.getWinner());
	}
	
	//test tiebrek increment score
	
	@Test
	public void playerOneScoresTiebrekOnce() {
		game.playerOneWinsTiebrekPoint();
		assertEquals("1-0", game.getTiebrekScore());		
	}

	@Test
	public void playerOneScoresTiebrekTwice() {
		setTiebrekScores(2,0);
		assertEquals("2-0", game.getTiebrekScore());		
	}

	@Test
	public void playerTwoScoresTiebrekOnce() {
		game.playerTwoWinsTiebrekPoint();
		assertEquals("0-1", game.getTiebrekScore());		
	}

	@Test
	public void playerTwoScoresTiebrekThrice() {
		setTiebrekScores(0,3);
		assertEquals("0-3", game.getTiebrekScore());		
	}
	
	@Test
	public void bothPlayersScoresTiebrek3Times() {
		setTiebrekScores(3,3);
		assertEquals("3-3", game.getTiebrekScore());
	}
	
	@Test
	public void bothPlayersScoresTiebrek6Times() {
		setTiebrekScores(6,6);
		assertEquals("6-6", game.getTiebrekScore());
	}
	
	// Test Good score of set when both have winned many tiebrekpoints
	
		@Test
		public void scoreOfTiebrekWhenPlayerOneWinsTiebrekPointAfterBothPlayerWin0TiebrekPoint() {
			setTiebrekScores(0,0);
			game.playerOneWinsTiebrekPoint();
			assertEquals("1-0", game.getTiebrekScore());
		}
		
		@Test
		public void scoreOfTiebrekWhenPlayerTwoWinsTiebrekPointAfterOnePlayerWinTiebrekPoint6TimesAndOttherWinsTiebrekPoint5Times() {
			setTiebrekScores(6,5);
			game.playerTwoWinsTiebrekPoint();		
			assertEquals("6-6", game.getTiebrekScore());
		}
		
		@Test
		public void scoreOfTiebrekWhenPlayerTwoWinsAfterOnePlayerWinTiebrekPoint4TimesAndOttherWinsTiebrekPoint5Times() {
			setTiebrekScores(4,5);
			game.playerTwoWinsTiebrekPoint();		
			assertEquals("4-6", game.getTiebrekScore());
		}
		
		// Test winning tiebrek
		@Test
		public void PlayerOneWinTiebrekAfterOnePlayerWinGame6TimesAndOttherWinsGame5Times() {
			setScoresOfSet(6,6);
			setTiebrekScores(6,5);
			game.playerOneWinsTiebrekPoint();
			assertEquals("0-0", game.getGameScore());
			assertEquals("0-0", game.getTiebrekScore());
			assertEquals("7-6", game.getSetScore());
			assertEquals(PLAYERONEWINSMATCH, game.getWinner());
		}
		
		@Test
		public void PlayerOneWinTiebrekAfterOnePlayerWinGame6TimesAndOttherWinsGame7Times() {
			setScoresOfSet(6,6);
			setTiebrekScores(6,7);
			game.playerTwoWinsTiebrekPoint();
			assertEquals("0-0", game.getGameScore());
			assertEquals("0-0", game.getTiebrekScore());
			assertEquals("6-7", game.getSetScore());
			assertEquals(PLAYERTWOWINSMATCH, game.getWinner());
		}
		
		private void setScores(int p1, int p2) {
			for (int i=0; i < p1; i++) {
				game.playerOneScoresPoint();
			}
			for (int i=0; i < p2; i++) {
				game.playerTwoScoresPoint();
			}
		}
		
		private void setTiebrekScores(int p1, int p2) {
			for (int i=0; i < p1; i++) {
				game.playerOneWinsTiebrekPoint();
			}
			for (int i=0; i < p2; i++) {
				game.playerTwoWinsTiebrekPoint();
			}
		}
		
		private void setScoresOfSet(int p1, int p2) {
			for (int i=0; i < p1; i++) {
				game.playerOneWinsGame();
			}
			for (int i=0; i < p2; i++) {
				game.playerTwoWinsGame();
			}
		}
}
