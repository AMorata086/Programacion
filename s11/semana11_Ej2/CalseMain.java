package semana11_Ej2;

import java.util.Scanner;

public class CalseMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("nombre apellido notas");
		Estudiante stemen = new Estudiante(sc.nextLine(),sc.nextLine(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
		sc.close();
		System.out.println(stemen);
	}

}
