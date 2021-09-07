package tests;

import static org.junit.Assert.*;

import java.util. *;

import org.junit.Test;

import tpTurismoEnLaTierraMedia.AdministradorDeArchivos;
import tpTurismoEnLaTierraMedia.Promocion;

public class getPromocionesTest {

	@Test
	public void test() {
		List<Promocion> promos = new LinkedList<Promocion>();
		promos = AdministradorDeArchivos.getPromociones("/files/promociones.txt");
		
		assertNotNull(promos);
	}

}
