
package semana12_Ej2;

/**
 * @author cesar martinez lara & alvaro morata hontanaya
 *
 */
public class RectangulosMain {

	public static void main(String[] args) {
		int areaMax = 1;
		int perMax = 4;
		int mayorLado = 1;
		int numElementos = (int) (Math.random() * 991 + 10);

		Rectangulo[] rect = new Rectangulo[numElementos];
		for (int i = 0; i < rect.length; i++) {
			rect[i] = new Rectangulo((int) (Math.random() * 10 + 1), (int) (Math.random() * 10 + 1));

			if (rect[i].getArea() > areaMax)
				areaMax = (int) rect[i].getArea();
			if (rect[i].getPerimetro() > perMax)
				perMax = (int) rect[i].getPerimetro();
			if (rect[i].getLadoMayor() > mayorLado)
				mayorLado = (int) rect[i].getLadoMayor();
		}
		System.out.println("Los cuadrados son:");
		for (int i = 0; i < rect.length; i++)
			if (rect[i].isCuadrado())
				System.out.println(rect[i]);

		System.out.println("Los de mayor area son:");
		for (int i = 0; i < rect.length; i++)
			if (rect[i].getArea() == areaMax)
				System.out.println(rect[i]);

		System.out.println("Los de mayor perimetro son:");
		for (int i = 0; i < rect.length; i++)
			if (rect[i].getPerimetro() == perMax)
				System.out.println(rect[i]);

		System.out.println("Los de lado mas grande son:");
		for (int i = 0; i < rect.length; i++)
			if (rect[i].getLadoMayor() == mayorLado) {
				System.out.println(rect[i]);
				if (rect[i].toCuadrado() && !rect[i].isCuadrado())
					System.out.println("Se ha convertido en: " + rect[i] + " y se ha cambiado su base");
				else
					System.out.println("Se ha convertido en: " + rect[i] + " y se ha cambiado su altura");
			}
	}
}
