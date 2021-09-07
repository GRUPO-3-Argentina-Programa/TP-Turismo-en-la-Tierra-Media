package tpTurismoEnLaTierraMedia;

import java.util.List;

public class PromocionesAbsolutas extends Promocion{
	private double precio;

	public PromocionesAbsolutas(TIPO valueOf, List<Atraccion> atraccionesDePromo, double precio) {
		super(valueOf, atraccionesDePromo);
		
		this.precio = precio;
	}

	@Override
	public double getCosto() {
		return precio;
	}


}
