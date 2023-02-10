import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		//Declaracion de variables
		double a, b;
		System.out.println("De el valor de un numero \"a\"");
		Scanner sc = new Scanner(System.in);
		a = sc.nextDouble();
		System.out.println("De el valor de una segunda variable \"b\"");
		b = sc.nextDouble();
		
		if(a == b) {
			System.out.println("Los numeros a y b son iguales");
		} else if(a > b) {
			System.out.println("El numero a es mayor que el numero b");
		} else if(a < b) {
			System.out.println("El numero b es mayor que el numero a");
		}
		sc.close();
		
		
		

	}

}
