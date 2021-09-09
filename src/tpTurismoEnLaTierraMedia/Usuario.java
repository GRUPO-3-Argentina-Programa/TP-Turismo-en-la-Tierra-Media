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
		this.itinerario = new LinkedList<Sugerible>();
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
		this.setTiempoDisponible(sugerencia.getTiempoTotal());
		this.setPresupuesto(sugerencia.getCosto());
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
				sugerencia.getTiempoTotal() <= this.tiempoDisponible
				&& noEstaIncluido(sugerencia));
	}
	
	// to do correccion
	private boolean noEstaIncluido(Sugerible sugerencia) {
			
		if (sugerencia.esPromo()) {
			for (Atraccion a : ((Promocion) sugerencia).getAtracciones()) {
				for (Sugerible s : itinerario) {
					if (s.esPromo()) {
						if (((Promocion) s).getAtracciones().contains(a))
							return false;
					} else if (s.equals(a))
						return false;
				}
			}
		}
		else {
			for (Sugerible s : itinerario) {
				if (s.esPromo()) {
					if (((Promocion) s).getAtracciones().contains(sugerencia))
						return false;
				} else if (s.equals(sugerencia))
					return false;
			}
		}		
		return true;
	}

	public void setPresupuesto(double costo) {
		this.presupuesto -= costo;		
	}

	public void setTiempoDisponible(double tiempo) {
		this.tiempoDisponible -= tiempo;
		
	}

	@Override
	public String toString() {
		return "Usuario [Nombre= " + nombre + ", presupuesto = " + presupuesto + ", "
				+ "Tiempo Disponible = " + tiempoDisponible
				+ ", Preferencia = " + tipoDeAtraccionPreferida + "]";
	}
	
}
