/**
 * @author Alvaro Morata Hontanaya, Cesar Martinez Lara
 * @since 22 octubre 2018
 * @version 1.0
 */

public class Ejercicio2 {

	public static void main(String[] args) {

		int[] array1 = { 56, 52, 2, 369, 2, 4, 8, 6, 5, 4 };
		int[] array2;

		array2 = array1;

		System.out.println("El segundo array tiene los siguientes elementos:");
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array2[i] + " ");
		}

		// Cambia el correspondiente elemento del segundo array si se cambia el valor de
		// un determinado elemento del primero?
		array1[4] = 998;

		System.out.println("\nEl segundo array tiene los siguientes elementos:");
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array2[i] + " ");
		}
		/*
		 * Si cambia, porque lo que se esta haciendo al hacer la asignacion
		 * "array2 = array1" es asginar la direccion de memoria (o puntero) del array1
		 * al array2
		 */

		// Y si cambiamos un elemento del segundo cambia el primero?
		array2[7] = 0;
		System.out.println("\n" + array1[7]);
		/*
		 * Como podemos ver al cambiar un elemento del segundo tambien cambia el del
		 * primero porque tienen la misma direccion de memoria
		 */

		// Hay alguna diferencia si copia los arrays con la sentencia
		// "System.arraycopy()"?
		int[] array3 = { 98, 45, 8456, 84, 5254, 21, 58, 63 };
		int[] array4 = new int[8];
		System.arraycopy(array3, 0, array4, 0, 8);
		System.out.println("El segundo array tiene los siguientes elementos:");
		for (int i = 0; i < array3.length; i++) {
			System.out.print(array4[i] + " ");
		}
		/*
		 * Como se puede observar en el codigo anterior,con la sentencia
		 * "System.arraycopy()" no pasa lo mismo de antes, pues aqui no se esta
		 * asignando la posicion de memoria del primer array al segundo, si no que se
		 * esta copianto elemento a elemento el array3 al array4. Otra diferencia es que
		 * para poder usar esta sentencia hay que inicializar el array4, mientras que
		 * con el otro metodo no hacia falta pues ya se habia declarado el tamaño del
		 * primer array.
		 */
		/*
		 * Lo siguiente son demostraciones como las anteriores, pero esta vez no
		 * "copiandose" los elementos automaticamente
		 */
		array3[2] = 2;
		System.out.println("\n" + array4[2]);

		array4[4] = 25;
		System.out.println(array3[4]);
	}

}
