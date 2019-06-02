
public class Tile {

	private String name;

	private int price;

	private String color;

	public final int index;

	private Player owner;

	private String type;

	private boolean mortgaged;
	
	private int mortgagePeriod;

	public Tile(String n, int p, String c, int i, Player o, String t) {
		name = n;
		price = p;
		color = c;
		index = i;
		type = t;
		mortgaged = false;

	}

	public void display() {
		this.toString();
	}

	public void changeOwner(Player p) {
		this.owner = p;
	}

	public Player getOwner() {
		return this.owner;
	}

	public void getName() {
		System.out.println(name);
	}

	public int getPrice() {
		return this.price;
	}

	public String getColor() {
		return color;
	}

	public int getIndex() {
		return index;
	}

	public String getType() {
		return type;
	}

	public void becomeMortgage() {
		mortgaged = true;
		mortgagePeriod=5;
		
	}

	public void redeemed() {
		mortgaged = false;
		
	}

	@Override
	public String toString() {

		return "Tile name:" + this.name + "\n" + "Tile price:" + this.price + "\n" + "This tile is own by:" + this.owner
				+ "(null means owned by bank so far)";
	}

}
