package semana9_Ej6;

import java.util.Scanner;

public class JuegoDeDados {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre del jugador 1");
		String nombre1 = sc.next();
		System.out.println("Introduce el nombre del jugador 2");
		String nombre2 = sc.next();
		System.out.println("Introduce el numero de tiradas");
		int n = sc.nextInt();
		sc.close();
		Dado jug1 = new Dado(nombre1, n);
		Dado jug2 = new Dado(nombre2, n);
		int scoreJug1 = Repes(jug1);
		int scoreJug2 = Repes(jug2);
		if (scoreJug1 > scoreJug2)
			System.out.println("Gana el " + jug1.getNombre() + " por numero de repes");
		else if (scoreJug2 > scoreJug1)
			System.out.println("Gana el " + jug2.getNombre() + " por numero de repes");
		else {
			int sumaJug1 = Suma(jug1);
			int sumaJug2 = Suma(jug2);
			if (sumaJug1 > sumaJug2)
				System.out.println("Gana el "+ jug1.getNombre() +" por suma de valores");
			else if (sumaJug2 > sumaJug1)
				System.out.println("Gana el "+ jug1.getNombre() + "por suma de valores");
			else
				System.out.println("EMPATE WHAT?");
		}
	}
	
	
	
	public static int Repes(Dado jug) {
		int[] numericos = new int[6];
		int maxRepes = 1;
		for (int i = 0; i < jug.getTiradas().length; i++) {
			if (jug.getTiradas()[i] == 1)
				numericos[0]++;
			else if (jug.getTiradas()[i] == 2)
				numericos[1]++;
			else if (jug.getTiradas()[i] == 3)
				numericos[2]++;
			else if (jug.getTiradas()[i] == 4)
				numericos[3]++;
			else if (jug.getTiradas()[i] == 5)
				numericos[4]++;
			else
				numericos[5]++;
		}
		
		for (int i = 0; i < 6; i++) {
			if (maxRepes < numericos[i])
				maxRepes = numericos[i];
		}
		return maxRepes;
	}
	public static int Suma(Dado jug) {
		int suma = 0;
		for (int i = 0; i < jug.getTiradas().length; i++)
			suma += jug.getTiradas()[i];
		return suma;
	}

}
