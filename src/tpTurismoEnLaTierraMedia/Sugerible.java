package tpTurismoEnLaTierraMedia;

public interface Sugerible {
	
	public String getNombre();
	
	public double getCosto();
	
	public double getTiempoTotal();
	
	public TIPO getTipoAtraccion();
	
	public boolean hayCupo();
	
	public boolean esPromo();
	
	public void restarCupo();
	
	//System.out.println(String.format("%.4f", inversionesAnuales[j]));

//	public void sugerenciaAcepatada();

}
