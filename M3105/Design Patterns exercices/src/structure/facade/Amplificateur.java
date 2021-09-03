package structure.facade;

public class Amplificateur {

	public void marche() {
		System.out.println("Ampli ON");
	}

	public void arret() {
		System.out.println("Ampli OFF");
	}

	public void setDvd(LecteurDvd dvd) {
		System.out.println("Ampli regle sur source lecteur DVD");
		
	}

	public void setSonSurround() {
		System.out.println("Ampli son surround ON");
	}

	public void setVolume(int vol) {
		System.out.println("Ampli volume sur "+vol);
	}

}
