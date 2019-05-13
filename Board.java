import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Board {

	private Tile[] board = new Tile[40];
	private int[] typeR = { 1, 3, 6, 8, 9, 11, 13, 1416, 18, 19, 21, 23, 24, 26, 27, 29, 31, 32, 34, 37, 39 };
	private int[] typeS = { 5, 15, 25, 35 };
	private int[] typeB = { 12, 28 };
	private int[] typeC = { 7, 22, 36 };
	private int[] typeF = { 2, 17, 33 };
	private int[] typeI = { 4, 38 };

	public Board() throws FileNotFoundException {
		String pathname1 = "real_estate.txt";
		String pathname2 = "stocks.txt";
		String pathname3 = "bonds.txt";
		File file1 = new File(pathname1);
		File file2 = new File(pathname2);
		File file3 = new File(pathname3);

		Scanner reader1 = new Scanner(file1);
		Scanner reader2 = new Scanner(file2);
		Scanner reader3 = new Scanner(file3);

		for (int r : typeR) {

		}

	}

}
