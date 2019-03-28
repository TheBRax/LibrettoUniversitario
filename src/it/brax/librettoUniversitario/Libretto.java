package it.brax.librettoUniversitario;
import java.util.ArrayList;
import java.util.List;

public class Libretto {
	private List<Esame> esami;
		
	public Libretto() {
		super();
		esami = new ArrayList<Esame>();
	}
	
	/**
	 * Aggiunge un esame al {@link Libretto}
	 * @param e L'{@link Esame} da aggiungere
	 */
	public void add(Esame e) {
		esami.add(e);
	}
	
	public void clear() {
		esami.clear();
	}

	public List<Esame> getEsami() {
		return esami;
	}
}
