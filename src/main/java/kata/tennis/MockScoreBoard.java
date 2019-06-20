package kata.tennis;

public class MockScoreBoard implements ScoreBoard{
	public String currentScore;

	public void updateScore(String score) {
		currentScore = score;
	}
}