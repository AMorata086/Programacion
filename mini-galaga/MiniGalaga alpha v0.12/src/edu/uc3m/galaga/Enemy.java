package edu.uc3m.galaga;

public abstract class Enemy extends Sprite {
	protected int points;
	protected int pasoMuerte = 0;
	protected boolean isMuriendo = false;
	protected boolean hasExtraHP;
	protected int idleStart;
	protected int pasoCoreo = 0;
	protected int frameEntrada;
	protected boolean isInEnjambre;
	protected boolean isGoingToAttack = false;
	
	
	protected boolean coreoIn;

	public void setMuriendo(boolean isMuriendo) {
		this.isMuriendo = isMuriendo;
	}

	public void performDeath() {
		if (pasoMuerte == 0) {
			setSpriteImage("explosion20.png");
			MiniGalaga.addScore(points);
			gui.gb_setValuePointsDown(MiniGalaga.getScore());
		}
		if (pasoMuerte == 1) {
			setSpriteImage("explosion21.png");
		}
		if (pasoMuerte == 2) {
			setSpriteImage("explosion22.png");
		}
		if (pasoMuerte == 3) {
			setSpriteImage("explosion23.png");
		}
		if (pasoMuerte == 4) {
			setSpriteImage("explosion24.png");
		}
		if (pasoMuerte == 5) {
			gui.gb_setSpriteVisible(id, false);
			isMuriendo = false;
		}
		pasoMuerte++;
	}

	public void animacionIdle(double frame) {
		if (isAlive && isInEnjambre) {
			double idleFrame = frame + idleStart;
			if (idleFrame % (60) == 0) {
				setSpriteImage(spriteFileNameIdle0);
			} else if (idleFrame % (30) == 0) {
				setSpriteImage(spriteFileNameIdle1);
			}

		}
	}
	
	public void moveCoreo(int direction, int speed) {
		move(direction, speed);
		pasoCoreo++;
	}
	
	public int getFrameEntrada() {
		return frameEntrada;
	}

	public void setFrameEntrada(int frameEntrada) {
		this.frameEntrada = frameEntrada;
	}
	
	
	public void zigzag(boolean canGank) {
		isZigzagueando = true;
		expedicionCompletada = false;
		if (canGank && Math.random()*100 > 99 && y < 110)
			isGankeando = true;
		if (pasoCoreo < 3)
			moveCoreo(8,3);
		else if (pasoCoreo <6)
			moveCoreo(9,1);
		else if (pasoCoreo <9)
			moveCoreo(10,2);
		else if (pasoCoreo <12)
			moveCoreo(9,1);
		else if (pasoCoreo <15)
			moveCoreo(8,3);
		else if (pasoCoreo <18)
			moveCoreo(7,1);
		else if (pasoCoreo <21)
			moveCoreo(6,2);
		else if (pasoCoreo <24)
			moveCoreo(7,1);
		else if (pasoCoreo >= 24) {
			pasoCoreo = 0;
		}
		if (y > 240) {
			setY(0);
			pasoCoreo = 0;
			isZigzagueando = false;
			isGankeando = false;
			expedicionCompletada = true;
			isGoingToAttack = false;
		}
	}
}
