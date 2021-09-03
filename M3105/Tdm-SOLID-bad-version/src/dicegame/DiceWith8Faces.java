package dicegame;

public class DiceWith8Faces extends DiceWith6Faces {

	public int getRandomValueFrom1To8() {
		return ((int)Math.random()*8) + 1;
	}

}
