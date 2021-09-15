package tests;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import tpTurismoEnLaTierraMedia.*;

public class UsuariosTest {

	private List<Usuario> usuarios;
	private Usuario u1;
	private Sugerible s1;
	private Sugerible s2;
	private Sugerible s3;

	@Before
	public void setUp() {
		usuarios = new LinkedList<Usuario>();
		usuarios = AdministradorDeArchivos.getUsuarios("files/usuarios.txt");
		u1 = new Usuario("u1", 100, 80, TIPO.AVENTURA);

		s1 = new Atraccion("Moria", 10, 2, 6, TIPO.AVENTURA);
		s2 = new Atraccion("Moria", 80, 81, 6, TIPO.AVENTURA);
		s3 = new Atraccion("Moria", 101, 2, 6, TIPO.AVENTURA);
	}

	@Test
	public void queLeeArchivo() {
		assertNotNull(usuarios);
	}

	@Test
	public void queLeeTodasLasLineas() {
		assertEquals(5, usuarios.size());
	}

	@Test
	public void queAceptaSugerencia() {

		u1.aceptarSugerencia(s1);

		assertEquals(90, u1.getPresupuesto(), 0.01);
		assertEquals(78, u1.getTiempoDisponible(), 0.01);
	}

	@Test
	public void quePuedeComprar() {

		assertTrue(u1.puedeComprar(s1));
		assertFalse(u1.puedeComprar(s2));
		assertFalse(u1.puedeComprar(s3));

	}

}
