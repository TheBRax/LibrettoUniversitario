package it.brax.librettoUniversitario;
import java.time.LocalDate;

public class Esame {
	private Voto voto;
	private String esame;
	private LocalDate data;
	
	public Esame(String esame, Voto voto, LocalDate data) {
		super();
		this.voto = voto;
		this.esame = esame;
		this.data = data;
	}

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

	public String getEsame() {
		return esame;
	}

	public void setEsame(String esame) {
		this.esame = esame;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	
	@Override
	public String toString() {
		return String.format("Esame [voto=%s, esame=%s, data=%s]\n", voto, esame, data);
	}	
	
}
