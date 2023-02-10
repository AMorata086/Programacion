package semana9_Ej5;

import java.util.Random;

public class Fecha {

	private int dia;
	private String mes;
	private int anyo;

	public Fecha(int dia, String mes, int anyo) {
		int maxDias = 30;
		int mesRandom = 20;
		Random r = new Random(System.currentTimeMillis());
		
		this.anyo = anyo;
		if (mes != "enero" && mes != "febrero" && mes != "marzo" && mes != "abril" && mes != "mayo" && mes != "junio"
				&& mes != "julio" && mes != "agosto" && mes != "septiembre" && mes != "octubre" && mes != "noviembre"
				&& mes != "diciembre") {
			mesRandom = r.nextInt(12);
		}
		if (mesRandom == 0)
			this.mes = "enero";
		if (mesRandom == 1)
			this.mes = "febrero";
		if (mesRandom == 2)
			this.mes = "marzo";
		if (mesRandom == 3)
			this.mes = "abril";
		if (mesRandom == 4)
			this.mes = "mayo";
		if (mesRandom == 5)
			this.mes = "junio";
		if (mesRandom == 6)
			this.mes = "julio";
		if (mesRandom == 7)
			this.mes = "agosto";
		if (mesRandom == 8)
			this.mes = "septiembre";
		if (mesRandom == 9)
			this.mes = "octubre";
		if (mesRandom == 10)
			this.mes = "noviembre";
		if (mesRandom == 11)
			this.mes = "diciembre";
		else
			this.mes = mes;

		switch (this.mes) {
		case "enero":
		case "marzo":
		case "mayo":
		case "julio":
		case "agosto":
		case "octubre":
		case "diciembre":
			maxDias = 31;
			break;
		case "febrero":
			if (this.anyo % 4 == 0) {
				if (this.anyo % 100 != 0)
					maxDias = 29;
				if (this.anyo % 400 == 0)
					maxDias = 29;
			} else
				maxDias = 28;
			break;
		}

		if (dia > 0 && dia < maxDias)
			this.dia = dia;
		else
			this.dia = r.nextInt(maxDias);
	}

	public String toString() {
		return dia + " de " + mes + " de " + anyo;
	}

}
