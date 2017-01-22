package prodAndCons;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class Consommateur extends Thread {
	BoiteAuxLettres boite;
	String nom;
	Random alea;
	
	Consommateur(BoiteAuxLettres boite, String nom, Random alea) {
		this.boite = boite;
		this.nom = nom;
		this.alea = alea;
		System.out.println("Consommateur: " + nom + " créé");
	}
	
	@Override
	public void run() {
		System.out.println("Consommateur: " + nom + " démarré");
		
		for (int i = 0; i < ProdCons.TOTAL; i++) {
			try {
				Consommateur.sleep(Math.abs(this.alea.nextInt()) % 1000);
			} catch (InterruptedException ex) {
				Logger.getLogger(Consommateur.class.getName()).log(Level.SEVERE, null, ex);
			}
			
			this.boite.retirer(this.nom);
		}
	}
}
