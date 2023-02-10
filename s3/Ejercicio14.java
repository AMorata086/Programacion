
public class Ejercicio14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int resultEnt;
		resultEnt = 1000000000*1000000000;
		System.out.println(resultEnt);
		//Si, es posible imprimirla por pantalla.
		/*El resultado de la operacion no es correcto:
		  El resultado real de la operacion deberia ser: 1000000000 * 1000000000 = 1e18 
		  El resultado que se muestra por pantalla es: 1000000000 * 1000000000 = -1486618624
		*/
		
		
		double resultReal;
		resultReal = 1000000000 * 1000000000;
		System.out.println(resultReal);
		//El resultado de esta operacion da -1.486618624E9 supuestamente
		
		
	}

}
