package tests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tpTurismoEnLaTierraMedia.AdministradorDeArchivos;
import tpTurismoEnLaTierraMedia.Atraccion;
import tpTurismoEnLaTierraMedia.ComparadorDeSugerencias;
import tpTurismoEnLaTierraMedia.Promocion;
import tpTurismoEnLaTierraMedia.PromocionesPorcentuales;
import tpTurismoEnLaTierraMedia.Sugerible;
import tpTurismoEnLaTierraMedia.TIPO;
import tpTurismoEnLaTierraMedia.Usuario;

public class Comparador {

	Atraccion moria;
	Atraccion mordor;
	Atraccion bosqueNegro;
	Atraccion minasTirith;
	Atraccion laComarca;
	Atraccion abismoDeHelm;
	Atraccion Lothlorien;
	Atraccion erebor;
	Atraccion atraccionRegalo;
	
	Promocion promoPorcentual;
	Promocion promoAxB;
	Promocion promoAbs;
	private List<Usuario> usuarios;
	private Usuario u1;
	
	@Before
	public void setUp() {
		
		moria = new Atraccion("Moria", 10, 2, 6, TIPO.AVENTURA);
		mordor = new Atraccion("Mordor", 25, 3, 4, TIPO.AVENTURA);
		bosqueNegro = new Atraccion("Bosque Negro", 3, 4, 12, TIPO.AVENTURA);
		minasTirith = new Atraccion("Minas Tirith", 5, 2.5, 2, TIPO.PAISAJE);
		laComarca = new Atraccion("La Comarca", 3, 6.5, 150, TIPO.DEGUSTACION);
		abismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TIPO.PAISAJE);
		Lothlorien = new Atraccion("Lothlorien", 35,1, 3, TIPO.DEGUSTACION);
		erebor = new Atraccion("Erebor",12, 3, 32, TIPO.PAISAJE);
		
		List<Atraccion> atraccionesDePromo = new LinkedList<Atraccion>();
		atraccionesDePromo.add (mordor);	
		atraccionesDePromo.add(bosqueNegro);
		promoPorcentual = new PromocionesPorcentuales(TIPO.AVENTURA, atraccionesDePromo, 20);
		
//		promoAxB = new LinkedList<Atraccion>();
//		promoAxB.add(minasTirith);
//		promoAxB.add(abismoDeHelm);
//		
		List<Sugerible> promoAbsoluta = new LinkedList<Sugerible>();
		promoAbsoluta.add(laComarca);
		promoAbsoluta.add(Lothlorien);
		//promoAbs = new PromocionesAbsolutas(iPO:)
		
		usuarios = new LinkedList<Usuario>();
		usuarios = AdministradorDeArchivos.getUsuarios("files/usuarios.txt");
		u1 = usuarios.get(0);
	}
	
	@Test
	public void test() {
		
		List<Sugerible> listaEsperada = new LinkedList<Sugerible>();
		List<Sugerible> otraLista = new LinkedList<Sugerible>();
		listaEsperada.add(promoPorcentual);
		listaEsperada.add(abismoDeHelm);
		listaEsperada.add(abismoDeHelm);
		listaEsperada.add(laComarca);
		otraLista.add(abismoDeHelm);
		otraLista.add(promoPorcentual);
		otraLista.add(laComarca);
		otraLista.add(abismoDeHelm);	
		otraLista.sort(new ComparadorDeSugerencias(TIPO.AVENTURA));
		System.out.println(otraLista);
		assertEquals(listaEsperada, otraLista);
		
	}

}
