package structure.facade;

public class FacadeHomeCinema {

	private Amplificateur amp;
	private Tuner tuner;
	private LecteurDvd dvd;
	private LecteurCd cd;
	private Projecteur projecteur;
	private Lumieres lumieres;
	private Ecran ecran;
	private MachineAPopcorn machineAPopCorn;

	public FacadeHomeCinema(Amplificateur amp, Tuner tuner, LecteurDvd dvd, LecteurCd cd, Projecteur projecteur,
			Ecran ecran, Lumieres lumieres, MachineAPopcorn machineAPopCorn) {
		this.amp = amp;
		this.tuner = tuner;
		this.dvd = dvd;
		this.cd = cd;
		this.projecteur = projecteur;
		this.ecran = ecran;
		this.lumieres = lumieres;
		this.machineAPopCorn = machineAPopCorn;
	}

	// autres méthodes

	public void regarderFilm(String film) {

		System.out.println("Vous allez voir un bon film...");
		machineAPopCorn.marche();
		machineAPopCorn.eclater();
		lumieres.attenuer(10);
		ecran.baisser();
		projecteur.marche();
		projecteur.modeGrandEcran();
		amp.marche();
		amp.setDvd(dvd);
		amp.setSonSurround();
		amp.setVolume(5);
		dvd.marche();
		dvd.jouer(film);
	}

	public void arreterFilm() {
		System.out.println("C’est la fin du film...");
		machineAPopCorn.arret();
		lumieres.marche();
		ecran.monter();
		projecteur.arret();
		amp.arret();
		dvd.stop();
		dvd.ejecter();
		dvd.arret();
	}

}
