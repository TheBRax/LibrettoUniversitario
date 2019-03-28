package it.brax.librettoUniversitario;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		Libretto libr = new Libretto();
		Libretto librFiltrato = new Libretto();
		
		Filtro votoUgualeA = (Esame e, Voto v) -> e.getVoto() == v ;
		
		libr.add(new Esame("Analisi I", Voto.VENTISEI, LocalDate.of(2000, 1, 13)));
		libr.add(new Esame("Geometria I", Voto.VENTISETTE, LocalDate.of(2000, 2, 15)));
		libr.add(new Esame("Chimica", Voto.VENTOTTO, LocalDate.of(2000, 6, 20)));
		libr.add(new Esame("Fisica I", Voto.VENTOTTO, LocalDate.of(2000, 7, 21)));
		libr.add(new Esame("Fondamenti di Informatica", Voto.TRENTA, LocalDate.of(2000, 9, 15)));
		
		for (Esame e : libr.getEsami()) {
			if (votoUgualeA.filtra(e, Voto.VENTISEI)) librFiltrato.add(e);
		}
		System.out.println(librFiltrato.getEsami());
		
	}

}
