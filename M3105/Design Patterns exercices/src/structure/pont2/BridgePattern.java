package structure.pont2;

public class BridgePattern { 
	
    public static void main(String[] args) {
        Vehicle vehicle1 = new Car(new Produce(), new Assemble()); 
        vehicle1.manufacture(); 
    
        Vehicle vehicle2 = new Bike(new Assemble(), new Produce());
        vehicle2.manufacture(); 
    } 
} 
