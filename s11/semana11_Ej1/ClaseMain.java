package semana11_Ej1;

import java.util.Scanner;

class ClaseMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		System.out.println("introduce los datos nombre apellido edad posicion equipo");
		JugadorFutbol yugaor = new JugadorFutbol(sc.nextLine(),sc.nextLine(),sc.nextInt(),sc.nextLine(),sc.nextLine());
		System.out.println(yugaor);
		sc.close();
	}

}
