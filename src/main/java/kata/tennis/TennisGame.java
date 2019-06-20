package kata.tennis;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TennisGame {

	
	private List<ScoreBoard> scoreboards = new ArrayList<ScoreBoard>();
	private boolean playWithAdv = true;
	private String winner;
	private Player playerOne;
	private Player playerTwo;
	private List<String> scoresDefs = Arrays.asList("0", "15", "30", "40", "adv" );
	
	public List<String> getScoresDefs() {
		return scoresDefs;
	}

	public String getGameScore() {
		return scoresDefs.get(playerOne.getTracker()) + "-" + scoresDefs.get(playerTwo.getTracker());
	}
	
	public String getSetScore() {
		return playerOne.getSetTracker() + "-" + playerTwo.getSetTracker();
	}
	
	public String getTiebrekScore() {
		return playerOne.getTiebrekTracker()+ "-" + playerTwo.getTiebrekTracker();
	}
	
	public TennisGame() {
		playerOne = new Player("player one");
		playerTwo = new Player("player two");
	}
	
	public void attach(ScoreBoard sb) {
		scoreboards.add(sb);
		sb.updateScore(getGameScore());		
	}	

	public void playerOneScoresPoint() {
		playerScoresPoint(this.playerOne, this.playerTwo );
	}

	public void playerTwoScoresPoint() {
		playerScoresPoint(this.playerTwo, this.playerOne );
	}	
	
	public void playerOneWinsGame() {
		playerWinsGame(this.playerOne, this.playerTwo );
	}
	
   public void playerTwoWinsGame() {
	   playerWinsGame(this.playerTwo, this.playerOne );
	}
   
   public void playerOneWinsTiebrekPoint() {
	  playerWinsTiebrekPoint(this.playerOne, this.playerTwo );
	}
	
  public void playerTwoWinsTiebrekPoint() {
	  playerWinsTiebrekPoint(this.playerTwo, this.playerOne );
	}
   
	
	private boolean hasAdvantage(Player player) {
		return player.getTracker() == scoresDefs.indexOf("adv");		
	}
	
	private void updateScores() {
		for (ScoreBoard sb : scoreboards) {
			sb.updateScore(getGameScore());
		}
	}

	private void setFinalScore(Player winner, Player loser) {
		winner.setTracker(0);
		loser.setTracker(0);
		this.setWinner(winner.getName() +" wins the game");
	}
	
	private boolean checkForNormalWin(Player candidate, Player other) {
		return rulesForWinGameWithoutAdvantage(candidate, other );	
	}
	
	private boolean checkForNormalWinSet(Player candidate, Player other) {
		return rulesForwinSetUpToGameSix(candidate,other) || rulesForwinSetAfterGameSix(candidate, other);
	}
	
	private void playerScoresPoint(Player scoredPlayer, Player otherPlayer ) {
		if (hasAdvantage(otherPlayer)) {
			otherPlayer.setTracker(otherPlayer.getTracker() - 1);
		}
		else if (checkForNormalWin(scoredPlayer, otherPlayer)) {
			winAction(scoredPlayer, otherPlayer);
		}
		else if (scoredPlayer.getTracker() == scoresDefs.indexOf("40") && !playWithAdv) {
			winAction(scoredPlayer, otherPlayer);
			}
		else if (scoredPlayer.getTracker() == scoresDefs.indexOf("adv")) {
			winAction(scoredPlayer, otherPlayer);
			}
		else scoredPlayer.setTracker(scoredPlayer.getTracker() + 1);
		updateScores();
	}
	
	private void playerWinsGame(Player scoredPlayer , Player otherPlayer) {
		if (checkForNormalWinSet(scoredPlayer, otherPlayer)) {
			scoredPlayer.setSetTracker(scoredPlayer.getSetTracker() + 1);
			this.setWinner(scoredPlayer.getName() +" wins the set");
		}
		else if (scoredPlayer.getSetTracker() == 6 && otherPlayer.getSetTracker() == 6) {
			playerWinsTiebrekPoint(scoredPlayer, otherPlayer);
		}
		else scoredPlayer.setSetTracker(scoredPlayer.getSetTracker()+ 1);
	}
	
	private void setFinalTieBrekScore(Player winnedPlayer, Player loserPlayer) {
		winnedPlayer.setTiebrekTracker(0);
		loserPlayer.setTiebrekTracker(0);
		this.setWinner(winnedPlayer.getName() +" wins the set and match");
	}

	private boolean checkConditionForWinTieBrek(Player candidate, Player other) {
		return candidate.getTiebrekTracker() >= 6 && (candidate.getTiebrekTracker()-other.getTiebrekTracker()) == 1;
	}

	private void winAction(Player scoredPlayer, Player otherPlayer ) {
		setFinalScore(scoredPlayer, otherPlayer);
		playerWinsGame(scoredPlayer,otherPlayer);
	}
	
	private boolean rulesForwinSetUpToGameSix(Player candidate, Player other ) {
		return (candidate.getSetTracker() == 5 && other.getSetTracker() < 5);
	}
	
	private boolean rulesForwinSetAfterGameSix(Player candidate, Player other ) {
		return (candidate.getSetTracker() == 6 && other.getSetTracker() == 5) ;
	}
	
	private boolean rulesForWinGameWithoutAdvantage(Player candidate, Player other ) {
		return candidate.getTracker() == scoresDefs.indexOf("40") && other.getTracker() < scoresDefs.indexOf("40");
	}
	
	private void playerWinsTiebrekPoint(Player scoredPlayer, Player otherPlayer) {
		if(checkConditionForWinTieBrek(scoredPlayer, otherPlayer)) {
			setFinalTieBrekScore(scoredPlayer, otherPlayer);
			scoredPlayer.setSetTracker(scoredPlayer.getSetTracker()+ 1);
		}else {
			scoredPlayer.setTiebrekTracker(scoredPlayer.getTiebrekTracker() +1);
		}
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	public boolean isPlayWithAdv() {
		return playWithAdv;
	}

	public void setPlayWithAdv(boolean playWithAdv) {
		this.playWithAdv = playWithAdv;
	}
	
}
