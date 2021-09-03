package version1.weather;

public class CurrentConditionsDisplay .........{
	private float temperature;
	private float humidity;
	//TODO:
	
	public CurrentConditionsDisplay(................) {
		//TODO:
	}
	
	public void ...........(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		//TODO:
	}
	
	public void display() {
		System.out.println("Current conditions: " + temperature 
			+ "F degrees and " + humidity + "% humidity");
	}
}
