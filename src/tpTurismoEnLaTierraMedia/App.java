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

			sugerencias.sort(new ComparadorDeSugerencias(us.getTipo()));
			System.out.println(sugerencias);

			Iterator<Sugerible> sg = sugerencias.iterator();
			Scanner sc = new Scanner(System.in);
			while (sg.hasNext()) {
				Sugerible sug = sg.next();
				if (us.puedeComprar(sug) && sug.hayCupo()) {
					System.out.println("Se sugiere:"+sug.toString() +
							"\n Usuario: " + us.getNombre() +
							" -Presione 1 si acepta sino presione cualquier otro numero");

					if (sc.next().equals("1")) {
						sug.restarCupo();
						us.aceptarSugerencia(sug);
					} 
				}
			}
			System.out.println("El itinerario de "+us.getNombre()+
					" esta formado por:"+ us.itinerario);
		}
		

//			for(Atraccion i : itinerario) System.out.println("Itinerario de "+u.getNombre()+i);
//			System.out.println(u.getTiempoDisponible()+" "+u.getPresupuesto());
//			for(Atraccion a : atracciones) System.out.println(a.getNombre()+"cupo "+a.getCupo());
//				double sumadorTiempo = 0;
//				double sumadorCosto = 0;
//				for(Sugerible s : u.itinerario) {
//					sumadorTiempo += s.getTiempoTotal();
//					sumadorCosto += s.getCosto();
//				}
//			}
//		}
	}
}
