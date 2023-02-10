package semana10_Ej3;

import java.util.Scanner;

public class ClaseMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter(System.getProperty("line.separator")); 
		Disco disco;
		System.out.println("titulo, lanzamiento, numCanciones, precio");
		disco = new Disco(sc.next(),sc.nextInt(),sc.nextInt(),sc.nextDouble());
		System.out.println(disco);
		sc.close();
	}

}
