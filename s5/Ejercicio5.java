import java.util.Scanner;

public class Ejercicio5 {
	
	public static void main(String[] args) {
		int a, b, c;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("De el valor de un numero \"a\"");
		a = sc.nextInt();
		System.out.println("De el valor de un numero \"b\"");
		b = sc.nextInt();
		System.out.println("De el valor de un numero \"c\"");
		c = sc.nextInt();
		sc.close();
		
		if(a < b && b < c) {
			System.out.println(a + " < " + b + " < " + c);
		}else if(a < c && c < b){
			System.out.println(a + " < " + c + " < " + b);
		}else if(b < a && a < c) {
			System.out.println(b + " < " + a + " < " + c);
		}else if(b < c && c < a) {
			System.out.println(b + " < " + c + " < " + a);
		}else if(c < a && a < b) {
			System.out.println(c + " < " + a + " < " + b);
		}else if(c < b && b < a) {
			System.out.println(c + " < " + b + " < " + a);
		}else if(a == b && b < c) {
			System.out.println(a + " = " + b + " < " + c);
		}else if(a == c && c < b) {
			System.out.println(a + " = " + c + " < " + b);
		}else if(b == c && c < a) {
			System.out.println(b + " = " + c + " < " + a);
		}else if(c < a && a == b) {
			System.out.println(c + " < " + a + " = " + b);
		}else if(b < a && a == c) {
			System.out.println(b + " < " + a + " = " + c);
		}else if(a < b && b == c) {
			System.out.println(a + " < " + b + " = " + c);
		}else if(a == b && b == c) {
			System.out.println(a + " = " + b + " = " + c);
		}
	}

}
