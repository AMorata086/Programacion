package semana11_Ej4;

public class Isla {

	private String nombre;
	private boolean isHabitada;
	private double gpsLat;
	private double gpsLon;
	private String pais;

	public Isla(String nombre, String pais, boolean isHabitada, double gpsLat, double gpsLon) {
		this.nombre = nombre;
		this.pais = pais;
		this.isHabitada = isHabitada;
		this.gpsLat = gpsLat;
		this.gpsLon = gpsLon;
	}

	public boolean isHabitada() {
		return isHabitada;
	}

	public String toString() {
		return "Isla: " + nombre + "\nPais: " + pais + "\nLongitud: " + gpsLon + "\nLatitud: " + gpsLat;
	}
}