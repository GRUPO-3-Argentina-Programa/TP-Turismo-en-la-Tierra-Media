package tpTurismoEnLaTierraMedia;

public abstract class Promocion implements Sugerible{
	protected Atraccion[] atraccion;
	protected TIPO tipoAtraccion;
	protected int tiempo;
	protected int cupo;
	private String nombre;
	
	// to do constructor 
	public Promocion(TIPO tipo, String nombre, Atraccion[] atracciones) {
		this.tipoAtraccion = tipo;
		this.atraccion = atracciones;
		this.nombre = nombre;
	}
	
	public TIPO getTipoAtraccion() {
		return tipoAtraccion;
	}
	
	public Atraccion[] getAtracciones(){
		return this.atraccion;
	}
	
	

}
