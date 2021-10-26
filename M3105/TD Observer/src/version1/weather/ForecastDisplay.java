package version1.weather;

import java.util.*;
import java.util.Observer;

public class ForecastDisplay implements Observer, Displayable {
	private float currentPressure = 29.92f;  
	private float lastPressure;

	public ForecastDisplay(WeatherData weatherData) {
	weatherData.addObserver(this);
	}

	@Override
	public void update(Observable o, Object args) {
        lastPressure = currentPressure;
		currentPressure = ((WeatherData) o).getPressure();

		display();
	}

	@Override
	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			System.out.println("Improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			System.out.println("More of the same");
		} else if (currentPressure < lastPressure) {
			System.out.println("Watch out for cooler, rainy weather");
		}
	}
}
