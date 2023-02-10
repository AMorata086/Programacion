package edu.uc3m.galaga;

import edu.uc3m.game.GameBoardGUI;

public abstract class Sprite {
	protected boolean isAlive;
	protected int id;
	protected int x;
	protected int y;
	protected int finalX;
	protected int finalY;
	protected String spriteFileNameIdle0;
	protected String spriteFileNameIdle1;
	protected String currentSpriteFileName;
	protected GameBoardGUI gui;
	protected String[] rotationSpriteNames;
	protected boolean isGoToDone;
	protected boolean isCircleDone;
	protected int pasoCircle;
	protected int xInCircle;
	protected int yInCircle;
	protected boolean isMidPasoCircle;
	protected boolean circleHasJustBegan = true;
	String spriteNameInicioCircle;

	public String getSpriteFileNameIdle0() {
		return spriteFileNameIdle0;
	}

	public String getSpriteFileNameIdle1() {
		return spriteFileNameIdle1;
	}

	public int getFinalX() {
		return finalX;
	}

	public void setFinalX(int finalX) {
		this.finalX = finalX;
	}

	public int getFinalY() {
		return finalY;
	}

	public void setFinalY(int finalY) {
		this.finalY = finalY;
	}

	public String getCurrentSpriteFileName() {
		return currentSpriteFileName;
	}

	public void setCurrentSpriteFileName(String currentSpriteFileName) {
		this.currentSpriteFileName = currentSpriteFileName;
	}

	public boolean isZigzagueando() {
		return isZigzagueando;
	}

	public void setZigzagueando(boolean isZigzagueando) {
		this.isZigzagueando = isZigzagueando;
	}

	public boolean isGankeando() {
		return isGankeando;
	}

	public void setGankeando(boolean isGankeando) {
		this.isGankeando = isGankeando;
	}

	public boolean isExpedicionCompletada() {
		return expedicionCompletada;
	}

	public void setExpedicionCompletada(boolean expedicionCompletada) {
		this.expedicionCompletada = expedicionCompletada;
	}

	protected boolean isZigzagueando;
	protected boolean isGankeando;
	protected boolean expedicionCompletada;

	public void move(int direction, int speed) {
		x = x + speed * Conf.MOVES[direction][0];
		y = y + speed * Conf.MOVES[direction][1];
		gui.gb_moveSpriteCoord(id, x, y);
		setSpriteImage(rotationSpriteNames[direction]);
	}

	public void setSpriteImage(String imageName) {
		gui.gb_setSpriteImage(id, imageName);
		currentSpriteFileName = imageName;
	}

	public String getSpriteFileName() {
		return currentSpriteFileName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		gui.gb_moveSpriteCoord(id, x, y);
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		gui.gb_moveSpriteCoord(id, x, y);
	}

	public void setSpriteFileNameIdle0(String spriteFileNameIdle0) {
		this.spriteFileNameIdle0 = spriteFileNameIdle0;
	}

	public void setSpriteFileNameIdle1(String spriteFileNameIdle1) {
		this.spriteFileNameIdle1 = spriteFileNameIdle1;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public void goTo(double toX, double toY, int speed) {
		double difX = toX - x;
		double difY = toY - y;
		if (difX != 0 || difY != 0)
			isGoToDone = false;
		if (difX != 0 && difY != 0) {
			if (difX == 1 && difY == -2) {
				move(4, 1);
				move(0, 2);
				setSpriteImage(rotationSpriteNames[1]);
			} else if (difX == 1 && difY == 2) {
				move(4, 1);
				move(12, 2);
				setSpriteImage(rotationSpriteNames[7]);
			} else if (difX == 2 && difY == 1) {
				move(4, 2);
				move(8, 1);
				setSpriteImage(rotationSpriteNames[5]);
			} else if (difX == 2 && difY == -1) {
				move(0, 1);
				move(4, 2);
				setSpriteImage(rotationSpriteNames[3]);
			} else if (difX == -1 && difY == -2) {
				move(12, 1);
				move(0, 2);
				setSpriteImage(rotationSpriteNames[15]);
			} else if (difX == -2 && difY == -1) {
				move(8, 1);
				move(12, 2);
				setSpriteImage(rotationSpriteNames[13]);
			} else if (difX == -1 && difY == 2) {
				move(8, 2);
				move(12, 1);
				setSpriteImage(rotationSpriteNames[9]);
			} else if (difX == -2 && difY == 1) {
				move(12, 2);
				move(8, 1);
				setSpriteImage(rotationSpriteNames[11]);
			} else if ((difX == 2 && difY == -3) || (difX == 3 && difY == -2)) {
				move(2, 1);
			} else if ((difX == 2 && difY == 3) || (difX == 3 && difY == 2)) {
				move(6, 1);
			} else if ((difX == -2 && difY == 3) || (difX == -3 && difY == 2)) {
				move(10, 1);
			} else if ((difX == -2 && difY == -3) || (difX == -3 && difY == -2)) {
				move(14, 1);
			} else if (difX == 1 && difY == 1) {
				move(6, 1);
			} else if (difX == 1 && difY == -1) {
				move(2, 1);
			} else if (difX == -1 && difY == 1) {
				move(10, 1);
			} else if (difX == -1 && difY == -1) {
				move(14, 1);
			} else if (difX == 2 && difY == 2) {
				move(6, 2);
			} else if (difX == 2 && difY == -2) {
				move(2, 2);
			} else if (difX == -2 && difY == 2) {
				move(10, 2);
			} else if (difX == -2 && difY == -2) {
				move(14, 2);
			}

			else if (Math.abs(difY) >= 3 || Math.abs(difX) >= 3) {
				double angle = Math.atan(Math.abs(difY) / Math.abs(difX)) * 180 / Math.PI;
				if (difX > 0 && difY < 0) {
					if (angle <= 11.25)
						move(4, 3);
					else if (angle <= 33.75)
						move(3, 1);
					else if (angle <= 56.25)
						move(2, 2);
					else if (angle <= 78.75)
						move(1, 1);
					else
						move(0, 3);
				} else if (difX < 0 && difY < 0) {
					if (angle <= 11.25)
						move(12, 3);
					else if (angle <= 33.75)
						move(13, 1);
					else if (angle <= 56.25)
						move(14, 2);
					else if (angle <= 78.75)
						move(15, 1);
					else
						move(0, 3);
				} else if (difX < 0 && difY > 0) {
					if (angle <= 11.25)
						move(12, 3);
					else if (angle <= 33.75)
						move(11, 1);
					else if (angle <= 56.25)
						move(10, 2);
					else if (angle <= 78.75)
						move(9, 1);
					else
						move(8, 3);
				} else if (difX > 0 && difY > 0) {
					if (angle <= 11.25)
						move(4, 3);
					else if (angle <= 33.75)
						move(5, 1);
					else if (angle <= 56.25)
						move(6, 2);
					else if (angle <= 78.75)
						move(7, 1);
					else
						move(8, 3);
				}
			}
		} else if (difY == 0 && difX != 0) {
			if (difX > 2)
				move(4, 3);
			else if (difX == 2)
				move(4, 2);
			else if (difX == 1)
				move(4, 1);
			else if (difX < -2)
				move(12, 3);
			else if (difX == -2)
				move(12, 2);
			else if (difX == -1)
				move(12, 1);
		} else if (difX == 0 && difY != 0) {
			if (difY > 2)
				move(8, 3);
			else if (difY == 2)
				move(8, 2);
			else if (difY == 1)
				move(8, 1);
			else if (difY < -2)
				move(0, 3);
			else if (difY == -2)
				move(0, 2);
			else if (difY == -1)
				move(0, 1);
		}
		if ((int) x == (int) toX && (int) y == (int) toY) {
			isGoToDone = true;

		}
	}

	public void doPasoCircle(int loquetoca, int radio) {
		if (loquetoca == 0) {
			goTo(xInCircle, yInCircle - radio, 1);
		} else if (loquetoca == 1) {
			goTo(xInCircle + radio, yInCircle - 2 * radio, 1);
		} else if (loquetoca == 2) {
			goTo(xInCircle + radio, yInCircle - radio, 1);
		} else if (loquetoca == 3) {
			goTo(xInCircle + 2 * radio, yInCircle - radio, 1);
		} else if (loquetoca == 4) {
			goTo(xInCircle + radio, yInCircle, 1);
		} else if (loquetoca == 5) {
			goTo(xInCircle + 2 * radio, yInCircle + radio, 1);
		} else if (loquetoca == 6) {
			goTo(xInCircle + radio, yInCircle + radio, 1);
		} else if (loquetoca == 7) {
			goTo(xInCircle + radio, yInCircle + 2 * radio, 1);
		} else if (loquetoca == 8) {
			goTo(xInCircle, yInCircle + radio, 1);
		} else if (loquetoca == 9) {
			goTo(xInCircle - radio, yInCircle + 2 * radio, 1);
		} else if (loquetoca == 10) {
			goTo(xInCircle - radio, yInCircle + radio, 1);
		} else if (loquetoca == 11) {
			goTo(xInCircle - 2 * radio, yInCircle + radio, 1);
		} else if (loquetoca == 12) {
			goTo(xInCircle - radio, yInCircle, 1);
		} else if (loquetoca == 13) {
			goTo(xInCircle - 2 * radio, yInCircle - radio, 1);
		} else if (loquetoca == 14) {
			goTo(xInCircle - radio, yInCircle - radio, 1);
		} else if (loquetoca == 15) {
			goTo(xInCircle - radio, yInCircle - 2 * radio, 1);
		}
		if (isGoToDone) {
			pasoCircle++;
			isMidPasoCircle = false;
		} else
			isMidPasoCircle = true;
	}

	public void doCircle(boolean horario, int radio) {
		if (isCircleDone) {
			circleHasJustBegan = true;
			isCircleDone = false;
		}
		if (circleHasJustBegan) {
			spriteNameInicioCircle = currentSpriteFileName;
			circleHasJustBegan = false;
		}
		if (!isMidPasoCircle) {
			xInCircle = x;
			yInCircle = y;
		}
		if (horario) {
			if (spriteNameInicioCircle == rotationSpriteNames[0]) {
				if (pasoCircle == 0) {
					doPasoCircle(0, radio);
				} else if (pasoCircle == 1) {
					doPasoCircle(1, radio);
				} else if (pasoCircle == 2) {
					doPasoCircle(2, radio);
				} else if (pasoCircle == 3) {
					doPasoCircle(3, radio);
				} else if (pasoCircle == 4) {
					doPasoCircle(4, radio);
				} else if (pasoCircle == 5) {
					doPasoCircle(5, radio);
				} else if (pasoCircle == 6) {
					doPasoCircle(6, radio);
				} else if (pasoCircle == 7) {
					doPasoCircle(7, radio);
				} else if (pasoCircle == 8) {
					doPasoCircle(8, radio);
				} else if (pasoCircle == 9) {
					doPasoCircle(9, radio);
				} else if (pasoCircle == 10) {
					doPasoCircle(10, radio);
				} else if (pasoCircle == 11) {
					doPasoCircle(11, radio);
				} else if (pasoCircle == 12) {
					doPasoCircle(12, radio);
				} else if (pasoCircle == 13) {
					doPasoCircle(13, radio);
				} else if (pasoCircle == 14) {
					doPasoCircle(14, radio);
				} else if (pasoCircle == 15) {
					doPasoCircle(15, radio);
				}
			}

			else if (spriteNameInicioCircle == rotationSpriteNames[1]) {

				if (pasoCircle == 0) {
					doPasoCircle(1, radio);
				} else if (pasoCircle == 1) {
					doPasoCircle(2, radio);
				} else if (pasoCircle == 2) {
					doPasoCircle(3, radio);
				} else if (pasoCircle == 3) {
					doPasoCircle(4, radio);
				} else if (pasoCircle == 4) {
					doPasoCircle(5, radio);
				} else if (pasoCircle == 5) {
					doPasoCircle(6, radio);
				} else if (pasoCircle == 6) {
					doPasoCircle(7, radio);
				} else if (pasoCircle == 7) {
					doPasoCircle(8, radio);
				} else if (pasoCircle == 8) {
					doPasoCircle(9, radio);
				} else if (pasoCircle == 9) {
					doPasoCircle(10, radio);
				} else if (pasoCircle == 10) {
					doPasoCircle(11, radio);
				} else if (pasoCircle == 11) {
					doPasoCircle(12, radio);
				} else if (pasoCircle == 12) {
					doPasoCircle(13, radio);
				} else if (pasoCircle == 13) {
					doPasoCircle(14, radio);
				} else if (pasoCircle == 14) {
					doPasoCircle(15, radio);
				} else if (pasoCircle == 15) {
					doPasoCircle(0, radio);
				}

			} else if (spriteNameInicioCircle == rotationSpriteNames[2]) {

				if (pasoCircle == 0) {
					doPasoCircle(2, radio);
				} else if (pasoCircle == 1) {
					doPasoCircle(3, radio);
				} else if (pasoCircle == 2) {
					doPasoCircle(4, radio);
				} else if (pasoCircle == 3) {
					doPasoCircle(5, radio);
				} else if (pasoCircle == 4) {
					doPasoCircle(6, radio);
				} else if (pasoCircle == 5) {
					doPasoCircle(7, radio);
				} else if (pasoCircle == 6) {
					doPasoCircle(8, radio);
				} else if (pasoCircle == 7) {
					doPasoCircle(9, radio);
				} else if (pasoCircle == 8) {
					doPasoCircle(10, radio);
				} else if (pasoCircle == 9) {
					doPasoCircle(11, radio);
				} else if (pasoCircle == 10) {
					doPasoCircle(12, radio);
				} else if (pasoCircle == 11) {
					doPasoCircle(13, radio);
				} else if (pasoCircle == 12) {
					doPasoCircle(14, radio);
				} else if (pasoCircle == 13) {
					doPasoCircle(15, radio);
				} else if (pasoCircle == 14) {
					doPasoCircle(0, radio);
				} else if (pasoCircle == 15) {
					doPasoCircle(1, radio);
				}
			} else if (spriteNameInicioCircle == rotationSpriteNames[3]) {
				if (pasoCircle == 0) {
					doPasoCircle(3, radio);
				} else if (pasoCircle == 1) {
					doPasoCircle(4, radio);
				} else if (pasoCircle == 2) {
					doPasoCircle(5, radio);
				} else if (pasoCircle == 3) {
					doPasoCircle(6, radio);
				} else if (pasoCircle == 4) {
					doPasoCircle(7, radio);
				} else if (pasoCircle == 5) {
					doPasoCircle(8, radio);
				} else if (pasoCircle == 6) {
					doPasoCircle(9, radio);
				} else if (pasoCircle == 7) {
					doPasoCircle(10, radio);
				} else if (pasoCircle == 8) {
					doPasoCircle(11, radio);
				} else if (pasoCircle == 9) {
					doPasoCircle(12, radio);
				} else if (pasoCircle == 10) {
					doPasoCircle(13, radio);
				} else if (pasoCircle == 11) {
					doPasoCircle(14, radio);
				} else if (pasoCircle == 12) {
					doPasoCircle(15, radio);
				} else if (pasoCircle == 13) {
					doPasoCircle(0, radio);
				} else if (pasoCircle == 14) {
					doPasoCircle(1, radio);
				} else if (pasoCircle == 15) {
					doPasoCircle(2, radio);
				}
			} else if (spriteNameInicioCircle == rotationSpriteNames[4]) {
				if (pasoCircle == 0) {
					doPasoCircle(4, radio);
				} else if (pasoCircle == 1) {
					doPasoCircle(5, radio);
				} else if (pasoCircle == 2) {
					doPasoCircle(6, radio);
				} else if (pasoCircle == 3) {
					doPasoCircle(7, radio);
				} else if (pasoCircle == 4) {
					doPasoCircle(8, radio);
				} else if (pasoCircle == 5) {
					doPasoCircle(9, radio);
				} else if (pasoCircle == 6) {
					doPasoCircle(10, radio);
				} else if (pasoCircle == 7) {
					doPasoCircle(11, radio);
				} else if (pasoCircle == 8) {
					doPasoCircle(12, radio);
				} else if (pasoCircle == 9) {
					doPasoCircle(13, radio);
				} else if (pasoCircle == 10) {
					doPasoCircle(14, radio);
				} else if (pasoCircle == 11) {
					doPasoCircle(15, radio);
				} else if (pasoCircle == 12) {
					doPasoCircle(0, radio);
				} else if (pasoCircle == 13) {
					doPasoCircle(1, radio);
				} else if (pasoCircle == 14) {
					doPasoCircle(2, radio);
				} else if (pasoCircle == 15) {
					doPasoCircle(3, radio);
				}
			} else if (spriteNameInicioCircle == rotationSpriteNames[5]) {
				if (pasoCircle == 0) {
					doPasoCircle(5, radio);
				} else if (pasoCircle == 1) {
					doPasoCircle(6, radio);
				} else if (pasoCircle == 2) {
					doPasoCircle(7, radio);
				} else if (pasoCircle == 3) {
					doPasoCircle(8, radio);
				} else if (pasoCircle == 4) {
					doPasoCircle(9, radio);
				} else if (pasoCircle == 5) {
					doPasoCircle(10, radio);
				} else if (pasoCircle == 6) {
					doPasoCircle(11, radio);
				} else if (pasoCircle == 7) {
					doPasoCircle(12, radio);
				} else if (pasoCircle == 8) {
					doPasoCircle(13, radio);
				} else if (pasoCircle == 9) {
					doPasoCircle(14, radio);
				} else if (pasoCircle == 10) {
					doPasoCircle(15, radio);
				} else if (pasoCircle == 11) {
					doPasoCircle(0, radio);
				} else if (pasoCircle == 12) {
					doPasoCircle(1, radio);
				} else if (pasoCircle == 13) {
					doPasoCircle(2, radio);
				} else if (pasoCircle == 14) {
					doPasoCircle(3, radio);
				} else if (pasoCircle == 15) {
					doPasoCircle(4, radio);
				}
			} else if (spriteNameInicioCircle == rotationSpriteNames[6]) {
				if (pasoCircle == 0) {
					doPasoCircle(6, radio);
				} else if (pasoCircle == 1) {
					doPasoCircle(7, radio);
				} else if (pasoCircle == 2) {
					doPasoCircle(8, radio);
				} else if (pasoCircle == 3) {
					doPasoCircle(9, radio);
				} else if (pasoCircle == 4) {
					doPasoCircle(10, radio);
				} else if (pasoCircle == 5) {
					doPasoCircle(11, radio);
				} else if (pasoCircle == 6) {
					doPasoCircle(12, radio);
				} else if (pasoCircle == 7) {
					doPasoCircle(13, radio);
				} else if (pasoCircle == 8) {
					doPasoCircle(14, radio);
				} else if (pasoCircle == 9) {
					doPasoCircle(15, radio);
				} else if (pasoCircle == 10) {
					doPasoCircle(0, radio);
				} else if (pasoCircle == 11) {
					doPasoCircle(1, radio);
				} else if (pasoCircle == 12) {
					doPasoCircle(2, radio);
				} else if (pasoCircle == 13) {
					doPasoCircle(3, radio);
				} else if (pasoCircle == 14) {
					doPasoCircle(4, radio);
				} else if (pasoCircle == 15) {
					doPasoCircle(5, radio);
				}
			} else if (spriteNameInicioCircle == rotationSpriteNames[7]) {
				if (pasoCircle == 0) {
					doPasoCircle(7, radio);
				} else if (pasoCircle == 1) {
					doPasoCircle(8, radio);
				} else if (pasoCircle == 2) {
					doPasoCircle(9, radio);
				} else if (pasoCircle == 3) {
					doPasoCircle(10, radio);
				} else if (pasoCircle == 4) {
					doPasoCircle(11, radio);
				} else if (pasoCircle == 5) {
					doPasoCircle(12, radio);
				} else if (pasoCircle == 6) {
					doPasoCircle(13, radio);
				} else if (pasoCircle == 7) {
					doPasoCircle(14, radio);
				} else if (pasoCircle == 8) {
					doPasoCircle(15, radio);
				} else if (pasoCircle == 9) {
					doPasoCircle(0, radio);
				} else if (pasoCircle == 10) {
					doPasoCircle(1, radio);
				} else if (pasoCircle == 11) {
					doPasoCircle(2, radio);
				} else if (pasoCircle == 12) {
					doPasoCircle(3, radio);
				} else if (pasoCircle == 13) {
					doPasoCircle(4, radio);
				} else if (pasoCircle == 14) {
					doPasoCircle(5, radio);
				} else if (pasoCircle == 15) {
					doPasoCircle(6, radio);
				}
			} else if (spriteNameInicioCircle == rotationSpriteNames[8]) {
				if (pasoCircle == 0) {
					doPasoCircle(8, radio);
				} else if (pasoCircle == 1) {
					doPasoCircle(9, radio);
				} else if (pasoCircle == 2) {
					doPasoCircle(10, radio);
				} else if (pasoCircle == 3) {
					doPasoCircle(11, radio);
				} else if (pasoCircle == 4) {
					doPasoCircle(12, radio);
				} else if (pasoCircle == 5) {
					doPasoCircle(13, radio);
				} else if (pasoCircle == 6) {
					doPasoCircle(14, radio);
				} else if (pasoCircle == 7) {
					doPasoCircle(15, radio);
				} else if (pasoCircle == 8) {
					doPasoCircle(0, radio);
				} else if (pasoCircle == 9) {
					doPasoCircle(1, radio);
				} else if (pasoCircle == 10) {
					doPasoCircle(2, radio);
				} else if (pasoCircle == 11) {
					doPasoCircle(3, radio);
				} else if (pasoCircle == 12) {
					doPasoCircle(4, radio);
				} else if (pasoCircle == 13) {
					doPasoCircle(5, radio);
				} else if (pasoCircle == 14) {
					doPasoCircle(6, radio);
				} else if (pasoCircle == 15) {
					doPasoCircle(7, radio);
				}
			} else if (spriteNameInicioCircle == rotationSpriteNames[9]) {
				if (pasoCircle == 0) {
					doPasoCircle(9, radio);
				} else if (pasoCircle == 1) {
					doPasoCircle(10, radio);
				} else if (pasoCircle == 2) {
					doPasoCircle(11, radio);
				} else if (pasoCircle == 3) {
					doPasoCircle(12, radio);
				} else if (pasoCircle == 4) {
					doPasoCircle(13, radio);
				} else if (pasoCircle == 5) {
					doPasoCircle(14, radio);
				} else if (pasoCircle == 6) {
					doPasoCircle(15, radio);
				} else if (pasoCircle == 7) {
					doPasoCircle(0, radio);
				} else if (pasoCircle == 8) {
					doPasoCircle(1, radio);
				} else if (pasoCircle == 9) {
					doPasoCircle(2, radio);
				} else if (pasoCircle == 10) {
					doPasoCircle(3, radio);
				} else if (pasoCircle == 11) {
					doPasoCircle(4, radio);
				} else if (pasoCircle == 12) {
					doPasoCircle(5, radio);
				} else if (pasoCircle == 13) {
					doPasoCircle(6, radio);
				} else if (pasoCircle == 14) {
					doPasoCircle(7, radio);
				} else if (pasoCircle == 15) {
					doPasoCircle(8, radio);
				}
			} else if (spriteNameInicioCircle == rotationSpriteNames[10]) {
				if (pasoCircle == 0) {
					doPasoCircle(10, radio);
				} else if (pasoCircle == 1) {
					doPasoCircle(11, radio);
				} else if (pasoCircle == 2) {
					doPasoCircle(12, radio);
				} else if (pasoCircle == 3) {
					doPasoCircle(13, radio);
				} else if (pasoCircle == 4) {
					doPasoCircle(14, radio);
				} else if (pasoCircle == 5) {
					doPasoCircle(15, radio);
				} else if (pasoCircle == 6) {
					doPasoCircle(0, radio);
				} else if (pasoCircle == 7) {
					doPasoCircle(1, radio);
				} else if (pasoCircle == 8) {
					doPasoCircle(2, radio);
				} else if (pasoCircle == 9) {
					doPasoCircle(3, radio);
				} else if (pasoCircle == 10) {
					doPasoCircle(4, radio);
				} else if (pasoCircle == 11) {
					doPasoCircle(5, radio);
				} else if (pasoCircle == 12) {
					doPasoCircle(6, radio);
				} else if (pasoCircle == 13) {
					doPasoCircle(7, radio);
				} else if (pasoCircle == 14) {
					doPasoCircle(8, radio);
				} else if (pasoCircle == 15) {
					doPasoCircle(9, radio);
				}
			} else if (spriteNameInicioCircle == rotationSpriteNames[11]) {
				if (pasoCircle == 0) {
					doPasoCircle(11, radio);
				} else if (pasoCircle == 1) {
					doPasoCircle(12, radio);
				} else if (pasoCircle == 2) {
					doPasoCircle(13, radio);
				} else if (pasoCircle == 3) {
					doPasoCircle(14, radio);
				} else if (pasoCircle == 4) {
					doPasoCircle(15, radio);
				} else if (pasoCircle == 5) {
					doPasoCircle(0, radio);
				} else if (pasoCircle == 6) {
					doPasoCircle(1, radio);
				} else if (pasoCircle == 7) {
					doPasoCircle(2, radio);
				} else if (pasoCircle == 8) {
					doPasoCircle(3, radio);
				} else if (pasoCircle == 9) {
					doPasoCircle(4, radio);
				} else if (pasoCircle == 10) {
					doPasoCircle(5, radio);
				} else if (pasoCircle == 11) {
					doPasoCircle(6, radio);
				} else if (pasoCircle == 12) {
					doPasoCircle(7, radio);
				} else if (pasoCircle == 13) {
					doPasoCircle(8, radio);
				} else if (pasoCircle == 14) {
					doPasoCircle(9, radio);
				} else if (pasoCircle == 15) {
					doPasoCircle(10, radio);
				}
			} else if (spriteNameInicioCircle == rotationSpriteNames[12]) {
				if (pasoCircle == 0) {
					doPasoCircle(12, radio);
				} else if (pasoCircle == 1) {
					doPasoCircle(13, radio);
				} else if (pasoCircle == 2) {
					doPasoCircle(14, radio);
				} else if (pasoCircle == 3) {
					doPasoCircle(15, radio);
				} else if (pasoCircle == 4) {
					doPasoCircle(0, radio);
				} else if (pasoCircle == 5) {
					doPasoCircle(1, radio);
				} else if (pasoCircle == 6) {
					doPasoCircle(2, radio);
				} else if (pasoCircle == 7) {
					doPasoCircle(3, radio);
				} else if (pasoCircle == 8) {
					doPasoCircle(4, radio);
				} else if (pasoCircle == 9) {
					doPasoCircle(5, radio);
				} else if (pasoCircle == 10) {
					doPasoCircle(6, radio);
				} else if (pasoCircle == 11) {
					doPasoCircle(7, radio);
				} else if (pasoCircle == 12) {
					doPasoCircle(8, radio);
				} else if (pasoCircle == 13) {
					doPasoCircle(9, radio);
				} else if (pasoCircle == 14) {
					doPasoCircle(10, radio);
				} else if (pasoCircle == 15) {
					doPasoCircle(11, radio);
				}
			} else if (spriteNameInicioCircle == rotationSpriteNames[13]) {
				if (pasoCircle == 0) {
					doPasoCircle(13, radio);
				} else if (pasoCircle == 1) {
					doPasoCircle(14, radio);
				} else if (pasoCircle == 2) {
					doPasoCircle(15, radio);
				} else if (pasoCircle == 3) {
					doPasoCircle(0, radio);
				} else if (pasoCircle == 4) {
					doPasoCircle(1, radio);
				} else if (pasoCircle == 5) {
					doPasoCircle(2, radio);
				} else if (pasoCircle == 6) {
					doPasoCircle(3, radio);
				} else if (pasoCircle == 7) {
					doPasoCircle(4, radio);
				} else if (pasoCircle == 8) {
					doPasoCircle(5, radio);
				} else if (pasoCircle == 9) {
					doPasoCircle(6, radio);
				} else if (pasoCircle == 10) {
					doPasoCircle(7, radio);
				} else if (pasoCircle == 11) {
					doPasoCircle(8, radio);
				} else if (pasoCircle == 12) {
					doPasoCircle(9, radio);
				} else if (pasoCircle == 13) {
					doPasoCircle(10, radio);
				} else if (pasoCircle == 14) {
					doPasoCircle(11, radio);
				} else if (pasoCircle == 15) {
					doPasoCircle(12, radio);
				}
			} else if (spriteNameInicioCircle == rotationSpriteNames[14]) {
				if (pasoCircle == 0) {
					doPasoCircle(14, radio);
				} else if (pasoCircle == 1) {
					doPasoCircle(15, radio);
				} else if (pasoCircle == 2) {
					doPasoCircle(0, radio);
				} else if (pasoCircle == 3) {
					doPasoCircle(1, radio);
				} else if (pasoCircle == 4) {
					doPasoCircle(2, radio);
				} else if (pasoCircle == 5) {
					doPasoCircle(3, radio);
				} else if (pasoCircle == 6) {
					doPasoCircle(4, radio);
				} else if (pasoCircle == 7) {
					doPasoCircle(5, radio);
				} else if (pasoCircle == 8) {
					doPasoCircle(6, radio);
				} else if (pasoCircle == 9) {
					doPasoCircle(7, radio);
				} else if (pasoCircle == 10) {
					doPasoCircle(8, radio);
				} else if (pasoCircle == 11) {
					doPasoCircle(9, radio);
				} else if (pasoCircle == 12) {
					doPasoCircle(10, radio);
				} else if (pasoCircle == 13) {
					doPasoCircle(11, radio);
				} else if (pasoCircle == 14) {
					doPasoCircle(12, radio);
				} else if (pasoCircle == 15) {
					doPasoCircle(13, radio);
				}
			} else if (spriteNameInicioCircle == rotationSpriteNames[15]) {
				if (pasoCircle == 0) {
					doPasoCircle(15, radio);
				} else if (pasoCircle == 1) {
					doPasoCircle(0, radio);
				} else if (pasoCircle == 2) {
					doPasoCircle(1, radio);
				} else if (pasoCircle == 3) {
					doPasoCircle(2, radio);
				} else if (pasoCircle == 4) {
					doPasoCircle(3, radio);
				} else if (pasoCircle == 5) {
					doPasoCircle(4, radio);
				} else if (pasoCircle == 6) {
					doPasoCircle(5, radio);
				} else if (pasoCircle == 7) {
					doPasoCircle(6, radio);
				} else if (pasoCircle == 8) {
					doPasoCircle(7, radio);
				} else if (pasoCircle == 9) {
					doPasoCircle(8, radio);
				} else if (pasoCircle == 10) {
					doPasoCircle(9, radio);
				} else if (pasoCircle == 11) {
					doPasoCircle(10, radio);
				} else if (pasoCircle == 12) {
					doPasoCircle(11, radio);
				} else if (pasoCircle == 13) {
					doPasoCircle(12, radio);
				} else if (pasoCircle == 14) {
					doPasoCircle(13, radio);
				} else if (pasoCircle == 15) {
					doPasoCircle(14, radio);
				}
			}

		} else if (!horario) {
			if (spriteNameInicioCircle == rotationSpriteNames[0]) {
				if (pasoCircle == 0) {
					doPasoCircle(0, radio);
				} else if (pasoCircle == 1) {
					doPasoCircle(15, radio);
				} else if (pasoCircle == 2) {
					doPasoCircle(14, radio);
				} else if (pasoCircle == 3) {
					doPasoCircle(13, radio);
				} else if (pasoCircle == 4) {
					doPasoCircle(12, radio);
				} else if (pasoCircle == 5) {
					doPasoCircle(11, radio);
				} else if (pasoCircle == 6) {
					doPasoCircle(10, radio);
				} else if (pasoCircle == 7) {
					doPasoCircle(9, radio);
				} else if (pasoCircle == 8) {
					doPasoCircle(8, radio);
				} else if (pasoCircle == 9) {
					doPasoCircle(7, radio);
				} else if (pasoCircle == 10) {
					doPasoCircle(6, radio);
				} else if (pasoCircle == 11) {
					doPasoCircle(5, radio);
				} else if (pasoCircle == 12) {
					doPasoCircle(4, radio);
				} else if (pasoCircle == 13) {
					doPasoCircle(3, radio);
				} else if (pasoCircle == 14) {
					doPasoCircle(2, radio);
				} else if (pasoCircle == 15) {
					doPasoCircle(1, radio);
				}
			} else if (spriteNameInicioCircle == rotationSpriteNames[1]) {
				if (pasoCircle == 0)
					doPasoCircle(1, radio);
				else if (pasoCircle == 1)
					doPasoCircle(0, radio);
				else if (pasoCircle == 2)
					doPasoCircle(15, radio);
				else if (pasoCircle == 3)
					doPasoCircle(14, radio);
				else if (pasoCircle == 4)
					doPasoCircle(13, radio);
				else if (pasoCircle == 5)
					doPasoCircle(12, radio);
				else if (pasoCircle == 6)
					doPasoCircle(11, radio);
				else if (pasoCircle == 7)
					doPasoCircle(10, radio);
				else if (pasoCircle == 8)
					doPasoCircle(9, radio);
				else if (pasoCircle == 9)
					doPasoCircle(8, radio);
				else if (pasoCircle == 10)
					doPasoCircle(7, radio);
				else if (pasoCircle == 11)
					doPasoCircle(6, radio);
				else if (pasoCircle == 12)
					doPasoCircle(5, radio);
				else if (pasoCircle == 13)
					doPasoCircle(4, radio);
				else if (pasoCircle == 14)
					doPasoCircle(3, radio);
				else if (pasoCircle == 15)
					doPasoCircle(2, radio);
			} else if (spriteNameInicioCircle == rotationSpriteNames[2]) {
				if (pasoCircle == 0)
					doPasoCircle(2, radio);
				else if (pasoCircle == 1)
					doPasoCircle(1, radio);
				else if (pasoCircle == 2)
					doPasoCircle(0, radio);
				else if (pasoCircle == 3)
					doPasoCircle(15, radio);
				else if (pasoCircle == 4)
					doPasoCircle(14, radio);
				else if (pasoCircle == 5)
					doPasoCircle(13, radio);
				else if (pasoCircle == 6)
					doPasoCircle(12, radio);
				else if (pasoCircle == 7)
					doPasoCircle(11, radio);
				else if (pasoCircle == 8)
					doPasoCircle(10, radio);
				else if (pasoCircle == 9)
					doPasoCircle(9, radio);
				else if (pasoCircle == 10)
					doPasoCircle(8, radio);
				else if (pasoCircle == 11)
					doPasoCircle(7, radio);
				else if (pasoCircle == 12)
					doPasoCircle(6, radio);
				else if (pasoCircle == 13)
					doPasoCircle(5, radio);
				else if (pasoCircle == 14)
					doPasoCircle(4, radio);
				else if (pasoCircle == 15)
					doPasoCircle(3, radio);
			} else if (spriteNameInicioCircle == rotationSpriteNames[3]) {
				if (pasoCircle == 0)
					doPasoCircle(3, radio);
				else if (pasoCircle == 1)
					doPasoCircle(2, radio);
				else if (pasoCircle == 2)
					doPasoCircle(1, radio);
				else if (pasoCircle == 3)
					doPasoCircle(0, radio);
				else if (pasoCircle == 4)
					doPasoCircle(15, radio);
				else if (pasoCircle == 5)
					doPasoCircle(14, radio);
				else if (pasoCircle == 6)
					doPasoCircle(13, radio);
				else if (pasoCircle == 7)
					doPasoCircle(12, radio);
				else if (pasoCircle == 8)
					doPasoCircle(11, radio);
				else if (pasoCircle == 9)
					doPasoCircle(10, radio);
				else if (pasoCircle == 10)
					doPasoCircle(9, radio);
				else if (pasoCircle == 11)
					doPasoCircle(8, radio);
				else if (pasoCircle == 12)
					doPasoCircle(7, radio);
				else if (pasoCircle == 13)
					doPasoCircle(6, radio);
				else if (pasoCircle == 14)
					doPasoCircle(5, radio);
				else if (pasoCircle == 15)
					doPasoCircle(4, radio);
			} else if (spriteNameInicioCircle == rotationSpriteNames[4]) {
				if (pasoCircle == 0)
					doPasoCircle(4, radio);
				else if (pasoCircle == 1)
					doPasoCircle(3, radio);
				else if (pasoCircle == 2)
					doPasoCircle(2, radio);
				else if (pasoCircle == 3)
					doPasoCircle(1, radio);
				else if (pasoCircle == 4)
					doPasoCircle(0, radio);
				else if (pasoCircle == 5)
					doPasoCircle(15, radio);
				else if (pasoCircle == 6)
					doPasoCircle(14, radio);
				else if (pasoCircle == 7)
					doPasoCircle(13, radio);
				else if (pasoCircle == 8)
					doPasoCircle(12, radio);
				else if (pasoCircle == 9)
					doPasoCircle(11, radio);
				else if (pasoCircle == 10)
					doPasoCircle(10, radio);
				else if (pasoCircle == 11)
					doPasoCircle(9, radio);
				else if (pasoCircle == 12)
					doPasoCircle(8, radio);
				else if (pasoCircle == 13)
					doPasoCircle(7, radio);
				else if (pasoCircle == 14)
					doPasoCircle(6, radio);
				else if (pasoCircle == 15)
					doPasoCircle(5, radio);
			} else if (spriteNameInicioCircle == rotationSpriteNames[5]) {
				if (pasoCircle == 0)
					doPasoCircle(5, radio);
				else if (pasoCircle == 1)
					doPasoCircle(4, radio);
				else if (pasoCircle == 2)
					doPasoCircle(3, radio);
				else if (pasoCircle == 3)
					doPasoCircle(2, radio);
				else if (pasoCircle == 4)
					doPasoCircle(1, radio);
				else if (pasoCircle == 5)
					doPasoCircle(0, radio);
				else if (pasoCircle == 6)
					doPasoCircle(15, radio);
				else if (pasoCircle == 7)
					doPasoCircle(14, radio);
				else if (pasoCircle == 8)
					doPasoCircle(13, radio);
				else if (pasoCircle == 9)
					doPasoCircle(12, radio);
				else if (pasoCircle == 10)
					doPasoCircle(11, radio);
				else if (pasoCircle == 11)
					doPasoCircle(10, radio);
				else if (pasoCircle == 12)
					doPasoCircle(9, radio);
				else if (pasoCircle == 13)
					doPasoCircle(8, radio);
				else if (pasoCircle == 14)
					doPasoCircle(7, radio);
				else if (pasoCircle == 15)
					doPasoCircle(6, radio);
			} else if (spriteNameInicioCircle == rotationSpriteNames[6]) {
				if (pasoCircle == 0)
					doPasoCircle(6, radio);
				else if (pasoCircle == 1)
					doPasoCircle(5, radio);
				else if (pasoCircle == 2)
					doPasoCircle(4, radio);
				else if (pasoCircle == 3)
					doPasoCircle(3, radio);
				else if (pasoCircle == 4)
					doPasoCircle(2, radio);
				else if (pasoCircle == 5)
					doPasoCircle(1, radio);
				else if (pasoCircle == 6)
					doPasoCircle(0, radio);
				else if (pasoCircle == 7)
					doPasoCircle(15, radio);
				else if (pasoCircle == 8)
					doPasoCircle(14, radio);
				else if (pasoCircle == 9)
					doPasoCircle(13, radio);
				else if (pasoCircle == 10)
					doPasoCircle(12, radio);
				else if (pasoCircle == 11)
					doPasoCircle(11, radio);
				else if (pasoCircle == 12)
					doPasoCircle(10, radio);
				else if (pasoCircle == 13)
					doPasoCircle(9, radio);
				else if (pasoCircle == 14)
					doPasoCircle(8, radio);
				else if (pasoCircle == 15)
					doPasoCircle(7, radio);
			} else if (spriteNameInicioCircle == rotationSpriteNames[7]) {
				if (pasoCircle == 0)
					doPasoCircle(7, radio);
				else if (pasoCircle == 1)
					doPasoCircle(6, radio);
				else if (pasoCircle == 2)
					doPasoCircle(5, radio);
				else if (pasoCircle == 3)
					doPasoCircle(4, radio);
				else if (pasoCircle == 4)
					doPasoCircle(3, radio);
				else if (pasoCircle == 5)
					doPasoCircle(2, radio);
				else if (pasoCircle == 6)
					doPasoCircle(1, radio);
				else if (pasoCircle == 7)
					doPasoCircle(0, radio);
				else if (pasoCircle == 8)
					doPasoCircle(15, radio);
				else if (pasoCircle == 9)
					doPasoCircle(14, radio);
				else if (pasoCircle == 10)
					doPasoCircle(13, radio);
				else if (pasoCircle == 11)
					doPasoCircle(12, radio);
				else if (pasoCircle == 12)
					doPasoCircle(11, radio);
				else if (pasoCircle == 13)
					doPasoCircle(10, radio);
				else if (pasoCircle == 14)
					doPasoCircle(9, radio);
				else if (pasoCircle == 15)
					doPasoCircle(8, radio);
			} else if (spriteNameInicioCircle == rotationSpriteNames[8]) {
				if (pasoCircle == 0)
					doPasoCircle(8, radio);
				else if (pasoCircle == 1)
					doPasoCircle(7, radio);
				else if (pasoCircle == 2)
					doPasoCircle(6, radio);
				else if (pasoCircle == 3)
					doPasoCircle(5, radio);
				else if (pasoCircle == 4)
					doPasoCircle(4, radio);
				else if (pasoCircle == 5)
					doPasoCircle(3, radio);
				else if (pasoCircle == 6)
					doPasoCircle(2, radio);
				else if (pasoCircle == 7)
					doPasoCircle(1, radio);
				else if (pasoCircle == 8)
					doPasoCircle(0, radio);
				else if (pasoCircle == 9)
					doPasoCircle(15, radio);
				else if (pasoCircle == 10)
					doPasoCircle(14, radio);
				else if (pasoCircle == 11)
					doPasoCircle(13, radio);
				else if (pasoCircle == 12)
					doPasoCircle(12, radio);
				else if (pasoCircle == 13)
					doPasoCircle(11, radio);
				else if (pasoCircle == 14)
					doPasoCircle(10, radio);
				else if (pasoCircle == 15)
					doPasoCircle(9, radio);
			} else if (spriteNameInicioCircle == rotationSpriteNames[9]) {
				if (pasoCircle == 0)
					doPasoCircle(9, radio);
				else if (pasoCircle == 1)
					doPasoCircle(8, radio);
				else if (pasoCircle == 2)
					doPasoCircle(7, radio);
				else if (pasoCircle == 3)
					doPasoCircle(6, radio);
				else if (pasoCircle == 4)
					doPasoCircle(5, radio);
				else if (pasoCircle == 5)
					doPasoCircle(4, radio);
				else if (pasoCircle == 6)
					doPasoCircle(3, radio);
				else if (pasoCircle == 7)
					doPasoCircle(2, radio);
				else if (pasoCircle == 8)
					doPasoCircle(1, radio);
				else if (pasoCircle == 9)
					doPasoCircle(0, radio);
				else if (pasoCircle == 10)
					doPasoCircle(15, radio);
				else if (pasoCircle == 11)
					doPasoCircle(14, radio);
				else if (pasoCircle == 12)
					doPasoCircle(13, radio);
				else if (pasoCircle == 13)
					doPasoCircle(12, radio);
				else if (pasoCircle == 14)
					doPasoCircle(11, radio);
				else if (pasoCircle == 15)
					doPasoCircle(10, radio);
			} else if (spriteNameInicioCircle == rotationSpriteNames[10]) {
				if (pasoCircle == 0)
					doPasoCircle(10, radio);
				else if (pasoCircle == 1)
					doPasoCircle(9, radio);
				else if (pasoCircle == 2)
					doPasoCircle(8, radio);
				else if (pasoCircle == 3)
					doPasoCircle(7, radio);
				else if (pasoCircle == 4)
					doPasoCircle(6, radio);
				else if (pasoCircle == 5)
					doPasoCircle(5, radio);
				else if (pasoCircle == 6)
					doPasoCircle(4, radio);
				else if (pasoCircle == 7)
					doPasoCircle(3, radio);
				else if (pasoCircle == 8)
					doPasoCircle(2, radio);
				else if (pasoCircle == 9)
					doPasoCircle(1, radio);
				else if (pasoCircle == 10)
					doPasoCircle(0, radio);
				else if (pasoCircle == 11)
					doPasoCircle(15, radio);
				else if (pasoCircle == 12)
					doPasoCircle(14, radio);
				else if (pasoCircle == 13)
					doPasoCircle(13, radio);
				else if (pasoCircle == 14)
					doPasoCircle(12, radio);
				else if (pasoCircle == 15)
					doPasoCircle(11, radio);
			} else if (spriteNameInicioCircle == rotationSpriteNames[11]) {
				if (pasoCircle == 0)
					doPasoCircle(11, radio);
				else if (pasoCircle == 1)
					doPasoCircle(10, radio);
				else if (pasoCircle == 2)
					doPasoCircle(9, radio);
				else if (pasoCircle == 3)
					doPasoCircle(8, radio);
				else if (pasoCircle == 4)
					doPasoCircle(7, radio);
				else if (pasoCircle == 5)
					doPasoCircle(6, radio);
				else if (pasoCircle == 6)
					doPasoCircle(5, radio);
				else if (pasoCircle == 7)
					doPasoCircle(4, radio);
				else if (pasoCircle == 8)
					doPasoCircle(3, radio);
				else if (pasoCircle == 9)
					doPasoCircle(2, radio);
				else if (pasoCircle == 10)
					doPasoCircle(1, radio);
				else if (pasoCircle == 11)
					doPasoCircle(0, radio);
				else if (pasoCircle == 12)
					doPasoCircle(15, radio);
				else if (pasoCircle == 13)
					doPasoCircle(14, radio);
				else if (pasoCircle == 14)
					doPasoCircle(13, radio);
				else if (pasoCircle == 15)
					doPasoCircle(12, radio);
			} else if (spriteNameInicioCircle == rotationSpriteNames[12]) {
				if (pasoCircle == 0)
					doPasoCircle(12, radio);
				else if (pasoCircle == 1)
					doPasoCircle(11, radio);
				else if (pasoCircle == 2)
					doPasoCircle(10, radio);
				else if (pasoCircle == 3)
					doPasoCircle(9, radio);
				else if (pasoCircle == 4)
					doPasoCircle(8, radio);
				else if (pasoCircle == 5)
					doPasoCircle(7, radio);
				else if (pasoCircle == 6)
					doPasoCircle(6, radio);
				else if (pasoCircle == 7)
					doPasoCircle(5, radio);
				else if (pasoCircle == 8)
					doPasoCircle(4, radio);
				else if (pasoCircle == 9)
					doPasoCircle(3, radio);
				else if (pasoCircle == 10)
					doPasoCircle(2, radio);
				else if (pasoCircle == 11)
					doPasoCircle(1, radio);
				else if (pasoCircle == 12)
					doPasoCircle(0, radio);
				else if (pasoCircle == 13)
					doPasoCircle(15, radio);
				else if (pasoCircle == 14)
					doPasoCircle(14, radio);
				else if (pasoCircle == 15)
					doPasoCircle(13, radio);
			} else if (spriteNameInicioCircle == rotationSpriteNames[13]) {
				if (pasoCircle == 0)
					doPasoCircle(13, radio);
				else if (pasoCircle == 1)
					doPasoCircle(12, radio);
				else if (pasoCircle == 2)
					doPasoCircle(11, radio);
				else if (pasoCircle == 3)
					doPasoCircle(10, radio);
				else if (pasoCircle == 4)
					doPasoCircle(9, radio);
				else if (pasoCircle == 5)
					doPasoCircle(8, radio);
				else if (pasoCircle == 6)
					doPasoCircle(7, radio);
				else if (pasoCircle == 7)
					doPasoCircle(6, radio);
				else if (pasoCircle == 8)
					doPasoCircle(5, radio);
				else if (pasoCircle == 9)
					doPasoCircle(4, radio);
				else if (pasoCircle == 10)
					doPasoCircle(3, radio);
				else if (pasoCircle == 11)
					doPasoCircle(2, radio);
				else if (pasoCircle == 12)
					doPasoCircle(1, radio);
				else if (pasoCircle == 13)
					doPasoCircle(0, radio);
				else if (pasoCircle == 14)
					doPasoCircle(15, radio);
				else if (pasoCircle == 15)
					doPasoCircle(14, radio);
			} else if (spriteNameInicioCircle == rotationSpriteNames[14]) {
				if (pasoCircle == 0)
					doPasoCircle(14, radio);
				else if (pasoCircle == 1)
					doPasoCircle(13, radio);
				else if (pasoCircle == 2)
					doPasoCircle(12, radio);
				else if (pasoCircle == 3)
					doPasoCircle(11, radio);
				else if (pasoCircle == 4)
					doPasoCircle(10, radio);
				else if (pasoCircle == 5)
					doPasoCircle(9, radio);
				else if (pasoCircle == 6)
					doPasoCircle(8, radio);
				else if (pasoCircle == 7)
					doPasoCircle(7, radio);
				else if (pasoCircle == 8)
					doPasoCircle(6, radio);
				else if (pasoCircle == 9)
					doPasoCircle(5, radio);
				else if (pasoCircle == 10)
					doPasoCircle(4, radio);
				else if (pasoCircle == 11)
					doPasoCircle(3, radio);
				else if (pasoCircle == 12)
					doPasoCircle(2, radio);
				else if (pasoCircle == 13)
					doPasoCircle(1, radio);
				else if (pasoCircle == 14)
					doPasoCircle(0, radio);
				else if (pasoCircle == 15)
					doPasoCircle(15, radio);
			} else if (spriteNameInicioCircle == rotationSpriteNames[15]) {
				if (pasoCircle == 0)
					doPasoCircle(15, radio);
				else if (pasoCircle == 1)
					doPasoCircle(14, radio);
				else if (pasoCircle == 2)
					doPasoCircle(13, radio);
				else if (pasoCircle == 3)
					doPasoCircle(12, radio);
				else if (pasoCircle == 4)
					doPasoCircle(11, radio);
				else if (pasoCircle == 5)
					doPasoCircle(10, radio);
				else if (pasoCircle == 6)
					doPasoCircle(9, radio);
				else if (pasoCircle == 7)
					doPasoCircle(8, radio);
				else if (pasoCircle == 8)
					doPasoCircle(7, radio);
				else if (pasoCircle == 9)
					doPasoCircle(6, radio);
				else if (pasoCircle == 10)
					doPasoCircle(5, radio);
				else if (pasoCircle == 11)
					doPasoCircle(4, radio);
				else if (pasoCircle == 12)
					doPasoCircle(3, radio);
				else if (pasoCircle == 13)
					doPasoCircle(2, radio);
				else if (pasoCircle == 14)
					doPasoCircle(1, radio);
				else if (pasoCircle == 15)
					doPasoCircle(0, radio);
			}

		}
		if (pasoCircle == 16) {
			pasoCircle = 0;
			isCircleDone = true;
			setSpriteImage(spriteNameInicioCircle);
		}

	}
}
