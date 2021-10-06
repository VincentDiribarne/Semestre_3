package creation.singleton;

public class TestA {

	public TestA() {
	}

	public void trucaFaire() {
		A.getInstance().methode();
	}

	public static void main(String[] args) {
		new TestA();
	}
}
