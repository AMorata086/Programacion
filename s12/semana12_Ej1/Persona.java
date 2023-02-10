package semana12_Ej1;

public class Persona {
	private String nombre;
	private int edad;
	private int dni;
	private char letraDNI;
	private String sexo = "Otro";
	private double peso = 90;
	private double altura = 185;

	public Persona() {	
	}
	
	public Persona(String nombre, int edad, int dni, String sexo, double peso, double altura) {
		setNombre(nombre);
		setEdad(edad);
		setSexo(sexo);
		setDni(dni);
		setPeso(peso);
		setAltura(altura);
	}
	
	public Persona(String nombre, int edad, int dni) {
		setNombre(nombre);
		setEdad(edad);
		setDni(dni);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	private void calcularLetraDNI(int dni) {
		char[] letras = new char[] { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S',
				'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
		letraDNI = letras[dni % 23];
	}

	public String toString() {
		calcularLetraDNI(dni);
		return "Informacion personal:\nNombre: " + nombre + "\nSexo: " + sexo + "\nEdad: " + edad + " años\nDNI: " + dni
				+ "-" + letraDNI + "\nPeso: " + peso + " kg\nAltura: " + altura + " cm";
	}
}
