package tpTurismoEnLaTierraMedia;

import java.util. *;

public abstract class Promocion implements Sugerible{
	protected List<Atraccion> atraccionesDePromo;
	protected TIPO tipoAtraccion;
	protected int tiempo;
	protected int cupo;
	protected double tiempoTotal;
	

	public Promocion(TIPO tipo, List<Atraccion> atraccionesDePromo) {
		this.tipoAtraccion = tipo;
		Iterator<Atraccion> itr = atraccionesDePromo.iterator();
			while (itr.hasNext()) {
				atraccionesDePromo.add(itr.next());
			}
	}
	
	public TIPO getTipoAtraccion() {
		return tipoAtraccion;
	}
	
	public List<Atraccion> getAtracciones(){
		return atraccionesDePromo;
	}
	
	public double getPromedioDeTiempo() {
		for (Atraccion a : this.atraccionesDePromo)
			tiempoTotal += a.getPromedioDeTiempo();
		
		return tiempoTotal;
	}
	
	@Override
	public boolean esPromo() {
		return true;
	}
	
	public void restarCupo() {
		for(Atraccion a : this.atraccionesDePromo)
			a.restarCupo();
	}
	

	public boolean hayCupo() {
		for (Atraccion a : this.atraccionesDePromo)
			if (!a.hayCupo())
				return false;
		return true;
		
	}
	
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public String toString() {
		return "Promocion [atraccion=" + atraccionesDePromo + ", tipoAtraccion=" + tipoAtraccion + ", "
				+ ", tiempoTotal=" + tiempoTotal + "]";
	}

	

	
}

