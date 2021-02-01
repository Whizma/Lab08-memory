<<<<<<< HEAD
package memory;

public class MemoryGame {
	public static void main(String[] args) {
		String[] frontFileNames = {"can.jpg", "flopsy_mopsy_cottontail.jpg",
				"friends.jpg", "mother_ladybird.jpg", "mr_mcgregor.jpg",
				"mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };
		
		// Fyll i egen kod här
	}
}
=======
package memory;

public class MemoryGame {
	public static void main(String[] args) {
		String[] frontFileNames = { "can.jpg", "flopsy_mopsy_cottontail.jpg", "friends.jpg", "mother_ladybird.jpg",
				"mr_mcgregor.jpg", "mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };
		String backFileName = "back.jpg";
		MemoryBoard game = new MemoryBoard(4, backFileName, frontFileNames);
		MemoryWindow window = new MemoryWindow(game);
		window.drawBoard();
		while (game.hasWon() == false) {
			window.waitForMouseClick();
			game.turnCard(window.getMouseRow(),window.getMouseCol());
			window.drawCard(window.getMouseRow(),window.getMouseCol());
			
			
			
			window.delay(1000);
		}


		// Fyll i egen kod här
	}
}
>>>>>>> c286feb629bca7f2fa7e95954caa43a9be84decf
