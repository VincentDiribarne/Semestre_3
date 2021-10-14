package creation.singleton;

public class A {
    private static A instance;

    public static A getInstance() {
        if (instance == null) {
            instance = new A();
        }
        return instance;
    }

    public A() {
    }

    public void methode() {

    }
}
