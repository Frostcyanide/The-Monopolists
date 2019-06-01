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

	public void generateChance(Player p, Board arena, ArrayList<Player> players) {
		Scanner input = new Scanner(System.in);
		Random gen = new Random();
		int r = gen.nextInt(10);
		System.out.println(deck.get(r));
		switch (r) {
		case 0:
			p.moveTo(0);
			p.setBalance(p.getBalance() + 200);
			System.out.println("You are at "); // displaying the current tile information
			arena.atIndex(p.getPosition()).display();
			System.out.println("Your new balance: " + p.getBalance());
			break;
		case 1:
			p.setBalance(p.getBalance() + 300);
			System.out.println("Your new balance: " + p.getBalance());
			break;
		case 2:
			p.moveTo(p.getPosition() - 3);
			System.out.println("You are at "); // displaying the current tile information
			arena.atIndex(p.getPosition()).display();
			break;
		case 3:
			p.setBalance(p.getBalance() - 50);
			System.out.println("Your new balance: " + p.getBalance());
			break;
		case 4:
			p.moveTo(39);
			System.out.println("You are at "); // displaying the current tile information
			arena.atIndex(p.getPosition()).display();
			if (arena.atIndex(39).getOwner() == null) {
				System.out.println("Buy or auction it?(1/2)");
				if (input.nextInt() == 1) {
					p.buyTile(arena.atIndex(39));
				} else {
					// auction
				}
			}

			else {
				p.payRent((Real_estate) arena.atIndex(39));
				arena.atIndex(39).getOwner().receiveRent((Real_estate) arena.atIndex(39));
			}
			break;
		case 5:
			p.moveTo(4);
			p.setBalance(p.getBalance() - 150);
			System.out.println("Your new balance: " + p.getBalance());
			break;
		case 6:
			p.moveTo(8);
			System.out.println("You are at "); // displaying the current tile information
			arena.atIndex(p.getPosition()).display();
			input = new Scanner(System.in);
			if (arena.atIndex(39).getOwner() == null) {
				System.out.println("Buy or auction it?(1/2)");
				if (input.nextInt() == 1) {
					p.buyTile(arena.atIndex(39));
				} else {
					arena.hostAuction(players, arena.atIndex(8));
				}
			}

			else {
				p.payRent((Real_estate) arena.atIndex(39));
				arena.atIndex(39).getOwner().receiveRent((Real_estate) arena.atIndex(39));
			}
			break;
		case 7:
			p.setBalance((int) (p.getBalance() * 0.8));
			System.out.println("Your new balance: " + p.getBalance());
			break;
		case 8:
			p.setBalance(p.getBalance() - 20);
			System.out.println("Your new balance: " + p.getBalance());
			break;
		case 9:
			p.setBalance(p.getBalance() - 40);
			System.out.println("Your new balance: " + p.getBalance());
			break;

		}

	}

}
