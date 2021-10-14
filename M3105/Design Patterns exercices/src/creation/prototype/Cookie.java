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
			// do other complex copy
			return (Cookie) super.clone();
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