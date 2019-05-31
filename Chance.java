import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.Random;

public class Chance extends Tile {
	private List<String> deck = new ArrayList<String>();

	public Chance(String name, int price, String color, int index, Player owner, String type)
			throws FileNotFoundException {

		super(name, price, color, index, owner, type);
		File file1 = new File("Chance.txt");
		Scanner reader1 = new Scanner(file1);

		while (reader1.hasNextLine()) {
			deck.add(reader1.nextLine());
		}
	}

	public void generateChance(Player p, Board arena) {
		Random gen = new Random();
		int r = gen.nextInt(10);
		System.out.println(deck.get(r));
		switch (r) {
		case 0:
			p.moveTo(0);
			p.setBalance(p.getBalance() + 200);
			break;
		case 1:
			// skip first
			break;
		case 2:
			p.moveTo(p.getPosition() - 5);
			break;
		case 3:
			p.setBalance(p.getBalance() - 50);
			break;
		case 4:
			Scanner input = new Scanner(System.in);
			p.moveTo(39);
			if (arena.atIndex(39).getOwner() == null) {
				System.out.println("Buy or action it?(1/2)");
				if (input.nextInt() == 1) {
					p.buyTile(arena.atIndex(39));
				} else {
					// auction
				}
			}
			break;
		case 5:
			p.moveTo(4);
			break;
		case 6:
			p.moveTo(8);
			break;
		case 7:
			// unfinished
			break;
		case 8:
			p.setBalance(p.getBalance() - 20);
			break;
		case 9:
			p.setBalance(p.getBalance() - 40);

			break;

		}

	}

}
