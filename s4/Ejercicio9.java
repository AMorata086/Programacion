import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int entero;
		double real;
		float result;
		Scanner sc = new Scanner(System.in);
		System.out.println("De el valor de un entero:");
		entero = sc.nextInt();
		System.out.println("De un valor de un numero real (utilicese comas para insertar el valor decimal):");
		real = sc.nextDouble();
		result = (float) (entero + real);
		System.out.println("El resultado es " + result);
	}
}
