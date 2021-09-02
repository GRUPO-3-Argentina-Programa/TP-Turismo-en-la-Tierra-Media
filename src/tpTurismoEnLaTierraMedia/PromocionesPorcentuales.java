package turismoEnLaTierraMedia;



public class PromocionesPorcentuales extends Atracciones{

	public PromocionesPorcentuales(int costo, double tiempo, int cupo, TIPO tipo) {
		super(costo, tiempo, cupo, tipo);
		// TODO Auto-generated constructor stub
	}


	static Atracciones a;
	static Atracciones b;
	
	double porcentaje;
	
	
	protected double precioPromo(Atracciones a, Atracciones b) {
	 if (Atracciones.getTipo().equals(Atracciones.getTipo()))
			return (a.getCostoDeVisita() + b.getCostoDeVisita())*(1-porcentaje);
	 else
		 throw new Error("Las atracciones deben ser desde mismo tipo");
	} 
}
	
	