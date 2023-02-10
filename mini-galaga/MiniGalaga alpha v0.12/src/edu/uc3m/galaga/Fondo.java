package edu.uc3m.galaga;

import edu.uc3m.game.GameBoardGUI;

public class Fondo extends Sprite {

	public Fondo(int id, String FileName, GameBoardGUI gui) {
		this.id = id;
		this.gui = gui;
		gui.gb_addSprite(id, FileName, true);
		gui.gb_setSpriteImage(id, FileName, 493, 638);
		setX(85);
		setY(110);
	}

	public void Bajar() {
		setY(y + 1);
		if (y > 340)
			setY(-100);
	}

	public void setVisible(boolean visible) {
		gui.gb_setSpriteVisible(id, visible);
	}
}
