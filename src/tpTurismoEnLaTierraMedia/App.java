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
			double precioFinal = 0;
			double tiempoFinal = 0;
			Usuario us = u.next();
			us.itinerario = new LinkedList<Sugerible>();

			sugerencias.sort(new ComparadorDeSugerencias(us.getTipo()));
			//System.out.println(sugerencias);

			Iterator<Sugerible> sg = sugerencias.iterator();
			Scanner sc = new Scanner(System.in);
			while (sg.hasNext()) {
				Sugerible sug = sg.next();
				
				if (us.puedeComprar(sug) && sug.hayCupo()) {
					System.out.println("\n Usuario: " + us.getNombre() + ", tiempo disponible: "+ us.getTiempoDisponible() +
							", presupuesto disponible: "+ String.format("%.2f", us.getPresupuesto())+
							"\nSe sugiere: "+sug.toString() +
							"\n-Presione 1 si acepta sino presione cualquier otro numero");

					if (sc.next().equals("1")) {
						sug.restarCupo();
						us.aceptarSugerencia(sug);
						precioFinal += sug.getCosto();
						tiempoFinal += sug.getTiempoTotal();
					} 
				}
			}
			System.out.println("Su itinerario incluye: " + us.itinerario+ 
					"\n\nEl costo total es: " + precioFinal + "\nEl tiempo total necesario es: " + tiempoFinal);
			System.out.println("\n ----------------------------");
			System.out.println("\nPresione Enter para continuar");
			
			System.in.read();
			
			AdministradorDeArchivos.escribirItinerario(us, tiempoFinal, precioFinal);
			
		}
//		
//		for (Usuario u : usuarios) {
//			AdministradorDeArchivos.escribirItinerario(u);
//		}

	}
}
