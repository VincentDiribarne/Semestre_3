package structure.pont;

public class BrigdeTV {

	public static void main(String[] args) {
		
		AbstractRemoteControl telecommande = new LogitechRemoteControl(new SonyTV());
		
		telecommande.turnOn();
		telecommande.setChannel(1);
		telecommande.setChannel(2);
		telecommande.turnOff();

	}

}
