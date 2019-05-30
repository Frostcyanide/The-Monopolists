import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.Random;

public class Chance extends Tile {
	private List<String> deck = new ArrayList<String>();

	private Random gen = new Random();

	public Chance(String name, int price, String color, int index, Player owner, String type)
			throws FileNotFoundException {

		super(name, price, color, index, owner, type);
		File file1 = new File("Chance.txt");
		Scanner reader1 = new Scanner(file1);

		while (reader1.hasNextLine()) {
			deck.add(reader1.nextLine());
		}
	}

	public int generateChance() {
		Random gen = new Random();
		int r = gen.nextInt(10);
		System.out.println(deck.get(r));
		return r;
	}

}
