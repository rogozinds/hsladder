package hs.ladder.model;

public class Ladder {

	/*
	HS ladder system:
		Rank 25 - Rank 21: 2 Stars
		Rank 20 - Rank 16: 3 Stars
		Rank 15 - Rank 11: 4 Stars
		Rank 10 - Rank 1: 5 Stars
		Legend - No More Stars
	*/
    private static int[] ladder = {
    	0,
        5, 5, 5, 5, 5,
        5, 5, 5, 5, 5,
        4, 4, 4, 4, 4,
        3, 3, 3, 3, 3,
        2, 2, 2, 2, 2 };

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
