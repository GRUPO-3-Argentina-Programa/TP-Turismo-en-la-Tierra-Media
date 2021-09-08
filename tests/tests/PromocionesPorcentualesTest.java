package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import tpTurismoEnLaTierraMedia.Atraccion;
import tpTurismoEnLaTierraMedia.Promocion;
import tpTurismoEnLaTierraMedia.PromocionesPorcentuales;
import tpTurismoEnLaTierraMedia.TIPO;

public class PromocionesPorcentualesTest {

	

	@Test
	public void gettersTest() {
		Atraccion a = new Atraccion("Rusa", TIPO.AVENTURA, 100, 30, 20);
		Atraccion B = new Atraccion("Tasa", TIPO.AVENTURA, 100, 15, 10);
		
		Promocion PP = new PromocionesPorcentuales(a, B, 0.2);
		
		assertEquals(160, PP.getCosto(), 0.001);
		assertEquals(45, PP.getTiempoTotal(), 0.001);
	}

	@Test (expected = Error.class)
	public void TipoTest()  {
		Atraccion a = new Atraccion("Degu", TIPO.DEGUSTACION , 150, 60, 40);
		Atraccion B = new Atraccion("Tasa", TIPO.AVENTURA, 100, 15, 10);
		
		Promocion PP = new PromocionesPorcentuales(a, B, 0.2);
		
		assertEquals(160, PP.getCosto(), 0.001);
	
	}
}