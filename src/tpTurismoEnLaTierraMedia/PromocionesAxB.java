package tpTurismoEnLaTierraMedia;

import java.util.Iterator;
import java.util.List;

public class PromocionesAxB extends Promocion implements Sugerible {
		
	protected double sumaCostos;

	public PromocionesAxB(TIPO valueOf, List<Atraccion> atraccionesDePromo) {
		super(valueOf, atraccionesDePromo);
	}

	public double getCosto() {
		atraccionesDePromo.remove(atraccionesDePromo.size());
		Iterator<Atraccion> itr = atraccionesDePromo.iterator();
		while (itr.hasNext())					
			sumaCostos += ((PromocionesAxB) itr).getCosto();
		return sumaCostos;
	}
	
	
}
