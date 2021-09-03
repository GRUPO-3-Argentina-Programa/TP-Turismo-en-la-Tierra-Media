package tpTurismoEnLaTierraMedia;



public class PromocionesPorcentuales extends Promocion{

	public PromocionesPorcentuales(Atraccion a, Atraccion b, double porcentaje) {
		this.a = a;
		this.b = b;
		this.porcentaje = porcentaje;
	}

	static Atraccion a;
	static Atraccion b;
	
	double porcentaje;
	
	
	
	@Override
	public double getPromedioDeTiempo() {
		return a.getPromedioDeTiempo() + b.getPromedioDeTiempo();
	}

	@Override
	public double getCosto() {
		if (b.getTipoAtraccion().equals(a.getTipoAtraccion()))
			return ((a.getCosto() + b.getCosto())*(1-porcentaje));
	 else
		 throw new Error("Las atracciones deben ser desde mismo tipo");
	}
	
}
	
	