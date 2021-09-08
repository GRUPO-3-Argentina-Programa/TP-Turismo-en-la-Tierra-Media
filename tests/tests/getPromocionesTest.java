package tests;

import static org.junit.Assert.*;

import java.util. *;

import org.junit.Test;

import tpTurismoEnLaTierraMedia.AdministradorDeArchivos;
import tpTurismoEnLaTierraMedia.Promocion;
import tpTurismoEnLaTierraMedia.Usuario;

public class getPromocionesTest {

	@Test
	public void test() {
		List<Promocion> promos = new LinkedList<Promocion>();
		promos = AdministradorDeArchivos.getPromociones("files/promociones.txt");
		
		assertNotNull(promos);
	}

	@Test
	public void queLeeTodasLasLineas() {
		List<Promocion> promociones = new LinkedList<Promocion>();
		
		promociones = AdministradorDeArchivos.getPromociones("files/promociones.txt");
		
		assertEquals(3, promociones.size());
	}
}
