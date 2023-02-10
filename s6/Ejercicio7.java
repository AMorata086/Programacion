
/**
 * @author Alvaro Morata Hontanaya & Cesar Martinez Lara
 * @since 2018/10/13
 * @version 1.0
 */
import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		int result;
		int luckyN = 0;
		int year, month, day;
		Scanner sc = new Scanner(System.in);

		System.out.println("Ingrese el anio de su nacimiento");
		year = sc.nextInt();
		System.out.println("Ingrese el mes de su nacimiento");
		month = sc.nextInt();
		System.out.println("Ingrese el dia de su nacimiento");
		day = sc.nextInt();
		sc.close();

		result = year + month + day;
		
		while (result > 1) {
			luckyN = luckyN + (result % 10);
			result -= (result % 10);
			result /= 10;
		}
		System.out.println(luckyN);
	}

}
