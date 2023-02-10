package semana9_Ej4;

import java.util.Scanner;

public class ClaseMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		TrianguloRectangulo[] triangulo = new TrianguloRectangulo[1];
		System.out.println("Introduce la base y la altura");
		triangulo[0] = new TrianguloRectangulo(sc.nextFloat(), sc.nextFloat());
		System.out.println("0 para area, 1 para perimetro");
		byte eleccion = sc.nextByte();
		if (eleccion == 0)
			System.out.println("el area es " + (triangulo[0].getBase()*triangulo[0].getAltura()/2) + " uds^2");
		else if (eleccion == 1)
			System.out.println("el perimetro es " + (triangulo[0].getBase()+triangulo[0].getAltura()+(Math.sqrt(Math.pow(triangulo[0].getAltura(), 2) + Math.pow(triangulo[0].getBase(), 2)))) + " uds");
		sc.close();
	}

}
