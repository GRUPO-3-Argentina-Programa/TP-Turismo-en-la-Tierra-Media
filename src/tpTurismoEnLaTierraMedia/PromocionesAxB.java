package tpTurismoEnLaTierraMedia;

import java.util.LinkedList;
import java.util.List;

public class PromocionesAxB extends Promocion {
		
	protected Atraccion atraccionRegalo;

	public PromocionesAxB(TIPO tipo, List<Atraccion> atraccionesDePromo, Atraccion atraccionRegalo) {
		super(tipo, atraccionesDePromo);
		this.atraccionRegalo = atraccionRegalo;
		this.tiempoTotal = getTiempoTotal();
	}
	
	@Override
	public double getTiempoTotal() {
		this.tiempoTotal = super.getTiempoTotal()+atraccionRegalo.getTiempoTotal();
		return this.tiempoTotal;
	}
	
	@Override
	public void restarCupo() {
		super.restarCupo();
		atraccionRegalo.restarCupo();
	}

	@Override
	public boolean hayCupo() {
		if (!atraccionRegalo.hayCupo()) return false;
		super.hayCupo();
		return true;
	}
		
	@Override
	public List<Atraccion> getAtracciones(){
		List <Atraccion> atracciones = new LinkedList<Atraccion>(atraccionesDePromo);
		atracciones.add(atraccionRegalo);
		return atracciones;
	}
	
}
