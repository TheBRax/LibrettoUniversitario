package it.brax.librettoUniversitario;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		Libretto libr = new Libretto();
		Libretto librFiltrato = new Libretto();
		
		Filtro votoUgualeA = (Esame e, Esame b, Voto v, String corso) -> e.getVoto() == v ;
		Filtro cercaCorso = (Esame e, Esame b, Voto v, String corso) -> e.getCorso() == corso ;
		Filtro giaInserito = (Esame e, Esame b, Voto v, String corso) -> e.getCorso() == b.getCorso() && e.getVoto() == b.getVoto() ;
		
		libr.add(new Esame("Analisi I", Voto.VENTISEI, LocalDate.of(2000, 1, 13)));
		libr.add(new Esame("Geometria I", Voto.VENTISETTE, LocalDate.of(2000, 2, 15)));
		libr.add(new Esame("Chimica", Voto.VENTOTTO, LocalDate.of(2000, 6, 20)));
		libr.add(new Esame("Fisica I", Voto.VENTOTTO, LocalDate.of(2000, 7, 21)));
		libr.add(new Esame("Fondamenti di Informatica", Voto.TRENTA, LocalDate.of(2000, 9, 15)));
		
		/**
		 * Punto 2: trovare gli esami con una votazione pari ad un certo numero
		 */
		for (Esame e : libr.getEsami()) {
			if (votoUgualeA.filtra(e, null, Voto.VENTOTTO, null)) librFiltrato.add(e);
		}
		System.out.println(librFiltrato.getEsami());
		librFiltrato.clear();
		
		/**
		 * Punto 3: trovare gli esami per il corso uguale a quello che si sta cercando		
		 */
		for (Esame e : libr.getEsami()) {
			if (cercaCorso.filtra(e, null, null, "Analisi I")) librFiltrato.add(e);
		}
		System.out.println(librFiltrato.getEsami());
		librFiltrato.clear();
		
		/**
		 * Punto 4: verificare se un esame risulta già inserito nella lista esami del LibrettoUniversitario
		 */
		for (Esame e : libr.getEsami()) {
			if (giaInserito.filtra(e, new Esame("Chimica", Voto.VENTOTTO, null), null, null))
				System.out.println(e + " già presente nella lista esami del Libretto Universitario");
		}
	}

}
