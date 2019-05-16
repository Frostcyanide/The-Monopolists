import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {

	private int balance;

	private List<Tile> tiles;

	private String name;

	private boolean employed;

	public Player() {
		balance = 1500;
		tiles = new ArrayList<Tile>();
		employed = true;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String n) {
		this.name = n;
	}

	public int getBalance() {
		return this.balance;
	}

	public void setBalance(int b) {
		this.balance = b;
	}

	private int roll() {
		Random gen = new Random();
		return (gen.nextInt(6) + 1) * 2;

	}

	private void getPay() {
		this.setBalance(this.getBalance() + 200);
	}

	private void buyTile(Tile t) {
		tiles.add(t);
	}

	private void sellTile(Tile t) {
		for (int i = 0; i < tiles.size(); i++) {
			if (t.equals(tiles.get(i)))
				tiles.remove(i);

		}
	}

	private void loseJob() {
		employed = false;
	}

	private void getJob() {
		employed = true;
	}
}
