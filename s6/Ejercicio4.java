
/**
 * @author Alvaro Morata Hontanaya & Cesar Martinez Lara
 * @since 2018/10/13
 * @version 1.0
 */
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		int random = (int) (Math.random() * 100);
		Scanner sc = new Scanner(System.in);
		int attempts = 0, entry = 0;

		System.out.println("Intente adivinar el numero que esta entre el 1 y el 100");
		while (entry != random) {
			entry = sc.nextInt();
			attempts++;
			if (entry > random) {
				System.out.println("El numero ingresado es mayor que el numero a adivinar");
			} else if (entry < random) {
				System.out.println("El numero ingresado es menor que el numero a adivinar");
			}
		}
		sc.close();
		System.out.println("Felicidades!\nEl numero a adivinar era el " + random);
		System.out.println("Tu numero de intentos ha sido " + attempts);
	}

}
