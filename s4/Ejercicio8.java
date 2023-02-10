
public class Ejercicio8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=5,b=3,c=20,d=20;
		c-=++a/b-3+a%b;	// c = c - (a + 1) / b - 3 + a % b = 21
		d-=++a/(b+3-4*a)%b;	// d = d - (a + 1) / (b + 3 - 4 * a) % b = 20
		System.out.println("c:" + c);
		System.out.println("d:" + d);
	}

}
