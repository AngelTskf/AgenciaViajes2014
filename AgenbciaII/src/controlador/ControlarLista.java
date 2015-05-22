package controlador;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import modelo.ArchivoSerializableLectura;
import modelo.FicheroTextoLectura;
import modelo.Ruta;


public class ControlarLista {
	private int posicion = 0;
	private ArrayList<Ruta> rutas;
	private float precioActual=0;

	public ControlarLista() {
		// TODO Auto-generated constructor stub
		ArchivoSerializableLectura leer = new ArchivoSerializableLectura();
		rutas = (ArrayList<Ruta>) leer.leerRutasFichero("rutas.dat");
	}

	private Ruta entregarSiguienteElementoLista() {
		Ruta elemento=null;
		if (rutas!=null&&posicion < rutas.size()) {
			elemento= rutas.get(posicion);
			posicion++;
		}
		return elemento;
	}
	public void iniciarLista(){
		posicion=0;
	}
	
	public void escribirCampos(JLabel nombre,JLabel ciudad,JLabel duracion, JTextArea descripcion){
		Ruta rutaActual=entregarSiguienteElementoLista();
		if(rutaActual!=null){
		nombre.setText(rutaActual.getNombre());
		ciudad.setText(rutaActual.getCiudadFinal());
		duracion.setText(Integer.toString(rutaActual.getDuracion()));
		FicheroTextoLectura leer=new FicheroTextoLectura();		
		descripcion.setText(leer.mostrarTextoFichero(rutaActual.getRutaAlFicheroDescripcion()));
		precioActual=rutaActual.getPrecio();
		}
	}

	public float getPrecioActual() {
		return precioActual;
	}
}
