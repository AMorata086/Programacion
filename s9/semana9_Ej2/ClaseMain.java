package semana9_Ej2;

import java.util.Scanner;

public class ClaseMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		JugadorFutbol[] fichajes = new JugadorFutbol[3];
		
		fichajes[0] = new JugadorFutbol(sc.next(),sc.next(),sc.nextInt(),sc.next(),sc.next());

		fichajes[1] = new JugadorFutbol();
		fichajes[1].setNombre(fichajes[0].getNombre());
		fichajes[1].setApellido(fichajes[0].getApellido());
		fichajes[1].setEdad(fichajes[0].getEdad());
		fichajes[1].setPosicion(fichajes[0].getPosicion());
		fichajes[1].setEquipo(fichajes[0].getEquipo());
				
		fichajes[2] = fichajes[0];
		fichajes[2].setNombre(sc.next());
		fichajes[2].setApellido(sc.next());
		fichajes[2].setEdad(sc.nextInt());
		fichajes[2].setPosicion(sc.next());
		fichajes[2].setEquipo(sc.next());
		
		System.out.println(fichajes[0]);
		System.out.println(fichajes[1]);
		System.out.println(fichajes[2]);
		
		sc.close();
	}

}
