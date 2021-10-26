package structure.facade;

public class TestHomeCinema2 {
	
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
		
		FacadeHomeCinema homeCinema = new FacadeHomeCinema(amp, tuner, dvd, cd, projecteur, ecran, lumieres, machineAPopCorn);

		homeCinema.regarderFilm("The Joker");
		homeCinema.arreterFilm(); 
	}
}
