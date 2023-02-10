package semana9_Ej5;

import java.util.Scanner;

public class Asignatura {

	private String nombre;
	private String cuatrimestre;

	public Asignatura(String nombre, String cuatrimestre) {
		this.nombre = nombre;
		this.cuatrimestre = cuatrimestre;
		Scanner sc = new Scanner(System.in);
		System.out.println("numero de clases mensuales?");
		Fecha[] sesiones = new Fecha[sc.nextInt()];
		for (int i = 0; i < sesiones.length; i++) {
			System.out.println("Introduce los dias con clase de la forma (dia mes anyo)");
			sesiones[i] = new Fecha(sc.nextInt(), sc.next(), sc.nextInt());
		}
		sc.close();
		System.out.println("Asignatura: " + this.nombre + "\nCuatrimestre: " + this.cuatrimestre + "\nDias con clase:");
		for (int i = 0; i < sesiones.length; i++)
			System.out.println(sesiones[i]);
	}


	

}
