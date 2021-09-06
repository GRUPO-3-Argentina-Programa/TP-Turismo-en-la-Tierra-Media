package tpTurismoEnLaTierraMedia;

public class PromocionesAxB extends Promocion implements Sugerible {
		
	public PromocionesAxB(TIPO valueOf, String nombre, Atraccion[] atraccionesDePromo) {
		super(valueOf, nombre, atraccionesDePromo);
		
		this.tipoAtraccion = valueOf;
		this.atraccion = atraccionesDePromo;
	}

	public double getPromedioDeTiempo() {
		return 0;
		//return a.getPromedioDeTiempo() + b.getPromedioDeTiempo() + gratuita.getPromedioDeTiempo();
	}

	public double getCosto() {
		return 0;
		//if (b.getTipoAtraccion().equals(a.getTipoAtraccion()))
		//	return a.getCosto() + b.getCosto();
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hayCupo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean esPromo() {
		// TODO Auto-generated method stub
		return false;
	}
	

	    
		
		
		
	
	
}
