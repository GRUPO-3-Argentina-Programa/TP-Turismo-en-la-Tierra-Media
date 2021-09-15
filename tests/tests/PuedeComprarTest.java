package tests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tpTurismoEnLaTierraMedia.Atraccion;
import tpTurismoEnLaTierraMedia.Promocion;
import tpTurismoEnLaTierraMedia.PromocionAbs;
import tpTurismoEnLaTierraMedia.PromocionAxB;
import tpTurismoEnLaTierraMedia.PromocionPorcentual;
import tpTurismoEnLaTierraMedia.TIPO;
import tpTurismoEnLaTierraMedia.Usuario;

public class PuedeComprarTest {
	Usuario u1;
	Atraccion a1;
	Atraccion a2;
	Atraccion a3;
	Atraccion a4;
			 
	Promocion p1;
	Promocion p2;
	Promocion p3;
	Promocion p4;
	
	List<Atraccion> lista1;
	List<Atraccion> lista2;
	List<Atraccion> lista3;
	List<Atraccion> lista4;

	@Before
	public void setUp() throws Exception {
		
		
		u1 = new Usuario("pepito", 100, 100, TIPO.AVENTURA);
		a1 = new Atraccion("a1",10 ,3 , 5, TIPO.AVENTURA);
		a2 = new Atraccion("a2", 4, 2.5, 10, TIPO.AVENTURA);
		a3 = new Atraccion("a3", 2, 1, 12, TIPO.AVENTURA);
		a4 = new Atraccion("a4", 8, 4, 15, TIPO.AVENTURA);
		
		lista1 = new LinkedList<Atraccion>();
		lista1.add(a1);
		lista1.add(a2);
		
		lista2 = new LinkedList<Atraccion>();
		lista2.add(a1);
		lista2.add(a3);
		
		lista3 = new LinkedList<Atraccion>();
		lista3.add(a1);
		lista3.add(a3);
		
		lista4 = new LinkedList<Atraccion>();
		lista4.add(a2);
		lista4.add(a4);
		
		p1 = new PromocionAbs(TIPO.AVENTURA, lista1, 10);
		p2 = new PromocionPorcentual(TIPO.AVENTURA, lista2, 30);
		p3 = new PromocionAxB(TIPO.AVENTURA, lista3, a2);
		p4 = new PromocionAbs(TIPO.AVENTURA, lista4, 5);
	}

	@Test
	public void test() {
				// Test nro1
				u1.aceptarSugerencia(p1);
				assertFalse(u1.puedeComprar(a2));
				// Test nro1.5 (opcional si una promocion solo tiene atracciones del mismo tipo)
				u1.aceptarSugerencia(a1);
				assertFalse(u1.puedeComprar(p2));
				// Test nro2
				u1.aceptarSugerencia(p1);
				assertFalse(u1.puedeComprar(p2));        
				// Test nro3
				u1.aceptarSugerencia(p3);
				assertFalse(u1.puedeComprar(p4));
	}

}
