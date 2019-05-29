import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {

	private int balance;

	private List<Tile> tiles;

	private String name;

	private boolean employed;

	private int position;

	public Player() {
		balance = 1500;
		tiles = new ArrayList<Tile>();
		employed = true;
		position =0;
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

	public int roll() {
		Random gen = new Random();
		return (gen.nextInt(6) + 1) + (gen.nextInt(6) + 1);

	}
	
	public void move() {
		int steps = roll();
		System.out.println(steps);
		position +=steps;
	}
	
	public int getPosition() {
		return position;
	}

	public void getPay() {
		this.setBalance(this.getBalance() + 200);
	}

	public void buyTile(Tile t) {
		tiles.add(t);
	}

	public void sellTile(Tile t) {
		for (int i = 0; i < tiles.size(); i++) {
			if (t.equals(tiles.get(i)))
				tiles.remove(i);

		}
	}

	public void loseJob() {
		employed = false;
	}

	public void getJob() {
		employed = true;
	}
}
