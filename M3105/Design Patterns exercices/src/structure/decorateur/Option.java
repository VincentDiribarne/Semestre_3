package structure.decorateur;

abstract class Option implements Voiture {
	protected Voiture _originale;
	protected double _tarifOption;

	public Option(Voiture originale, double tarif) {
		_originale = originale;
		_tarifOption += tarif;
	}

	public double getPrix() {
		return _originale.getPrix() + _tarifOption;
	}
}
