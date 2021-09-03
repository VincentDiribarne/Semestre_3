package structure.proxynewversion;

public class TestImage {

	public static void main(String[] args) throws InterruptedException {
		
		//Image proxy = new ProxyImage(new RealImage("toto.jpeg"));
		Image proxy = new RealImage("toto.jpeg");
		
		System.out.println("First diplaying");
		proxy.displayImage();
		System.out.println("Second diplaying");
		proxy.displayImage();
	}

}
