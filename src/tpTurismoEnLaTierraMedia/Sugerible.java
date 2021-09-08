package tpTurismoEnLaTierraMedia;

public interface Sugerible {
	
	public String getNombre();
	
	public double getCosto();
	
	public double getTiempoTotal();
	
	public TIPO getTipoAtraccion();
	
	public boolean hayCupo();
	
	public boolean esPromo();
	
	public void restarCupo();

	public void sugerenciaAcepatada();

}
