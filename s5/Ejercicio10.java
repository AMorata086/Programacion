import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		double dineros, memoria;
		int billetes500 = 0, billetes200 = 0, billetes100 = 0, billetes50 = 0, billetes20 = 0, billetes10 = 0, billetes5 = 0;
		int moneda2 = 0, moneda1 = 0, moneda50c = 0, moneda20c = 0, moneda10c = 0, moneda5c = 0, moneda2c = 0, moneda1c = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese la cantidad de dinero para el desglose monetario:");
		dineros = sc.nextDouble();
		sc.close();
		
		memoria = dineros;
		
		while(memoria >= 500) {
			billetes500 += 1;
			memoria -= 500;
		}
		while(memoria >= 200) {
			billetes200 += 1;
			memoria -= 200;
		}
		while(memoria >= 100) {
			billetes100 += 1;
			memoria -= 100;
		}
		while(memoria >= 50) {
			billetes50 += 1;
			memoria -= 50;
		}
		while(memoria >= 20) {
			billetes20 += 1;
			memoria -= 20;
		}
		while(memoria >= 10) {
			billetes10 += 1;
			memoria -= 10;
		}
		while(memoria >= 5) {
			billetes5 += 1;
			memoria -= 5;
		}
		while(memoria >= 2) {
			moneda2 += 1;
			memoria -= 2;
		}
		while(memoria >= 1) {
			moneda1 += 1;
			memoria -= 1;
		}
		while(memoria >= 0.50) {
			moneda50c += 1;
			memoria -= 0.50;
		}
		while(memoria >= 0.20) {
			moneda20c += 1;
			memoria -= 0.20;
		}
		while(memoria >= 0.10) {
			moneda10c += 1;
			memoria -= 0.10;
		}
		while(memoria >= 0.05) {
			moneda5c += 1;
			memoria -= 0.05;
		}
		while(memoria >= 0.02) {
			moneda2c += 1;
			memoria -= 0.02;
		}
		while(memoria >= 0.01) {
			moneda1c += 1;
			memoria -= 0.01;
		}
		
		if(billetes500 != 0)
			System.out.println("500€: " + billetes500);
		if(billetes200 != 0)
			System.out.println("200€: " + billetes200);
		if(billetes100 != 0)
			System.out.println("100€: " + billetes100);
		if(billetes50 != 0)
			System.out.println("50€: " + billetes50);
		if(billetes20 != 0)
			System.out.println("20€: " + billetes20);
		if(billetes10 != 0)
			System.out.println("10€: " + billetes10);
		if(billetes5 != 0)
			System.out.println("5€: " + billetes5);
		if(moneda2 != 0)
			System.out.println("2€: " + moneda2);
		if(moneda1 != 0)
			System.out.println("1€: " + moneda1);
		if(moneda50c != 0)
			System.out.println("0.50€: " + moneda50c);
		if(moneda20c != 0)
			System.out.println("0.20€: " + moneda20c);
		if(moneda10c != 0)
			System.out.println("0.10€: " + moneda10c);
		if(moneda5c != 0)
			System.out.println("0.05€: " + moneda5c);
		if(moneda2c != 0)
			System.out.println("0.02€: " + moneda2c);
		if(moneda1c != 0)
			System.out.println("0.01€: " + moneda1c);
	}

}
