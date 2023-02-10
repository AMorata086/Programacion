import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		double sueldo;
		int antiguedad;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese el sueldo actual:");
		sueldo = sc.nextDouble();
		System.out.println("Ingrese su antiguedad:");
		antiguedad = sc.nextInt();
		sc.close();
		
		if(sueldo < 500 && antiguedad >= 10) {
			System.out.println("Su sueldo recibe un aumento del 20%, siendo el total: " + sueldo*1.20 + "€");
		}else if(sueldo < 500 && antiguedad < 10) {
			System.out.println("Su sueldo recibe un aumento del 5%, siendo el total: " + sueldo*1.05 + "€");
		}else if(sueldo >= 500) {
			System.out.println("Su sueldo no recibe ningun aumento, permaneciendo igual: " + sueldo + "€");
		}
	}
}
