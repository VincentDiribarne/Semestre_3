package comportement.patron2methode;

class Coffee extends BoissonCafeinee {
	public void preparer() {
		System.out.println("Passage du cafe");
	}

	public void ajouterSupplements() {
		System.out.println("Ajout du lait et du sucre");
	}
}