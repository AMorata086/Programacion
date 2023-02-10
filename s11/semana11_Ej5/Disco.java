package semana11_Ej5;

import java.util.Scanner;

public class Disco {
	private String titulo;
	private int lanzamiento;
	private Cancion[] canciones;
	private double precio;
	private Grupo grupo;
	private String cancionesToString = "";

	public Disco(String titulo, int lanzamiento, int numCanciones, double precio) {
		this.titulo = titulo;
		this.lanzamiento = lanzamiento;
		if (precio >= 0)
			this.precio = precio;
		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);
		sc1.useDelimiter(System.getProperty("line.separator"));
		System.out.println("Introduce el nombre del grupo, su fecha de creacion y el numero de miembros en lineas separadas");
		grupo = new Grupo(sc1.next(),sc1.nextInt(),sc1.nextInt());
		canciones = new Cancion[numCanciones];
		for (int i = 0; i < numCanciones; i++) {
			System.out.println("Introduce el titulo de la cancion y en otra linea la duracion min:seg");
			canciones[i] = new Cancion(sc1.next(),sc1.nextInt());
			cancionesToString = cancionesToString + (i+1) + "." + canciones[i] + "\n";
		}
	}
	
	public String toString() {
		return "Disco: " + titulo + " (" + lanzamiento + ") " + precio + "€" +
				"\nPor: " + grupo.getNombre() + " (" + grupo.getFundacion() + ") " +
				grupo.getMiembros() + "\n" +
				"Canciones:\n" + 
				cancionesToString;
				
				
				
	}
}
