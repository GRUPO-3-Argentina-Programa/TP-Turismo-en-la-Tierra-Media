package tpTurismoEnLaTierraMedia;

import java.util.Comparator;

public class TiempoComparator implements Comparator<Atraccion>{
	
	@Override
	public int compare(Atraccion a1, Atraccion a2) {
		return Double.compare(a1.getPromedioDeTiempo(), a2.getPromedioDeTiempo());
	}

}
