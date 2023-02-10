
public class Ejercicio7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=5,b=3;
		boolean r=true,s=false;
		a+=b+8*b;
		r&=s;
		System.out.println("a:" + a); // a = a + b + 8 * b = 32
		System.out.println("b:" + b); // b = 3
		System.out.println("r:" + r); // r = r & s = false
		System.out.println("s:" + s); // s = false
	}

}
