package semana11_Ej1;

public class JugadorFutbol {

	private String nombre;
	private String apellido;
	private int edad = 25;
	private String equipo;
	private String posicion;

	public JugadorFutbol(String nombre, String apellido, int edad, String posicion, String equipo) {
		setNombre(nombre);
		setApellido(apellido);
		setEdad(edad);
		setEquipo(equipo);
		setPosicion(apellido);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public void setEdad(int edad) {
		if (edad > 15 && edad < 51)
			this.edad = edad;
	}

	public void setPosicion(String apellido) {
		if (apellido.toLowerCase().equals("portero") || apellido.toLowerCase().equals("defensa")
				|| apellido.toLowerCase().equals("centrocampista") || apellido.toLowerCase().equals("delantero"))
			this.apellido = apellido;
		else {
			int random = (int) (Math.random() * 4);
			if (random == 0)
				this.posicion = "portero";
			else if (random == 1)
				this.posicion = "defensa";
			else if (random == 2)
				this.posicion = "centrocampista";
			else if (random == 3)
				this.posicion = "delantero";
		}

	}
	public String toString() {
		return nombre + " " + apellido+ " " + edad + " " + posicion + " " + equipo;
	}
}
