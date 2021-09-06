package tpTurismoEnLaTierraMedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AdministradorDeArchivos {

	public static List<Usuario> getUsuarios(String archivoUs){
		List <Usuario> usuarios = new LinkedList<Usuario>(); 
		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivoUs));
			
			while (sc.hasNext()) {
				String datos[] = sc.nextLine().split("-");
				
				Usuario u = new Usuario(datos[0],
						Integer.parseInt(datos[1]),
						Double.parseDouble(datos[2]),
						TIPO.valueOf(datos[3]));
				
				if (!usuarios.contains(u))
					usuarios.add(u);
			}
		} catch(FileNotFoundException f){
			f.printStackTrace();
		}
		sc.close();
		return usuarios;			
	}
	
	public static List<Atraccion> leerAtracciones() {
		File f = new File("files/atracciones.txt");
		Scanner sc;
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		String[] datos;
		
		try {
			sc = new Scanner(f);
			
			while(sc.hasNext()) {
				datos = sc.nextLine().split("-");

				atracciones.add(
					new Atraccion(datos[0], Integer.parseInt(datos[1]), Double.parseDouble(datos[2]),
						Integer.parseInt(datos[3]),	TIPO.valueOf(datos[4]))
				);
				datos = null;
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
		}
		
		return atracciones;
	}
	
	public static void escribirItinerario(Usuario u, List<Atraccion> itinerario, double sumadorTiempo,
			double sumadorCosto) {
		
			File f = new File("files/"+u.getNombre()+".txt");
			PrintWriter pw;
			
			try {
				pw = new PrintWriter(f);
				
				pw.write(u.toString()+"\n");
							
				for(Atraccion i : itinerario) 
					pw.write(i.getNombre()+"\n");
				
				pw.write("El costo total es : "+sumadorCosto+"\n El tiempo total es:"+sumadorTiempo);			
				pw.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
				
		}
		
	public static List<Promocion> getPromociones(String archivoPromos){
		List <Promocion> promociones = new LinkedList<Promocion>(); 
		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivoPromos));
			
			while (sc.hasNext()) {
				String datos[] = sc.nextLine().split("-");
				int size = datos.length;
				
				if (datos[0] == "porcentual") {
					Atraccion atraccionesDePromo[] = null;
					
					for (int i=3; i<datos.length-2;i++) 
						for (Atraccion a : leerAtracciones()) {
							if (datos[i]==a.getNombre()) {
								atraccionesDePromo[i] = a;
							}
						}

					Promocion p = new PromocionesPorcentuales(TIPO.valueOf(datos[1]),
							datos[2],
							atraccionesDePromo,
							Double.parseDouble(datos[size-1]));
					if (!promociones.contains(p))
						promociones.add(p);
				}
				
				else if (datos[0] == "absoluta") {
					Atraccion atraccionesDePromo[] = null;
					
					for (int i=3; i<datos.length-2;i++) 
						for (Atraccion a : leerAtracciones()) {
							if (datos[i]==a.getNombre()) {
								atraccionesDePromo[i] = a;
							}
						}

					Promocion p = new PromocionesAbsolutas(TIPO.valueOf(datos[1]),
							datos[2],
							atraccionesDePromo,
							Double.parseDouble(datos[size-1]));
					if (!promociones.contains(p))
						promociones.add(p);
				}
				
				else if (datos[0] == "AxB") {
					Atraccion atraccionesDePromo[] = null;
					
					for (int i=3; i<datos.length-1;i++) 
						for (Atraccion a : leerAtracciones()) {
							if (datos[i]==a.getNombre()) {
								atraccionesDePromo[i] = a;
							}
						}

					Promocion p = new PromocionesAxB(TIPO.valueOf(datos[1]),
							datos[2],
							atraccionesDePromo);
					if (!promociones.contains(p))
						promociones.add(p);
				}
				
			}
		} catch(FileNotFoundException f){
			f.printStackTrace();
		}
		sc.close();
		return promociones;
	}
	
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println(sc.nextLine());
		
}
	}