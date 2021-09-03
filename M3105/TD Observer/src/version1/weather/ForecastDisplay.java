package version1.weather;

import java.util.*;

public class ForecastDisplay .... {
	private float currentPressure = 29.92f;  
	private float lastPressure;
	//TODO:

	public ForecastDisplay(..............) {
		//TODO:
	}

	public void ............(float temp, float humidity, float pressure) {
        lastPressure = currentPressure;
		currentPressure = pressure;
		//TODO:
	}

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
