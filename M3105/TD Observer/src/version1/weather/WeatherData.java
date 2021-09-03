package version1.weather;

import java.util.*;

public class WeatherData ...... {
	private List observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		//TODO:
	}
	
	public void registerObserver(Observer o) {
		//TODO:
	}
	
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}
	
	public void notifyObservers() {
		//TODO:
	}
	
	public void measurementsChanged() {
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		//TODO:
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public float getHumidity() {
		return humidity;
	}
	
	public float getPressure() {
		return pressure;
	}
}
