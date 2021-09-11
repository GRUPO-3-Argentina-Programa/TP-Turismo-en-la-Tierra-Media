package tpTurismoEnLaTierraMedia;

import java.util.List;

public interface Sugerible {
	
	public String getNombre();
	
	public double getCosto();
	
	public double getTiempoTotal();
	
	public TIPO getTipoAtraccion();
	
	public boolean hayCupo();
	
	public boolean esPromo();
	
	public void restarCupo();
	
	public List<Atraccion> getAtracciones();
	
	public String[] getNombresDeAtracciones();
	
	//System.out.println(String.format("%.4f", inversionesAnuales[j]));

//	public void sugerenciaAcepatada();

}
