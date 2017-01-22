package prodAndCons;

import java.util.Random;

class ProdCons {
	final static int TOTAL = 2;
	
	public static void main(String [] argv) {
		BoiteAuxLettres boite = new BoiteAuxLettres();
		
		Random alea = new Random();
		
		new Producteur(boite, "David", alea).start();
		new Producteur(boite, "Antoine", alea).start();
		new Consommateur(boite, "Sophie", alea).start();
		new Consommateur(boite, "Marie", alea).start();
	}
}
