package hs.ladder.model;

public class LadderSimulator {

	private final int MIN_RANG = 25;
	private final int MAX_RANG = 0;
	private int currentRang;
	private int curStars = 0;
	private int winStreak = 0;

	public LadderSimulator() {

	}

	/**
	 *
	 * @param currentRang
	 * @param results
	 * @return newRang
	 */
	public int calc(int currentRang, GameResult[] results) {
		this.currentRang = currentRang;
		winStreak = 0;
		for (int i = 0; i < results.length; i++) {
			simGame(results[i]);
		}
		return this.currentRang;
	}

	public int calcGames(int currentRang, int expectedRang, double winRate,
			int nAttempts) {
		int sum = 0;
		for (int i = 0; i < nAttempts; i++) {
			sum += calcGamesOnce(currentRang, expectedRang, winRate);
		}
		return sum / nAttempts;
	}

	public int calcGames(int currentRang, int expectedRang, double winRate) {
		return calcGames(currentRang,expectedRang,winRate,10000);
	}
	
	private int calcGamesOnce(int currentRang, int expectedRang, double winRate) {
		this.currentRang = currentRang;
		int nGames = 0;
		GameResult[] results = GameGenerator.generate(10, winRate);
		int index = 0;
		while (expectedRang != this.currentRang) {
			++nGames;
			simGame(results[index]);
			++index;
			if (index >= 10) {
				results = GameGenerator.generate(10, winRate);
				index = 0;
			}

			if (nGames > 10000) {
				return 10000;
			}
		}
		return nGames;
	}

	private void simGame(GameResult res) {
		if (res == GameResult.LOOSE) {
			lost();
		} else {
			win();
		}
	}

	private void win() {
		int starsToGo = Ladder.get()[currentRang];
		++winStreak;
		int stars = addedStars();
		if ( curStars + stars < starsToGo ) {
			curStars += stars;
		} else {
			--currentRang;
			curStars = curStars + stars - starsToGo;
		}
	}

	private int addedStars() {
		if (winStreak >= 3) {
			return 2;
		} else {
			return 1;
		}
	}

	private void lost() {
		winStreak = 0;
		if (curStars == 0) {
			if (currentRang < MIN_RANG) {
				++currentRang;
			}
		} else {
			--curStars;
		}
	}

}
