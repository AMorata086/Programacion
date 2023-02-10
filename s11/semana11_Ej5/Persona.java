package semana11_Ej5;

public class Persona {
	private String nombre;
	private int birth;
	
	public Persona(String nombre, int birth) {
		this.nombre = nombre;
		this.birth = birth;
	}
	public String getNombre() {
		return nombre;
	}
	public int getBirth() {
		return birth;
	}
	public String toString() {
		return nombre + "(" + birth + ")";
	}

}
