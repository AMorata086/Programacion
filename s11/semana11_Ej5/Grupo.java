package semana11_Ej5;

import java.util.Scanner;

public class Grupo {

	private String nombre = "grupo sin nombre";
	private int birth = 2018;
	private Persona[] miembros;
	private String miembrostoString = "";
	
	public Grupo(String nombre, int birth, int numMiembros) {
		this.nombre = nombre;
		this.birth = birth;
		@SuppressWarnings("resource")
		Scanner sc2 = new Scanner(System.in);
		sc2.useDelimiter(System.getProperty("line.separator"));
		miembros = new Persona[numMiembros];
		for (int i = 0; i < numMiembros; i++) {
			System.out.println("Introduce el nombre y la fecha de nacimiento (en diferentes lineas) del miembro " + (i+1));
			miembros[i] = new Persona(sc2.next(),sc2.nextInt());
			miembrostoString = miembrostoString + "\n" + miembros[i];
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getFundacion() {
		return birth;
	}
	public String getMiembros() {
			return miembrostoString;
		
	}
}
