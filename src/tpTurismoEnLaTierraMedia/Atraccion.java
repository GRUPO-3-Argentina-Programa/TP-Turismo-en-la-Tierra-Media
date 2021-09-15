package tpTurismoEnLaTierraMedia;

import java.util.List;
import java.util.Objects;

public class Atraccion implements Sugerible {
	private int costeDeVisita;
	private double promedioDeTiempo;
	private int cupoDePersonas;
	private TIPO tipo;
	private String nombre;

	public Atraccion(String nombre, int costeDeVisita, double promedioDeTiempo, int cuposDePersonas, TIPO tipo) {
		this.nombre = nombre;
		this.costeDeVisita = costeDeVisita;
		this.promedioDeTiempo = promedioDeTiempo;
		this.cupoDePersonas = cuposDePersonas;
		this.tipo = tipo;
	}

	public TIPO getTipoAtraccion() {
		return tipo;
	}

	public double getCosto() {
		return costeDeVisita;
	}

	@Override
	public String toString() {
		return "\n Atraccion: " + nombre + ", Costo: " + costeDeVisita + ", Tiempo: " + promedioDeTiempo + ", Tipo: "
				+ tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(costeDeVisita, cupoDePersonas, nombre, promedioDeTiempo, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return costeDeVisita == other.costeDeVisita && cupoDePersonas == other.cupoDePersonas
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(promedioDeTiempo) == Double.doubleToLongBits(other.promedioDeTiempo)
				&& tipo == other.tipo;
	}

	@Override
	public double getTiempoTotal() {
		return promedioDeTiempo;
	}

	public int getCupo() {
		return this.cupoDePersonas;
	}

	public void restarCupo() {
		this.cupoDePersonas--;
	}

	public String getNombre() {
		return this.nombre;
	}

	@Override
	public boolean hayCupo() {
		return (this.getCupo() >= 1);
	}

	@Override
	public boolean esPromo() {
		return false;
	}

	@Override
	public List<Atraccion> getAtracciones() {
		return null;
	}

	@Override
	public String[] getNombresDeAtracciones() {
		return null;
	}

}
