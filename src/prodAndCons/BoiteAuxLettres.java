package prodAndCons;

class BoiteAuxLettres {
	private boolean plein = false;
	private String lettre;
	
	synchronized void deposer(String nomProd, String lettre) {
		try {
			while (this.plein) {
				System.out.println(nomProd + " attend");
				this.wait();
				System.out.println(nomProd + " réveillé");
			}
		} catch (InterruptedException exc) {
			// Empty
		}
		
		this.lettre = lettre;
		
		System.out.println(nomProd + " écrit: \"" + this.lettre + "\"");
		this.plein = true;
		this.notify();
	}
	
	synchronized String retirer(String nomConso) {
		try {
			while (!this.plein) {
				System.out.println(nomConso + " attend");
				this.wait();
				System.out.println(nomConso + " réveillé");
			}
		} catch (InterruptedException exc) {
			return null;
		}
		
		System.out.println(nomConso + " lit: \"" + this.lettre + "\"");
		this.plein = false;
		this.notify();
		
		return lettre;
	}
}
