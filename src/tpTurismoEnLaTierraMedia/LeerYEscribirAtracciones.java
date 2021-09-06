package tpTurismoEnLaTierraMedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LeerYEscribirAtracciones {
	
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
	
	public static void escribirAtracciones(List<Atraccion> atracciones) {
		File f = new File("files/atraccionesOUT.txt");
		PrintWriter pw;
		
		try {
			pw = new PrintWriter(f);
			
			for(Atraccion a : atracciones) 
				pw.write(a.toString()+"\n");
			
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			
	}
	
	
	// Este main es provisional
	public static void main(String[] args) {
		System.out.println("Leer\n");
		List<Atraccion> atracciones;
		atracciones = leerAtracciones();
		for(Atraccion a : atracciones) System.out.println(a);
		
		System.out.println("\nOrdenar\n");
		atracciones.sort(new ComparadorDeSugerencias(TIPO.AVENTURA));
		
//		List<Atraccion> ordenada;
//		ordenada = atracciones.sort()
		
		for(Atraccion a : atracciones) System.out.println(a);
		
		System.out.println("\nEscribir\n");
		escribirAtracciones(atracciones); 

	}

}
