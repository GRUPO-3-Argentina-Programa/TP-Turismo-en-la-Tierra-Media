package tpTurismoEnLaTierraMedia;

public interface Sugerible {
	
	public String getNombre();
	
	public double getCosto();
	
	public double getPromedioDeTiempo();
	
	public TIPO getTipoAtraccion();
	
	public boolean hayCupo();
	
	public boolean esPromo();
	
	public Atraccion[] getAtracciones();
	
}
