import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Fate extends Tile {
	private List<String> deck = new ArrayList<String>();
	private Random gen = new Random();

	public Fate(String name, int price, String color, int index, Player owner, String type)
			throws FileNotFoundException {

		super(name, price, color, index, owner, type);
		File file1 = new File("Fate.txt");
		Scanner reader1 = new Scanner(file1);

		while (reader1.hasNextLine()) {
			deck.add(reader1.nextLine());
		}
	}

	public void generateFate(Player p, Board arena, ArrayList<Player> players) {
		Scanner input = new Scanner(System.in);
		Random gen = new Random();
		int r = gen.nextInt(10);
		System.out.println(deck.get(r));
		switch (r) {
		case 0:
			p.setBalance(p.getBalance() - 100);
			System.out.println("Your new balance: " + p.getBalance());
			break;

		case 1:
			p.setBalance(p.getBalance() - 50);
			System.out.println("Your new balance: " + p.getBalance());
			break;

		case 2:
			p.setBalance(p.getBalance() - 75);
			System.out.println("Your new balance: " + p.getBalance());
			break;

		case 3:
			p.setBalance(p.getBalance() - 50);
			System.out.println("Your new balance: " + p.getBalance());
			break;

		case 4:
			p.setBalance(p.getBalance() - 150);
			System.out.println("Your new balance: " + p.getBalance());
			break;

		case 5:
			p.setBalance(p.getBalance() + 100);
			System.out.println("Your new balance: " + p.getBalance());
			break;

		case 6:
			p.setBalance(p.getBalance() + 50);
			System.out.println("Your new balance: " + p.getBalance());
			break;

		case 7:
			p.setBalance(p.getBalance() + 25);
			System.out.println("Your new balance: " + p.getBalance());
			break;

		case 8:
			p.loseJob();
			break;

		case 9:
			p.setBalance(p.getBalance() - 30);
			System.out.println("Your new balance: " + p.getBalance());
			p.loseJob();
			break;
		}

	}

}
