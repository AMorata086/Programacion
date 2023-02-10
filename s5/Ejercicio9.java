import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		
		int year;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese el valor de un anio:");
		year = sc.nextInt();
		sc.close();
		
		if(year % 4 == 0) {
			if(year % 100 == 0) {
				if(year % 400 == 0) {
					System.out.println("El año " + year + " es bisiesto");
				} else {
					System.out.println("El año " + year + " no es bisiesto");
				}
			} else {
				System.out.println("El año " + year + " es bisiesto");
			}
		} else {
			System.out.println("El año " + year + " no es bisiesto");
		}
	}

}
