import java.util.Scanner;
import java.util.Math;

public class Ejercicio12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double capInicial = 0;
		double capFinal = 0;
		int n = 0;
		double interes = 0;
		short tipoInteres;
		Scanner sc = new Scanner(System.in);
		System.out.println("Capital (insertar coma para dividir parte decimal y entera en caso necesario)?");
		capInicial = sc.nextDouble();
		System.out.println("Tipo de interes anual? (Insertar 1 para el simple o 2 para el compuesto)");
		tipoInteres = sc.nextShort();
		System.out.println("Interes que se pide (insertar con coma si pide decimales)?");
		interes = sc.nextDouble();
		System.out.println("Cantidad de años?");
		n = sc.nextInt();
		if(tipoInteres == 1) {
			capFinal = capInicial * (1 + interes * n);
			System.out.println("El capital final con interes simple seria " + capFinal);
		} else if(tipoInteres == 2) {
			capFinal = capInicial * (Math.pow((1 + interes),n));
			System.out.println("El capital final con interes compuesto seria " + capFinal);
		} else {
			System.out.println("No se reconoce el tipo de interes");
		}
	}

}
