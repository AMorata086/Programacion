
public class Ejercicio13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int int1, int2, int3;
		int1 = 5;
		int2 = 0;
		int3 = int1 / int2;
		System.out.println(int3);
		//Se produce un fallo el cual dice que no se puede dividir por 0
		
		
		
		byte by1, by2, by3;
		by1 = 5;
		by2 = 0;
		by3 = 5 / 0;
		System.out.println(by3);
		//En el caso de BYTE, se produce antes el fallo de compilacion: cannot convert from int to byte
		
		short sh1, sh2, sh3;
		sh1 = 5;
		sh2 = 0;
		sh3 = 5 / 0;
		System.out.println(sh3);
		//En el caso de SHORT, se produce antes el fallo de compilacion: cannot convert from int to short
		
		
		
		long lg1, lg2, lg3;
		lg1 = 5;
		lg2 = 0;
		lg3 = lg1 / lg2;
		System.out.println(lg3);
		//Con el tipo entero LONG la operacion sigue dando el mismo fallo que con INT
		
	}

}
