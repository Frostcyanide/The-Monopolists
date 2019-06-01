import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {

	private Tile[] board = new Tile[40];
	private int[] typeR = { 1, 3, 6, 8, 9, 11, 13, 14, 16, 18, 19, 21, 23, 24, 26, 27, 29, 31, 32, 34, 37, 39 };
	private int[] typeS = { 5, 15, 25, 35 };
	private int[] typeB = { 12, 28 };
	private int[] typeC = { 7, 22, 36 };
	private int[] typeF = { 2, 17, 33 };
	private int[] typeT = { 4, 38 };

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
			board[typeR[i]] = new Real_estate(reader1.nextLine(), reader4.nextInt(), reader5.nextLine(), typeR[i], null,
					"RE");
		}
		for (int i = 0; i < typeS.length; i++) {
			board[typeS[i]] = new Stock(reader2.nextLine(), reader6.nextInt(), "black", typeS[i], null, "S");
		}
		for (int i = 0; i < typeB.length; i++) {
			board[typeB[i]] = new Bond(reader3.nextLine(), reader7.nextInt(), "white", typeB[i], null, "B");
		}
		for (int i = 0; i < typeC.length; i++) {
			board[typeC[i]] = new Chance("Chance", 0, "chance", typeC[i], null, "C");
		}
		for (int i = 0; i < typeF.length; i++) {
			board[typeF[i]] = new Fate("Fate", 0, "fate", typeF[i], null, "F");

		}

		board[4] = new Tile("Luxury tax", -150, "grey", 4, null, "T");
		board[38] = new Tile("Automobile tax", -250, "grey", 38, null, "T");
		board[0] = new Tile("Payday, collect $200", 200, "NC", 0, null, "T");
		board[10] = new Tile("Helping the unemployed", -100, "NC", 10, null, "T");
		board[20] = new Tile("Vacation", 0, "NC", 20, null, "T");
		board[30] = new Tile("Got fired!", 0, "NC", 30, null, "T");

	}

	public Tile atIndex(int index) {
		return board[index];
	}

	public void hostAuction(ArrayList<Player> players, Tile t) {
		Scanner input = new Scanner(System.in);
		int highestPrice = 0;
		Player highestPlayer = null;

		while (players.size() != 1) {

			for (Player p : players) {
				System.out.println("The current highest price is $" + highestPrice + " by " + "highestPlayer\n"
						+ p.getName() + ", would you like to bid or fold?(1/2)");
				if (input.nextInt() == 2)
					players.remove(p);
				else {
					System.out.println("How much would you bid?");
					int price = input.nextInt();
					if (price > highestPrice) {
						highestPrice = price;
						highestPlayer = p;
					}
				}
			}

			System.out.println(players.get(0).getName() + "won the auction at a price of " + highestPrice
					+ " and got the tile\n" + t.toString());

			players.get(0).buyTile(t);
			players.get(0).setBalance(players.get(0).getBalance() + t.getPrice() - highestPrice);

		}
	}
}
