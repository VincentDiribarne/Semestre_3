package creation.monteur;

public abstract class MonteurPizza {
	protected Pizza pizza;

	public Pizza getPizza() {
		return pizza;
	}

	public void creerNouvellePizza() {
		pizza = new Pizza();
	}

	public abstract void monterPate();

	public abstract void monterSauce();

	public abstract void monterGarniture();
}

class MonteurPizzaHawaii extends MonteurPizza {
	public void monterPate() {
		pizza.setPate("croisée");
	}

	public void monterSauce() {
		pizza.setSauce("douce");
	}

	public void monterGarniture() {
		pizza.setGarniture("jambon+ananas");
	}
}

class MonteurPizzaPiquante extends MonteurPizza {
	public void monterPate() {
		pizza.setPate("feuilletée");
	}

	public void monterSauce() {
		pizza.setSauce("piquante");
	}

	public void monterGarniture() {
		pizza.setGarniture("pepperoni+salami");
	}
}