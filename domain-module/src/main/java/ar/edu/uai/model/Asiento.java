package ar.edu.uai.model;

import javax.persistence.*;

@Entity
public class Asiento {

	public Asiento() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Integer numero;

	private boolean ocupado;

	@ManyToOne
	private Fila fila;

	public Asiento(Fila fila, int numero, boolean ocupado) {
		this.fila = fila;
		this.numero = numero;
		this.ocupado = ocupado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Fila getFila() {
		return fila;
	}

	public void setFila(Fila fila) {
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


}
