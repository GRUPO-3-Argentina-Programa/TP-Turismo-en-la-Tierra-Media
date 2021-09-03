package tpTurismoEnLaTierraMedia;
import java.util.Comparator;

public class TipoComparator implements Comparator<Atraccion>{
	
	@Override
	public int compare(Atraccion o1, Atraccion o2) {
		return o1.getTipoAtraccion().compareTo(o2.getTipoAtraccion());
	}
}
