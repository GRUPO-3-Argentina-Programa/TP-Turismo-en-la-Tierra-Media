package tests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tpTurismoEnLaTierraMedia.Atraccion;
import tpTurismoEnLaTierraMedia.ComparadorDeSugerencias;
import tpTurismoEnLaTierraMedia.Promocion;
import tpTurismoEnLaTierraMedia.PromocionPorcentual;
import tpTurismoEnLaTierraMedia.Sugerible;
import tpTurismoEnLaTierraMedia.TIPO;

public class Comparador {

	Atraccion moria;
	Atraccion mordor;
	Atraccion bosqueNegro;
	Atraccion minasTirith;
	Atraccion laComarca;
	Atraccion abismoDeHelm;
	Atraccion lothlorien;
	Atraccion erebor;
	Atraccion atraccionRegalo;
	Atraccion carretaFantasma;
	Atraccion castilloEmbrujado;
	Atraccion bosqueTenebroso;

	Promocion promoPorcentual;
	Promocion promoAxB;
	Promocion promoAbs;

	@Before
	public void setUp() {

		moria = new Atraccion("Moria", 10, 2, 6, TIPO.AVENTURA);
		mordor = new Atraccion("Mordor", 25, 3, 4, TIPO.AVENTURA);
		bosqueNegro = new Atraccion("Bosque Negro", 3, 4, 12, TIPO.AVENTURA);
		minasTirith = new Atraccion("Minas Tirith", 5, 2.5, 2, TIPO.PAISAJE);
		laComarca = new Atraccion("La Comarca", 3, 6.5, 150, TIPO.DEGUSTACION);
		abismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TIPO.PAISAJE);
		lothlorien = new Atraccion("Lothlorien", 35, 1, 3, TIPO.DEGUSTACION);
		erebor = new Atraccion("Erebor", 12, 3, 32, TIPO.PAISAJE);
		carretaFantasma = new Atraccion("Carreta Fantasma", 8, 4, 25, TIPO.TERROR);
		castilloEmbrujado = new Atraccion("Castillo Embrujado", 10, 3.5, 4, TIPO.TERROR);
		bosqueTenebroso = new Atraccion("Bosque Tenebroso", 6, 4.5, 10, TIPO.TERROR);

		List<Atraccion> atraccionesDePromo = new LinkedList<Atraccion>();
		atraccionesDePromo.add(mordor);
		atraccionesDePromo.add(bosqueNegro);
		promoPorcentual = new PromocionPorcentual(TIPO.AVENTURA, atraccionesDePromo, 20);

		List<Sugerible> promoAbsoluta = new LinkedList<Sugerible>();
		promoAbsoluta.add(laComarca);
		promoAbsoluta.add(lothlorien);

	}

	@Test
	public void test() {

		List<Sugerible> listaEsperada = new LinkedList<Sugerible>();
		List<Sugerible> otraLista = new LinkedList<Sugerible>();
		// Se agregan las sugerencias esperadas de acuerdo al criterio ingresado.
		listaEsperada.add(castilloEmbrujado);
		listaEsperada.add(carretaFantasma);
		listaEsperada.add(bosqueTenebroso);
		listaEsperada.add(promoPorcentual);
		listaEsperada.add(lothlorien);
		listaEsperada.add(mordor);
		listaEsperada.add(erebor);
		listaEsperada.add(moria);
		listaEsperada.add(minasTirith);
		listaEsperada.add(abismoDeHelm);
		listaEsperada.add(laComarca);
		listaEsperada.add(bosqueNegro);

		// Lista desordenada.
		otraLista.add(abismoDeHelm);
		otraLista.add(promoPorcentual);
		otraLista.add(laComarca);
		otraLista.add(mordor);
		otraLista.add(moria);
		otraLista.add(minasTirith);
		otraLista.add(bosqueNegro);
		otraLista.add(erebor);
		otraLista.add(lothlorien);
		otraLista.add(bosqueTenebroso);
		otraLista.add(carretaFantasma);
		otraLista.add(castilloEmbrujado);
		otraLista.sort(new ComparadorDeSugerencias(TIPO.TERROR));
		assertEquals(listaEsperada, otraLista);

	}

}
