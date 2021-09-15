package tests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import tpTurismoEnLaTierraMedia.AdministradorDeArchivos;
import tpTurismoEnLaTierraMedia.Atraccion;
import tpTurismoEnLaTierraMedia.TIPO;

public class AtraccionesTest {
	Atraccion Moria;
	List<Atraccion> atracciones;

	@Test
	public void constructorDeAtraccionesTest() {
		Moria = new Atraccion("Moria", 10, 2, 6, TIPO.AVENTURA);

		assertNotNull(Moria);
	}

	@Test
	public void queLasCreaCorrectamenteTest() {
		Moria = new Atraccion("Moria", 10, 2, 6, TIPO.AVENTURA);

		assertEquals("Moria", Moria.getNombre());
		assertEquals(10, Moria.getCosto(), 0);
		assertEquals(2, Moria.getTiempoTotal(), 0);
		assertEquals(6, Moria.getCupo(), 0);
		assertEquals(TIPO.AVENTURA, Moria.getTipoAtraccion());
	}

	@Test
	public void hayCupoTest() {
		Moria = new Atraccion("Moria", 10, 2, 1, TIPO.AVENTURA);

		assertTrue(Moria.hayCupo());

		Moria.restarCupo();

		assertFalse(Moria.hayCupo());
	}

	@Test
	public void leerAtraccionesTest() {
		atracciones = new LinkedList<Atraccion>();

		atracciones = AdministradorDeArchivos.leerAtracciones();

		assertNotNull(atracciones);
	}

	@Test
	public void queCreaTodasLasAtraccionesTest() {
		atracciones = new LinkedList<Atraccion>();

		atracciones = AdministradorDeArchivos.leerAtracciones();

		assertEquals(11, atracciones.size());
	}

}
