import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
		return "Player " + this.name;
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
			System.out.println();

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

		balance -= t.getPrice();
		getTile(t);

	}

	public void getTile(Tile t) {
		tiles.add(t);
		t.changeOwner(this);
	}

	public void sellTile(Tile t) {
		for (int i = 0; i < tiles.size(); i++) {
			if (t.equals(tiles.get(i))) {
				loseTile(t);

			}
		}
		balance += t.getPrice() * 0.6;
	}

	public void loseTile(Tile t) {
		tiles.remove(t);
		t.changeOwner(null);

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
			System.out.print(p.getName());
			System.out.println();

		}

		System.out.println("Who do you want to trade with?");
		int choice1 = input.nextInt();

		displayProperty();
		System.out.println(
				"Which property do you offer?(Enter one property's number, or -1 if you don't offer a property)");
		int location = input.nextInt();

		System.out.println("How much are you offering?");
		int priceOffer = input.nextInt();

		players.get(choice1).displayProperty();
		System.out.println("What property do you wish to get?");

		int demand = input.nextInt();

		System.out.println("How much do you demand?");
		int demandPrice = input.nextInt();

		if (!this.tradeRequest(players.get(choice1), tiles.get(location), priceOffer,
				players.get(choice1).returnProperty(demand), demandPrice))
			System.out.println("Trade rejected by ");

		else {
			/*
			 * Buyer loses the amount he offered Seller receives that
			 */
			players.get(choice1).setBalance(players.get(choice1).getBalance() + demandPrice);
			balance -= priceOffer;
			/*
			 * Buyer gets the amount he demands Seller loses that
			 */
			balance += demandPrice;
			players.get(choice1).setBalance(players.get(choice1).getBalance() - demandPrice);
			/*
			 * Seller gets the tile offered by buyer Buyer loses that tile
			 */
			players.get(choice1).getTile(tiles.get(location));
			this.loseTile(tiles.get(location));
			/*
			 * Buyer gets the tile he demands Seller loses it
			 */
			this.getTile(players.get(choice1).returnProperty(demand));
			players.get(choice1).loseTile(players.get(choice1).returnProperty(demand));

		}

	}

//displaying problem
	public boolean tradeRequest(Player p, Tile tOffer, int mOffer, Tile tDemand, int mDemand) {
		Scanner input = new Scanner(System.in);
		System.out.println(p.getName() + ", " + this.getName() + " has sent you a trade request, offering\n" + tOffer
				+ "\n\n and $" + mOffer + " in exchange for \n" + tDemand + "\n\n and $" + mDemand
				+ "\n\n, accept or deny?(1/2)");
		return input.nextInt() == 1;

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
		this.moveTo(9);
	}

	public void findJob() throws InterruptedException {
		int r = roll();
		System.out.println("Looking for jobs......(Get a job only when you hit 3, 6, 9, or 12)");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Trying out for the Patriots...");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Running for presidents...");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Trying to be a Youtuber...");
		TimeUnit.SECONDS.sleep(1);

		System.out.println(r);

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

	public int totalValue() {

		System.out.println(this.getName() + "has the following properties:");
		System.out.println("Cash:" + Integer.toString(balance));
		displayProperty();

		int total = balance;
		for (Tile t : tiles) {
			total += t.getPrice();
		}
		return total;
	}

	public boolean bankrupt() {
		return balance < 0;
	}

	public boolean getLiquidated() {
		System.out.println(
				"You are in bankrupcy now! The only way to stay in the game is to sell all your properties until you have enough cash");
		while (tiles.size() > 0) {
			System.out.println("The following tiles has been liquidated:");
			tiles.get(tiles.size() - 1).display();
			this.sellTile(tiles.get(tiles.size() - 1));

		}

		System.out.println("All mortgages will be taken away as well");

		for (Tile t : mortgages) {
			t.changeOwner(null);
		}

		if (balance < 0) {
			System.out.println(
					"Your properties still can not afford your debts, unfortunately you lose and will be removed from the game");
			return false;
		}

		return true;

	}

}
