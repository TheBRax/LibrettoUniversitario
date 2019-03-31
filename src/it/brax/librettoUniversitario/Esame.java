package it.brax.librettoUniversitario;
import java.io.Serializable;
import java.time.LocalDate;

public class Esame implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Voto voto;
	private String corso;
	private LocalDate data;
	
	public Esame(String corso, Voto voto, LocalDate data) {
		super();
		this.voto = voto;
		this.corso = corso;
		this.data = data;
	}

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	
	@Override
	public String toString() {
		return String.format("Esame [voto=%s, corso=%s, data=%s]\n", voto, corso, data);
	}	
	
}
