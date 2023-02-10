package semana9_Ej1;

import java.util.Scanner;

public class Clase {

	public static void main(String[] args) {

		Telefono[] nuevo = new Telefono[1];
		Scanner sc = new Scanner(System.in);
		
		nuevo[0] = new Telefono(sc.next(), sc.next(), sc.nextInt());
		System.out.println(nuevo[0].getModelo() + " " + nuevo[0].getMarca() + " " + nuevo[0].getAnyo());
		
		nuevo[0].setModelo(sc.next());
		nuevo[0].setMarca(sc.next());
		nuevo[0].setAnyo(sc.nextInt());
		System.out.println(nuevo[0]);
		
		sc.close();
	}

}
