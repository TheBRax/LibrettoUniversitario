package it.brax.librettoUniversitario;

public enum Voto {
	DICIOTTO(18),
	DICIANNOVE(19),
	VENTI(20),
	VENTUNO(21),
	VENTIDUE(22),
	VENTITRE(23),
	VENTIQUATTRO(24),
	VENTICINQUE(25),
	VENTISEI(26),
	VENTISETTE(27),
	VENTOTTO(28),
	VENTINOVE(29),
	TRENTA(30),
	TRENTA_LODE(31);
	
	private int voto;
	
	Voto(int i){
		this.voto =i;
	}

	public int getVoto() {
		return voto;
	}
	
}
