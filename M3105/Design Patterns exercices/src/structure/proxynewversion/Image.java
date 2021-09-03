package structure.proxynewversion;

public abstract class Image {
	
	public void displayImage() throws InterruptedException {
		System.out.println("This is "+ this.loadImageFromDisk());
	}
	abstract public String loadImageFromDisk() throws InterruptedException;
}
