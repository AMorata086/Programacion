/**
 * @author Alvaro Morata Hontanaya, Cesar Martinez Lara
 * @since 22 octubre 2018
 * @version 1.0
 */

public class Ejercicio3 {

	public static void main(String[] args) {
		String[][] meses = new String[12][];
		meses[0] = new String[31]; // Enero
		meses[1] = new String[28]; // Febrero
		meses[2] = new String[31]; // Marzo
		meses[3] = new String[30]; // Abril
		meses[4] = new String[31]; // Mayo
		meses[5] = new String[30]; // Junio
		meses[6] = new String[31]; // Julio
		meses[7] = new String[31]; // Agosto
		meses[8] = new String[30]; // Septiembre
		meses[9] = new String[31]; // Octubre
		meses[10] = new String[30]; // Noviembre
		meses[11] = new String[31]; // Diciembre

		meses[0][5] = "Hoy no hay clase";
		meses[9][19] = "Examen parcial";

		System.out.println("El numero de filas del array es " + meses.length + "\n");

		for (int i = 0; i < meses.length; i++) {
			System.out.println("El numero de columnas en la fila " + i + " es " + meses[i].length);
		}

	}

}
