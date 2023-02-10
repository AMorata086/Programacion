package semana11_Ej2;

public class Estudiante {
	private String nombre;
	private String apellido;
	private int prog;
	private int alg;
	private int calc;
	private int fis;
	private int writ;
	private int inf;
	
	public Estudiante(String nombre, String apellido, int prog, int alg, int calc, int fis, int writ, int inf) {
		setNombre(nombre);
		setApellido(apellido);
		setProg(prog);
		setAlg(alg);
		setCalc(calc);
		setFis(fis);
		setWrit(writ);
		setInf(inf);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getProg() {
		return prog;
	}

	public void setProg(int prog) {
		this.prog = prog;
	}

	public int getAlg() {
		return alg;
	}

	public void setAlg(int alg) {
		this.alg = alg;
	}

	public int getCalc() {
		return calc;
	}

	public void setCalc(int calc) {
		this.calc = calc;
	}

	public int getFis() {
		return fis;
	}

	public void setFis(int fis) {
		this.fis = fis;
	}

	public int getWrit() {
		return writ;
	}

	public void setWrit(int writ) {
		this.writ = writ;
	}

	public int getInf() {
		return inf;
	}

	public void setInf(int inf) {
		this.inf = inf;
	}

	public String toString() {
		return nombre + " " + apellido + " " + prog + " " + alg + " " + calc + " " + fis + " " + writ + " " + inf;
	}
}
