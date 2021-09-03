package tpTurismoEnLaTierraMedia;

public abstract class Promocion implements Sugerible{
	private Atraccion[] atraccion;
	private TIPO tipoAtraccion;
	private int tiempo;
	private int cupo;
	
	
	public TIPO getTipoAtraccion() {
		return tipoAtraccion;
	}

}
