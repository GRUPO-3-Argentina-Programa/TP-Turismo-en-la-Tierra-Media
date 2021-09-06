package tpTurismoEnLaTierraMedia;

import java.io.IOException;
import java.util. *;

public class App {
		
	public static void main(String[] args) throws IOException {
		
		List<Atraccion> atracciones;
		atracciones = LeerYEscribirAtracciones.leerAtracciones();
		
		List<Usuario> usuarios;
		usuarios = AdministradorDeArchivos.getUsuarios("files/usuarios.txt");
		
		List<Promocion> promociones;
		promociones = AdministradorDeArchivos.getPromociones("files/promociones.taxt");
		
		for (Usuario u: usuarios) {
			
			
			atracciones.sort(new ComparadorDeSugerencias(u.getTipo())); 
			System.out.println("\n para usuario "+ u.getNombre());
			//for(Atraccion a : atracciones) System.out.println(a);
			u.itinerario = new LinkedList<Sugerible>();
			for (Atraccion a: atracciones) {
				
				if (u.puedeComprar(a) && a.getCupo() > 0) {
					//System.out.println(a.toString()+"\n Presione 1 si acepta sino presione cualquier otro numero\n");
					
					//int r = System.in.read();
					//if (r == 1) {
						u.setPresupuesto(a.getCosto());
						u.setTiempoDisponible(a.getPromedioDeTiempo());
						a.restarCupo();
						u.itinerario.add(a);
						
					}
				
				}
//			for(Atraccion i : itinerario) System.out.println("Itinerario de "+u.getNombre()+i);
//			System.out.println(u.getTiempoDisponible()+" "+u.getPresupuesto());
//			for(Atraccion a : atracciones) System.out.println(a.getNombre()+"cupo "+a.getCupo());
			double sumadorTiempo = 0;
			double sumadorCosto = 0;
			for(Sugerible s : u.itinerario) {
				sumadorTiempo += s.getPromedioDeTiempo();
				sumadorCosto += s.getCosto();
			}
//			AdministradorDeArchivos.escribirItinerario(u, itinerario, sumadorTiempo, sumadorCosto);
		}
			
			//itinerario = null;
			//for(Atraccion i : itinerario) System.out.println(i);
	}
}
	

