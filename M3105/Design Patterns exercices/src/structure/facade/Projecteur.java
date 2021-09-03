package structure.facade;

public class Projecteur {

	public void marche() {
		System.out.println("Projecteur ON");
		
	}

	public void arret() {
		System.out.println("Projecteur OFF");
	}

	public void modeGrandEcran() {
		System.out.println("Projecteur en mode Grand Ecran");
	}

	public void setEntree(Source source) {
		System.out.println("Source changee pour le " + source);
	}

}
