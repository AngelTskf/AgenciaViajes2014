package modelo;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArchivoSerializableEscritura {

	private ObjectOutputStream abrirArchivoEscritura(String ruta) {
		File archivo = new File(ruta);
		FileOutputStream flujoDestino = null;
		BufferedOutputStream buferDestino = null;
		ObjectOutputStream salida = null;
		if (!archivo.exists())
			try {
				archivo.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		try {
			if ((flujoDestino = new FileOutputStream(archivo)) != null)
				buferDestino = new BufferedOutputStream(flujoDestino);
			if(buferDestino!=null)
				try {
					salida=new ObjectOutputStream(buferDestino);
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

	public boolean escribirListaEnFichero(ArrayList lista,String ruta) {
		ObjectOutputStream buferDestino=abrirArchivoEscritura(ruta);
		if(buferDestino!=null)
			try {
				buferDestino.writeObject(lista);
				buferDestino.close();
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return false;
			}
		else
			return false;
	}
}// class
