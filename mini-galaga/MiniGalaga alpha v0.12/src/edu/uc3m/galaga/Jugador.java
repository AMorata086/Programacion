package edu.uc3m.galaga;

import edu.uc3m.game.GameBoardGUI;

public class Jugador extends Sprite {
	private int hp = 3;
	
	public Jugador(GameBoardGUI gui) {
		this.gui = gui;
		this.id = 0;
		currentSpriteFileName = "player.png";
		rotationSpriteNames = new String[] { "player.png", "enemy101.png", "enemy102.png", "enemy103.png",
				"enemy104.png", "enemy105.png", "enemy106.png", "enemy107.png", "enemy108.png", "enemy109.png",
				"enemy110.png", "enemy111.png", "enemy112.png", "enemy113.png", "enemy114.png", "enemy115.png" };
	}
	
	public void setX(int x) {
		if (x <= Conf.WIDTH*10-5 && x >= 5) {
			this.x = x;
			gui.gb_moveSpriteCoord(id, x, y);
		}
	}
	
	public void reduceHP() {
		hp--;
		gui.gb_setValueHealthCurrent(hp);
		if (hp == 0)
			MiniGalaga.exit = true;
	}
}
