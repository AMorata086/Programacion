package semana12_Ej2;

public class Rectangulo {
	private double base;
	private double altura;
	private boolean cuadrado = false;

	public Rectangulo(double base, double altura) {
		setBase(base);
		setAltura(altura);
		setCuadrado(base, altura);
	}

	public Rectangulo(double base) {
		setBase(base);
		altura = base;
		cuadrado = true;
	}

	public void setBase(double base) {
		if (base != 0)
			this.base = Math.abs(base);
	}

	public void setAltura(double altura) {
		if (altura != 0)
			this.altura = Math.abs(altura);
	}

	public void setCuadrado(double base, double altura) {
		if (base == altura)
			cuadrado = true;
	}

	public double getBase() {
		return base;
	}

	public double getAltura() {
		return altura;
	}

	public boolean isCuadrado() {
		return cuadrado;
	}

	public String toString() {
		String cuadradoOrRectangulo = "rectangulo";
		if (cuadrado)
			cuadradoOrRectangulo = "cuadrado";
		return "un " + cuadradoOrRectangulo + " de base " + base + " y altura " + altura;
	}

	public double getPerimetro() {
		return 2 * base + 2 * altura;
	}

	public double getArea() {
		return base * altura;
	}

	public double getLadoMayor() {
		return Math.max(base, altura);
	}

	public boolean equals(Rectangulo otro) {
		if (base == otro.getBase() && altura == otro.getAltura())
			return true;
		else
			return false;
	}

	public boolean toCuadrado() {
		if (base > altura) {
			altura = base;
			return false;
		} else {
			base = altura;
			return true;
		}
	}
}
