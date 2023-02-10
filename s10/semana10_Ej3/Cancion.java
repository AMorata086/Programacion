package semana10_Ej3;

public class Cancion {
	private String titulo;
	private int segundos;

	public Cancion(String titulo, int segundos) {
		this.titulo = titulo;
		if (segundos >= 0 || segundos < 60)
			this.segundos = segundos;
	}
	
	public String toString() {
		return titulo + "(" + segundos + " segundos)";
	}

}
