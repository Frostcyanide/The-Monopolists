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
		position = 0;
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
		position += steps;
	}

	public void moveTo(int index) {
		position = index;
	}

	public int getPosition() {
		return position;
	}

	public void getPay() {
		this.setBalance(this.getBalance() + 200);
	}

	public void buyTile(Tile t) {
		tiles.add(t);
		balance -= t.getPrice();
	}

	public void sellTile(Tile t) {
		for (int i = 0; i < tiles.size(); i++) {
			if (t.equals(tiles.get(i)))
				tiles.remove(i);

		}
		balance += t.getPrice() * 0.75;
	}

	public void payRent(Real_estate r) {
		balance -= r.getRent();
	}

	public void receiveRent(Real_estate r) {
		balance += r.getRent();
	}

	public void payTax(Tile t) {

	}

	public void returnInvestment(Stock s) {
		Random gen = new Random();
		if (gen.nextInt(2) == 1)
			balance += gen.nextInt(4) * s.getPrice();
		else
			balance -= gen.nextInt(4) * s.getPrice();

	}

	public void returnBond(Bond b) {
		balance += b.getPrice() * 2;
	}

	public void loseJob() {
		employed = false;
	}

	public void getJob() {
		employed = true;
	}

}
