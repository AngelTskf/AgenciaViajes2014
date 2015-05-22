package modelo;

import java.io.Serializable;

public class Ruta implements Serializable {
	//Propiedades
	private String nombre;
	private String ciudadFinal;
	private int duracion;
	private float precio;
	private String rutaAlFicheroDescripcion;
	
	//Constructor
	public Ruta(String nombre, String ciudadFinal, int duracion, float precio,
			String descripcion) {
		super();
		this.nombre = nombre;
		this.ciudadFinal = ciudadFinal;
		this.duracion = duracion;
		this.precio = precio;
		this.rutaAlFicheroDescripcion = descripcion;
	}

	//getters & setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudadFinal() {
		return ciudadFinal;
	}

	public void setCiudadFinal(String ciudadFinal) {
		this.ciudadFinal = ciudadFinal;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getRutaAlFicheroDescripcion() {
		return rutaAlFicheroDescripcion;
	}

	public void setRutaAlFicheroDescripcion(String rutaAlFicheroDescripcion) {
		this.rutaAlFicheroDescripcion = rutaAlFicheroDescripcion;
	}

	
	
}
