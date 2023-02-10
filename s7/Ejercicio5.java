
/**
 * @author Alvaro Morata Hontanaya, Cesar Martinez Lara
 * @since 22 octubre 2018
 * @version 1.0
 */
import java.util.Scanner;
import java.util.Random;

public class Ejercicio5 {

	public static void main(String[] args) {
		double[] array;
		Scanner sc = new Scanner(System.in);
		int result = 0;
		Random number = new Random();

		System.out.println("Introduzca la longitud del array de double: ");
		array = new double[sc.nextInt()];
		sc.close();

		for (int i = 0; i < array.length; i++) {
			array[i] = number.nextDouble() + number.nextInt(48) + 1;
			result += array[i];
		}

		System.out.println("La suma de todos los elementos es " + result);
	}

}
