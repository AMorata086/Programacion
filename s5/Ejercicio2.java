import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		int a, b;
		int result;
		
		System.out.println("Ingrese el valor de un numero \"a\"");
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		System.out.println("Ingrese el valor de un segundo numero \"b\"");
		b = sc.nextInt();
		
		if(b != 0) {
			result = a/b;
			System.out.println("El resultado de " + a + " entre " + b + " es " + result);
		} else if(b==0) {
			System.out.println("No se puede dividir por cero usando enteros");
		}
		
		sc.close();

	}

}
