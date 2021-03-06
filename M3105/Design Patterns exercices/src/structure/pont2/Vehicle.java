package structure.pont2;

public abstract class Vehicle { 
	protected Workshop workShop1; 
	protected Workshop workShop2; 

	protected Vehicle(Workshop workShop1, Workshop workShop2) { 
		this.workShop1 = workShop1; 
		this.workShop2 = workShop2; 
	} 

	public abstract void manufacture();

	public Workshop getWorkShop1() {
		return workShop1;
	}

	public Workshop getWorkShop2() {
		return workShop2;
	}
}
