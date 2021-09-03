package tpTurismoEnLaTierraMedia;

public class Usuario {
	private int presupuesto;
	private double tiempoDisponible;
	private TIPO tipoDeAtraccionPreferida;
	
	public Usuario(int presupuesto, double tiempoDisponible, TIPO tipoDeAtraccionPreferida) {
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoDeAtraccionPreferida = tipoDeAtraccionPreferida;
	}
	
	public void aceptarSugerencia(Sugerible sugerencia) {
		return;
	}
	
	

}
