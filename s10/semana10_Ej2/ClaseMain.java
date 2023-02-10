package semana10_Ej2;

import java.util.Scanner;

public class ClaseMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre de la isla y el pais de origen");
		String nomIsla = sc.next();
		String nomPais = sc.next();
		System.out.println("Esta habitada? (true/false)");
		boolean habitada = sc.nextBoolean();
		if (habitada) {
			System.out.println("Introduce las coordenadas GPS");
			double latitud = sc.nextDouble();
			double longitud = sc.nextDouble();
			Isla islaDeOrigen = new Isla(nomIsla, nomPais, habitada, latitud, longitud);
			System.out.println("Introduce el nombre de la isla y el pais destino");
			nomIsla = sc.next();
			nomPais = sc.next();
			System.out.println("Esta habitada? (true/false)");
			habitada = sc.nextBoolean();
			if (habitada) {
				System.out.println("Introduce las coordenadas GPS");
				latitud = sc.nextDouble();
				longitud = sc.nextDouble();
				Isla islaDestino = new Isla(nomIsla, nomPais, habitada, latitud, longitud);
				System.out.println(
						"Introduce el numero de vuelo, la companyia, el numero de asientos ocupados y su estado actual (puntual/retrasado/cancelado)");
				Avion miAvion = new Avion(sc.nextInt(), islaDeOrigen, islaDestino, sc.next(), sc.nextInt(), sc.next());
				sc.close();
				System.out.println(miAvion);
			} else
				System.out.println("El vuelo no puede ser realizado porque una de las islas no esta habitada");
		} else
			System.out.println("El vuelo no puede ser realizado porque una de las islas no esta habitada");
	}

}
