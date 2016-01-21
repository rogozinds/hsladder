package hs.ladder.model;

import static hs.ladder.model.GameResult.LOOSE;
import static hs.ladder.model.GameResult.WIN;
import hs.ladder.model.GameGenerator;
import hs.ladder.model.GameResult;
import hs.ladder.model.LadderSimulator;

import org.junit.Assert;
import org.junit.Test;

public class LadderTest {

    @Test
    public void testGameGenerator() {
        GameResult[] expected = new GameResult[10];
        for (int i = 0; i < expected.length; i++) {
            expected[i] = GameResult.WIN;
        }
        double winRate = 1.0f;
        int nGames = 10;
        GameResult[] results = GameGenerator.generate(nGames, winRate);

        Assert.assertArrayEquals(expected, results);

    }

    @Test
    public void test10WinRang5() {
        int currentRang = 20;
        int expectedRang = 17;
        GameResult[] results = GameGenerator.generate(5, 1.0f);
        LadderSimulator sim = new LadderSimulator();
        int newRang = sim.calc(currentRang, results);

        Assert.assertEquals(expectedRang, newRang);
    }

    @Test
    public void test1Win() {
        int currentRang = 20;
        int expectedRang = 20;
        GameResult[] results = { WIN };
        LadderSimulator sim = new LadderSimulator();
        int newRang = sim.calc(currentRang, results);

        Assert.assertEquals(expectedRang, newRang);
    }

    @Test
    public void test3Win() {
        int currentRang = 20;
        int expectedRang = 19;
        GameResult[] results = { WIN, WIN, WIN };
        LadderSimulator sim = new LadderSimulator();
        int newRang = sim.calc(currentRang, results);

        Assert.assertEquals(expectedRang, newRang);
    }

    @Test
    public void test4Win() {
        int currentRang = 20;
        int expectedRang = 18;
        GameResult[] results = { WIN, WIN, WIN, WIN };
        LadderSimulator sim = new LadderSimulator();
        int newRang = sim.calc(currentRang, results);

        Assert.assertEquals(expectedRang, newRang);
    }

    @Test
    public void test6WinLoss() {
        int currentRang = 20;
        int expectedRang = 16;
        GameResult[] results = { WIN, WIN, WIN, WIN, WIN, WIN, LOOSE, LOOSE,
                WIN, WIN };
        LadderSimulator sim = new LadderSimulator();
        int newRang = sim.calc(currentRang, results);

        Assert.assertEquals(expectedRang, newRang);
    }

    @Test
    public void testCalcGames() {
        int currentRang = 20;
        int expectedRang = 17;
        LadderSimulator sim = new LadderSimulator();
        int nGames = sim.calcGames(currentRang, expectedRang, 1.0f);

        Assert.assertEquals(5, nGames);

    }
}
