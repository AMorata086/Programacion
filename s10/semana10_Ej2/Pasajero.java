package semana10_Ej2;

public class Pasajero {

	private String nombre;
	private String apellido;
	private int id;
	private int billete;

	public Pasajero(String nombre, String apellido, int id, int billete) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.id = id;
		this.billete = billete;
	}

	public String toString() {
		return nombre + " " + apellido + " id:" + id + " Billete: " + billete;
	}

}
