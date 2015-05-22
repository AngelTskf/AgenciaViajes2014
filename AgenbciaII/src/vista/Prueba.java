package vista;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.ArchivoSerializableEscritura;
import modelo.ArchivoSerializableLectura;
import modelo.Ruta;


public class Prueba {
public static void main(String[] args) {
	String[] nombre={"navarra","el hereje","trujillo","canal de castilla","jerte","la rioja","vino","betanzos","zaragoza","gijon"};
	String prefijoRuta="../rutas/";
	String sufijoRuta=".txt";
	String[] ciudad={"Pamplona","Valladolid","Trujillo","Madrid","Plasencia","Logroño","Burgos","La Coruña","Zaragoza","Gijon"};
	int[] duracion={5,6,4,5,7,6,3,6,5,6};
	float[] precio={3,4,3,2,4,5,4,5,4,3};
	for (int i = 0; i < 10; i++) {
		System.out.println("los valores: "+nombre[i]+";"+ciudad[i]+";"+duracion[i]+";"+precio[i]*100+";"+prefijoRuta+nombre[i]+sufijoRuta);		
		
		Ruta ruta=new Ruta(nombre[i], ciudad[i], duracion[i], precio[i]*100, prefijoRuta+nombre[i]+sufijoRuta);
		String rutaFinal = "rutas.dat";
		ArchivoSerializableLectura leer=new ArchivoSerializableLectura();
		ArchivoSerializableEscritura escribir=new ArchivoSerializableEscritura();
		ArrayList<Ruta> listaRutaViajes=leer.leerRutasFichero(rutaFinal);
		if (listaRutaViajes==null)
			listaRutaViajes=new ArrayList<Ruta>();
		listaRutaViajes.add(ruta);
		
		escribir.escribirListaEnFichero(listaRutaViajes, rutaFinal);
	}
	
	
	
//	ArrayList<RutaViaje> listaRutaViajes2=leer.leerRutasFichero(rutaFinal);	
//	for (int i = 0; i < listaRutaViajes2.size(); i++) {
//		System.out.println(listaRutaViajes2.get(i).getNombre());
//		FicheroTextoLectura leerdesc=new FicheroTextoLectura();
//		System.out.println(leerdesc.mostrarTextoFichero(listaRutaViajes2.get(i).getRutaAlFicheroDescripcion()));
//		
		
//	}	
}
}
