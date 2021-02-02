package memory;

import java.awt.Image;
import java.util.Random;

public class MemoryBoard {

	private int size;
	MemoryCardImage[][] board;
	private String backFileName;
	private String[] frontFileNames;
	private int totalCards;
	boolean[][] turned;

	/**
	 * Skapar ett memorybräde med size * size kort. backFileName är filnamnet för
	 * filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen för
	 * frontbilderna.
	 */
	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {
		this.size = size;
		this.backFileName = backFileName;
		this.frontFileNames = frontFileNames;
		createCards(backFileName, frontFileNames);

	}

	/*
	 * Skapar size * size / 2 st memorykortbilder. Placerar ut varje kort på två
	 * slumpmässiga ställen på spelplanen.
	 */
	private void createCards(String backFileName, String[] frontFileNames) {
		int cards = 2 * size;
		int totalCards = size * size; // storleken på spelbrädet
		MemoryCardImage[][] board = new MemoryCardImage[size][size]; // "spelbrädet"
		this.board = board;
		MemoryCardImage[] cardArray = new MemoryCardImage[cards]; // En array med cards-objekt
		String frontFileName;

		for (int i = 0; i < frontFileNames.length; i++) {
			frontFileName = frontFileNames[i];
			MemoryCardImage card = new MemoryCardImage(frontFileName, backFileName);
			cardArray[i] = card;

		}
		Random rand1 = new Random();
		int r = rand1.nextInt(size);
		Random rand2 = new Random();
		int c = rand2.nextInt(size);

		for (int j = 0; j < 2; j++) {
			for (int a = 0; a < cards; a++) {
				while (board[r][c] != null) {
					r = rand1.nextInt(size);
					c = rand2.nextInt(size);
				}
				if (board[r][c] == null) {
					board[r][c] = cardArray[a];
				}
			}

		}
		boolean[][] turned = new boolean[size][size];
		for (int r1 = 0; r1 < size; r1++) {
			for (int c1 = 0; c1 < size; c1++) {
				turned[r1][c1] = false;

			}
			this.turned = turned;
		}

		

	}

	/** Tar reda på brädets storlek. */
	public int getSize() {
		return size;
	}

	/**
	 * Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c. Raderna och
	 * kolonnerna numreras från 0 och uppåt.
	 */
	public MemoryCardImage getCard(int r, int c) {
		return board[r][c];
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {
		if (frontUp(r, c) == false) {
			turned[r][c] = true;
		} else {
			turned[r][c] = false;
		}

	}

	/*
	 * if (board.frontUp(r, c)) {
	 * getAdvancedControls().drawImage(card.getFront().getScaledInstance(imgSize,
	 * imgSize, Image.SCALE_SMOOTH)); } else {
	 * getAdvancedControls().drawImage(card.getBack().getScaledInstance(imgSize,
	 * imgSize, Image.SCALE_SMOOTH)); }
	 * 
	 * /** Returnerar true om kortet r, c har framsidan upp.
	 */
	public boolean frontUp(int r, int c) {
		boolean res = false;
		if (turned[r][c] == true) {
			res = true;
		}
		return res;
	}

	/**
	 * Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2,
	 * kolonn c2.
	 */
	public boolean same(int r1, int c1, int r2, int c2) {
		boolean res = false;
		if (board[r1][c1] == board[r2][c2]) {
			res = true;
		}
		return res;
	}

	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon() {
		boolean res = true;
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (turned[c][r] == false) {
					res = false;
				}
			}
		}
		return res;
	}
}