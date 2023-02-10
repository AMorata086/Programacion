package semana9_Ej6;

public class Dado {

	private String nombre;
	private int[] tiradas;
	
	public Dado(String nuevoNombre, int n) {
		if (n >= 0)
			tiradas = new int[n];
		nombre = nuevoNombre;
		for (int i = 0; i < n; i++)
			tiradas[i] = (int)(Math.random()*6) + 1;
	}
	
	public int[] getTiradas() {
		return tiradas;
	}
	
	public String getNombre() {
		return nombre;
	}
}
