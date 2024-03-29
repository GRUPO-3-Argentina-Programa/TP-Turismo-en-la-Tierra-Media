package tpTurismoEnLaTierraMedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AdministradorDeArchivos {

	// Se lee el archivo de usuarios y se crea una lista.
	public static List<Usuario> getUsuarios(String archivoUs) {
		List<Usuario> usuarios = new LinkedList<Usuario>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivoUs));

			while (sc.hasNext()) {
				String datos[] = sc.nextLine().split("-");

				Usuario u = new Usuario(datos[0], Integer.parseInt(datos[1]), Double.parseDouble(datos[2]),
						TIPO.valueOf(datos[3]));

				if (!usuarios.contains(u))
					usuarios.add(u);
			}
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		}
		sc.close();
		return usuarios;
	}

	// Se lee el archivo de atracciones y se crea una lista.
	public static List<Atraccion> leerAtracciones() {
		File f = new File("files/atracciones.txt");
		Scanner sc;
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		String[] datos;

		try {
			sc = new Scanner(f);

			while (sc.hasNext()) {
				datos = sc.nextLine().split("-");

				atracciones.add(new Atraccion(datos[0], Integer.parseInt(datos[1]), Double.parseDouble(datos[2]),
						Integer.parseInt(datos[3]), TIPO.valueOf(datos[4])));
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

	// Se lee el archivo de promociones y se crea una lista.
	public static List<Promocion> getPromociones(String archivoPromos) {
		List<Promocion> promociones = new LinkedList<Promocion>();
		List<Atraccion> atraccionesDePromo;
		Scanner sc = null;

		try {
			sc = new Scanner(new File(archivoPromos));

			while (sc.hasNext()) {
				atraccionesDePromo = new LinkedList<Atraccion>();
				String[] datos = sc.nextLine().split("-");
				int size = datos.length;
				Atraccion next;

				for (int i = 2; i < size - 1; i++) {
					Iterator<Atraccion> itr = leerAtracciones().iterator();
					while (itr.hasNext()) {
						next = itr.next();
						if (datos[i].equals(next.getNombre())) {
							atraccionesDePromo.add(next);
						}
					}
				}

				if (datos[0].equals("porcentual")) {
					Promocion p = new PromocionPorcentual(TIPO.valueOf(datos[1]), atraccionesDePromo,
							Double.parseDouble(datos[size - 1]));
					if (!promociones.contains(p))
						promociones.add(p);
				}

				else if (datos[0].equals("absoluta")) {
					Promocion p = new PromocionAbs(TIPO.valueOf(datos[1]), atraccionesDePromo,
							Double.parseDouble(datos[size - 1]));
					if (!promociones.contains(p))
						promociones.add(p);
				}

				else if (datos[0].equals("AxB")) {
					Atraccion atraccionRegalo = null;
					Iterator<Atraccion> itr = leerAtracciones().iterator();

					while (itr.hasNext()) {
						next = itr.next();
						if (datos[size - 1].equals(next.getNombre())) {
							atraccionRegalo = next;
						}
					}
					Promocion p = new PromocionAxB(TIPO.valueOf(datos[1]), atraccionesDePromo, atraccionRegalo);
					if (!promociones.contains(p))
						promociones.add(p);
				}
			}
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		}
		sc.close();
		return promociones;
	}

	// Se escribe el archivo de salida del itinerario para cada usuario.
	public static void escribirItinerario(Usuario u) {

		File f = new File("filesOUT/" + u.getNombre() + ".txt");
		PrintWriter pw;

		try {
			pw = new PrintWriter(f);

			pw.write(
					"Usuario: " + u.getNombre() + ", tiempo disponible: " + u.getTIEMPO() + ", presupuesto disponible: "
							+ String.format("%.2f", u.getPRESUPUESTO()) + "\nSu itinerario incluye:");

			for (Sugerible i : u.itinerario)
				pw.write("\n" + i.toString());

			pw.write("\n-------------------------\nEl costo total es: " + u.totalPagar + "\nEl tiempo total es: "
					+ u.totalTiempo);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}