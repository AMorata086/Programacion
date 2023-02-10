/**
 * @author Alvaro Morata Hontanaya, Cesar Martinez Lara
 * @since 22 octubre 2018
 * @version 1.0
 */

public class Ejercicio1 {

	public static void main(String[] args) {

		int[] array = { 0, 11, 26, 98, 2, 51, 45 };

		array[0] = array[5];

		System.out.println(array[0]);
		System.out.println(array[5] + "\n");

		array[5] = 856;

		System.out.println(array[0]);
		System.out.println(array[5] + "\n");

		// Cambia el primero si se cambia el segundo elemento del array?
		/*
		 * No, porque el codigo es lineal y la asignacion se realiza antes de cambiar el
		 * valor al segundo elemento
		 */

		// Y si se cambia el valor del primer elemento del array?

		array[0] = 625;

		System.out.println(array[0]);
		System.out.println(array[5]);

		/*
		 * Como se puede observar: no, no cambia el valor del segundo si se cambia el
		 * primero por la misma razon de antes: no se asigna el valor del primero al
		 * segundo en ningun momento despues de la asignacion del primero
		 */
	}

}
