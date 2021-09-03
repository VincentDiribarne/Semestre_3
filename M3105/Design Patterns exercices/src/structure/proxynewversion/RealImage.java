package structure.proxynewversion;

public class RealImage extends Image{
	private String filename;
	
	public RealImage(String filename) {
		this.filename = filename;
	}
	
	
	
	@Override
	public String loadImageFromDisk() throws InterruptedException {
		for(int i=0;i<=10;i++) {
			System.out.println("loading image "+i*10+"%");
			Thread.sleep(500);
		}
		return "loaded image "+this.filename;
	}

}
