
/**
 * @author Alvaro Morata Hontanaya, Cesar Martinez Lara
 * @since 22 octubre 2018
 * @version 1.0
 */
import java.util.Scanner;
import java.util.Random;

public class Ejercicio9 {

	public static void main(String[] args) {
		int[] tried = new int[100];
		int attempts = 0;
		int number = 0;
		int reachs100 = 0;
		boolean isCorrect = false;
		Scanner sc = new Scanner(System.in);
		Random aleatory = new Random();

		System.out.println("Piensa un número del 1 al 100 e intentaré adivinarlo.");

		while (!isCorrect) {
			reachs100 = 0;
			for (int i = 0; i < tried.length; i++) {
				if (tried[i] != 0)
					reachs100++;
			}
			number = aleatory.nextInt(100) + 1;
			System.out.println("Es el número que tienes pensado el " + number + "? (true/false)");
			isCorrect = sc.nextBoolean();
			tried[number + 1] = number;
			attempts++;
			if (reachs100 >= 100) {
				System.out.println("Mentira! Ya he probado todos los numeros!");
				isCorrect = true;
			}

		}
		sc.close();
		if(reachs100 < 100 && isCorrect)
			System.out.println("Lo adiviné! El número era el: " + number);
		System.out.println("El numero de intentos ha sido " + attempts);
	}
}
