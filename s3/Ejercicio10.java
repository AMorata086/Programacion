
public class Ejercicio10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1, num2;
		num1 = 100;
		num2 = num1;
		System.out.println(num2);
		num1 = 50;
		System.out.println(num2);
		/*La segunda variable no cambia de valor porque las lineas de codigo se ejecutan de manera lineal,
		  de modo que la igualacion o asignacion de la primera variable a la segunda se ejecuta antes de que
		  se le cambie el valor a la primera y se vuelva a imprimir el valor de la segunda, por tanto, se imprime
		  dos veces por pantalla el mismo valor de la segunda variable, porque no cambia en ningun momento al
		  segundo valor asignado a la primera*/
		
		
		
		String chain1, chain2;
		chain1 = "Hello";
		chain2 = chain1;
		System.out.println(chain2);
		chain1 = "World";
		System.out.println(chain2);
		/*Vuelve a pasar lo mismo por la linealidad del codigo*/
	}

}
