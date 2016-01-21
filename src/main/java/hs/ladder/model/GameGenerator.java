package hs.ladder.model;

import java.util.Random;

public class GameGenerator {

    public static GameResult[] generate(int nGames, double winRate) {
        GameResult[] games = new GameResult[nGames];
        for (int i = 0; i < nGames; i++) {
            games[i] = simulateGameResult(winRate);
        }
        return games;
    }

    private static GameResult simulateGameResult(double winRate) {
        Random rand = new Random();
        int winRateInPercent =(int) (winRate * 100);
        int r = rand.nextInt(100);

        if (r < winRateInPercent) {
            return GameResult.WIN;
        } else {
            return GameResult.LOOSE;
        }
    }
}
