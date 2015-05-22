package modelo;

import java.io.Serializable;

public class Contrato implements Serializable {
	private String nif;
	private String nombreRuta;
	private int personas;

	public Contrato(String nif, String ruta, int personas) {
		super();
		this.nif = nif;
		this.nombreRuta = ruta;
		this.personas = personas;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	

	public int getPersonas() {
		return personas;
	}

	public void setPersonas(int personas) {
		this.personas = personas;
	}

	public String getNombreRuta() {
		return nombreRuta;
	}

	public void setNombreRuta(String nombreRuta) {
		this.nombreRuta = nombreRuta;
	}

}
