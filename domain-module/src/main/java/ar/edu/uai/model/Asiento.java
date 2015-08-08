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

	private Boolean ocupado;

	@ManyToOne
	private Fila fila;

	//@ManyToMany
	//private Collection<Venta> ventas;

	public Asiento(Integer numero) {
		this.numero = numero;
		this.ocupado = false;
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

	public Boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(Boolean ocupado) {
		this.ocupado = ocupado;
	}


}
