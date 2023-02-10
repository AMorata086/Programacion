/**
 * @author Alvaro Morata Hontanaya & Cesar Martinez Lara
 * @since 2018/10/13
 * @version 1.0
 */
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		int nEntry, nMultiples, i;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese el valor de un numero: ");
		nEntry = sc.nextInt();
		System.out.println("Ingrese la cantidad de multiplos que quiere saber del numero anterior");
		nMultiples = sc.nextInt();
		sc.close();
		
		for(i = 1; i <= nMultiples; i++) {
			System.out.println(nEntry * i);
		}

	}

}
