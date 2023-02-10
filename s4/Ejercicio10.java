import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x, y;
		System.out.println("Valor de los grados celsius a convertir en Fahrenheit");
		Scanner sc = new Scanner(System.in);
		x = sc.nextDouble();
		y = (9 * x) / 5 + 32;
		System.out.println(x + "ºC son igual a " + y + "ºF");
	}

}
