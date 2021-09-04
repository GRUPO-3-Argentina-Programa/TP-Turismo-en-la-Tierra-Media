package tpTurismoEnLaTierraMedia;

import java.util.Objects;

public class Usuario {
	
	private String nombre;
	private int presupuesto;
	private double tiempoDisponible;
	private String tipoDeAtraccionPreferida;
	
	public Usuario(String nombre, int presupuesto, double tiempoDisponible, String tipoDeAtraccionPreferida) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoDeAtraccionPreferida = tipoDeAtraccionPreferida;
	}
	
	public void aceptarSugerencia(Sugerible sugerencia) {
		return;
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
	
	
	

}
