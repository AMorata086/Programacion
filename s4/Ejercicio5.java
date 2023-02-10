
public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b;
		boolean r,s;
		a = 3;
		b = 8;
		r = a == 0 || b >= a;
		s = a != 0 && b < a;
		System.out.println("r:" + r); //true
		System.out.println("s:" + s); //false
		/*Son las operaciones logicas del O-cortocircuito y el Y-cortocircuito*/
	}

}
