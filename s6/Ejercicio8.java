
/**
 * @author Alvaro Morata Hontanaya & Cesar Martinez Lara
 * @since 2018/10/13
 * @version 1.0
 */

import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		int n, i, j;
		Scanner sc = new Scanner(System.in);

		System.out.println("Cuadrado latino a mostrar por pantalla: ");
		n = sc.nextInt();
		sc.close();

		for (i = 1; i <= n; i++) {
			for (j = 1; j <= n; j++) {
				if (j + 1 - i <= 0) {
					System.out.print(Math.abs(j-i+n+1) + "  ");
				} else if (j + 1 - i > 0) {
					System.out.print(Math.abs(j + 1 - i) + "  ");
				}

			}
			System.out.print("\n");
		}

	}

}
