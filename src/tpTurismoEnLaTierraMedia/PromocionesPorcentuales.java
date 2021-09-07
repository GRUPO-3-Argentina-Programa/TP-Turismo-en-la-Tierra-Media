package tpTurismoEnLaTierraMedia;

import java.util. *;

public class PromocionesPorcentuales extends Promocion{

	double porcentaje;
	private double tiempoTotal;
	private double sumaCostos;
	
		public PromocionesPorcentuales(TIPO valueOf, List<Atraccion> atraccionesDePromo, double porcentaje) {
		super(valueOf, atraccionesDePromo);
		this.porcentaje = porcentaje;
		}

	@Override
	public double getCosto() {
		for (Atraccion a : this.atraccionesDePromo)
			sumaCostos += a.getCosto();
		return sumaCostos*(1-porcentaje/100);
	}


	
	
}
	
	