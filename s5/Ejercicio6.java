import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		String entrada;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese el valor de un numero o letra (un solo digito)");
		entrada = sc.next();
		sc.close();
		
		switch(entrada.toLowerCase()) {
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
		case "0":
			System.out.println("La entrada es un numero");
			break;
		default:
			System.out.println("La entrada es una letra");
			break;
		}
	}

}
