
/**
 * @author Alvaro Morata Hontanaya, Cesar Martinez Lara
 * @since 22 octubre 2018
 * @version 1.0
 */
import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		int[][] matriz1, matriz2;
		int filas, columnas;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el numero de filas de la matriz 1:");
		filas = sc.nextInt();
		System.out.println("Introduce el numero de columnas de la matriz 1:");
		columnas = sc.nextInt();
		matriz1 = new int[filas][columnas];
		for (int i = 0; i < matriz1.length; i++) {
			for (int j = 0; j < matriz1[i].length; j++) {
				System.out.println("Introduzca el valor de la posicion (" + i + ", " + j + ")");
				matriz1[i][j] = sc.nextInt();
			}
		}
		System.out.println("La primera matriz es la siguiente:");
		for (int i = 0; i < matriz1.length; i++) {
			for (int j = 0; j < matriz1[i].length; j++) {
				System.out.print(matriz1[i][j] + " ");
			}
			System.out.print("\n");
		}

		System.out.println("Introduce el numero de filas de la matriz 2:");
		filas = sc.nextInt();
		System.out.println("Introduce el numero de columnas de la matriz 2:");
		columnas = sc.nextInt();
		matriz2 = new int[filas][columnas];
		for (int i = 0; i < matriz2.length; i++) {
			for (int j = 0; j < matriz2[i].length; j++) {
				System.out.println("Introduzca el valor de la posicion (" + i + ", " + j + ")");
				matriz2[i][j] = sc.nextInt();
			}
		}
		System.out.println("La segunda matriz es la siguiente:");
		for (int i = 0; i < matriz2.length; i++) {
			for (int j = 0; j < matriz2[i].length; j++) {
				System.out.print(matriz2[i][j] + " ");
			}
			System.out.print("\n");
		}
		sc.close();

		for (int i = 0; i < matriz1.length; i++) {
			for (int j = 0; j < matriz1[i].length; j++) {
				for (int k = 0; k < matriz2.length; k++) {
					for (int l = 0; l < matriz2[k].length; l++) {
						if (matriz2[k][l] == matriz1[i][j]) {
							System.out.println("El elemento " + matriz1[i][j] + " está en ambas matrices");
						}
					}
				}
			}
		}
	}
}
