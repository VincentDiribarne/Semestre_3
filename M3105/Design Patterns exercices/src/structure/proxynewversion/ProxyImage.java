package structure.proxynewversion;

public class ProxyImage extends Image {
	private String loadedImage;
	private RealImage rimage;
	
	public ProxyImage(RealImage rimage) {
		this.rimage = rimage;
	}

	@Override
	public String loadImageFromDisk() throws InterruptedException {
		if(loadedImage == null) {
			loadedImage = rimage.loadImageFromDisk();
		}
		return loadedImage;
	}

}
