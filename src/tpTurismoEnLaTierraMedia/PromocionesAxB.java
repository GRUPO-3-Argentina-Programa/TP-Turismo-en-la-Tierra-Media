package tpTurismoEnLaTierraMedia;

public class PromocionesAxB extends Promocion implements Sugerible {

	Atraccion a;
	Atraccion b;
	Atraccion gratuita;
	
	public PromocionesAxB(Atraccion a, Atraccion b, Atraccion gratuita) {
			this.a = a;
			this.b = b;
			this.gratuita = gratuita;
		}
	
	public double getPromedioDeTiempo() {
		return a.getPromedioDeTiempo() + b.getPromedioDeTiempo() + gratuita.getPromedioDeTiempo();
	}

	public double getCosto() {
		if (b.getTipoAtraccion().equals(a.getTipoAtraccion()))
			return a.getCosto() + b.getCosto();
	 else
		 throw new Error("Las atracciones deben ser desde mismo tipo");
	}
	

	    
		
		
		
	
	
}
