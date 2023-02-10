/**
 * @author Alvaro Morata Hontanaya & Cesar Martinez Lara
 * @since 2018/10/13
 * @version 1.0
 */
public class Ejercicio6 {

	public static void main(String[] args) {
		int player1, player2, player3;
		int score1 = 0, score2 = 0, score3 = 0;
		int i;
		String cara = "CARA", cruz = "CRUZ";

		for (i = 1; i < 11; i++) {
			System.out.println("Resultados de la tirada " + i);
			player1 = (int) (Math.random() * 2);
			player2 = (int) (Math.random() * 2);
			player3 = (int) (Math.random() * 2);
			if (player1 == 1) {
				System.out.println("El jugador 1 ha sacado " + cara);
			} else if (player1 == 0) {
				System.out.println("El jugador 1 ha sacado " + cruz);
			}
			if (player2 == 1) {
				System.out.println("El jugador 2 ha sacado " + cara);
			} else if (player2 == 0) {
				System.out.println("El jugador 2 ha sacado " + cruz);
			}
			if (player3 == 1) {
				System.out.println("El jugador 3 ha sacado " + cara);
			} else if (player3 == 0) {
				System.out.println("El jugador 3 ha sacado " + cruz);
			}
			
			if(player1 == 0 && player2 == 0 && player3 == 0) {
				System.out.println("Ha habido empate en la tirada " + i + "\n\n");
			}else if(player1 == 0 && player2 == 0 && player3 == 1) {
				System.out.println("El ganador de la tirada " + i + " es el jugador 3\n\n");
				score3++;
			}else if(player1 == 0 && player2 == 1 && player3 == 0) {
				System.out.println("El ganador de la tirada " + i + " es el jugador 2\n\n");
				score2++;
			}else if(player1 == 0 && player2 == 1 && player3 == 1) {
				System.out.println("El ganador de la tirada " + i + " es el jugador 1\n\n");
				score1++;
			}else if(player1 == 1 && player2 == 0 && player3 == 0) {
				System.out.println("El ganador de la tirada " + i + " es el jugador 1\n\n");
				score1++;
			}else if(player1 == 1 && player2 == 0 && player3 == 1) {
				System.out.println("El ganador de la tirada " + i + " es el jugador 2\n\n");
				score2++;
			}else if(player1 == 1 && player2 == 1 && player3 == 0) {
				System.out.println("El ganador de la tirada " + i + " es el jugador 3\n\n");
				score3++;
			}else if(player1 == 1 && player2 == 1 && player3 == 1) {
				System.out.println("Ha habido empate en la tirada " + i + "\n\n");
			}
			
			System.out.println("EL RESULTADO HASTA EL MOMENTO ES:");
			System.out.println("Jugador 1 ---------> " + score1 + " puntos");
			System.out.println("Jugador 2 ---------> " + score2 + " puntos");
			System.out.println("Jugador 3 ---------> " + score3 + " puntos\n\n");
		}
		
		if(score1 > score2 && score1 > score3) {
			System.out.println("El ganador final es el jugador 1");
		}else if(score2 > score1 && score2 > score3) {
			System.out.println("El ganador final es el jugador 2");
		}else if(score3 > score1 && score3 > score2) {
			System.out.println("El ganador final es el jugador 2");
		}else if(score1 == score2 && score1 > score3) {
			System.out.println("Ha habido empate al final entre el jugador 1 y el jugador 2");
		}else if(score1 == score3 && score1 > score2) {
			System.out.println("Ha habido empate al final entre el jugador 1 y el jugador 3");
		}else if(score2 == score3 && score1 < score2) {
			System.out.println("Ha habido empate al final entre el jugador 2 y el jugador 3");
		}else if(score1 == score2 && score2 == 3) {
			System.out.println("Ha habido empate al final entre el jugador 1, el jugador 2 y el jugador 3");
		}
	}
}
