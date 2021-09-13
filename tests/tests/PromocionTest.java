package tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import tpTurismoEnLaTierraMedia.AdministradorDeArchivos;
import tpTurismoEnLaTierraMedia.Atraccion;
import tpTurismoEnLaTierraMedia.Promocion;
import tpTurismoEnLaTierraMedia.PromocionesAbsolutas;
import tpTurismoEnLaTierraMedia.PromocionesAxB;
import tpTurismoEnLaTierraMedia.PromocionesPorcentuales;
import tpTurismoEnLaTierraMedia.TIPO;



public class PromocionTest  {

		Atraccion moria;
		Atraccion mordor;
		Atraccion bosqueNegro;
		Atraccion minasTirith;
		Atraccion laComarca;
		Atraccion abismoDeHelm;
		Atraccion Lothlorien;
		Atraccion erebor;
		Atraccion atraccionRegalo;

		List<Atraccion> atracciones;
		List<Atraccion> atraccionesAxB;
		List<Atraccion> atraccionesAbs;


	@Before
	public void crearListaPromociones() {
		Atraccion moria = new Atraccion("Moria", 10, 2, 6, TIPO.AVENTURA);
		Atraccion mordor = new Atraccion("Mordor", 25, 3, 4, TIPO.AVENTURA);
		Atraccion bosqueNegro = new Atraccion("Bosque Negro", 3, 4, 12, TIPO.AVENTURA);
		Atraccion minasTirith = new Atraccion("Minas Tirith", 5, 2.5, 2, TIPO.PAISAJE);
		Atraccion laComarca = new Atraccion("La Comarca", 3, 6.5, 150, TIPO.DEGUSTACION);
		Atraccion abismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TIPO.PAISAJE);
		Atraccion Lothlorien = new Atraccion("Lothlorien", 35,1, 3, TIPO.DEGUSTACION);
		Atraccion erebor = new Atraccion("Erebor",12, 3, 32, TIPO.PAISAJE);

		atracciones = new LinkedList<Atraccion>();
		atracciones.add (mordor);	
		atracciones.add(moria);
		atracciones.add(bosqueNegro);

		atraccionesAxB = new LinkedList<Atraccion>();
		atraccionesAxB.add(minasTirith);
		atraccionesAxB.add(abismoDeHelm);

		 atraccionesAbs = new LinkedList<Atraccion>();
		 atraccionesAbs.add(laComarca);
		 atraccionesAbs.add(Lothlorien);
	}

	@Test
	public void promosProcentualesTest() {

		Promocion promo = new PromocionesPorcentuales(TIPO.AVENTURA, atracciones,  20);

		assertEquals(30.4 , promo.getCosto(), 0.001);
		assertEquals(TIPO.AVENTURA, promo.getTipoAtraccion());
		assertEquals(9, promo.getTiempoTotal(), 0.001);

		assertTrue(promo.esPromo());
		assertTrue(promo.hayCupo());
	}

	@Test
	public void restaCupoProcentualesTest() {
		Atraccion mordor = new Atraccion("Mordor", 25, 3, 4, TIPO.AVENTURA);
		Promocion promo = new PromocionesPorcentuales(TIPO.AVENTURA, atracciones,  20);

		promo.restarCupo();
		promo.restarCupo();
		promo.restarCupo();

		assertTrue(promo.hayCupo());


	}

	@Test
	public void promosAxBTest() {
		Atraccion erebor = new Atraccion("Erebor",12, 3, 32, TIPO.PAISAJE);
		Atraccion atraccionRegalo = erebor;

		Promocion promoAxB = new PromocionesAxB(TIPO.PAISAJE, atraccionesAxB, atraccionRegalo);
		assertEquals(10 , promoAxB.getCosto(), 0.001);
		assertEquals(TIPO.PAISAJE, promoAxB.getTipoAtraccion());
		assertEquals(7.5, promoAxB.getTiempoTotal(), 0.001);

		assertTrue(promoAxB.esPromo());
		assertTrue(promoAxB.hayCupo());
	}

	@Test
	public void restaCupoAxBTest() {
		Atraccion minasTirith = new Atraccion("Minas Tirith", 5, 2.5, 2, TIPO.PAISAJE);


		Atraccion erebor = new Atraccion("Erebor",12, 3, 32, TIPO.PAISAJE);
		Atraccion atraccionRegalo = erebor;

	Promocion promoAxB = new PromocionesAxB(TIPO.PAISAJE, atraccionesAxB,  atraccionRegalo);

	   promoAxB.restarCupo();
	   promoAxB.restarCupo();
		promoAxB.restarCupo();

		minasTirith.restarCupo();

		assertEquals(1, minasTirith.getCupo());

		erebor.restarCupo();

		assertEquals(28, erebor.getCupo());


	}

	@Test
	public void promosAbsTest() {


		Promocion promoAbs = new PromocionesAbsolutas(TIPO.DEGUSTACION, atraccionesAbs, 36);
		assertEquals(36 , promoAbs.getCosto(), 0.001);
		assertEquals(TIPO.DEGUSTACION, promoAbs.getTipoAtraccion());
		assertEquals(7.5, promoAbs.getTiempoTotal(), 0.001);

		assertTrue(promoAbs.esPromo());
		assertTrue(promoAbs.hayCupo());
	}

	@Test
	public void restaCupoAbsTest() {
		Atraccion Lothlorien = new Atraccion("Lothlorien", 35,1, 3, TIPO.DEGUSTACION);

		Promocion promoAbs = new PromocionesAbsolutas(TIPO.DEGUSTACION, atraccionesAbs, 36);

	    promoAbs.restarCupo();
	    promoAbs.restarCupo();

	   assertTrue(promoAbs.hayCupo());

	}

	@Test
	public void lecturaArchivoPromoTest() {
		List<Promocion> promosArchivo = new LinkedList<Promocion>();

		promosArchivo = AdministradorDeArchivos.getPromociones("files/promociones.txt");

		assertNotNull(promosArchivo);


	}

}