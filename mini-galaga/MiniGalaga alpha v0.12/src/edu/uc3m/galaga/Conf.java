package edu.uc3m.galaga;

public abstract class Conf {
	public static final int WIDTH = 17;
	public static final int HEIGHT = 22;
	public static final int CADENCIA = 20;
	public static final int SPEED = 30;

	static public final int DIR_N = 0;
	static public final int DIR_NNE = 1;
	static public final int DIR_NE = 2;
	static public final int DIR_ENE = 3;
	static public final int DIR_E = 4;
	static public final int DIR_ESE = 5;
	static public final int DIR_SE = 6;
	static public final int DIR_SSE = 7;
	static public final int DIR_S = 8;
	static public final int DIR_SSW = 9;
	static public final int DIR_SW = 10;
	static public final int DIR_WSW = 11;
	static public final int DIR_W = 12;
	static public final int DIR_WNW = 13;
	static public final int DIR_NW = 14;
	static public final int DIR_NNW = 15;

	static public final int[][] MOVES = { { 0, -1 }, // DIR_N
			{ 1, -3 }, // DIR_NNE
			{ 1, -1 }, // DIR_NE
			{ 3, -1 }, // DIR_ENE
			{ 1, 0 }, // DIR_E
			{ 3, 1 }, // DIR_ESE
			{ 1, 1 }, // DIR_SE
			{ 1, 3 }, // DIR_SSE
			{ 0, 1 }, // DIR_S
			{ -1, 3 }, // DIR_SSW
			{ -1, 1 }, // DIR_SW
			{ -3, 1 }, // DIR_WSW
			{ -1, 0 }, // DIR_W
			{ -3, -1 }, // DIR_WNW
			{ -1, -1 }, // DIR_NW
			{ -1, -3 }, // DIR_NNW
	};

}
