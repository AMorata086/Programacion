package semana9_Ej7;

import java.util.Scanner;

public class Tienda {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcion;
		Producto[] tienda = new Producto[10];
		int estante = 0;

		do {
			System.out.println("Selecciona opcion");
			System.out.println("1: Anyadir producto");
			System.out.println("2: Buscar producto por su nombre");
			System.out.println("3: Modificar el precio y stock de un producto existente");
			System.out.println("4: Cerrar tienda");
			opcion = sc.nextInt();
			if (opcion == 1) {
				if (estante < 10) {
					System.out.println("Introduce el nombre del producto, su precio, y el stock");
					tienda[estante] = new Producto(sc.next(), sc.nextDouble(), sc.nextInt());
					estante++;
				} else
					System.out.println("Todos los estantes estan llenos");
			}
			if (opcion == 2) {
				String buscado = sc.next();
				for (int i = 0; i < estante; i++) {
					if (buscado.contains(tienda[i].getNombre()))
						System.out.println(tienda[i]);
				}
			}
			if (opcion == 3) {
				System.out.println("Introduce el nombre del producto a modificar");
				String buscado = sc.next();
				for (int i = 0; i < estante; i++) {
					if (buscado.contains(tienda[i].getNombre())) {
						System.out.println("Introduce el nuevo precio y stock");
						tienda[i].setPrecio(sc.nextDouble());
						tienda[i].setStock(sc.nextInt());
					}
				}
			}
		} while (opcion == 1 || opcion == 2 || opcion == 3);
		sc.close();
		System.out.println("Adios!");
	}

}
