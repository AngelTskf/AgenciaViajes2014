package controlador;

import java.util.ArrayList;

import modelo.ArchivoSerializableEscritura;
import modelo.ArchivoSerializableLectura;
import modelo.Contrato;

public class ControlarContrato {
	
	private ArrayList<Contrato> listaContratos;
	
	public float calcularTotal(int personas,float precio) {
		float total = personas * precio;
		return total;
	}
	public boolean almacenarContrato(String nif,String nombreRuta,int personas){
		try {
			ArchivoSerializableLectura leer=new ArchivoSerializableLectura();
			listaContratos=leer.leerRutasFichero("contratos.dat");
			if(listaContratos==null)
				listaContratos=new ArrayList<>();
			Contrato nuevoContrato=new Contrato(nif, nombreRuta, personas);
			listaContratos.add(nuevoContrato);
			ArchivoSerializableEscritura escribir=new ArchivoSerializableEscritura();
			escribir.escribirListaEnFichero(listaContratos, "contratos.dat");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}		
	}
}
