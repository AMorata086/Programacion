package semana11_Ej4;

import java.util.Scanner;

public class Avion {

	private Isla origen;
	private Isla destino;
	private String estado;
	private int numAsientos;
	private Pasajero[] asientos;
	private int numeroDeVuelo;
	private String company;
	private String pasajeros = "";

	public Avion(int numeroDeVuelo, Isla origen, Isla destino, String company, int numAsientos, String estado) {
		Scanner sc2 = new Scanner(System.in);
		if (origen.isHabitada())
			this.origen = origen;
		if (destino.isHabitada())
			this.destino = destino;
		this.estado = estado;
		if (numAsientos > 0)
			this.numAsientos = numAsientos;
		this.numeroDeVuelo = numeroDeVuelo;
		this.company = company;
		asientos = new Pasajero[numAsientos];
		for (int i = 0; i < numAsientos; i++) {
			System.out.println("Introduce el nombre, apellido e identificacion del siguiente pasajero");
			asientos[i] = new Pasajero(sc2.next(), sc2.next(), sc2.nextInt(), numeroDeVuelo);
			pasajeros = pasajeros + asientos[i] + "\n";
		}
		sc2.close();

	}

	public String toString() {
		return "El vuelo " + numeroDeVuelo + "\n" + "Con origen en:\n" + origen + "\nCon destino:\n" + destino
				+ "\nDe la company " + company + "\nTiene " + numAsientos + " asientos ocupados"
				+ "\nCon los siguientes pasajeros:\n" + pasajeros + "Se encuentra en estado: " + estado;

	}

}
