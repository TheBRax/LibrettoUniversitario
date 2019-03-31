package it.brax.librettoUniversitario;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Libretto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public void migliora() {
		for (Esame e : this.getEsami()) {
			if (e.getVoto().getVoto() == 31) {}
			else {
				if (e.getVoto().getVoto() >= 24) {
					if (e.getVoto().getVoto() +2 >= 30) e.setVoto(Voto.TRENTA);
					else e.setVoto(Voto.getVoto2(e.getVoto().getVoto() + 2));
				}
				else e.setVoto(Voto.getVoto2(e.getVoto().getVoto() + 1));
			}
		}
	}
	
	public void cancellaVotiBrutti() {
		List<Esame> esamiDaCancellare = new ArrayList<Esame>();
		for (Esame e : this.esami) {
			if (e.getVoto().getVoto() <= 24) esamiDaCancellare.add(e);
		}
		this.esami.removeAll(esamiDaCancellare);
	}
	
	protected static Object deepCopy(Object object) {
		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			ObjectOutputStream outputStrm = new ObjectOutputStream(outputStream);
			outputStrm.writeObject(object);
			ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
			ObjectInputStream objInputStream = new ObjectInputStream(inputStream);
			return objInputStream.readObject();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void ordinaAlfabeticamente() {
		List<String> corsiOrdineAlfabetico = new ArrayList<String>();
		List<Esame> listaEsamiOrdineAlfabetico = new ArrayList<Esame>();
		for (Esame e : esami) {
			corsiOrdineAlfabetico.add(e.getCorso());
		}
		Collections.sort(corsiOrdineAlfabetico);
		for (int i = 0; i <= corsiOrdineAlfabetico.size()-1; i++) {
			for (Esame e : this.esami) {
				if (e.getCorso() == corsiOrdineAlfabetico.get(i)) {
					listaEsamiOrdineAlfabetico.add(e);
					break;
				}
			}
		}
		this.esami.clear();
		this.esami.addAll(listaEsamiOrdineAlfabetico);
	}
	
	public void ordinaPerVoto(boolean ascendente) {
		List<Integer> votiOrdinati = new ArrayList<Integer>();
		List<Esame> listaEsamiOrdineVoto = new ArrayList<Esame>();
		for (Esame e : esami) {
			votiOrdinati.add(e.getVoto().getVoto());
		}
		
		if (ascendente)
			Collections.sort(votiOrdinati);
		else
			Collections.sort(votiOrdinati, Collections.reverseOrder());
		
		for (int i = 0; i <= votiOrdinati.size()-1; i++) {
			for (Esame e : this.esami) {
				if (e.getVoto().getVoto() == votiOrdinati.get(i)) {
					listaEsamiOrdineVoto.add(e);
					break;
				}
			}
		}
		this.esami.clear();
		this.esami.addAll(listaEsamiOrdineVoto);
	}
}
