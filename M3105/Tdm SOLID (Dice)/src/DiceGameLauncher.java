import dicegame.Dice;
import dicegame.DiceGame;
import dicegame.DiceWith8Faces;
import dicegame.IDiceGame;

public class DiceGameLauncher {

	public static void main(String[] args) {
		Dice dice8Faces = new DiceWith8Faces();
		IDiceGame game = new DiceGame();
		game.start();
	}

}
