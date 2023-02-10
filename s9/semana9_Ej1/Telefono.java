package semana9_Ej1;

public class Telefono {

	private String modelo;
	private String marca;
	private int anyo;
	
	public Telefono (String nuevoModelo, String nuevaMarca, int nuevoAnyo) {
		modelo = nuevoModelo;
		marca = nuevaMarca;
		anyo = nuevoAnyo;
	}
	
	public void setModelo (String nuevoModelo) {
		modelo = nuevoModelo;
	}
	public void setMarca (String nuevaMarca) {
		marca = nuevaMarca;
	}
	public void setAnyo (int nuevoAnyo) {
		anyo = nuevoAnyo;
	}
	public String getModelo() {
		return modelo;
	}
	public String getMarca() {
		return marca;
	}
	public int getAnyo() {
		return anyo;
	}
	
	public String toString() {
		return modelo + " " + marca + " " + anyo;
	}
}
