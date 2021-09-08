package tpTurismoEnLaTierraMedia;

import java.util.*;

public class Promocion implements Sugerible {
	protected List<Atraccion> atraccionesDePromo;
	protected TIPO tipoAtraccion;
	protected int cupo;
	protected double tiempoTotal;
	protected double sumaCostos;
	protected String[] nombresDeAtracciones;

	public Promocion(TIPO tipo, List<Atraccion> atraccionesDePromo) {
		this.tipoAtraccion = tipo;
		this.atraccionesDePromo = new LinkedList<Atraccion>(atraccionesDePromo);
		
	}

	public TIPO getTipoAtraccion() {
		return tipoAtraccion;
	}

	public List<Atraccion> getAtracciones() {
		return atraccionesDePromo;
	}

	public double getTiempoTotal() {
		for (Atraccion a : this.atraccionesDePromo)
			tiempoTotal += a.getTiempoTotal();

		return tiempoTotal;
	}

	public double getCosto() {
		for (Atraccion a : atraccionesDePromo) {
			sumaCostos += a.getCosto();
		}
		return sumaCostos;
	}

	@Override
	public boolean esPromo() {
		return true;
	}

	public void restarCupo() {
		Iterator<Atraccion> itr = this.atraccionesDePromo.iterator();
		while (itr.hasNext())
			itr.next().restarCupo();
	}

	public boolean hayCupo() {
		Iterator<Atraccion> itr = this.atraccionesDePromo.iterator();
		while (itr.hasNext())
			if (!itr.next().hayCupo())
				return false;
		return true;
	}

	// to do
	public String[] getNombresDeAtracciones() {
		int size = this.atraccionesDePromo.size();
		for (int i = 0; i < size; i++)
			nombresDeAtracciones[i] = atraccionesDePromo.get(i).getNombre();
		return nombresDeAtracciones;
	}

	@Override
	public String getNombre() {
		return null;
	}

	@Override
	public String toString() {

		// ver como obtener solo nombres de las atracciones!!
		return "Promocion incluye " + nombresDeAtracciones + "\nTipo de Atracciones=" + tipoAtraccion
				+ "\nCosto Total= " + sumaCostos + "\nTiempo Total=" + tiempoTotal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(atraccionesDePromo, cupo, sumaCostos, tiempoTotal, tipoAtraccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promocion other = (Promocion) obj;
		return Objects.equals(atraccionesDePromo, other.atraccionesDePromo) && cupo == other.cupo
				&& Double.doubleToLongBits(sumaCostos) == Double.doubleToLongBits(other.sumaCostos)
				&& Double.doubleToLongBits(tiempoTotal) == Double.doubleToLongBits(other.tiempoTotal)
				&& tipoAtraccion == other.tipoAtraccion;
	}

	@Override
	public void sugerenciaAcepatada() {
		for (Atraccion a : atraccionesDePromo)
			a.restarCupo();
	}

}
