package semana11_Ej3;

import java.util.Scanner;

public class Estudiante {

	private String nombre;
	private String apellido;
	private double[] notas;
	
	public Estudiante() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre, el apellido");
		setNombre(sc.nextLine());
		setApellido(sc.nextLine());
		System.out.println("Cuantas notas vas a introducir?");
		int numNotas = sc.nextByte();
		notas = new double[numNotas];
		System.out.println("Intoduce las notas");
		for (int i = 0; i < numNotas; i++) {
			notas[i] = sc.nextDouble();
		}
		sc.close();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setNotas(double[] notas) {
		this.notas = notas;
	}
	public double[] getNotas() {
		return notas;
	}
	public void printEstudiante() {
		System.out.println(nombre);
		System.out.println(apellido);
		System.out.println("Notas:");
		for (int i = 0; i < notas.length; i++) {
			System.out.println(notas[i]);
		}
	}
}
