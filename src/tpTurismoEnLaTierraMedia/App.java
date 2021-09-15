package tpTurismoEnLaTierraMedia;

import java.io.IOException;
import java.util.*;

public class App {

	public static void main(String[] args) throws IOException {

		List<Atraccion> atracciones;
		atracciones = AdministradorDeArchivos.leerAtracciones();

		List<Usuario> usuarios;
		usuarios = AdministradorDeArchivos.getUsuarios("files/usuarios.txt");

		List<Promocion> promociones;
		promociones = AdministradorDeArchivos.getPromociones("files/promociones.txt");

		List<Sugerible> sugerencias = new LinkedList<Sugerible>(atracciones);
		sugerencias.addAll(promociones);

		Iterator<Usuario> u = usuarios.iterator();
		while (u.hasNext()) {

			Usuario us = u.next();
			us.itinerario = new LinkedList<Sugerible>();

			Ofertador ofertador = new Ofertador();
			ofertador.ofertar(us, sugerencias);

		}

		for (Usuario us : usuarios) {
			AdministradorDeArchivos.escribirItinerario(us);
		}

	}
}
