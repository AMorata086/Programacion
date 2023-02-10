
/**
 * @author Alvaro Morata Hontanaya, Cesar Martinez Lara
 * @since 22 octubre 2018
 * @version 1.0
 */
import java.util.Random;

public class Ejercicio4 {

	public static void main(String[] args) {

		// Apartado a)
		String[] quinielaJornada = new String[15];
		Random aleatorio = new Random();
		int result;

		for (int i = 0; i < quinielaJornada.length; i++) {
			result = (aleatorio.nextInt(3) + 1);
			if (result == 1) {
				quinielaJornada[i] = "1";
			} else if (result == 2) {
				quinielaJornada[i] = "2";
			} else if (result == 3) {
				quinielaJornada[i] = "X";
			}
			System.out.println("El elemento " + (i + 1) + " de la jornada es " + quinielaJornada[i]);
		}

		// Apartado b)
		String[][] quiniela = new String[38][15];

		for (int j = 0; j < quiniela.length; j++) {
			System.out.println("Los resultados de la jornada " + (j + 1) + " son los siguientes:");
			for (int i = 0; i < quiniela[j].length; i++) {
				result = (aleatorio.nextInt(3) + 1);
				if (result == 1) {
					quiniela[j][i] = "1";
				} else if (result == 2) {
					quiniela[j][i] = "2";
				} else if (result == 3) {
					quiniela[j][i] = "X";
				}
				System.out.print(quiniela[j][i] + " ");
			}
			System.out.println("\n");
		}
	}
}
