import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		int x, y;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese el valor de la coordenada \"x\"");
		x = sc.nextInt();
		System.out.println("Ingrese el valor de la coordenada \"y\"");
		y = sc.nextInt();
		sc.close();
		
		if(x > 0 && y > 0) {
			System.out.println("El punto (" + x + "," + y + ") esta en el 1er cuadrante");
		}else if(x < 0 && y > 0) {
			System.out.println("El punto (" + x + "," + y + ") esta en el 2º cuadrante");
		}else if(x < 0 && y < 0) {
			System.out.println("El punto (" + x + "," + y + ") esta en el 3er cuadrante");
		}else if(x > 0 && y < 0) {
			System.out.println("El punto (" + x + "," + y + ") esta en el 4º cuadrante");
		}else if(x == 0) {
			System.out.println("El punto (" + x + "," + y + ") esta sobre el eje \"y\"");
		}else if(y == 0) {
			System.out.println("El punto (" + x + "," + y + ") esta sobre el eje \"x\"");
		}else if(x == 0 && y == 0) {
			System.out.println("El punto (" + x + "," + y + ") esta en la interseccion de los ejes \"x\" e \"y\"");
		}
	}

}
