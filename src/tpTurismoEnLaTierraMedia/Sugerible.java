package turismoEnLaTierraMedia;

public interface Sugerible {

	public double promedioDeTiempo= 0;
	public static final TIPO tipoAtraccion = null;
	public int costo = 0;
	
	
	
	
	public static int getCosto(int monedas) {
		int costo = monedas;
		 return costo;
		}
	
	public static double getPromedioDeTiempo(double tiempo) {
		double promedioDeTiempo = tiempo;
		return promedioDeTiempo;
	}
	
	public static TIPO getTipoAtraccion() {
		return tipoAtraccion;
	}
	
}
