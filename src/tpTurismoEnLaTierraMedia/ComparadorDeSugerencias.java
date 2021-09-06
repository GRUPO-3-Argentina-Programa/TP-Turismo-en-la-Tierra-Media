package tpTurismoEnLaTierraMedia;

import java.util.Comparator;

public class ComparadorDeSugerencias implements Comparator<Sugerible>{

	private TIPO preferencia;
	
	public ComparadorDeSugerencias(TIPO preferencia) {
		this.preferencia = preferencia;
	}
	
	@Override
	public int compare(Sugerible s1, Sugerible s2) {
		//ordena por preferencia
		if (this.preferencia == s1.getTipoAtraccion() &&
				this.preferencia != s2.getTipoAtraccion())
			return -1;
		else if (this.preferencia != s1.getTipoAtraccion() &&
				this.preferencia == s2.getTipoAtraccion())
			return 1;
		//to do primero promocion
		
		//ordenar por costo
		else if (s1.getCosto() > s2.getCosto())
			return -1;
		else if (s1.getCosto() < s2.getCosto())
			return 1;
		//ordenar por tiempo
		else if (s1.getPromedioDeTiempo() > s2.getPromedioDeTiempo())
			return -1;
		else if (s1.getPromedioDeTiempo() > s2.getPromedioDeTiempo())
			return 1;
		
		else return 0;			
	}
}
