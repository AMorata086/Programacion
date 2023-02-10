package semana9_Ej7;

public class Producto {
	private String nombre; //Es un public xq me daba problemas a la hora de 
	private double precio;
	private int stock;

	public Producto(String nuevoNombre, double nuevoPrecio, int nuevoStock) {
		nombre = nuevoNombre;
		precio = nuevoPrecio;
		stock = nuevoStock;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String toString() {
		return "El precio es: " + precio + " y el numero en stock es: " + stock;
	}
	
	public void setStock(int nuevoStock) {
		stock = nuevoStock;
	}
	
	public void setPrecio(double nuevoPrecio) {
		precio = nuevoPrecio;
	}
}
