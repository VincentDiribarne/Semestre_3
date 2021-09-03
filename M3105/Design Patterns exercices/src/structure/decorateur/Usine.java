package structure.decorateur;

public class Usine {
	
	public static void main(String[] args) {
	
		Voiture astonMartin = new VoitureAvecClimatisation(new AstonMartin()); 
		astonMartin = new VoitureAvecParachute(astonMartin); 
		astonMartin = new VoitureAmphibie(astonMartin);
 
		System.out.println(String.format("Prix = %.2f€", astonMartin.getPrix())); 
                // affiche "Prix = 1110,99€"
	}
}

