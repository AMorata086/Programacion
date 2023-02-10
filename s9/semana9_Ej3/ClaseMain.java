package semana9_Ej3;

import java.util.Scanner;

public class ClaseMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		Estudiante[] student = new Estudiante[1];
		System.out.println("Escribe el nombre, el apellido, y las notas en algebra, calculo, programacion, fisica, escritura e informacion");
		student[0] = new Estudiante(sc.next(),sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
		sc.close();
		System.out.println(student[0]);
	}

}
