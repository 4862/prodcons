package prodAndCons;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class Producteur extends Thread {
	BoiteAuxLettres boite;
	String nom;
	Random alea;
	
	Producteur(BoiteAuxLettres boite, String nom, Random alea) {
		this.boite = boite;
		this.nom = nom;
		this.alea = alea;
		System.out.println("Producteur: " + nom + " créé");
	}
	
	@Override
	public void run() {
		System.out.println("Producteur: " + nom + " démarré");
		
		for (int i = 0; i < ProdCons.TOTAL; i++) {
			try {
				Producteur.sleep(Math.abs(this.alea.nextInt()) % 1000);
			} catch (InterruptedException ex) {
				Logger.getLogger(Producteur.class.getName()).log(Level.SEVERE, null, ex);
			}
			
			this.boite.deposer(this.nom, this.nom + ", lettre " + (i + 1));
		}
	}
}
