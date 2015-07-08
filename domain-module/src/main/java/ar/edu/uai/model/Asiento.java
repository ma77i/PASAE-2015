package ar.edu.uai.model;

import javax.persistence.*;

@Entity
public class Asiento {

	public Asiento() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String fila;

	private int numero;

	private boolean ocupado;

	@ManyToOne
	private Sector sector;

	public Asiento(String fila, int numero, boolean ocupado, Sector sector) {
		this.fila = fila;
		this.numero = numero;
		this.ocupado = ocupado;
		this.sector = sector;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFila() {
		return fila;
	}

	public void setFila(String fila) {
		this.fila = fila;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

}
