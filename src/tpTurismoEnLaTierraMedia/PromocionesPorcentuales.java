package tpTurismoEnLaTierraMedia;



public class PromocionesPorcentuales extends Promocion{

	double porcentaje;
	
		public PromocionesPorcentuales(TIPO valueOf,String nombre , Atraccion[] atraccionesDePromo, double porcentaje) {
		super(valueOf, nombre, atraccionesDePromo);
			
		this.porcentaje = porcentaje;
		
	}
	
	@Override
	public double getPromedioDeTiempo() {
		return 0;
	}

	@Override
	public double getCosto() {
		return 0;
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
	
	