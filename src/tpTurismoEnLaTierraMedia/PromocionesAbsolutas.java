package tpTurismoEnLaTierraMedia;

public class PromocionesAbsolutas extends Promocion{
	private double precio;

	public PromocionesAbsolutas(TIPO valueOf, String nombre, Atraccion[] atraccionesDePromo, double precio) {
		super(valueOf, nombre, atraccionesDePromo);
		
		this.precio = precio;
	}

	@Override
	public double getCosto() {
		return precio;
	}

	@Override
	public double getPromedioDeTiempo() {
		// TODO Auto-generated method stub
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
