package tpTurismoEnLaTierraMedia;

import java.io. *;
import java.util. *;

public class LeerYEscribirPromociones {
	
	
	
	public static LinkedList<Promocion> getPromocion(String archivoP){
		LinkedList <Promocion> promociones = new LinkedList<Promocion>(); 
		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivoP));
			
			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String datos[] = linea.split("-");
		
				String Atraccion1 = datos[1];
				String Atraccion2 = datos[2];
				double descuento = Integer.parseInt(datos[3]);
				
				
				Promocion a = new PromocionesPorcentuales(Atraccion1, Atraccion2, descuento);
				
				if (!promociones.contains(a))
					promociones.add(a);
			}
		} catch(FileNotFoundException f){
			f.printStackTrace();
		}
		sc.close();
		return promociones;
	}

}
