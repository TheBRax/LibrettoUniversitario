package it.brax.librettoUniversitario;

import java.io.Serializable;

public interface Filtro extends Serializable{
	public boolean filtra(Esame e, Esame b, Voto v, String corso);
	
}
