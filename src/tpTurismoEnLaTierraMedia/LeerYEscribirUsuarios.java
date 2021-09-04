package tpTurismoEnLaTierraMedia;

import java.io. *;
import java.util. *;

public class LeerYEscribirUsuarios {
	
	public static LinkedList<Usuario> getUsuarios(String archivo){
		LinkedList <Usuario> usuarios = new LinkedList<Usuario>(); 
		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivo));
			
			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String datos[] = linea.split("-");
				
				String nombre = datos[0];
				int presupuesto = Integer.parseInt(datos[1]);
				double tiempoDisp = Double.parseDouble(datos[2]);
				String preferencia = datos[3];
				
				Usuario u = new Usuario(nombre, presupuesto, tiempoDisp, preferencia);
				
				if (!usuarios.contains(u))
					usuarios.add(u);
			}
		} catch(FileNotFoundException f){
			f.printStackTrace();
		}
		sc.close();
		return usuarios;
	}
	
	
	
	

}
