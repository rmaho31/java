package gg;

public class GuessingGameApp {

	public static void main(String[] args) {
		//initializes Game instance
		//@param is limit for the game
		Game g1 = new Game(100);
		
		g1.displayWelcomeMessage();
		g1.mainLoop(100);
		g1.displayGoodbye();

	}
}
