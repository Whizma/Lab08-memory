package memory;

public class MemoryGame {
	public static void main(String[] args) {
		String[] frontFileNames = { "can.jpg", "flopsy_mopsy_cottontail.jpg", "friends.jpg", "mother_ladybird.jpg",
				"mr_mcgregor.jpg", "mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };
		String backFileName = "back.jpg";
		MemoryBoard game = new MemoryBoard(4, backFileName, frontFileNames);
		MemoryWindow window = new MemoryWindow(game);
		int row;
		int col;
		int row2;
		int col2;
		int tries = 0;
		window.drawBoard();
		while (game.hasWon() == false) {
			window.waitForMouseClick();
			row = window.getMouseRow();
			col = window.getMouseCol();
			while (game.frontUp(row, col) == true) {
				window.waitForMouseClick();
				row = window.getMouseRow();
				col = window.getMouseCol();
			}
			game.turnCard(row, col);
			window.drawCard(row, col);
		

		window.waitForMouseClick();

		row2 = window.getMouseRow();
		col2 = window.getMouseCol();
		while (game.frontUp(row2, col2) == true) {
			window.waitForMouseClick();
			row2 = window.getMouseRow();
			col2 = window.getMouseCol();
		}
		game.turnCard(row2, col2);
		window.drawCard(row2, col2);

		if (game.same(row, col, row2, col2) == false) {
			window.delay(1000);
			game.turnCard(row, col);
			window.drawCard(row, col);
			game.turnCard(row2, col2);
			window.drawCard(row2, col2);
		}
		tries++;
	}
		System.out.println("Det tog dig" + " " + tries + " " + "försök för att vinna");
}
}
