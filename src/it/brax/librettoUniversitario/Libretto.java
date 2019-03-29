package it.brax.librettoUniversitario;
import java.util.ArrayList;
import java.util.List;

public class Libretto {
	private List<Esame> esami;
		
	public Libretto() {
		super();
		esami = new ArrayList<Esame>();
	}
	
	Filtro giaInserito = (Esame e, Esame b, Voto v, String corso) -> e.getCorso() == b.getCorso() && e.getVoto() == b.getVoto() ;
	Filtro inConflitto = (Esame e, Esame b, Voto v, String corso) -> e.getCorso() == b.getCorso() && e.getVoto() != b.getVoto() ;
	
	/**
	 * Aggiunge un esame al {@link Libretto}. Restituisce false se l'{@link Esame} passato è già presente nel Libretto
	 * o è in conflitto con un esame già presente nel libretto; true altrimenti.
	 * @param e L'{@link Esame} da aggiungere
	 */
	public boolean add(Esame e) {
		for (Esame a : this.getEsami() ) {
			if (giaInserito.filtra(e, a, null, null) || inConflitto.filtra(e, a, null, null))
				return false;
		}
		this.esami.add(e);
		return true;
	}
	
	public void clear() {
		esami.clear();
	}

	public List<Esame> getEsami() {
		return esami;
	}
}
