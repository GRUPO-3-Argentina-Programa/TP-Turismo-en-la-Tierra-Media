package tpTurismoEnLaTierraMedia;

import java.util.List;

public interface Sugerible {
	
	public String getNombre();
	
	public double getCosto();
	
	public double getPromedioDeTiempo();
	
	public TIPO getTipoAtraccion();
	
	public boolean hayCupo();
	
	public boolean esPromo();
	
	public void restarCupo();

	//public List<Atraccion> getAtracciones();
	
}
