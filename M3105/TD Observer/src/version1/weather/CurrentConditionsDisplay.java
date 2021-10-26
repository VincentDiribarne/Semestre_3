package version1.weather;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, Displayable{
	private float temperature;
	private float humidity;

	public CurrentConditionsDisplay(WeatherData weatherData) {
		weatherData.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.temperature = ((WeatherData) o).getTemperature();
		this.humidity = ((WeatherData) o).getHumidity();

		display();
	}
	
	public void display() {
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
	}
}
