import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		int edad;
		double precio = 9;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Edad del cliente?");
		edad = sc.nextInt();
		sc.close();
		
		if(edad < 5) {
			precio *= 0.40;
			System.out.println("El precio de la entrada es " + precio + " euros");
		} else if(edad < 26) {
			precio *= 0.80;
			System.out.println("El precio de la entrada es " + precio + " euros");
		} else if(edad > 65){
			precio *= 0.60;
			System.out.println("El precio de la entrada es " + precio + " euros");
		} else {
			System.out.println("El precio de la entrada es " + precio + " euros");
		}
	}

}
