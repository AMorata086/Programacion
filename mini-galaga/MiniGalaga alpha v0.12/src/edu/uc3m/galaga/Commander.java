package edu.uc3m.galaga;

import edu.uc3m.game.GameBoardGUI;

public class Commander extends Enemy {

	private int idAsociada1;
	private int idAsociada2;

	public Commander(GameBoardGUI gui, int id, int idAsociada1, int idAsociada2) {
		this.gui = gui;
		this.id = id;
		spriteFileNameIdle0 = "enemy100.png";
		spriteFileNameIdle1 = "enemy1G0.png";
		hasExtraHP = true;
		points = 500;
		this.idAsociada1 = idAsociada1;
		this.idAsociada2 = idAsociada2;
		idleStart = (int) ((Math.random()) * 60);
		rotationSpriteNames = new String[] { "enemy100.png", "enemy101.png", "enemy102.png", "enemy103.png",
				"enemy104.png", "enemy105.png", "enemy106.png", "enemy107.png", "enemy108.png", "enemy109.png",
				"enemy110.png", "enemy111.png", "enemy112.png", "enemy113.png", "enemy114.png", "enemy115.png" };
	}

	public int getIdAsociada1() {
		return idAsociada1;
	}

	public int getIdAsociada2() {
		return idAsociada2;
	}
	public void reduceHP() {
		hasExtraHP = false;
		spriteFileNameIdle0 = "enemy900.png";
		spriteFileNameIdle1 = "enemy9G0.png";
		rotationSpriteNames = new String[] { "enemy9G0.png", "enemy901.png", "enemy902.png", "enemy903.png",
				"enemy904.png", "enemy905.png", "enemy906.png", "enemy907.png", "enemy908.png", "enemy909.png",
				"enemy910.png", "enemy911.png", "enemy912.png", "enemy913.png", "enemy914.png", "enemy915.png" };
		
		switch (currentSpriteFileName) {
		case "enemy100.png":
			setSpriteImage("enemy900.png");
			break;
		case "enemy1G0.png":
			setSpriteImage("enemy9G0.png");
			break;
		case "enemy101.png":
			setSpriteImage("enemy901.png");
			break;
		case "enemy102.png":
			setSpriteImage("enemy902.png");
			break;
		case "enemy103.png":
			setSpriteImage("enemy903.png");
			break;
		case "enemy104.png":
			setSpriteImage("enemy904.png");
			break;
		case "enemy105.png":
			setSpriteImage("enemy905.png");
			break;
		case "enemy106.png":
			setSpriteImage("enemy906.png");
			break;
		case "enemy107.png":
			setSpriteImage("enemy907.png");
			break;
		case "enemy108.png":
			setSpriteImage("enemy908.png");
			break;
		case "enemy109.png":
			setSpriteImage("enemy909.png");
			break;
		case "enemy110.png":
			setSpriteImage("enemy910.png");
			break;
		case "enemy111.png":
			setSpriteImage("enemy911.png");
			break;
		case "enemy112.png":
			setSpriteImage("enemy912.png");
			break;
		case "enemy113.png":
			setSpriteImage("enemy913.png");
			break;
		case "enemy114.png":
			setSpriteImage("enemy914.png");
			break;
		case "enemy115.png":
			setSpriteImage("enemy915.png");
			break;
		}

	}
}
