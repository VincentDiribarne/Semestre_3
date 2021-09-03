package creation.monteur;

class Serveur {
	private MonteurPizza monteurPizza;

	public void setMonteurPizza(MonteurPizza mp) {
		monteurPizza = mp;
	}

	public Pizza getPizza() {
		return monteurPizza.getPizza();
	}

	public void construirePizza() {
		monteurPizza.creerNouvellePizza();
		monteurPizza.monterPate();
		monteurPizza.monterSauce();
		monteurPizza.monterGarniture();
	}
}

public class ExempleMonteur {
	public static void main(String[] args) {
		Serveur serveur = new Serveur();
		MonteurPizza monteurPizzaHawaii = new MonteurPizzaHawaii();
		MonteurPizza monteurPizzaPiquante = new MonteurPizzaPiquante();

		serveur.setMonteurPizza(monteurPizzaHawaii);
		serveur.construirePizza();

		Pizza pizza = serveur.getPizza();
	}
}
