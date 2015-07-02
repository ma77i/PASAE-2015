package ar.edu.uai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Asiento {

	public Asiento() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Integer fila;

	private Integer numero;

	private boolean ocupado;

	@ManyToOne
	private Sector sector;

	public Asiento(Integer fila, int numero, boolean ocupado, Sector sector) {
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

	public Integer getFila() {
		return fila;
	}

	public void setFila(Integer fila) {
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
