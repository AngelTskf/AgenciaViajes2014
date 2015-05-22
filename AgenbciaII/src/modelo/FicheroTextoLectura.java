package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FicheroTextoLectura {
	/**
	 * Abre un bufer de texto secuencial para lectura basandose en la ruta
	 * 
	 * @param ubicacion
	 *            del fichero
	 * @return un bufer al fichero o null si no ha podido leer
	 */
	private BufferedReader abrirBufferTextoLectura(String ruta) {
		File archivo = new File(ruta);
		FileReader flujo = null;
		BufferedReader bufer = null;
		if (archivo.exists()) {
			try {
				flujo = new FileReader(archivo);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				return null;
			}
			if (flujo != null)
				bufer = new BufferedReader(flujo);
		}
		return bufer;
	}
/**
 * Lee completamente un buffer de texto y lo entrega
 * @param bufer donde se encuentra el texto (sabemos que es pequeño)
 * @return el texto integro leido
 */
	private String entregarFicheroTextoCompleto(BufferedReader bufer){
		
		StringBuilder texto=new StringBuilder();
		String cadena="";
		try {
			while((cadena=bufer.readLine())!=null){
				texto.append(cadena);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "";
		}
		return texto.toString();
	}
	public String mostrarTextoFichero(String ruta){
		BufferedReader bufer=abrirBufferTextoLectura(ruta);
		return entregarFicheroTextoCompleto(bufer);
	}
}
