package edu.uc3m.galaga;

import edu.uc3m.game.GameBoardGUI;

public class Goei extends Enemy {
	boolean isEscolta1;
	boolean isEscolta2;
	int xRelativa;
	public int getxRelativa() {
		return xRelativa;
	}
	public void setxRelativa(int xRelativa) {
		this.xRelativa = xRelativa;
	}
	public int getyRelativa() {
		return yRelativa;
	}
	public void setyRelativa(int yRelativa) {
		this.yRelativa = yRelativa;
	}
	int yRelativa;
	public Goei(GameBoardGUI gui, int id) {
		this.gui = gui;
		this.id = id;
		points = 250;
		spriteFileNameIdle0 = "enemy200.png";
		spriteFileNameIdle1 = "enemy2G0.png";
		idleStart = (int)((Math.random())*60);
		rotationSpriteNames = new String[] { "enemy200.png", "enemy201.png", "enemy202.png", "enemy203.png",
				"enemy204.png", "enemy205.png", "enemy206.png", "enemy207.png", "enemy208.png", "enemy209.png",
				"enemy210.png", "enemy211.png", "enemy212.png", "enemy213.png", "enemy214.png", "enemy215.png" };
	}
	public boolean isEscolta1() {
		return isEscolta1;
	}
	public void setEscolta1(boolean isEscolta1) {
		this.isEscolta1 = isEscolta1;
	}
	public boolean isEscolta2() {
		return isEscolta2;
	}
	public void setEscolta2(boolean isEscolta2) {
		this.isEscolta2 = isEscolta2;
	}

}
