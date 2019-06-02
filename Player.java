import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Player {

	private int balance;

	private List<Tile> tiles;

	private List<Tile> mortgages;

	private String name;

	private boolean employed;

	private int position;

	private int remainRoundUnemployed;

	public Player(String n) {
		balance = 1500;
		tiles = new ArrayList<Tile>();
		mortgages = new ArrayList<Tile>();
		employed = true;
		position = 0;
		name = n;
		remainRoundUnemployed = 0;
	}

	public String getName() {
		return "Player" + this.name;
	}

	public int getBalance() {
		return this.balance;
	}

	public void setBalance(int b) {
		this.balance = b;
	}

	public void displayProperty() {
		int count = 0;
		for (Tile t : tiles) {
			System.out.print(count + ". ");
			t.getName();
			count++;

		}
	}

	public Tile returnProperty(int i) {
		return tiles.get(i);
	}

	public int roll() {
		Random gen = new Random();
		return (gen.nextInt(6) + 1) + (gen.nextInt(6) + 1);

	}

	public void moveTo(int index) {
		position = index;
	}

	public void checkBeforeMove(int step) {
		System.out.println(step);
		if (this.getPosition() + step > 39)
			this.moveTo(getPosition() + step - 40);
		else
			position += step;
	}

	public int getPosition() {
		return position;
	}

	public void getPay() {
		this.setBalance(this.getBalance() + 200);
	}

	public boolean afford(int price) {
		return this.getBalance() >= price;
	}

	public void buyTile(Tile t) {
		tiles.add(t);
		balance -= t.getPrice();
	}

	public void sellTile(Tile t) {
		for (int i = 0; i < tiles.size(); i++) {
			if (t.equals(tiles.get(i))) {
				t.changeOwner(null);
				tiles.remove(i);

			}
		}
		balance += t.getPrice() * 0.6;
	}

	public void buildRoom(Board arena) {
		Scanner input = new Scanner(System.in);
		this.displayProperty();
		System.out.println("Which one do you want to build more rooms in?");
		int location, numberOfRooms;
		location = input.nextInt();
		System.out.println("How many new rooms? Each one costs $" + arena.atIndex(location).getPrice() / 5);
		numberOfRooms = input.nextInt();

		if (!this.afford(arena.atIndex(location).getPrice() / 5)) {
			System.out.println("^^^^^^^^^^^You can't afford this^^^^^^^^^^^^^");
		} else {
			balance -= arena.atIndex(location).getPrice() / 5 * numberOfRooms;
			System.out.println("^^^^^^^^^^Purchase completed^^^^^^^^^^");

		}
	}

	public void getMortgage(Board arena) {
		Scanner input = new Scanner(System.in);
		this.displayProperty();
		System.out.println("Which one do you want to mortgage? You got 75% of the amount you paid for the property.");
		int location = input.nextInt();

		balance += arena.atIndex(location).getPrice() * 0.75;
		arena.atIndex(location).becomeMortgage();
		mortgages.add(arena.atIndex(location));

	}

	public void redeemProperty(Board arena) {
		Scanner input = new Scanner(System.in);
		this.displayProperty();
		System.out.println("Which one do you redeem? You pay the orginal price for it.");
		int location = input.nextInt();

		if (!this.afford(arena.atIndex(location).getPrice()))
			System.out.println("You can't afford it");
		else {
			arena.atIndex(location).redeemed();
			balance -= arena.atIndex(location).getPrice();
			System.out.println("Property redeemed!");
		}
	}

	public void trade(ArrayList<Player> players) {
		Scanner input = new Scanner(System.in);
		int count = 0;
		for (Player p : players) {
			System.out.print(count + ". ");
			count++;
			p.getName();
		}

		System.out.println("Who do you want to trade with?");
		int choice = input.nextInt();

	}

	public boolean tradeRequest(Player p) {

	}

	public void payRent(Real_estate r) {
		balance -= r.getRent();
	}

	public void receiveRent(Real_estate r) {
		balance += r.getRent();
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

	public boolean haveJob() {
		return employed;
	}

	public void loseJob() {
		employed = false;
		remainRoundUnemployed = 3;
		position = 9;
	}

	public void findJob() {
		int r = roll();
		if (r == 3 || r == 6 || r == 9 || r == 12) {
			employed = true;
			remainRoundUnemployed = 0;
			checkBeforeMove(r);
			System.out.println("You received $" + r * 50 + "from your new boss to help you begin a new life! ");
			balance += r * 50;
		} else {
			remainRoundUnemployed--;
			System.out.println("You have " + remainRoundUnemployed + " rounds to find a new job");

			if (remainRoundUnemployed == 0) {
				employed = true;
				System.out.println("You got a new job!");
			}
		}
	}

}
