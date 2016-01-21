package hs.ladder.model;

public class Ladder {

    private static int[] ladder = { 0, 5, 5, 5, 5,
        4, 4, 4, 4, 4,
        4, 4, 4, 4, 4,
        3, 3, 3, 3, 3,
        3, 3, 3, 3, 3,
        3, 3, 3, 3, 3 };

    public static int[] get() {
        return ladder;
    }

    /**
     * Return amount of stars in rang
     *
     * @param index
     *            of rang in ladder
     * @return
     */
    public static int getStars(int index) {
        return ladder[index];
    }
}
