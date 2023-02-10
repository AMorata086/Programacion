package semana9_Ej3;

public class Estudiante {

	private String nombre;
	private String apellido;
	private int programacion;
	private int algebra;
	private int calculo;
	private int fisica;
	private int escritura;
	private int informacion;
	
	public Estudiante(String nombre, String apellido, int algebra, int calculo, int programacion, int fisica, int escritura, int informacion) {
		this.nombre = nombre;
		this.apellido = apellido;
		if (programacion <= 10 && programacion > 0)
			this.programacion = programacion;
		if (algebra <= 10 && algebra > 0)
			this.algebra = algebra;
		if (calculo <= 10 && calculo > 0)
			this.calculo = calculo;
		if (fisica <= 10 && fisica > 0)
			this.fisica = fisica;
		if (escritura <= 10 && escritura > 0)
			this.escritura = escritura;
		if (informacion <= 10 && informacion > 0)
			this.informacion = informacion;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public int getProgramacion() {
		return programacion;
	}
	public int getAlgebra() {
		return algebra;
	}
	public int getCalculo() {
		return calculo;
	}
	public int getFisica() {
		return fisica;
	}
	public int getEscritura() {
		return escritura;
	}
	public int getInformacion() {
		return informacion;
	}
	public String toString() {
		return "Estudiante: " + nombre + " " + apellido +
				"\nNota Algebra: " + algebra +
				"\nNota Calculo: " + calculo +
				"\nNota Programacion: " + programacion +
				"\nNota Fisica: " + fisica +
				"\nNota Escritura: " + escritura +
				"\nNota Informacion: " + informacion;
	}
}
