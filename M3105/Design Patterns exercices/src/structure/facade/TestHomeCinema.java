package structure.facade;

public class TestHomeCinema {
	
	public static void main(String[] args) {
		// instanciation des composants
		Amplificateur amp = new Amplificateur();
		Tuner tuner = new Tuner();
		LecteurDvd dvd = new LecteurDvd();
		LecteurCd cd = new LecteurCd();
		Projecteur projecteur = new Projecteur();
		Ecran ecran = new Ecran();
		Lumieres lumieres = new Lumieres();
		MachineAPopcorn machineAPopCorn = new MachineAPopcorn();
		
		machineAPopCorn.marche();
		machineAPopCorn.eclater();
		lumieres.attenuer(10);
		ecran.baisser();
		projecteur.marche();
		projecteur.setEntree(dvd);
		projecteur.modeGrandEcran();
		amp.marche();
		amp.setDvd(dvd);
		amp.setSonSurround();
		amp.setVolume(5);
		dvd.marche();
		dvd.jouer("The Joker");
	}
}
