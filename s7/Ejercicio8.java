import java.util.Scanner;

/**
 * @author Alvaro Morata Hontanaya, Cesar Martinez Lara
 * @since 22 octubre 2018
 * @version 1.0
 */

public class Ejercicio8 {

	public static void main(String[] args) {
		char[][] matriz;
		Scanner sc = new Scanner(System.in);
		int input;
		
		System.out.println("Introduzca un numero entero");
		input = sc.nextInt();
		sc.close();
		matriz = new char[input][input];
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				if(i == 0 || i == matriz.length-1) {
					matriz[i][j] = '*';
				}else if(j== 0 || j== matriz[i].length-1) {
					matriz[i][j] = '*';
				}else {
					matriz[i][j] = ' ';
				}
			}
		}
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]);
			}
			System.out.print("\n");
		}

	}

}
