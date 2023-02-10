package edu.uc3m.galaga;

import edu.uc3m.game.GameBoardGUI;

public class Zako extends Enemy{

	public Zako(GameBoardGUI gui, int id) {
		this.gui = gui;
		this.id = id;
		spriteFileNameIdle0 = "enemy300.png";
		spriteFileNameIdle1 = "enemy3G0.png";
		points = 100;
		idleStart = (int)((Math.random())*60) + 1;
		rotationSpriteNames = new String[] { "enemy300.png", "enemy301.png", "enemy302.png", "enemy303.png",
				"enemy304.png", "enemy305.png", "enemy306.png", "enemy307.png", "enemy308.png", "enemy309.png",
				"enemy310.png", "enemy311.png", "enemy312.png", "enemy313.png", "enemy314.png", "enemy315.png" };
	}
	
}
