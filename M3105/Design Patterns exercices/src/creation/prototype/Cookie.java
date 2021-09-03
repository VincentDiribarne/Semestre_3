package creation.prototype;

public class Cookie implements Cloneable {

	private String taste;

	public Cookie(String taste) {
		super();
		this.taste = taste;
	}

	public String toString() {
		return "Cookie with a " + taste + " flavour";
	}

	@Override
	public Cookie clone() {
		try {
			Cookie copy = (Cookie) super.clone();
			// do other complex copy
			return copy;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}

class CoconutCookie extends Cookie {

	public CoconutCookie() {
		super("coconut");
	}

}