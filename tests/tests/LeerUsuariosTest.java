package tests;

import static org.junit.Assert.*;

import java.util. *;

import org.junit. *;

import tpTurismoEnLaTierraMedia. *;


public class LeerUsuariosTest {

	@Before
	public void setUp() {
		List<Usuario> usuarios;
	}
	
	@Test
	public void queLeeUnArchivo() {
		List<Usuario> usuarios = new LinkedList<Usuario>();
		
		usuarios = AdministradorDeArchivos.getUsuarios("files/usuarios.txt");
		
		assertNotNull(usuarios);
	}
	
	@Test
	public void queLeeTodasLasLineas() {
		List<Usuario> usuarios = new LinkedList<Usuario>();
		
		usuarios = AdministradorDeArchivos.getUsuarios("files/usuarios.txt");
		
		assertEquals(4, usuarios.size());
	}

}
