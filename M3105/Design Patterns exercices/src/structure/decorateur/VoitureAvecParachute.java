package structure.decorateur;

class VoitureAvecParachute extends Option {
	public VoitureAvecParachute(Voiture originale) {
		super(originale, 10.0);
	}
}