package tpTurismoEnLaTierraMedia;
import java.util.Comparator;

public class CostoComparator implements Comparator<Atraccion>{
	
	@Override
	public int compare(Atraccion o1, Atraccion o2) {
		return Integer.compare(o1.getCosto(), o2.getCosto());	
	}
}
