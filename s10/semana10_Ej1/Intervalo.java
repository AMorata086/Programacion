package semana10_Ej1;

public class Intervalo {

	private int hora1;
	private int minutos1;
	private int hora2;
	private int minutos2;
	private boolean madrugada = false;
	private boolean manyana = false;
	private boolean tarde = false;
	private boolean noche = false;
	private String pertenencia = "";

	public Intervalo(int hora1, int minutos1, int hora2, int minutos2) {

		if (hora1 >= 0 && hora1 < 24)
			this.hora1 = hora1;
		else
			this.hora1 = hora2;
		if (hora2 >= 0 && hora2 < 24)
			this.hora2 = hora2;
		else
			this.hora2 = hora1;
		if ((hora1 > 23 || hora1 < 0) && (hora2 > 23 || hora2 < 0)) {
			this.hora1 = 0;
			this.hora2 = 0;
		}

		if (minutos1 >= 0 && minutos1 < 60)
			this.minutos1 = minutos1;
		else
			this.minutos1 = 0;
		if (minutos2 >= 0 && minutos2 < 60)
			this.minutos2 = minutos2;
		else
			this.minutos2 = 0;

		if (this.hora2 < this.hora1) {
			this.hora1 = hora2;
			this.hora2 = hora1;
			this.minutos1 = minutos2;
			this.minutos2 = minutos1;
		} else if (this.hora1 == this.hora2) {
			if (this.minutos2 > this.minutos1) {
				this.minutos1 = minutos2;
				this.minutos2 = minutos1;
			}
		}

		momentoDelDia(this.hora1);
		momentoDelDia(this.hora2);

		if (madrugada && tarde)
			manyana = true;
		else if (manyana && noche)
			tarde = true;
		else if (madrugada && noche)
			manyana = true; tarde = true;

		if (madrugada)
			pertenencia = pertenencia + "madrugada ";
		if (manyana)
			pertenencia = pertenencia + "manyana ";
		if (tarde)
			pertenencia = pertenencia + "tarde ";
		if (noche)
			pertenencia = pertenencia + "noche ";

	}

	private void momentoDelDia(int hora) {
		if (hora >= 0 && hora < 6)
			madrugada = true;
		if (hora >= 6 && hora < 12)
			manyana = true;
		if (hora >= 12 && hora < 18)
			tarde = true;
		if (hora >= 18 && hora < 24)
			noche = true;
	}

	public String toString() {
		return "Intervalo temporal: [" + hora1 + ":" + minutos1 + "-" + hora2 + ":" + minutos2 + "]\nPertenece a: "
				+ pertenencia;
	}
}
