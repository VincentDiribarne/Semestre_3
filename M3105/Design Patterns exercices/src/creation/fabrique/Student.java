package creation.fabrique;

public interface Student {
	public void giveOOskill();
}

class SmartStudent implements Student {
	public void giveOOskill() {
		System.out.println("Good level");
	}
}

class DumbStudent implements Student {
	@Override
	public void giveOOskill() {
		System.out.println("You're very crazy and dumb !");
	}
}