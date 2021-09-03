package structure.facade;

public class LecteurDvd implements Source {

	public void marche() {
		System.out.println("DVD ON");
	}

	public void jouer(String film) {
		System.out.println("DVD PLAY film "+film);
	}

	public void stop() {
		System.out.println("DVD STOP");
	}

	public void ejecter() {
		System.out.println("DVD EJECT");
	}

	public void arret() {
		System.out.println("DVD OFF");
	}

}
