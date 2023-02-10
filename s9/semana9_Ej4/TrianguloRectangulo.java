package semana9_Ej4;

public class TrianguloRectangulo {
	private float base;
	private float altura;
	
	public TrianguloRectangulo(float base,float altura) {
		if (base > 0)
			this.base = base;
		if (altura > 0)
			this.altura = altura;
	}
	public float getBase() {
		return base;
	}
	public float getAltura() {
		return altura;
	}
}
