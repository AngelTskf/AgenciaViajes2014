package modelo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ArchivoSerializableLectura {
	private ObjectInputStream abrirArchivoLectura(String ruta) {
		File archivo = new File(ruta);
		FileInputStream flujoDestino = null;
		BufferedInputStream buferDestino = null;
		ObjectInputStream salida = null;
		if (!archivo.exists())
			try {
				archivo.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		try {
			if ((flujoDestino = new FileInputStream(archivo)) != null)
				buferDestino = new BufferedInputStream(flujoDestino);
			if(buferDestino!=null)
				try {
					salida=new ObjectInputStream(buferDestino);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					return null;
				}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return null;
		}

		return salida;
	}
	
	public ArrayList leerRutasFichero(String ruta){
		ObjectInputStream buferOrigen=abrirArchivoLectura(ruta);
		ArrayList listaRutas = null;
		if(buferOrigen!=null){
			try {
				listaRutas=(ArrayList) buferOrigen.readObject();
				buferOrigen.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listaRutas;
		}
		return null;
	}
}
