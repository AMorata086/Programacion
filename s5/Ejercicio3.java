import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		int edad1, edad2;
		String nombre1, nombre2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese el nombre del primer usuario: ");
		nombre1 = sc.next();
		System.out.println("Ingrese la edad de " +nombre1+ ":");
		edad1 = sc.nextInt();
		System.out.println("Ingrese el nombre del segundo usuario: ");
		nombre2 = sc.next();
		System.out.println("Ingrese la edad de "+nombre2+ ":");
		edad2 = sc.nextInt();
		sc.close();
		
		if(edad1 == edad2) {
			System.out.println(nombre1+" y "+nombre2+" tienen la misma edad.");
		} else if(edad1 > edad2) {
			System.out.println(nombre1+" es mayor que "+nombre2+".");
		} else if(edad1 < edad2) {
			System.out.println(nombre2+" es mayor que "+nombre1+".");
			
		}

	}

}
