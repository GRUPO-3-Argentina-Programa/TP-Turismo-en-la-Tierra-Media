package tpTurismoEnLaTierraMedia;

import java.util. *;

public class Usuario {
	
	private String nombre;
	private double presupuesto;
	private double tiempoDisponible;
	private TIPO tipoDeAtraccionPreferida;
	protected List<Sugerible> itinerario;
	
	public Usuario(String nombre, int presupuesto, double tiempoDisponible,TIPO tipoDeAtraccionPreferida) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoDeAtraccionPreferida = tipoDeAtraccionPreferida;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double getTiempoDisponible() {
		return this.tiempoDisponible;
	}

	public double getPresupuesto() {
		return this.presupuesto;
	}
	
	public TIPO getTipo() {
		return this.tipoDeAtraccionPreferida;
	}
	
	public List<Sugerible> getItinerario(){
		return this.itinerario;
	}
	
	public void aceptarSugerencia(Sugerible sugerencia) {
		this.itinerario.add(sugerencia);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, presupuesto, tiempoDisponible, tipoDeAtraccionPreferida);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nombre, other.nombre) && presupuesto == other.presupuesto
				&& Double.doubleToLongBits(tiempoDisponible) == Double.doubleToLongBits(other.tiempoDisponible)
				&& tipoDeAtraccionPreferida == other.tipoDeAtraccionPreferida;
	}
	
	public boolean puedeComprar(Sugerible sugerencia) {
		return (sugerencia.getCosto() <= this.presupuesto &&
				sugerencia.getPromedioDeTiempo() <= this.tiempoDisponible
				&& noEstaIncluido(sugerencia));
	}

	private boolean noEstaIncluido(Sugerible sugerencia) {
			
		if (sugerencia.esPromo()) {
			for (Atraccion a : ((Promocion) sugerencia).getAtracciones())
				if (itinerario.contains(a))
					return false;
			}
		else
			return (itinerario.contains(sugerencia));
		
		return true;
	}


	public void setPresupuesto(double costo) {
		this.presupuesto -= costo;		
	}

	public void setTiempoDisponible(double promedioDeTiempo) {
		this.tiempoDisponible -= promedioDeTiempo;
		
	}

	@Override
	public String toString() {
		return "Usuario [Nombre= " + nombre + ", presupuesto = " + presupuesto + ", "
				+ "Tiempo Disponible = " + tiempoDisponible
				+ ", Preferencia = " + tipoDeAtraccionPreferida + "]";
	}
	
}
