import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long segundos = 0, minutos = 0, horas = 0;
		final long SECONDS;
		Scanner sc = new Scanner(System.in);
		System.out.println("De un numero de segundos a convertir en horas");
		segundos = sc.nextLong();
		SECONDS = segundos;
		while(segundos >= 60) {
			segundos -= 60;
			minutos++;
		}
		while(minutos >= 60) {
			minutos -= 60;
			horas++;
		}
		if(segundos == 1 & minutos == 1 & horas == 1) {
			System.out.println(SECONDS + " segundos es igual a " + horas + " hora " + minutos + " minuto " + segundos + " segundo");
		} else if(segundos == 1 & minutos == 1) {
			System.out.println(SECONDS + " segundos es igual a " + horas + " horas " + minutos + " minuto " + segundos + " segundo ");
		} else if(segundos == 1) {
			System.out.println(SECONDS + " segundos es igual a " + horas + " horas " + minutos + " minutos " + segundos + " segundo");
		} else if(horas == 1 & minutos == 1) {
			System.out.println(SECONDS + " segundos es igual a " + horas + " hora " + minutos + " minuto " + segundos + " segundos ");
		} else if(segundos == 1 & horas == 1) {
			System.out.println(SECONDS + " segundos es igual a " + horas + " hora " + minutos + " minutos " + segundos + " segundo ");
		} else if(horas == 1) {
			System.out.println(SECONDS + " segundos es igual a " + horas + " hora " + minutos + " minutos " + segundos + " segundos ");
		}
			
	}

}
