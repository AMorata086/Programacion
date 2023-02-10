package semana10_Ej1;

import java.util.Scanner;

public class ClaseMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Cuantos intervalos vas a introducir?");
		Intervalo[] todosLosIntervalos = new Intervalo[sc.nextInt()];
		for (int i = 0; i < todosLosIntervalos.length; i++) {
			System.out.println("Introduce el siguiente intervalo de la forma <horaInicial> <minutosInicial> <horaFinal> <minutosInicial");
			todosLosIntervalos[i] = new Intervalo(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		sc.close();
		for (int i = 0; i < todosLosIntervalos.length; i++)
			System.out.println(todosLosIntervalos[i]);
	}

}
