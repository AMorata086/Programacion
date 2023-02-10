/**
 * @author Alvaro Morata Hontanaya & Cesar Martinez Lara
 * @since 2018/10/13
 * @version 1.0
 */

public class Ejercicio9 {

	public static void main(String[] args) {
		int i;
		int pares = 0, impares = 0;
		int numero;

		for (i = 0; i < 50; i++) {
			numero = (int) (Math.random() * 100);
			pares = numero % 2 == 0 ? ++pares : pares;
			impares = numero % 2 == 0 ? impares : ++impares;
		}
		System.out.println("Numeros pares: " + pares);
		System.out.println("Numeros impares: " + impares);
	}

}
