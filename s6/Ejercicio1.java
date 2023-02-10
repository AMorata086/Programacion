
/**
 * @author Alvaro Morata Hontanaya & Cesar Martinez Lara
 * @since 2018/10/13
 * @version 1.0
 */
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		int repeats = 0;
		double result = 0, entry;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Ingrese el valor de un numero. Para que el programa termine, ingrese \"0\"");
			entry = sc.nextDouble();
			result = result + entry;
			repeats++;
		} while (entry != 0);
		sc.close();
		System.out.println("La suma de los valores ingresados es: " + result);
		if (repeats == 1) {
			System.out.println("La media de los valores ingresados es: " + result / repeats);
		} else {
			System.out.println("La media de los valores ingresados es: " + result / (repeats - 1));
		}
	}

}
