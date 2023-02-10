package edu.uc3m.galaga;

import edu.uc3m.game.GameBoardGUI;

public class MiniGalaga {

	public static int score = 0;
	public static boolean exit = false;
	public static boolean pause = false;

	public static void main(String[] args) throws InterruptedException {
		GameBoardGUI gui = new GameBoardGUI(Conf.WIDTH, Conf.HEIGHT);
		gui.setVisible(true);

		gui.gb_setGridColor(0, 0, 0); // Configuraciones del tablero y la interfaz
		gui.gb_setValueHealthCurrent(3);
		gui.gb_setValueHealthMax(3);
		gui.gb_setPortraitPlayer("galagaLogo.jpg");
		gui.gb_setTextPointsUp("");
		gui.gb_setTextPointsDown("Score:");
		gui.gb_setValuePointsDown(0);

		//////////////////////
		/// CREACION FONDO ///
		//////////////////////

		gui.gb_addSprite(1, "Negro.png", true); // Fondo negro
		gui.gb_setSpriteImage(1, "Negro.png", 1000, 1000);
		gui.gb_setSpriteVisible(1, true);

		Fondo[][] stars = new Fondo[3][2];
		stars[0] = new Fondo[2]; // Near
		stars[1] = new Fondo[2]; // Mid-Far
		stars[2] = new Fondo[2]; // Far

		stars[0][0] = new Fondo(10, "StarsFull1.png", gui);
		stars[0][1] = new Fondo(11, "StarsFull2.png", gui);
		stars[1][0] = new Fondo(20, "StarsFar1.png", gui);
		stars[1][1] = new Fondo(21, "StarsFar3.png", gui);
		stars[2][0] = new Fondo(30, "StarsFar2.png", gui);
		stars[2][1] = new Fondo(31, "StarsFar2.png", gui);

		for (int i = 0; i < stars.length; i++)
			stars[i][1].setY(-110);
		for (int i = 0; i < stars.length; i++)
			for (int j = 0; j < stars[i].length; j++)
				stars[i][j].setVisible(true);

		//////////////////////
		// CREACION JUGADOR //
		//////////////////////

		Jugador jugador = new Jugador(gui);
		gui.gb_addSprite(0, "player.png", true);
		gui.gb_setSpriteVisible(0, true);
		jugador.setX(Conf.WIDTH * 10 / 2);
		jugador.setY(Conf.HEIGHT * 10 - 35);
		jugador.setSpriteImage("player.png");

		//////////////////////////
		// CREACION DE ENEMIGOS //
		//////////////////////////

		Enemy[][] nivel1 = new Enemy[4][];
		nivel1[0] = new Enemy[2]; // Comandantes
		nivel1[1] = new Enemy[10]; // Goeis
		nivel1[2] = new Enemy[8]; // Zakos
		nivel1[3] = new Enemy[7]; // Mas Zakos

		//////////////////////////
		//// CREACION NIVEL 2 ////
		//////////////////////////

		Enemy[][] nivel2 = new Enemy[6][];
		nivel2[0] = new Enemy[4]; // Comandantes
		nivel2[1] = new Enemy[8]; // Fila 1 Goeis
		nivel2[2] = new Enemy[8]; // Fila 2 Goeis
		nivel2[3] = new Enemy[8]; // Fila 1 Zakos
		nivel2[4] = new Enemy[6]; // Fila 2 Zakos
		nivel2[5] = new Enemy[4]; // Fila 3 Zakos

		//// NIVEL 1 ////
		for (int i = 0; i < nivel1[0].length; i++) {
			nivel1[0][i] = new Commander(gui, i + 100, (i + 1) * 2 + 1, (i + 1) * 2 + 2); // Comandantes
			gui.gb_addSprite(i + 100, "enemy100.png", true);
		}

		for (int i = 0; i < nivel1[1].length; i++) { // Goeis nivel 1
			nivel1[1][i] = new Goei(gui, i + 200);
			gui.gb_addSprite(i + 200, "enemy200.png", true);
		}

		for (int i = 0; i < nivel1[2].length; i++) { // Zakos de arriba nivel1
			nivel1[2][i] = new Zako(gui, i + 300);
			gui.gb_addSprite(i + 300, "enemy300.png", true);
		}

		for (int i = 0; i < nivel1[3].length; i++) { // Zakos de abajo nivel1
			nivel1[3][i] = new Zako(gui, i + 300 + nivel1[2].length);
			gui.gb_addSprite(i + 300 + nivel1[2].length, "enemy300.png", true);
		}

		///////////////////////////////////////////////

		////////////////
		/// TORPEDOS ///
		////////////////

		Torpedo[] torpedos = new Torpedo[5];
		for (int i = 0; i < torpedos.length; i++) {
			torpedos[i] = new Torpedo(i + 500, gui, "torpedo100.png");
			gui.gb_addSprite(i + 500, "torpedo100.png", true);
		}

		Torpedo[] torpedosEnemigos = new Torpedo[100];
		for (int i = 0; i < torpedosEnemigos.length; i++) {
			torpedosEnemigos[i] = new Torpedo(i + 600, gui, "torpedo100.png");
			gui.gb_addSprite(i + 600, "torpedo200.png", true);
		}
		/////////////////////////////
		/// POSICIONES TRAS COREO ///
		/////////////////////////////

		for (int i = 0; i < nivel1[0].length; i++) {
			nivel1[0][i].setFinalX(i * 20 + 75);
			nivel1[0][i].setFinalY(25);
		}
		for (int i = 0; i < nivel1[1].length; i++) {
			nivel1[1][i].setFinalX(i * 10 + 40);
			nivel1[1][i].setFinalY(38);
		}
		for (int i = 0; i < nivel1[2].length; i++) {
			nivel1[2][i].setFinalX(i * 10 + 50);
			nivel1[2][i].setFinalY(51);
		}
		for (int i = 0; i < nivel1[3].length; i++) {
			nivel1[3][i].setFinalX(i * 10 + 55);
			nivel1[3][i].setFinalY(64);
		}

		/////////////
		// ESCOLTA //
		/////////////
		for (int i = 0; i < nivel1[1].length; i++) {
			for (int j = 0; j < nivel1[0].length; j++) {
				if (j == ((Commander) nivel1[0][j]).getIdAsociada1()) {
					((Goei) nivel1[1][j]).setEscolta1(true);
				} else if (j == ((Commander) nivel1[0][j]).getIdAsociada2()) {
					((Goei) nivel1[1][j]).setEscolta2(true);
				}
			}
		}

		///////////////
		// VARIABLES //
		///////////////

		int tope = 0;
		boolean izq = false;
		boolean derecha = true;
		int cooldown = Conf.CADENCIA;
		int nextTorpedo = 0;
		int nextTorpedoEnemigo = 0;
		boolean colocacionInicial = true;
		boolean CoreoCompletada = false;
		boolean inLvl1 = false;
		boolean inLvl2 = true;
		boolean inLvl3 = false;
		boolean lvl2Creado = false;
		double frameLvl1 = 0;
		double frameLvl2 = 0;
		double frameLvl3 = 0;

		////////////////////
		////////////////////
		////////////////////
		////////////////////
		////////////////////
		while (!exit) {

			if (pause) {
				switch (gui.gb_getLastAction()) {
				case "tab":
					pause = false;
				}
			}
			while (!pause && !exit) {
				frameLvl1++;
				if (inLvl2)
					frameLvl2++;
				if (inLvl3)
					frameLvl3++;

				///////////
				// FONDO //
				///////////

				for (int i = 0; i < stars[0].length; i++) {
					stars[0][i].Bajar();
					stars[0][i].Bajar();
					stars[0][i].Bajar(); // Las que estan cerca bajan 3 veces por frame
					stars[1][i].Bajar();
					stars[1][i].Bajar(); // Las que no estan muy lejos 2
					stars[2][i].Bajar(); // Las mas lejanas 1
				}

				/////////////
				/// INPUT ///
				/////////////

				switch (gui.gb_getLastAction()) {
				case "left":
					jugador.setX(jugador.getX() - 5);
					break;

				case "right":
					jugador.setX(jugador.getX() + 5);
					break;
				case "tab":
					pause = true;
					break;
				case "up":
					jugador.setY(jugador.getY() - 5);
					break;
				case "down":
					jugador.setY(jugador.getY() + 5);
					break;
				case "space":
					if (cooldown == Conf.CADENCIA) {
						gui.gb_setSpriteVisible(torpedos[nextTorpedo].getId(), true);
						torpedos[nextTorpedo].setX(jugador.getX());
						torpedos[nextTorpedo].setY(jugador.getY() - 10);
						torpedos[nextTorpedo].setAlive(true);
						cooldown = 0;
						do {
							if (nextTorpedo != 5 - 1)
								nextTorpedo++;
							else
								nextTorpedo = 0;
						} while (torpedos[nextTorpedo].isAlive());
					}
					break;
				}

				///////////////////////////////////////
				/// MOVIMIENTO Y MUERTE DE TORPEDOS ///
				///////////////////////////////////////
				for (int i = 0; i < torpedos.length; i++) {
					if (torpedos[i].isAlive()) {
						torpedos[i].setY(torpedos[i].getY() - 3);
						if (torpedos[i].getY() < 0) {
							torpedos[i].setAlive(false);
							gui.gb_setSpriteVisible(torpedos[i].getId(), false);
						}
					}
				}
				if (cooldown != Conf.CADENCIA) {
					cooldown++;
				}
				if (inLvl1) {
					////////////////////////////
					/// POSICIONES INICIALES ///
					////////////////////////////

					if (colocacionInicial) {
						// Goeis de comandantes
						for (int i = 3; i < 7; i++) {
							nivel1[1][i].setY(-5); //
							nivel1[1][i].setX(40 + 10 * i);
							nivel1[1][i].setFrameEntrada(120);
						}
						// Colocacion Goeis
						for (int i = 0; i < 3; i++) {
							nivel1[1][i].setX(-5); // INICIO GOEI IZQ
							nivel1[1][i].setY(38);
							nivel1[1][2 - i].setFrameEntrada(60 + 30 * i); // GoeiIZQ
							nivel1[1][nivel1[1].length - 3 + i].setFrameEntrada(60 + 30 * i); // GoeiDCHA
							nivel1[1][nivel1[1].length - 3 + i].setX(175); // INICIO GoeiDCHA
							nivel1[1][nivel1[1].length - 3 + i].setY(38);
						}
						// Comandantes
						for (int i = 0; i < 2; i++) {
							nivel1[0][i].setX(i * 20 + 75);
							nivel1[0][i].setY(-17);
							nivel1[0][i].setFrameEntrada(120);
						}
						// Zakos Fila 1
						for (int i = 0; i < 4; i++) { // Fila zakos 1
							nivel1[2][i].setX(-9); // Zakos fila 1A INICIO
							nivel1[2][3 - i].setFrameEntrada(60 + 6 * i); // ENTRADA Fila 1A zakos
							nivel1[2][i + 4].setFrameEntrada(60 + 6 * i); // Fila 1B zakos ENTRADA
							nivel1[2][7 - i].setX(179); // Fila 1B zakos INICIO
						}
						for (int i = 0; i < nivel1[2].length; i++) { // Altura INICIO Fila 1AB Zakos
							nivel1[2][i].setY(81);
						}
						// Zakos Fila 2
						for (int i = 0; i < nivel1[3].length; i++) {
							nivel1[3][i].setY(94);
							if (i < 3) {
								nivel1[3][i].setX(-9);
								nivel1[3][i].setFrameEntrada(66 + 12 * i);
							} else {
								nivel1[3][i].setX(178);
							}
						}
						for (int i = 0; i < 4; i++) {
							nivel1[3][nivel1[3].length - 1 - i].setFrameEntrada(60 + 12 * i);
						}

						colocacionInicial = false;
					} // VISIBLES AL ENTRAR
					for (int i = 0; i < nivel1.length; i++) {
						for (int j = 0; j < nivel1[i].length; j++) {
							if (nivel1[i][j].getFrameEntrada() == frameLvl1) {
								gui.gb_setSpriteVisible(nivel1[i][j].getId(), true);
								nivel1[i][j].setAlive(true);
							}
						}
					}

					/////////////////
					// COREOGRAFÍA //
					/////////////////

					for (int j = 0; j < nivel1.length; j++)
						for (int i = 0; i < nivel1[j].length; i++)
							if (frameLvl1 == nivel1[j][i].getFrameEntrada())
								nivel1[j][i].coreoIn = true;

					if (frameLvl1 % 2 == 0 && !CoreoCompletada) { // Movimiento Goeis y comandante
						for (int i = 0; i < 3; i++)
							if (nivel1[1][i].getX() != nivel1[1][i].finalX && nivel1[1][i].coreoIn) {
								nivel1[1][i].setX(nivel1[1][i].getX() + 1);
							}
						for (int i = 7; i < 10; i++)
							if (nivel1[1][i].getX() != nivel1[1][i].finalX && nivel1[1][i].coreoIn) {
								nivel1[1][i].setX(nivel1[1][i].getX() - 1);
							}
						for (int i = 0; i < 2; i++)
							if (nivel1[0][i].getY() != nivel1[0][i].finalY && nivel1[0][i].coreoIn) {
								nivel1[0][i].setY(nivel1[0][i].getY() + 1);
							}
						for (int i = 3; i < 7; i++)
							if (nivel1[1][i].getY() != nivel1[1][i].finalY && nivel1[1][i].coreoIn) {
								nivel1[1][i].setY(nivel1[1][i].getY() + 1);
							}

					}
					if (frameLvl1 % 2 == 0 && !CoreoCompletada) { // MOVIMIENTO ZAKOS
						for (int i = 0; i < 4; i++) { // ENTRADA ZAKOS 1A
							if (nivel1[2][i].coreoIn) {
								if (nivel1[2][i].pasoCoreo < 25) {
									nivel1[2][i].moveCoreo(4, 3);
								} else if (nivel1[2][i].pasoCoreo == 25) {
									nivel1[2][i].moveCoreo(3, 1);
								} else if (nivel1[2][i].pasoCoreo == 26) {
									nivel1[2][i].moveCoreo(2, 2);
								} else if (nivel1[2][i].pasoCoreo == 27) {
									nivel1[2][i].moveCoreo(1, 1);
								} else if (nivel1[2][i].pasoCoreo == 28) {
									nivel1[2][i].moveCoreo(0, 4);
								} else if (nivel1[2][i].pasoCoreo == 29) {
									nivel1[2][i].moveCoreo(15, 1);
								} else if (nivel1[2][i].pasoCoreo == 30) {
									nivel1[2][i].moveCoreo(14, 2);
								} else if (nivel1[2][i].pasoCoreo == 31) {
									nivel1[2][i].moveCoreo(13, 1);
								} else if (nivel1[2][i].pasoCoreo < 40) {
									nivel1[2][i].moveCoreo(12, 3);
								} else if (nivel1[2][i].pasoCoreo == 40) {
									nivel1[2][i].moveCoreo(13, 1);
								} else if (nivel1[2][i].pasoCoreo == 41) {
									nivel1[2][i].moveCoreo(14, 2);
								} else if (nivel1[2][i].pasoCoreo == 42) {
									nivel1[2][i].moveCoreo(15, 1);
								} else if (nivel1[2][i].pasoCoreo == 43) {
									nivel1[2][i].moveCoreo(0, 3);
								} else if (nivel1[2][i].pasoCoreo == 44) {
									nivel1[2][i].moveCoreo(1, 1);
								} else if (nivel1[2][i].pasoCoreo == 45) {
									nivel1[2][i].moveCoreo(2, 2);
								} else if (nivel1[2][i].pasoCoreo == 46) {
									nivel1[2][i].moveCoreo(3, 1);
									nivel1[2][i].setSpriteImage(nivel1[2][i].rotationSpriteNames[4]);
								} else if (nivel1[2][i].getFinalX() != nivel1[2][i].getX()) {
									nivel1[2][i].goTo(nivel1[2][i].getFinalX(), nivel1[2][i].getFinalY(), 1);
								} else if (nivel1[2][i].getFinalX() == nivel1[2][i].getX()) {
									nivel1[2][i].setSpriteImage(nivel1[2][i].spriteFileNameIdle0);
								}
							}
						}
						for (int i = 4; i < 8; i++)
							if (nivel1[2][i].coreoIn) { // ENTRADA ZAKOS 1B
								if (nivel1[2][i].pasoCoreo < 25) {
									nivel1[2][i].moveCoreo(12, 3);
								} else if (nivel1[2][i].pasoCoreo == 25) {
									nivel1[2][i].moveCoreo(13, 1);
								} else if (nivel1[2][i].pasoCoreo == 26) {
									nivel1[2][i].moveCoreo(14, 2);
								} else if (nivel1[2][i].pasoCoreo == 27) {
									nivel1[2][i].moveCoreo(15, 1);
								} else if (nivel1[2][i].pasoCoreo == 28) {
									nivel1[2][i].moveCoreo(0, 3);
								} else if (nivel1[2][i].pasoCoreo == 29) {
									nivel1[2][i].moveCoreo(1, 1);
								} else if (nivel1[2][i].pasoCoreo == 30) {
									nivel1[2][i].moveCoreo(2, 2);
								} else if (nivel1[2][i].pasoCoreo == 31) {
									nivel1[2][i].moveCoreo(3, 1);
								} else if (nivel1[2][i].pasoCoreo < 40) {
									nivel1[2][i].moveCoreo(4, 3);
								} else if (nivel1[2][i].pasoCoreo == 40) {
									nivel1[2][i].moveCoreo(3, 1);
								} else if (nivel1[2][i].pasoCoreo == 41) {
									nivel1[2][i].moveCoreo(2, 2);
								} else if (nivel1[2][i].pasoCoreo == 42) {
									nivel1[2][i].moveCoreo(1, 1);
								} else if (nivel1[2][i].pasoCoreo == 43) {
									nivel1[2][i].moveCoreo(0, 3);
								} else if (nivel1[2][i].pasoCoreo == 44) {
									nivel1[2][i].moveCoreo(15, 1);
								} else if (nivel1[2][i].pasoCoreo == 45) {
									nivel1[2][i].moveCoreo(14, 2);
								} else if (nivel1[2][i].pasoCoreo == 46) {
									nivel1[2][i].moveCoreo(13, 1);
									nivel1[2][i].setSpriteImage(nivel1[2][i].rotationSpriteNames[12]);
								} else if (nivel1[2][i].getFinalX() != nivel1[2][i].getX()) {
									nivel1[2][i].goTo(nivel1[2][i].getFinalX(), nivel1[2][i].getFinalY(), 1);
								} else if (nivel1[2][i].getFinalX() <= nivel1[2][i].getX()) {
									nivel1[2][i].setSpriteImage(nivel1[2][i].spriteFileNameIdle0);
								}
							}
						for (int i = 0; i < 3; i++) { // ZAKOS LINEA2
							if (nivel1[3][i].coreoIn) { // ZAKOS 2A
								if (nivel1[3][i].pasoCoreo < 29) {
									nivel1[3][i].moveCoreo(4, 3);
								} else if (nivel1[3][i].pasoCoreo == 29) {
									nivel1[3][i].moveCoreo(3, 1);
								} else if (nivel1[3][i].pasoCoreo == 30) {
									nivel1[3][i].moveCoreo(2, 2);
								} else if (nivel1[3][i].pasoCoreo == 31) {
									nivel1[3][i].moveCoreo(1, 1);
								} else if (nivel1[3][i].pasoCoreo < 38) {
									nivel1[3][i].moveCoreo(0, 3);
								} else if (nivel1[3][i].pasoCoreo == 38) {
									nivel1[3][i].moveCoreo(15, 1);
								} else if (nivel1[3][i].pasoCoreo == 39) {
									nivel1[3][i].moveCoreo(14, 2);
								} else if (nivel1[3][i].pasoCoreo == 40) {
									nivel1[3][i].moveCoreo(13, 1);
									nivel1[3][i].setSpriteImage(nivel1[3][i].rotationSpriteNames[12]);
								} else if (nivel1[3][i].getFinalX() != nivel1[3][i].getX()) {
									nivel1[3][i].setX(nivel1[3][i].getX() - 1);
								} else if (nivel1[3][i].getFinalX() == nivel1[3][i].getX()) {
									nivel1[3][i].setSpriteImage(nivel1[3][i].spriteFileNameIdle0);
								}
							}
						}
						for (int i = 3; i < 7; i++) {
							if (nivel1[3][i].coreoIn) { // ZAKOS 2B
								if (nivel1[3][i].pasoCoreo < 29) {
									nivel1[3][i].moveCoreo(12, 3);
								} else if (nivel1[3][i].pasoCoreo == 29) {
									nivel1[3][i].moveCoreo(13, 1);
								} else if (nivel1[3][i].pasoCoreo == 30) {
									nivel1[3][i].moveCoreo(14, 2);
								} else if (nivel1[3][i].pasoCoreo == 31) {
									nivel1[3][i].moveCoreo(15, 1);
								} else if (nivel1[3][i].pasoCoreo < 38) {
									nivel1[3][i].moveCoreo(0, 3);
								} else if (nivel1[3][i].pasoCoreo == 38 && i != 3) {
									nivel1[3][i].moveCoreo(1, 1);
								} else if (nivel1[3][i].pasoCoreo == 39 && i != 3) {
									nivel1[3][i].moveCoreo(2, 2);
								} else if (nivel1[3][i].pasoCoreo == 40 && i != 3) {
									nivel1[3][i].moveCoreo(3, 1);
								} else if (nivel1[3][i].getFinalX() != nivel1[3][i].getX() && i != 3) {
									nivel1[3][i].setSpriteImage(nivel1[3][i].rotationSpriteNames[4]);
									nivel1[3][i].setX(nivel1[3][i].getX() + 1);
								} else if (i == 3 && nivel1[3][i].getY() != nivel1[3][i].finalY) {
									nivel1[3][i].setY(nivel1[3][i].getY() - 1);
								} else if (nivel1[3][i].getFinalX() == nivel1[3][i].getX()) {
									nivel1[3][i].setSpriteImage(nivel1[3][i].spriteFileNameIdle0);
								}
							}
						}
					}

					//////////////////////////
					/// COMPROBACION COREO ///
					//////////////////////////
					if (!CoreoCompletada) {
						CoreoCompletada = true;
						for (int i = 0; i < nivel1.length; i++) {
							for (int j = 0; j < nivel1[i].length; j++) {
								if (nivel1[i][j].getFinalX() != nivel1[i][j].getX()) {
									CoreoCompletada = false;
								}
							}
						}
						if (CoreoCompletada)
							for (int i = 0; i < nivel1.length; i++) {
								for (int j = 0; j < nivel1[i].length; j++) {
									nivel1[i][j].pasoCoreo = 0;
								}
							}
					}
					//////////////////////////
					/// VUELTA TRAS ATACAR ///
					//////////////////////////
					if (CoreoCompletada) {
						for (int i = 0; i < nivel1.length; i++) {
							for (int j = 0; j < nivel1[i].length; j++) {
								if (nivel1[i][j].getX() == nivel1[i][j].finalX && nivel1[i][j].y == nivel1[i][j].finalY)
									nivel1[i][j].isInEnjambre = true;
								else
									nivel1[i][j].isInEnjambre = false;
							}
						}
					}
					if (CoreoCompletada && frameLvl1 % 3 == 0)
						for (int i = 0; i < nivel1.length; i++) {
							for (int j = 0; j < nivel1[i].length; j++) {
								if (nivel1[i][j].isAlive() && nivel1[i][j].expedicionCompletada
										&& nivel1[i][j].isInEnjambre == false) {
									nivel1[i][j].goTo(nivel1[i][j].finalX, nivel1[i][j].finalY, 1);

								}
							}
						}

					////////////////
					/// ENJAMBRE ///
					////////////////
					if (frameLvl1 % Conf.SPEED == 0 && CoreoCompletada) {
						if (izq) {
							for (int i = 0; i < nivel1.length; i++) {
								for (int j = 0; j < nivel1[i].length; j++) {
									if (nivel1[i][j].isAlive()) {
										nivel1[i][j].finalX--;
										if (nivel1[i][j].isInEnjambre) {
											nivel1[i][j].setX((nivel1[i][j].getX() - 1));
										}
									}
									if (i == 1
											&& (((Goei) nivel1[i][j]).isEscolta1 || ((Goei) nivel1[i][j]).isEscolta2))
										((Goei) nivel1[1][i]).setxRelativa(((Goei) nivel1[1][i]).getxRelativa() - 1);

								}
							}
							if (--tope == -15) {
								derecha = true;
								izq = false;
							}
						} else if (derecha) {
							for (int i = 0; i < nivel1.length; i++) {
								for (int j = 0; j < nivel1[i].length; j++) {
									if (nivel1[i][j].isAlive()) {
										nivel1[i][j].finalX++;
										if (nivel1[i][j].isInEnjambre) {
											nivel1[i][j].setX((nivel1[i][j].getX() + 1));
										}
									}
									if (i == 1
											&& (((Goei) nivel1[i][j]).isEscolta1 || ((Goei) nivel1[i][j]).isEscolta2))
										((Goei) nivel1[1][i]).setxRelativa(((Goei) nivel1[1][i]).getxRelativa() + 1);
								}
							}
							if (++tope == 15) {
								derecha = false;
								izq = true;
							}

						}
					}
				}

				//////////////////////////
				/// MUERTE DE ENEMIGOS ///
				//////////////////////////
				if (inLvl1)
					for (int i = 0; i < nivel1.length; i++) {
						for (int j = 0; j < nivel1[i].length; j++) {
							if (nivel1[i][j].isAlive()) {
								for (int h = 0; h < torpedos.length; h++) {
									if (torpedos[h].isAlive()) {
										if (torpedos[h].getX() <= nivel1[i][j].getX() + 5
												&& torpedos[h].getX() >= nivel1[i][j].getX() - 5
												&& torpedos[h].getY() <= nivel1[i][j].getY() + 8
												&& torpedos[h].getY() >= nivel1[i][j].getY() - 6) {
											torpedos[h].setAlive(false);
											gui.gb_setSpriteVisible(torpedos[h].getId(), false);
											if (!nivel1[i][j].hasExtraHP) {
												nivel1[i][j].setAlive(false);
												nivel1[i][j].setMuriendo(true);
											} else {
												((Commander) nivel1[i][j]).reduceHP();
											}
										}
									}
								}
							}
						}
					}
				for (int i = 0; i < nivel1.length; i++) {
					for (int j = 0; j < nivel1[i].length; j++) {
						if (nivel1[i][j].isMuriendo)
							nivel1[i][j].performDeath();
					}
				}

				//////////////////////////////////
				/// ANIMACION PERIODICA PASIVA ///
				//////////////////////////////////
				if (CoreoCompletada && inLvl1)
					for (int i = 0; i < nivel1.length; i++) { // animacion idle
						for (int j = 0; j < nivel1[i].length; j++)
							nivel1[i][j].animacionIdle(frameLvl1);
					}

				////////////////
				/// TORPEDOS ///
				/// ENEMIGOS ///
				////////////////
				if (CoreoCompletada && inLvl1) {
					for (int i = 0; i < nivel1.length; i++)
						for (int j = 0; j < nivel1[i].length; j++)
							if (nivel1[i][j].isAlive())
								if (Math.random() * 2000 > 1999) {
									gui.gb_setSpriteVisible(torpedosEnemigos[nextTorpedoEnemigo].getId(), true);
									torpedosEnemigos[nextTorpedoEnemigo].setX(nivel1[i][j].getX());
									torpedosEnemigos[nextTorpedoEnemigo].setY(nivel1[i][j].getY() + 3);
									torpedosEnemigos[nextTorpedoEnemigo].setAlive(true);
									do {
										if (nextTorpedoEnemigo != 100 - 1)
											nextTorpedoEnemigo++;
										else
											nextTorpedoEnemigo = 0;
									} while (torpedosEnemigos[nextTorpedoEnemigo].isAlive());
								}
					for (int i = 0; i < torpedosEnemigos.length; i++) {
						if (torpedosEnemigos[i].isAlive()) {
							torpedosEnemigos[i].setY(torpedosEnemigos[i].getY() + 2);
							if (torpedosEnemigos[i].getY() > 220) {
								torpedosEnemigos[i].setAlive(false);
								gui.gb_setSpriteVisible(torpedosEnemigos[i].getId(), false);
							}
						}
					}
					for (int i = 0; i < torpedosEnemigos.length; i++) {
						if (torpedosEnemigos[i].isAlive() && torpedosEnemigos[i].getX() <= jugador.getX() + 5
								&& torpedosEnemigos[i].getX() >= jugador.getX() - 5
								&& torpedosEnemigos[i].getY() <= jugador.getY() + 5
								&& torpedosEnemigos[i].getY() >= jugador.getY() - 7) {
							torpedosEnemigos[i].setAlive(false);
							gui.gb_setSpriteVisible(torpedosEnemigos[i].getId(), false);
							jugador.reduceHP();
						}
					}
				}
				////////////////
				/// COLISION ///
				////////////////

				for (int i = 0; i < nivel1.length; i++) {
					for (int j = 0; j < nivel1[i].length; j++) {
						if (nivel1[i][j].isAlive())
							if (nivel1[i][j].getX() >= jugador.getX() - 10 && nivel1[i][j].getY() >= jugador.getY() - 10
									&& nivel1[i][j].getX() <= jugador.getX() + 10
									&& nivel1[i][j].getY() <= jugador.getY() + 10) {
								exit = true;
							}
					}
				}

				/////////////////////
				// ZIGZAG Y GANKEO //
				/////////////////////
				if (frameLvl1 % 3 == 0 && CoreoCompletada)
					for (int i = 0; i < nivel1.length; i++) {
						for (int j = 0; j < nivel1[i].length; j++) {
							if (nivel1[i][j].isAlive() && i > 1) {
								if (Math.random() * 1000 > 999 && nivel1[i][j].isInEnjambre
										&& !nivel1[i][j].isGankeando) {
									nivel1[i][j].isZigzagueando = true;
								}
								if (nivel1[i][j].isZigzagueando && !nivel1[i][j].isGankeando)
									nivel1[i][j].zigzag(true);
								if (nivel1[i][j].isGankeando && nivel1[i][j].isZigzagueando) {
									jugador.setFinalX(jugador.getX());
									jugador.setFinalY(jugador.getY());
									nivel1[i][j].isZigzagueando = false;
								} else if (!nivel1[i][j].isZigzagueando && nivel1[i][j].isGankeando) {
									nivel1[i][j].goTo(jugador.getFinalX(), jugador.getFinalY(), 1);
									if (nivel1[i][j].isGoToDone) {
										nivel1[i][j].setGankeando(false);
										nivel1[i][j].setZigzagueando(true);
									}
								}
							}
							// Para comandantes y sus goei
							else if (i == 0 && nivel1[0][j].isAlive()) {
								if (Math.random() * 10 > 9 && nivel1[0][j].isInEnjambre)
									nivel1[0][j].isZigzagueando = true;
								if (nivel1[0][j].isZigzagueando
										&& !nivel1[1][((Commander) nivel1[0][j]).getIdAsociada1()].isZigzagueando
										&& !nivel1[1][((Commander) nivel1[0][j]).getIdAsociada2()].isZigzagueando) {
									((Goei) nivel1[1][((Commander) nivel1[0][j]).getIdAsociada1()])
											.setxRelativa(((Commander) nivel1[0][j]).getX() - 6);
									((Goei) nivel1[1][((Commander) nivel1[0][j]).getIdAsociada2()])
											.setxRelativa(((Commander) nivel1[0][j]).getX() + 6);
									((Goei) nivel1[1][((Commander) nivel1[0][j]).getIdAsociada1()])
											.setyRelativa(((Commander) nivel1[0][j]).getY() + 13);
									((Goei) nivel1[1][((Commander) nivel1[0][j]).getIdAsociada2()])
											.setyRelativa(((Commander) nivel1[0][j]).getY() + 13);
									nivel1[1][((Commander) nivel1[0][j]).getIdAsociada1()].goTo(
											((Goei) nivel1[1][((Commander) nivel1[0][j]).getIdAsociada1()]).xRelativa,
											((Goei) nivel1[1][((Commander) nivel1[0][j]).getIdAsociada1()]).yRelativa,
											1);
									nivel1[1][((Commander) nivel1[0][j]).getIdAsociada2()].goTo(
											((Goei) nivel1[1][((Commander) nivel1[0][j]).getIdAsociada2()]).xRelativa,
											((Goei) nivel1[1][((Commander) nivel1[0][j]).getIdAsociada2()]).yRelativa,
											1);
								}
								if (nivel1[1][((Commander) nivel1[0][j]).getIdAsociada1()].isZigzagueando
										&& nivel1[1][((Commander) nivel1[0][j]).getIdAsociada2()].isZigzagueando) {
									nivel1[1][((Commander) nivel1[0][j]).getIdAsociada1()].zigzag(false);
									nivel1[1][((Commander) nivel1[0][j]).getIdAsociada2()].zigzag(false);
									nivel1[0][j].zigzag(false);
								} else if (nivel1[1][((Commander) nivel1[0][j]).getIdAsociada1()]
										.getX() == ((Goei) nivel1[1][((Commander) nivel1[0][j])
												.getIdAsociada1()]).xRelativa
										&& nivel1[1][((Commander) nivel1[0][j]).getIdAsociada1()]
												.getY() == ((Goei) nivel1[1][((Commander) nivel1[0][j])
														.getIdAsociada1()]).yRelativa
										&& nivel1[1][((Commander) nivel1[0][j]).getIdAsociada2()]
												.getX() == ((Goei) nivel1[1][((Commander) nivel1[0][j])
														.getIdAsociada2()]).xRelativa
										&& nivel1[1][((Commander) nivel1[0][j]).getIdAsociada2()]
												.getY() == ((Goei) nivel1[1][((Commander) nivel1[0][j])
														.getIdAsociada2()]).yRelativa) {
									nivel1[1][((Commander) nivel1[0][j]).getIdAsociada1()].isZigzagueando = true;
									nivel1[1][((Commander) nivel1[0][j]).getIdAsociada2()].isZigzagueando = true;
								}
								if (nivel1[0][j].getY() > 225) {
									nivel1[0][j].zigzag(false);
								}
							}
						}
					}

				///////////////////////////////
				/// COMPROBACION FINAL LVL1 ///
				///////////////////////////////
				if (inLvl1 && CoreoCompletada) {
					inLvl1 = false;
					for (int i = 0; i < nivel1.length; i++) {
						for (int j = 0; j < nivel1[i].length; j++) {
							if (nivel1[i][j].isAlive()) {
								inLvl1 = true;

							}
						}
					}
				}
				if (!inLvl1) {
					inLvl2 = true;
				}

				if (inLvl2) {

					///// ASIGNACION DE SPRITES E INICIALIZACION NIVEL 2 /////
					if (!lvl2Creado) {
						CoreoCompletada = false;
						gui.gb_println("El nivel 1 ha sido completado");
						// Creacion Comandantes lvl 2
						for (int i = 0; i < nivel2[0].length; i++) {
							nivel2[0][i] = new Commander(gui, i + 100, i * 2, i * 2 + 1);
							gui.gb_addSprite(i + 100, "enemy100.png", true);
						}
						// Creacion Goeis fila 1 lvl 2
						for (int i = 0; i < nivel2[1].length; i++) {
							nivel2[1][i] = new Goei(gui, i + 200);
							gui.gb_addSprite(i + 200, "enemy200.png", true);
						}
						// Creacion Goeis fila 2 lvl 2
						for (int i = 0; i < nivel2[2].length; i++) {
							nivel2[2][i] = new Goei(gui, i + 200 + nivel2[1].length);
							gui.gb_addSprite(i + 200 + nivel2[1].length, "enemy200.png", true);
						}
						// Creacion Zakos fila 1 lvl 2
						for (int i = 0; i < nivel2[3].length; i++) {
							nivel2[3][i] = new Zako(gui, i + 300);
							gui.gb_addSprite(i + 300, "enemy300.png", true);
						}
						// Creacion Zakos fila 2 lvl 2
						for (int i = 0; i < nivel2[4].length; i++) {
							nivel2[4][i] = new Zako(gui, i + 300 + nivel2[3].length);
							gui.gb_addSprite(i + 300 + nivel2[3].length, "enemy300.png", true);
						}
						// Creacion Zakos fila 3 lvl 2
						for (int i = 0; i < nivel2[5].length; i++) {
							nivel2[5][i] = new Zako(gui, i + 300 + nivel2[3].length + nivel2[4].length);
							gui.gb_addSprite(i + 300 + nivel2[3].length + nivel2[4].length, "enemy300.png", true);
						}

						/// POSICIONES TRAS COREO LVL 2 ///

						for (int i = 0; i < nivel2[0].length; i++) {
							nivel2[0][i].setFinalX(i * 10 + 70);
							nivel2[0][i].setFinalY(25);
						}
						for (int i = 0; i < nivel2[1].length; i++) {
							nivel2[1][i].setFinalX(i * 10 + 50);
							nivel2[1][i].setFinalY(35);
						}
						for (int i = 0; i < 4; i++) {
							nivel2[2][i].setFinalX(80 - i * 10);
							nivel2[2][i].setFinalY(45);
						}
						for (int i = 4; i < nivel2[2].length; i++) {
							nivel2[2][i].setFinalX((i - 4) * 10 + 90);
							nivel2[2][i].setFinalY(45);
						}
						for (int i = 0; i < 4; i++) {
							nivel2[3][i].setFinalX(i * 10 + 50);
							nivel2[3][i].setFinalY(55);
						}
						for (int i = 4; i < 8; i++) {
							nivel2[3][i].setFinalX(120 - (i - 4) * 10);
							nivel2[3][i].setFinalY(55);
						}
						for (int i = 0; i < 3; i++) {
							nivel2[4][i].setFinalX(i * 10 + 60);
							nivel2[4][i].setFinalY(65);
						}
						for (int i = 3; i < 6; i++) {
							nivel2[4][i].setFinalX(110 - (i - 3) * 10);
							nivel2[4][i].setFinalY(65);
						}
						for (int i = 0; i < 2; i++) {
							nivel2[5][i].setFinalX(90 + i * 10);
						}
						nivel2[5][2].setFinalX(80);
						nivel2[5][3].setFinalX(70);
						for (int i = 0; i < nivel2[5].length; i++)
							nivel2[5][i].setFinalY(75);

						/////////////
						// ESCOLTA //
						/////////////
						for (int i = 0; i < nivel2[1].length; i++) {
							for (int j = 0; j < nivel2[0].length; j++) {
								if (nivel2[1][i].getId() == ((Commander) nivel2[0][j]).getIdAsociada1()) {
									((Goei) nivel2[1][i]).setEscolta1(true);

								} else if (nivel2[1][i].getId() == ((Commander) nivel2[0][j]).getIdAsociada2()) {
									((Goei) nivel2[1][i]).setEscolta2(true);

								}
							}
						}

						///////////////////////////////
						// POSICIONES INICIALES LVL2 //
						///////////////////////////////
						// Posiciones de los comandantes
						nivel2[0][0].setX(-15);
						nivel2[0][0].setY(25);
						for (int i = 1; i < 3; i++) {
							nivel2[0][i].setX(80 + ((i - 1) * 10));
							nivel2[0][i].setY(-15);
						}
						nivel2[0][3].setX(185);
						nivel2[0][3].setY(25);
						for (int i = 0; i < nivel2[0].length; i++) {
							nivel2[0][i].setFrameEntrada(120);
						}
						// Posiciones de la fila 1 de goeis
						for (int i = 0; i < 2; i++) {
							nivel2[1][i].setX(-5);
							nivel2[1][i].setY(35 - i * 20);
						}
						for (int i = 2; i < 6; i++) {
							nivel2[1][i].setX(70 + ((i - 2) * 10));
							nivel2[1][i].setY(-5);
						}
						for (int i = 6; i < 8; i++) {
							nivel2[1][i].setX(175);
							nivel2[1][i].setY(15 + ((i - 6) * 20));
						}
						for (int i = 0; i < nivel2[1].length; i++) {
							nivel2[1][i].setFrameEntrada(120);
						}
						// Posiciones de la fila 2 de goeis
						for (int i = 0; i < 4; i++) {
							nivel2[2][i].setX(40);
							nivel2[2][i].setY(-15);
						}
						for (int i = 4; i < 8; i++) {
							nivel2[2][i].setX(130);
							nivel2[2][i].setY(-15);
						}
						for (int i = 0; i < 4; i++) {
							nivel2[2][i].setFrameEntrada(180 + i * 10);
						}
						for (int i = 4; i < 8; i++) {
							nivel2[2][i].setFrameEntrada(180 + (i - 4) * 10);
						}
						// Posiciones de la fila 1 de Zakos
						for (int i = 0; i < 4; i++) {
							nivel2[3][i].setX(-5);
							nivel2[3][i].setY(105);
						}
						for (int i = 4; i < 8; i++) {
							nivel2[3][i].setX(175);
							nivel2[3][i].setY(105);
						}
						for (int i = 0; i < 4; i++) {
							nivel2[3][i].setFrameEntrada(180 + i * 10);
						}
						for (int i = 4; i < 8; i++) {
							nivel2[3][i].setFrameEntrada(180 + (i - 4) * 10);
						}
						// Posiciones de la fila 2 de Zakos
						for (int i = 0; i < 3; i++) {
							nivel2[4][i].setX(-5);
							nivel2[4][i].setY(165);
						}
						for (int i = 3; i < 6; i++) {
							nivel2[4][i].setX(175);
							nivel2[4][i].setY(165);
						}
						for (int i = 0; i < 3; i++) {
							nivel2[4][i].setFrameEntrada(170 + i * 10);
						}
						for (int i = 3; i < 6; i++) {
							nivel2[4][i].setFrameEntrada(170 + (i - 3) * 10);
						}
						// Posiciones de la fila 3 de Zakos
						for (int i = 0; i < 2; i++) {
							nivel2[5][i].setX(-5);
							nivel2[5][i].setY(165);
						}
						for (int i = 2; i < 4; i++) {
							nivel2[5][i].setX(175);
							nivel2[5][i].setY(165);
						}
						for (int i = 0; i < 2; i++) {
							nivel2[5][i].setFrameEntrada(120 + i * 6);
						}
						for (int i = 2; i < 4; i++) {
							nivel2[5][i].setFrameEntrada(120 + (i - 2) * 6);
						}
						lvl2Creado = true;
					}

					if (frameLvl2 > 5 && !CoreoCompletada) {
						// VISIBLES AL ENTRAR
						for (int i = 0; i < nivel2.length; i++) {
							for (int j = 0; j < nivel2[i].length; j++) {
								if (nivel2[i][j].getFrameEntrada() == frameLvl2) {
									gui.gb_setSpriteVisible(nivel2[i][j].getId(), true);
									nivel2[i][j].setAlive(true);
									nivel2[i][j].coreoIn = true;
								}
							}
						}
					}

					/////////////////////////
					/// COREOGRAFIA LVL 2 ///
					/////////////////////////
					if (frameLvl2 > 5 && !CoreoCompletada) {

						// Movimiento de los comandantes y fila 1 Goeis
						if (frameLvl2 % 2 == 0) {
							if (nivel2[0][0].coreoIn) {
								// Comandante de la izqda
								if (nivel2[0][0].pasoCoreo < 18)
									nivel2[0][0].moveCoreo(4, 3);
								else if (nivel2[0][0].pasoCoreo < 22)
									nivel2[0][0].moveCoreo(4, 1);
								else if (!nivel2[0][0].isInEnjambre) {
									nivel2[0][0].goTo(nivel2[0][0].getFinalX(), nivel2[0][0].getFinalY(), 1);
									if (nivel2[0][0].isGoToDone)
										nivel2[0][0].setSpriteImage(nivel2[0][0].spriteFileNameIdle0);
								}
							}
							if (nivel2[0][3].coreoIn) {
								// Comandante de la dcha
								if (nivel2[0][3].pasoCoreo < 18)
									nivel2[0][3].moveCoreo(12, 3);
								else if (nivel2[0][3].pasoCoreo < 22)
									nivel2[0][3].moveCoreo(12, 1);
								else if (!nivel2[0][3].isInEnjambre) {
									nivel2[0][3].goTo(nivel2[0][3].getFinalX(), nivel2[0][3].getFinalY(), 1);
									if (nivel2[0][3].isGoToDone)
										nivel2[0][3].setSpriteImage(nivel2[0][3].spriteFileNameIdle0);
								}
							}
							for (int i = 1; i < 3; i++) { // Comandantes del medio
								if (nivel2[0][i].coreoIn) {
									if (nivel2[0][i].pasoCoreo < 19)
										nivel2[0][i].moveCoreo(8, 2);
									else if (!nivel2[0][i].isInEnjambre) {
										nivel2[0][i].goTo(nivel2[0][i].getFinalX(), nivel2[0][i].getFinalY(), 1);
										if (nivel2[0][i].isGoToDone)
											nivel2[0][i].setSpriteImage(nivel2[0][i].spriteFileNameIdle0);
									}
								}
							}
							for (int i = 2; i < 6; i++) { // Goeis Acompañantes de los comandantes del medio
								if (nivel2[1][i].coreoIn) {
									if (nivel2[1][i].pasoCoreo < 19)
										nivel2[1][i].moveCoreo(8, 2);
									else if (!nivel2[1][i].isInEnjambre) {
										nivel2[1][i].goTo(nivel2[1][i].getFinalX(), nivel2[1][i].getFinalY(), 1);
										if (nivel2[1][i].isGoToDone)
											nivel2[1][i].setSpriteImage(nivel2[1][i].spriteFileNameIdle0);
									}
								}
							}

							// Goeis acompañantes superiores de los comandantes laterales
							if (nivel2[1][0].coreoIn) {
								if (nivel2[1][0].pasoCoreo < 20) {
									nivel2[1][0].moveCoreo(4, 3);
								} else if (!nivel2[1][0].isInEnjambre) {
									nivel2[1][0].goTo(nivel2[1][0].getFinalX(), nivel2[1][0].getFinalY(), 1);
									if (nivel2[1][0].isGoToDone)
										nivel2[1][0].setSpriteImage(nivel2[1][0].spriteFileNameIdle0);
								}
							}
							if (nivel2[1][6].coreoIn) {
								if (nivel2[1][6].pasoCoreo < 20) {
									nivel2[1][6].moveCoreo(12, 3);
								} else if (!nivel2[1][6].isInEnjambre) {
									nivel2[1][6].goTo(nivel2[1][6].getFinalX(), nivel2[1][6].getFinalY(), 1);
									if (nivel2[1][0].isGoToDone)
										nivel2[1][6].setSpriteImage(nivel2[1][6].spriteFileNameIdle0);
								}
							}

							// Goeis acompañantes inferiores de los comandantes laterales
							if (nivel2[1][1].coreoIn) {
								if (nivel2[1][1].pasoCoreo < 18)
									nivel2[1][1].moveCoreo(4, 3);
								else if (!nivel2[1][1].isInEnjambre) {
									nivel2[1][1].goTo(nivel2[1][1].getFinalX(), nivel2[1][1].getFinalY(), 1);
									if (nivel2[1][1].isGoToDone)
										nivel2[1][1].setSpriteImage(nivel2[1][1].spriteFileNameIdle0);
								}
							}
							if (nivel2[1][7].coreoIn) {
								if (nivel2[1][7].pasoCoreo < 18)
									nivel2[1][7].moveCoreo(12, 3);
								else if (!nivel2[1][7].isInEnjambre) {
									nivel2[1][7].goTo(nivel2[1][7].getFinalX(), nivel2[1][7].getFinalY(), 1);
									if (nivel2[1][7].isGoToDone)
										nivel2[1][7].setSpriteImage(nivel2[1][1].spriteFileNameIdle0);
								}

							}

							// Goeis de la fila 2 de la izqda
							for (int i = 0; i < 4; i++) {
								if (nivel2[2][i].coreoIn) {
									if (nivel2[2][i].pasoCoreo < 22)
										nivel2[2][i].moveCoreo(8, 4);
									else if (nivel2[2][i].pasoCoreo == 22)
										nivel2[2][i].moveCoreo(8, 2);
									else if (nivel2[2][i].pasoCoreo == 23)
										nivel2[2][i].moveCoreo(9, 1);
									else if (nivel2[2][i].pasoCoreo == 24)
										nivel2[2][i].moveCoreo(10, 2);
									else if (nivel2[2][i].pasoCoreo == 25)
										nivel2[2][i].moveCoreo(11, 1);
									else if (nivel2[2][i].pasoCoreo < 32)
										nivel2[2][i].moveCoreo(12, 3);
									else if (nivel2[2][i].pasoCoreo == 32)
										nivel2[2][i].moveCoreo(13, 1);
									else if (nivel2[2][i].pasoCoreo == 33)
										nivel2[2][i].moveCoreo(14, 2);
									else if (nivel2[2][i].pasoCoreo == 34)
										nivel2[2][i].moveCoreo(15, 1);
									else if (nivel2[2][i].pasoCoreo < 43)
										nivel2[2][i].moveCoreo(0, 3);
									else if (nivel2[2][i].pasoCoreo == 43)
										nivel2[2][i].moveCoreo(1, 1);
									else if (nivel2[2][i].pasoCoreo == 44)
										nivel2[2][i].moveCoreo(2, 2);
									else if (nivel2[2][i].pasoCoreo == 45)
										nivel2[2][i].moveCoreo(3, 1);
									else if (!nivel2[2][i].isInEnjambre) {
										nivel2[2][i].goTo(nivel2[2][i].getFinalX(), nivel2[2][i].getFinalY(), 1);
										if (nivel2[2][i].isGoToDone)
											nivel2[2][i].setSpriteImage(nivel2[2][i].spriteFileNameIdle0);
									}
								}
							}
							// Goeis de la fila 2 de la dcha
							for (int i = 4; i < 8; i++) {
								if (nivel2[2][i].coreoIn) {
									if (nivel2[2][i].pasoCoreo < 22)
										nivel2[2][i].moveCoreo(8, 4);
									else if (nivel2[2][i].pasoCoreo == 22)
										nivel2[2][i].moveCoreo(8, 2);
									else if (nivel2[2][i].pasoCoreo == 23)
										nivel2[2][i].moveCoreo(7, 1);
									else if (nivel2[2][i].pasoCoreo == 24)
										nivel2[2][i].moveCoreo(6, 2);
									else if (nivel2[2][i].pasoCoreo == 25)
										nivel2[2][i].moveCoreo(5, 1);
									else if (nivel2[2][i].pasoCoreo < 32)
										nivel2[2][i].moveCoreo(4, 3);
									else if (nivel2[2][i].pasoCoreo == 32)
										nivel2[2][i].moveCoreo(3, 1);
									else if (nivel2[2][i].pasoCoreo == 33)
										nivel2[2][i].moveCoreo(2, 2);
									else if (nivel2[2][i].pasoCoreo == 34)
										nivel2[2][i].moveCoreo(1, 1);
									else if (nivel2[2][i].pasoCoreo < 43)
										nivel2[2][i].moveCoreo(0, 3);
									else if (nivel2[2][i].pasoCoreo == 43)
										nivel2[2][i].moveCoreo(15, 1);
									else if (nivel2[2][i].pasoCoreo == 44)
										nivel2[2][i].moveCoreo(14, 2);
									else if (nivel2[2][i].pasoCoreo == 45)
										nivel2[2][i].moveCoreo(13, 1);
									else if (!nivel2[2][i].isInEnjambre) {
										nivel2[2][i].goTo(nivel2[2][i].getFinalX(), nivel2[2][i].getFinalY(), 1);
										if (nivel2[2][i].isGoToDone)
											nivel2[2][i].setSpriteImage(nivel2[2][i].spriteFileNameIdle0);
									}
								}
							}

							// Zakos fila 1 izqda
							for (int i = 0; i < 4; i++) {
								if (nivel2[3][i].coreoIn) {
									if (nivel2[3][i].pasoCoreo < 19)
										nivel2[3][i].moveCoreo(4, 4);
									else if (nivel2[3][i].pasoCoreo == 19)
										nivel2[3][i].moveCoreo(4, 2);
									else if (nivel2[3][i].pasoCoreo == 20)
										nivel2[3][i].moveCoreo(3, 1);
									else if (nivel2[3][i].pasoCoreo == 21)
										nivel2[3][i].moveCoreo(2, 2);
									else if (nivel2[3][i].pasoCoreo == 22)
										nivel2[3][i].moveCoreo(1, 1);
									else if (nivel2[3][i].pasoCoreo < 30)
										nivel2[3][i].moveCoreo(0, 3);
									else if (nivel2[3][i].pasoCoreo < 41)
										nivel2[3][i].moveCoreo(0, 2);
									else if (nivel2[3][i].pasoCoreo == 41)
										nivel2[3][i].moveCoreo(0, 1);
									else if (!nivel2[3][i].isInEnjambre) {
										nivel2[3][i].goTo(nivel2[3][i].getFinalX(), nivel2[3][i].getFinalY(), 1);
										if (nivel2[3][i].isGoToDone)
											nivel2[3][i].setSpriteImage(nivel2[3][i].spriteFileNameIdle0);
									}
								}
							}
							// Zakos fila 1 dcha
							for (int i = 4; i < 8; i++) {
								if (nivel2[3][i].coreoIn) {
									if (nivel2[3][i].pasoCoreo < 19)
										nivel2[3][i].moveCoreo(12, 4);
									else if (nivel2[3][i].pasoCoreo == 19)
										nivel2[3][i].moveCoreo(12, 1);
									else if (nivel2[3][i].pasoCoreo == 20)
										nivel2[3][i].moveCoreo(13, 1);
									else if (nivel2[3][i].pasoCoreo == 21)
										nivel2[3][i].moveCoreo(14, 2);
									else if (nivel2[3][i].pasoCoreo == 22)
										nivel2[3][i].moveCoreo(15, 1);
									else if (nivel2[3][i].pasoCoreo < 30)
										nivel2[3][i].moveCoreo(0, 3);
									else if (nivel2[3][i].pasoCoreo < 41)
										nivel2[3][i].moveCoreo(0, 2);
									else if (nivel2[3][i].pasoCoreo == 41)
										nivel2[3][i].moveCoreo(0, 1);
									else if (!nivel2[3][i].isInEnjambre) {
										nivel2[3][i].goTo(nivel2[3][i].getFinalX(), nivel2[3][i].getFinalY(), 1);
										if (nivel2[3][i].isGoToDone)
											nivel2[3][i].setSpriteImage(nivel2[3][i].spriteFileNameIdle0);
									}
								}
							}

							// Zakos fila 2 izqda
							for (int i = 0; i < 3; i++) {
								if (nivel2[4][i].coreoIn) {
									if (nivel2[4][i].pasoCoreo < 5)
										nivel2[4][i].moveCoreo(4, 1);
									else if (nivel2[4][i].pasoCoreo == 5)
										nivel2[4][i].moveCoreo(3, 1);
									else if (nivel2[4][i].pasoCoreo == 6)
										nivel2[4][i].moveCoreo(2, 1);
									else if (nivel2[4][i].pasoCoreo == 7)
										nivel2[4][i].moveCoreo(1, 1);
									else if (nivel2[4][i].pasoCoreo < 25)
										nivel2[4][i].moveCoreo(0, 3);
									else if (nivel2[4][i].pasoCoreo == 25)
										nivel2[4][i].moveCoreo(1, 1);
									else if (nivel2[4][i].pasoCoreo == 26)
										nivel2[4][i].moveCoreo(2, 1);
									else if (nivel2[4][i].pasoCoreo == 27)
										nivel2[4][i].moveCoreo(3, 1);
									else if (nivel2[4][i].pasoCoreo < 50)
										nivel2[4][i].moveCoreo(4, 3);
									else if (nivel2[4][i].pasoCoreo == 50)
										nivel2[4][i].moveCoreo(5, 1);
									else if (nivel2[4][i].pasoCoreo == 51)
										nivel2[4][i].moveCoreo(6, 1);
									else if (nivel2[4][i].pasoCoreo == 52)
										nivel2[4][i].moveCoreo(7, 1);
									else if (nivel2[4][i].pasoCoreo == 53)
										nivel2[4][i].moveCoreo(8, 3);
									else if (nivel2[4][i].pasoCoreo == 54)
										nivel2[4][i].moveCoreo(9, 1);
									else if (nivel2[4][i].pasoCoreo == 55)
										nivel2[4][i].moveCoreo(10, 1);
									else if (nivel2[4][i].pasoCoreo == 56)
										nivel2[4][i].moveCoreo(11, 1);
									else if (nivel2[4][i].pasoCoreo == 57)
										nivel2[4][i].moveCoreo(12, 3);
									else if (nivel2[4][i].pasoCoreo == 58)
										nivel2[4][i].moveCoreo(13, 1);
									else if (nivel2[4][i].pasoCoreo == 59)
										nivel2[4][i].moveCoreo(14, 1);
									else if (nivel2[4][i].pasoCoreo == 60)
										nivel2[4][i].moveCoreo(15, 1);
									else if (nivel2[4][i].pasoCoreo == 61)
										nivel2[4][i].moveCoreo(0, 3);
									else if (nivel2[4][i].pasoCoreo == 62)
										nivel2[4][i].moveCoreo(1, 1);
									else if (nivel2[4][i].pasoCoreo == 63)
										nivel2[4][i].moveCoreo(2, 1);
									else if (nivel2[4][i].pasoCoreo == 64)
										nivel2[4][i].moveCoreo(3, 1);
									else if (nivel2[4][i].pasoCoreo == 65)
										nivel2[4][i].moveCoreo(4, 3);
									else if (nivel2[4][i].pasoCoreo == 66)
										nivel2[4][i].moveCoreo(5, 1);
									else if (nivel2[4][i].pasoCoreo == 67)
										nivel2[4][i].moveCoreo(6, 1);
									else if (nivel2[4][i].pasoCoreo == 68)
										nivel2[4][i].moveCoreo(7, 1);
									else if (nivel2[4][i].pasoCoreo == 69)
										nivel2[4][i].moveCoreo(8, 1);
									else if (nivel2[4][i].pasoCoreo == 70)
										nivel2[4][i].moveCoreo(9, 1);
									else if (nivel2[4][i].pasoCoreo == 71)
										nivel2[4][i].moveCoreo(10, 1);
									else if (nivel2[4][i].pasoCoreo == 72)
										nivel2[4][i].moveCoreo(11, 1);
									else if (nivel2[4][i].pasoCoreo == 73)
										nivel2[4][i].moveCoreo(12, 1);
									else if (nivel2[4][i].pasoCoreo == 74)
										nivel2[4][i].moveCoreo(13, 1);
									else if (nivel2[4][i].pasoCoreo == 75)
										nivel2[4][i].moveCoreo(14, 1);
									else if (nivel2[4][i].pasoCoreo == 76)
										nivel2[4][i].moveCoreo(15, 1);
									else if (!nivel2[4][i].isInEnjambre) {
										nivel2[4][i].goTo(nivel2[4][i].getFinalX(), nivel2[4][i].getFinalY(), 1);
										if (nivel2[4][i].isGoToDone)
											nivel2[4][i].setSpriteImage(nivel2[4][i].spriteFileNameIdle0);

									}
								}
							}
							// Zakos fila 2 dcha
							for (int i = 3; i < 6; i++) {
								if (nivel2[4][i].coreoIn) {
									if (nivel2[4][i].pasoCoreo < 5)
										nivel2[4][i].moveCoreo(12, 1);
									else if (nivel2[4][i].pasoCoreo == 5)
										nivel2[4][i].moveCoreo(13, 1);
									else if (nivel2[4][i].pasoCoreo == 6)
										nivel2[4][i].moveCoreo(14, 1);
									else if (nivel2[4][i].pasoCoreo == 7)
										nivel2[4][i].moveCoreo(15, 1);
									else if (nivel2[4][i].pasoCoreo < 25)
										nivel2[4][i].moveCoreo(0, 3);
									else if (nivel2[4][i].pasoCoreo == 25)
										nivel2[4][i].moveCoreo(15, 1);
									else if (nivel2[4][i].pasoCoreo == 26)
										nivel2[4][i].moveCoreo(14, 1);
									else if (nivel2[4][i].pasoCoreo == 27)
										nivel2[4][i].moveCoreo(13, 1);
									else if (nivel2[4][i].pasoCoreo < 50)
										nivel2[4][i].moveCoreo(12, 3);
									else if (nivel2[4][i].pasoCoreo == 50)
										nivel2[4][i].moveCoreo(11, 1);
									else if (nivel2[4][i].pasoCoreo == 51)
										nivel2[4][i].moveCoreo(10, 1);
									else if (nivel2[4][i].pasoCoreo == 52)
										nivel2[4][i].moveCoreo(9, 1);
									else if (nivel2[4][i].pasoCoreo == 53)
										nivel2[4][i].moveCoreo(8, 3);
									else if (nivel2[4][i].pasoCoreo == 54)
										nivel2[4][i].moveCoreo(7, 1);
									else if (nivel2[4][i].pasoCoreo == 55)
										nivel2[4][i].moveCoreo(6, 1);
									else if (nivel2[4][i].pasoCoreo == 56)
										nivel2[4][i].moveCoreo(5, 1);
									else if (nivel2[4][i].pasoCoreo == 57)
										nivel2[4][i].moveCoreo(4, 3);
									else if (nivel2[4][i].pasoCoreo == 58)
										nivel2[4][i].moveCoreo(3, 1);
									else if (nivel2[4][i].pasoCoreo == 59)
										nivel2[4][i].moveCoreo(2, 1);
									else if (nivel2[4][i].pasoCoreo == 60)
										nivel2[4][i].moveCoreo(1, 1);
									else if (nivel2[4][i].pasoCoreo == 61)
										nivel2[4][i].moveCoreo(0, 3);
									else if (nivel2[4][i].pasoCoreo == 62)
										nivel2[4][i].moveCoreo(15, 1);
									else if (nivel2[4][i].pasoCoreo == 63)
										nivel2[4][i].moveCoreo(14, 1);
									else if (nivel2[4][i].pasoCoreo == 64)
										nivel2[4][i].moveCoreo(13, 1);
									else if (nivel2[4][i].pasoCoreo == 65)
										nivel2[4][i].moveCoreo(12, 3);
									else if (nivel2[4][i].pasoCoreo == 66)
										nivel2[4][i].moveCoreo(11, 1);
									else if (nivel2[4][i].pasoCoreo == 67)
										nivel2[4][i].moveCoreo(10, 1);
									else if (nivel2[4][i].pasoCoreo == 68)
										nivel2[4][i].moveCoreo(9, 1);
									else if (nivel2[4][i].pasoCoreo == 69)
										nivel2[4][i].moveCoreo(8, 1);
									else if (nivel2[4][i].pasoCoreo == 70)
										nivel2[4][i].moveCoreo(7, 1);
									else if (nivel2[4][i].pasoCoreo == 71)
										nivel2[4][i].moveCoreo(6, 1);
									else if (nivel2[4][i].pasoCoreo == 72)
										nivel2[4][i].moveCoreo(5, 1);
									else if (nivel2[4][i].pasoCoreo == 73)
										nivel2[4][i].moveCoreo(4, 1);
									else if (nivel2[4][i].pasoCoreo == 74)
										nivel2[4][i].moveCoreo(3, 1);
									else if (nivel2[4][i].pasoCoreo == 75)
										nivel2[4][i].moveCoreo(2, 1);
									else if (nivel2[4][i].pasoCoreo == 76)
										nivel2[4][i].moveCoreo(1, 1);
									else if (!nivel2[4][i].isInEnjambre) {
										nivel2[4][i].goTo(nivel2[4][i].getFinalX(), nivel2[4][i].getFinalY(), 1);
										if (nivel2[4][i].isGoToDone)
											nivel2[4][i].setSpriteImage(nivel2[4][i].spriteFileNameIdle0);
									}
								}
							}

							// Zakos fila 3 izqda
							for (int i = 0; i < 2; i++) {
								if (nivel2[5][i].coreoIn) {
									if (nivel2[5][i].pasoCoreo < 10)
										nivel2[5][i].moveCoreo(4, 3);
									else if (nivel2[5][i].pasoCoreo == 10)
										nivel2[5][i].moveCoreo(3, 2);
									else if (nivel2[5][i].pasoCoreo == 11)
										nivel2[5][i].moveCoreo(2, 2);
									else if (nivel2[5][i].pasoCoreo == 12)
										nivel2[5][i].moveCoreo(1, 2);
									else if (nivel2[5][i].pasoCoreo < 58)
										nivel2[5][i].moveCoreo(0, 3);
									else if (nivel2[5][i].pasoCoreo == 58)
										nivel2[5][i].moveCoreo(1, 1);
									else if (nivel2[5][i].pasoCoreo == 59)
										nivel2[5][i].moveCoreo(2, 1);
									else if (nivel2[5][i].pasoCoreo == 60)
										nivel2[5][i].moveCoreo(3, 1);
									else if (nivel2[5][i].pasoCoreo < 86)
										nivel2[5][i].moveCoreo(4, 4);
									else if (nivel2[5][i].pasoCoreo == 86)
										nivel2[5][i].moveCoreo(5, 1);
									else if (nivel2[5][i].pasoCoreo == 87)
										nivel2[5][i].moveCoreo(6, 1);
									else if (nivel2[5][i].pasoCoreo == 88)
										nivel2[5][i].moveCoreo(7, 1);
									else if (nivel2[5][i].pasoCoreo < 105)
										nivel2[5][i].moveCoreo(8, 3);
									else if (nivel2[5][i].pasoCoreo == 105)
										nivel2[5][i].moveCoreo(9, 1);
									else if (nivel2[5][i].pasoCoreo == 106)
										nivel2[5][i].moveCoreo(10, 1);
									else if (nivel2[5][i].pasoCoreo == 107)
										nivel2[5][i].moveCoreo(11, 1);
									else if (nivel2[5][i].pasoCoreo == 108)
										nivel2[5][i].moveCoreo(12, 1);

									else if (!nivel2[5][i].isInEnjambre) {
										nivel2[5][i].goTo(nivel2[5][i].getFinalX(), nivel2[5][i].getFinalY(), 1);
										if (nivel2[5][i].isGoToDone)
											nivel2[5][i].setSpriteImage(nivel2[5][i].spriteFileNameIdle0);
									}
								}
							}
							// Zakos fila 3 dcha
							for (int i = 2; i < 4; i++) {
								if (nivel2[5][i].coreoIn) {
									if (nivel2[5][i].pasoCoreo < 10)
										nivel2[5][i].moveCoreo(12, 3);
									else if (nivel2[5][i].pasoCoreo == 10)
										nivel2[5][i].moveCoreo(13, 2);
									else if (nivel2[5][i].pasoCoreo == 11)
										nivel2[5][i].moveCoreo(14, 2);
									else if (nivel2[5][i].pasoCoreo == 12)
										nivel2[5][i].moveCoreo(15, 2);
									else if (nivel2[5][i].pasoCoreo < 61)
										nivel2[5][i].moveCoreo(0, 3);
									else if (nivel2[5][i].pasoCoreo == 61)
										nivel2[5][i].moveCoreo(15, 1);
									else if (nivel2[5][i].pasoCoreo == 62)
										nivel2[5][i].moveCoreo(14, 2);
									else if (nivel2[5][i].pasoCoreo == 63)
										nivel2[5][i].moveCoreo(13, 1);
									else if (nivel2[5][i].pasoCoreo < 89)
										nivel2[5][i].moveCoreo(12, 4);
									else if (nivel2[5][i].pasoCoreo == 89)
										nivel2[5][i].moveCoreo(11, 1);
									else if (nivel2[5][i].pasoCoreo == 90)
										nivel2[5][i].moveCoreo(10, 1);
									else if (nivel2[5][i].pasoCoreo == 91)
										nivel2[5][i].moveCoreo(9, 1);
									else if (nivel2[5][i].pasoCoreo < 106)
										nivel2[5][i].moveCoreo(8, 4);
									else if (nivel2[5][i].pasoCoreo == 106)
										nivel2[5][i].moveCoreo(8, 3);
									else if (nivel2[5][i].pasoCoreo == 107)
										nivel2[5][i].moveCoreo(7, 1);
									else if (nivel2[5][i].pasoCoreo == 108)
										nivel2[5][i].moveCoreo(6, 1);
									else if (nivel2[5][i].pasoCoreo == 109)
										nivel2[5][i].moveCoreo(5, 1);
									else if (nivel2[5][i].pasoCoreo == 110)
										nivel2[5][i].moveCoreo(4, 1);

									else if (!nivel2[5][i].isInEnjambre) {
										nivel2[5][i].goTo(nivel2[5][i].getFinalX(), nivel2[5][i].getFinalY(), 1);
										if (nivel2[5][i].isGoToDone)
											nivel2[5][i].setSpriteImage(nivel2[5][i].spriteFileNameIdle0);
									}
								}
							}
							//////////////////////////
							/// COMPROBACION COREO ///
							//////////////////////////
							if (!CoreoCompletada) {
								CoreoCompletada = true;
								for (int i = 0; i < nivel2.length; i++) {
									for (int j = 0; j < nivel2[i].length; j++) {
										if (nivel2[i][j].getX() != nivel2[i][j].getFinalX()
												|| nivel2[i][j].getY() != nivel2[i][j].getFinalY()) {
											CoreoCompletada = false;
										}
									}
								}
								if (CoreoCompletada)
									for (int i = 0; i < nivel2.length; i++) {
										for (int j = 0; j < nivel2[i].length; j++) {
											nivel2[i][j].pasoCoreo = 0;
											nivel2[i][j].isGoToDone = false;
										}
									}
							}
						}
					}
					/// IS IN ENJAMBRE
					if (CoreoCompletada) {
						for (int i = 0; i < nivel2.length; i++) {
							for (int j = 0; j < nivel2[i].length; j++) {
								if (nivel2[i][j].getX() == nivel2[i][j].finalX && nivel2[i][j].y == nivel2[i][j].finalY)
									nivel2[i][j].isInEnjambre = true;
								else
									nivel2[i][j].isInEnjambre = false;
							}
						}
					}

					/////////////// ENJAMBRE
					if (frameLvl2 % Conf.SPEED == 0 && CoreoCompletada) {
						if (izq) {
							for (int i = 0; i < nivel2.length; i++) {
								for (int j = 0; j < nivel2[i].length; j++) {
									if (nivel2[i][j].isAlive()) {

										if (nivel2[i][j].getX() == nivel2[i][j].getFinalX()
												&& nivel2[i][j].getY() == nivel2[i][j].getFinalY()) {
											nivel2[i][j].setX((nivel2[i][j].getX() - 1));
										}
										nivel2[i][j].finalX--;
									}

								}
							}
							if (--tope == -15) {
								derecha = true;
								izq = false;
							}
						} else if (derecha) {
							for (int i = 0; i < nivel2.length; i++) {
								for (int j = 0; j < nivel2[i].length; j++) {
									if (nivel2[i][j].isAlive()) {

										if (nivel2[i][j].getX() == nivel2[i][j].getFinalX()
												&& nivel2[i][j].getY() == nivel2[i][j].getFinalY()) {
											nivel2[i][j].setX((nivel2[i][j].getX() + 1));
										}
										nivel2[i][j].finalX++;
									}

								}
							}
							if (++tope == 15) {
								derecha = false;
								izq = true;
							}

						}
					}

					//////////////////////////
					/// MUERTE DE ENEMIGOS ///
					//////////////////////////
					for (int i = 0; i < nivel2.length; i++) {
						for (int j = 0; j < nivel2[i].length; j++) {
							if (nivel2[i][j].isAlive()) {
								for (int h = 0; h < torpedos.length; h++) {
									if (torpedos[h].isAlive()) {
										if (torpedos[h].getX() <= nivel2[i][j].getX() + 5
												&& torpedos[h].getX() >= nivel2[i][j].getX() - 5
												&& torpedos[h].getY() <= nivel2[i][j].getY() + 8
												&& torpedos[h].getY() >= nivel2[i][j].getY() - 6) {
											torpedos[h].setAlive(false);
											gui.gb_setSpriteVisible(torpedos[h].getId(), false);
											if (!nivel2[i][j].hasExtraHP) {
												nivel2[i][j].setAlive(false);
												nivel2[i][j].setMuriendo(true);
											} else {
												((Commander) nivel2[i][j]).reduceHP();
											}
										}
									}
								}
							}
						}
					}
					for (int i = 0; i < nivel2.length; i++) {
						for (int j = 0; j < nivel2[i].length; j++) {
							if (nivel2[i][j].isMuriendo)
								nivel2[i][j].performDeath();
						}
					}
					if (CoreoCompletada)
						for (int i = 0; i < nivel2.length; i++) { // animacion idle
							for (int j = 0; j < nivel2[i].length; j++)
								nivel2[i][j].animacionIdle(frameLvl2);
						}

					////////////////
					/// TORPEDOS ///
					/// ENEMIGOS ///
					////////////////
					if (CoreoCompletada)
						for (int i = 0; i < nivel2.length; i++)
							for (int j = 0; j < nivel2[i].length; j++)
								if (nivel2[i][j].isAlive())
									if (Math.random() * 2000 > 1999) {
										gui.gb_setSpriteVisible(torpedosEnemigos[nextTorpedoEnemigo].getId(), true);
										torpedosEnemigos[nextTorpedoEnemigo].setX(nivel2[i][j].getX());
										torpedosEnemigos[nextTorpedoEnemigo].setY(nivel2[i][j].getY() + 3);
										torpedosEnemigos[nextTorpedoEnemigo].setAlive(true);
										do {
											if (nextTorpedoEnemigo != 100 - 1)
												nextTorpedoEnemigo++;
											else
												nextTorpedoEnemigo = 0;
										} while (torpedosEnemigos[nextTorpedoEnemigo].isAlive());
									}
					for (int i = 0; i < torpedosEnemigos.length; i++) {
						if (torpedosEnemigos[i].isAlive()) {
							torpedosEnemigos[i].setY(torpedosEnemigos[i].getY() + 2);
							if (torpedosEnemigos[i].getY() > 220) {
								torpedosEnemigos[i].setAlive(false);
								gui.gb_setSpriteVisible(torpedosEnemigos[i].getId(), false);
							}
						}
					}
					for (int i = 0; i < torpedosEnemigos.length; i++) {
						if (torpedosEnemigos[i].isAlive() && torpedosEnemigos[i].getX() <= jugador.getX() + 5
								&& torpedosEnemigos[i].getX() >= jugador.getX() - 5
								&& torpedosEnemigos[i].getY() <= jugador.getY() + 5
								&& torpedosEnemigos[i].getY() >= jugador.getY() - 7) {
							torpedosEnemigos[i].setAlive(false);
							gui.gb_setSpriteVisible(torpedosEnemigos[i].getId(), false);
							// jugador.reduceHP();
						}
					}
					////// MUERTE DEL JUGADOR
					for (int i = 0; i < nivel2.length; i++) {
						for (int j = 0; j < nivel2[i].length; j++) {
							if (nivel2[i][j].isAlive())
								if (nivel2[i][j].getX() >= jugador.getX() - 10
										&& nivel2[i][j].getY() >= jugador.getY() - 10
										&& nivel2[i][j].getX() <= jugador.getX() + 10
										&& nivel2[i][j].getY() <= jugador.getY() + 10) {
									// exit = true;
								}
						}
					}

					if (frameLvl2 % 3 == 0 && CoreoCompletada)
						for (int i = 0; i < nivel2.length; i++) {
							for (int j = 0; j < nivel2[i].length; j++) {
								if (nivel2[i][j].isAlive() && i > 1) {
									if (Math.random() * 1000 > 999 && nivel2[i][j].isInEnjambre
											&& !nivel2[i][j].isGankeando) {
										nivel2[i][j].isZigzagueando = true;
									}
									if (nivel2[i][j].isZigzagueando && !nivel2[i][j].isGankeando)
										nivel2[i][j].zigzag(true);
									if (nivel2[i][j].isGankeando && nivel2[i][j].isZigzagueando) {
										jugador.setFinalX(jugador.getX());
										jugador.setFinalY(jugador.getY());
										nivel2[i][j].isZigzagueando = false;
									} else if (!nivel2[i][j].isZigzagueando && nivel2[i][j].isGankeando) {
										nivel2[i][j].goTo(jugador.getFinalX(), jugador.getFinalY(), 1);
										if (nivel2[i][j].isGoToDone) {
											nivel2[i][j].setGankeando(false);
											nivel2[i][j].setZigzagueando(true);
										}
									}
								}
								// Para comandantes y sus goei
								else if (i == 0) {
									if (Math.random() * 100 > 99 && nivel2[0][j].isInEnjambre)
										nivel2[0][j].isZigzagueando = true;
									if (nivel2[0][j].isZigzagueando && nivel2[0][j].isAlive()
											&& !nivel2[1][((Commander) nivel2[0][j]).getIdAsociada1()].isZigzagueando
											&& !nivel2[1][((Commander) nivel2[0][j]).getIdAsociada2()].isZigzagueando) {
										((Goei) nivel2[1][((Commander) nivel2[0][j]).getIdAsociada1()])
												.setxRelativa(((Commander) nivel2[0][j]).getX() - 6);
										((Goei) nivel2[1][((Commander) nivel2[0][j]).getIdAsociada2()])
												.setxRelativa(((Commander) nivel2[0][j]).getX() + 6);
										((Goei) nivel2[1][((Commander) nivel2[0][j]).getIdAsociada1()])
												.setyRelativa(((Commander) nivel2[0][j]).getY() + 13);
										((Goei) nivel2[1][((Commander) nivel2[0][j]).getIdAsociada2()])
												.setyRelativa(((Commander) nivel2[0][j]).getY() + 13);
										nivel2[1][((Commander) nivel2[0][j]).getIdAsociada1()].isGoingToAttack = true;
										nivel2[1][((Commander) nivel2[0][j]).getIdAsociada2()].isGoingToAttack = true;
										nivel2[1][((Commander) nivel2[0][j]).getIdAsociada1()].goTo(
												((Goei) nivel2[1][((Commander) nivel2[0][j])
														.getIdAsociada1()]).xRelativa,
												((Goei) nivel2[1][((Commander) nivel2[0][j])
														.getIdAsociada1()]).yRelativa,
												1);
										nivel2[1][((Commander) nivel2[0][j]).getIdAsociada2()].goTo(
												((Goei) nivel2[1][((Commander) nivel2[0][j])
														.getIdAsociada2()]).xRelativa,
												((Goei) nivel2[1][((Commander) nivel2[0][j])
														.getIdAsociada2()]).yRelativa,
												1);
									}
									if (!nivel2[0][j].isAlive()) {
										nivel2[1][((Commander) nivel2[0][j]).getIdAsociada1()].zigzag(false);
										nivel2[1][((Commander) nivel2[0][j]).getIdAsociada2()].zigzag(false);
										if (nivel2[1][((Commander) nivel2[0][j]).getIdAsociada1()].getX() < 0) {
											nivel2[1][((Commander) nivel2[0][j]).getIdAsociada1()].setX(90);
											nivel2[1][((Commander) nivel2[0][j]).getIdAsociada1()].setY(-10);
										}
										if (nivel2[1][((Commander) nivel2[0][j]).getIdAsociada2()].getX() < 0) {
											nivel2[1][((Commander) nivel2[0][j]).getIdAsociada2()].setX(90);
											nivel2[1][((Commander) nivel2[0][j]).getIdAsociada2()].setY(-10);
										}
									}
									if (nivel2[1][((Commander) nivel2[0][j]).getIdAsociada1()].isZigzagueando
											&& nivel2[1][((Commander) nivel2[0][j]).getIdAsociada2()].isZigzagueando) {
										nivel2[1][((Commander) nivel2[0][j]).getIdAsociada1()].zigzag(false);
										nivel2[1][((Commander) nivel2[0][j]).getIdAsociada2()].zigzag(false);
										nivel2[0][j].zigzag(false);
									}
									if (nivel2[1][((Commander) nivel2[0][j]).getIdAsociada1()]
											.getX() == ((Goei) nivel2[1][((Commander) nivel2[0][j])
													.getIdAsociada1()]).xRelativa
											&& nivel2[1][((Commander) nivel2[0][j]).getIdAsociada1()]
													.getY() == ((Goei) nivel2[1][((Commander) nivel2[0][j])
															.getIdAsociada1()]).yRelativa
											&& nivel2[1][((Commander) nivel2[0][j]).getIdAsociada2()]
													.getX() == ((Goei) nivel2[1][((Commander) nivel2[0][j])
															.getIdAsociada2()]).xRelativa
											&& nivel2[1][((Commander) nivel2[0][j]).getIdAsociada2()]
													.getY() == ((Goei) nivel2[1][((Commander) nivel2[0][j])
															.getIdAsociada2()]).yRelativa) {
										nivel2[1][((Commander) nivel2[0][j]).getIdAsociada1()].isZigzagueando = true;
										nivel2[1][((Commander) nivel2[0][j]).getIdAsociada2()].isZigzagueando = true;
									}
									if (nivel2[0][j].getY() > 220) {
										nivel2[0][j].zigzag(false);
									}
								}
							}
						}
					if (CoreoCompletada && frameLvl2 % 3 == 0)
						for (int i = 0; i < nivel2.length; i++) {
							for (int j = 0; j < nivel2[i].length; j++) {
								if (nivel2[i][j].isAlive() && nivel2[i][j].expedicionCompletada
										&& nivel2[i][j].isInEnjambre == false && !nivel2[i][j].isGoingToAttack) {
									nivel2[i][j].goTo(nivel2[i][j].finalX, nivel2[i][j].finalY, 1);
									nivel2[i][j].animacionIdle(frameLvl2);

								}
							}
						}

				}

				// gui.setSize(510, 710);
				if (inLvl1)
					gui.gb_setValuePointsUp((int) frameLvl1);
				if (inLvl2)
					gui.gb_setValuePointsUp((int) frameLvl2);

				Thread.sleep(1000 / 60);
			}
			Thread.sleep(1000 / 60);

		}
		gui.gb_setSpriteImage(0, "explosion11.png");
		Thread.sleep(1000 / 60 * 15);
		gui.gb_setSpriteImage(0, "explosion12.png");
		Thread.sleep(1000 / 60 * 5);
		gui.gb_setSpriteImage(0, "explosion13.png");
		Thread.sleep(1000 / 60 * 5);
		gui.gb_setSpriteImage(0, "explosion14.png");
		Thread.sleep(1000 / 60 * 5);
		gui.gb_setSpriteImage(0, "empty.png");

	}

	public static int getScore() {
		return score;
	}

	public static void addScore(int points) {
		score = score + points;
	}

}
