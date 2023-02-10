
/**
 * @author Alvaro Morata Hontanaya, Cesar Martinez Lara
 * @since 22 octubre 2018
 * @version 1.0
 */
import java.util.Scanner;
import java.util.Random;

public class Ejercicio6 {

	public static void main(String[] args) {
		int[] array = new int[20];
		int input;
		Scanner sc = new Scanner(System.in);
		Random generator = new Random();
		boolean appears = false;

		for (int i = 0; i < array.length; i++) {
			array[i] = generator.nextInt(9) + 1;
		}

		System.out.println("Ingrese un numero del 1 al 9");
		input = sc.nextInt();
		sc.close();

		for (int i = 0; i < array.length; i++) {
			if (array[i] == input) {
				System.out.println("El numero " + input + " esta en la posicion " + i);
				appears = true;
			}
		}
		if (!appears)
			System.out.println("El numero " + input + " no esta en el array");
	}

}
