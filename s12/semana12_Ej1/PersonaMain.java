package semana12_Ej1;

import java.util.Scanner;

public class PersonaMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el nombre, la edad, el dni, el sexo, el peso y la altura");
		Persona persona1 = new Persona(sc.next(),sc.nextInt(),sc.nextInt(),sc.next(),sc.nextDouble(),sc.nextDouble());
		System.out.println(persona1);
		
		Persona persona2 = new Persona();		
		System.out.println("Introduce el nombre, la edad, el dni, el sexo, el peso y la altura");
		persona2.setNombre(sc.next());
		persona2.setEdad(sc.nextInt());
		persona2.setDni(sc.nextInt());
		persona2.setSexo(sc.next());
		persona2.setPeso(sc.nextDouble());
		persona2.setAltura(sc.nextDouble());
		System.out.println(persona2);
		
		
		System.out.println("Introduce el nombre, la edad y el dni");
		Persona persona3 = new Persona(sc.next(),sc.nextInt(),sc.nextInt());
		System.out.println(persona3);
		
		sc.close();
	}

}
