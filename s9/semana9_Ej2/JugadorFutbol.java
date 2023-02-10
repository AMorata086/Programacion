package semana9_Ej2;

public class JugadorFutbol {

	private String nombre;
	private String apellido;
	private int edad;
	private String posicion;
	private String equipo;
	
	public JugadorFutbol() {
		
	}
	
	public JugadorFutbol(String nombre, String apellido, int edad, String posicion, String equipo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.posicion = posicion;
		this.equipo = equipo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public int getEdad() {
		return edad;
	}
	public String getPosicion() {
		return posicion;
	}
	public String getEquipo() {
		return equipo;
	}
	public String toString() {
		return nombre + " " + apellido + " " + edad + " " + posicion + " " + equipo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
}
