package it.brax.librettoUniversitario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestLibretto {

	public static void main(String[] args) {
		Libretto libr = new Libretto();
		Libretto librFiltrato = new Libretto();
		
		Filtro votoUgualeA = (Esame e, Esame b, Voto v, String corso) -> e.getVoto() == v ;
		Filtro cercaCorso = (Esame e, Esame b, Voto v, String corso) -> e.getCorso() == corso ;
		Filtro giaInserito = (Esame e, Esame b, Voto v, String corso) -> e.getCorso() == b.getCorso() && e.getVoto() == b.getVoto() ;
		Filtro inConflitto = (Esame e, Esame b, Voto v, String corso) -> e.getCorso() == b.getCorso() && e.getVoto() != b.getVoto() ;
		
		libr.add(new Esame("Analisi I", Voto.VENTISEI, LocalDate.of(2000, 1, 13)));
		libr.add(new Esame("Geometria I", Voto.VENTISETTE, LocalDate.of(2000, 2, 15)));
		libr.add(new Esame("Chimica", Voto.VENTOTTO, LocalDate.of(2000, 6, 20)));
		libr.add(new Esame("Fisica I", Voto.VENTOTTO, LocalDate.of(2000, 7, 21)));
		libr.add(new Esame("Fondamenti di Informatica", Voto.TRENTA, LocalDate.of(2000, 9, 15)));
		libr.add(new Esame("Fondamenti di Automatica", Voto.DICIANNOVE, LocalDate.of(2003, 5, 15)));
		
		System.out.println("\n----- Punto 2: trovare gli esami con una votazione pari ad un certo numero");
		/**
		 * Punto 2: trovare gli esami con una votazione pari ad un certo numero
		 */
		for (Esame e : libr.getEsami()) {
			if (votoUgualeA.filtra(e, null, Voto.VENTOTTO, null)) librFiltrato.add(e);
		}
		System.out.println(librFiltrato.getEsami());
		librFiltrato.clear();
		
		System.out.println("\n----- Punto 3: trovare gli esami per il corso uguale a quello che si sta cercando");
		/**
		 * Punto 3: trovare gli esami per il corso uguale a quello che si sta cercando		
		 */
		for (Esame e : libr.getEsami()) {
			if (cercaCorso.filtra(e, null, null, "Analisi I")) librFiltrato.add(e);
		}
		System.out.println(librFiltrato.getEsami());
		librFiltrato.clear();
		
		System.out.println("\n----- Punto 4: verificare se un esame risulta già inserito nella lista esami del LibrettoUniversitario");
		/**
		 * Punto 4: verificare se un esame risulta già inserito nella lista esami del LibrettoUniversitario
		 */
		for (Esame e : libr.getEsami()) {
			if (giaInserito.filtra(e, new Esame("Chimica", Voto.VENTOTTO, null), null, null))
				System.out.println(e + " già presente nella lista esami del Libretto Universitario");
		}
		
		System.out.println("\n----- Punto 5: verificare se un esame è in conflitto con uno già inserito nella lista esami del LibrettoUniversitario");
		/**
		 * Punto 5: verificare se un esame è in conflitto con uno già inserito nella lista esami del LibrettoUniversitario
		 */
		for (Esame e : libr.getEsami()) {
			if (inConflitto.filtra(e, new Esame("Analisi I", Voto.VENTOTTO, null), null, null))
				System.out.println(e + " nella lista esami del Libretto Universitario è in conflitto con quello cercato");
		}
		
		System.out.println("\n----- Punto 6: verifica del funzionamento del nuovo metodo add");
		/**
		 * Punto 6: verifica del funzionamento del nuovo metodo add
		 */
		libr.add(new Esame("Analisi I", Voto.VENTISEI, LocalDate.now()));
		libr.add(new Esame("Fisica I", Voto.DICIANNOVE, LocalDate.now()));
		libr.add(new Esame("Merendine", Voto.TRENTA_LODE, LocalDate.now()));
		System.out.println(libr.getEsami());
		
		System.out.println("\n----- Punto 7: creazione del Libretto Migliorato");
		/**
		 * Punto 7: creazione del Libretto Migliorato
		 */
		Libretto librMigliorato = new Libretto();
		librMigliorato = (Libretto)Libretto.deepCopy(libr);
		librMigliorato.migliora();
		System.out.println(librMigliorato.getEsami());
		System.out.println(libr.getEsami());
		System.out.println(librMigliorato);
		System.out.println(libr);
		
		System.out.println("\n----- Punto 8: stampa del libretto in ordine alfabetico di corso ed in ordine decrescente di voto");
		/**
		 * Punto 8: ordinamento della lista
		 */
		libr.ordinaAlfabeticamente();
		System.out.println(libr.getEsami());
		libr.ordinaPerVoto(false);
		System.out.println(libr.getEsami());
		
		libr.ordinaAlfabeticamente();
		System.out.println(libr.getEsami());
		libr.ordinaPerVoto(false);
		System.out.println(libr.getEsami());
		
		System.out.println("\n----- Punto 9: elimina i voti sotto il 24");
		/**
		 * Punto 9: eliminazione voti sotto il 24
		 */
		librMigliorato.cancellaVotiBrutti();
		System.out.println(librMigliorato.getEsami());
	}

}
