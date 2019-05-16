import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Board {

	private Tile[] board = new Tile[40];
	private int[] typeR = { 1, 3, 6, 8, 9, 11, 13, 14, 16, 18, 19, 21, 23, 24, 26, 27, 29, 31, 32, 34, 37, 39 };
	private int[] typeS = { 5, 15, 25, 35 };
	private int[] typeB = { 12, 28 };
	private int[] typeC = { 7, 22, 36 };
	private int[] typeF = { 2, 17, 33 };
	private int[] typeI = { 4, 38 };

	public Board() throws FileNotFoundException {
		String pathname1 = "real_estate.txt";
		String pathname2 = "stocks.txt";
		String pathname3 = "bonds.txt";
		String pathname4 = "real_estate_price.txt";
		String pathname5 = "real_estate_color.txt";
		String pathname6 = "stocks_price.txt";
		String pathname7 = "bond_price.txt";

		File file1 = new File(pathname1);
		File file2 = new File(pathname2);
		File file3 = new File(pathname3);
		File file4 = new File(pathname4);
		File file5 = new File(pathname5);
		File file6 = new File(pathname6);
		File file7 = new File(pathname7);

		Scanner reader1 = new Scanner(file1);
		Scanner reader2 = new Scanner(file2);
		Scanner reader3 = new Scanner(file3);
		Scanner reader4 = new Scanner(file4);
		Scanner reader5 = new Scanner(file5);
		Scanner reader6 = new Scanner(file6);
		Scanner reader7 = new Scanner(file7);

		for (int i = 0; i < typeR.length; i++) {
			board[i] = new Real_estate(reader1.nextLine(), reader4.nextInt(), reader5.nextLine(), i);
		}
		for (int i = 0; i < typeS.length; i++) {
			board[i] = new Stock(reader2.nextLine(), reader6.nextInt(), "black", i);
		}
		for (int i = 0; i < typeB.length; i++) {
			board[i] = new Bond(reader3.nextLine(), reader7.nextInt(), "white", i);
		}
		for (int i = 0; i < typeC.length; i++) {
			board[i] = new Chance("Chance", 0, "c", i);
		}
		for (int i = 0; i < typeF.length; i++) {
			board[i] = new Fate("Fate", 0, "f", i);

		}

		board[4] = new Tile("Luxury tax", 150, "grey", 4);
		board[38] = new Tile("Automobile tax", 250, "grey", 38);

	}

}
