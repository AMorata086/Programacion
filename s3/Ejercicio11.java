
public class Ejercicio11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b;
		int c, d;
		a = 2;
		b = 3 * 3;
		c = 7 / 3;
		d = a + b * c;
		System.out.println(d);
		/*
		  El valor de las operaciones anteriores es el siguiente
		  a = 2
		  b = 3 * 3 = 9
		  c = 7 / 3 = 2 (Esto sucede porque c es un numero entero, y el ordenador aproxima la solucion al numero
		  entero mas proximo: 7/3 = 2.3333333333 ----> 2)
		  d = 2 + 9 * 2 = 2 + 18 = 20
		*/
	}

}
