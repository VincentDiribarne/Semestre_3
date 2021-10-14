package dicegame;

public interface IDiceGame {
	void start();
	void playOneRound();
	int getRandomDiceValue();
	void displayEntryText();
	void displayPlayAgainText();
	void displaySuccessText();
}
