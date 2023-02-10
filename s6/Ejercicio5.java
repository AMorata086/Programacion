
/**
 * @author Alvaro Morata Hontanaya & Cesar Martinez Lara
 * @since 2018/10/13
 * @version 1.0
 */
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		int entry, n = 1, d;
		int result;
		Scanner sc = new Scanner(System.in);

		System.out.println("Indica el limite superior para generar numeros perfectos y pulsa Enter: ");
		entry = sc.nextInt();
		sc.close();

		while (n <= entry) {
			result = 0;
			if (n % 2 == 0) {
				d = n / 2;
			} else {
				d = n - 1;
				d /= 2;
			}
			while (d > 0) {
				if (n % d == 0)
					result += d;
				d--;
			}
			if (n == result)
				System.out.println(n);
			n++;
		}

	}

}
