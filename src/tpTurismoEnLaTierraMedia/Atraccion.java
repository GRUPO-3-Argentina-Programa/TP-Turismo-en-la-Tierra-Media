package tpTurismoEnLaTierraMedia;

public class Atraccion {
	private int costeDeVisita;
	private double promedioDeTiempo;
	private int cupoDePersonas;
	private TIPO tipo;
	private String nombre;
	
	public Atraccion(String nombre, TIPO tipo, int costeDeVisita, double promedioDeTiempo, int cuposDePersonas) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.costeDeVisita = costeDeVisita;
		this.promedioDeTiempo = promedioDeTiempo;
		this.cupoDePersonas = cuposDePersonas;
	}

}
