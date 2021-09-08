package tpTurismoEnLaTierraMedia;

import java.util.List;

public class PromocionesAbsolutas extends Promocion{
	

	public PromocionesAbsolutas(TIPO valueOf, List<Atraccion> atraccionesDePromo, double precio) {
		super(valueOf, atraccionesDePromo);
		this.sumaCostos = precio;
		this.tiempoTotal = super.getTiempoTotal();
	}

}
