
public class Tile {

	private String name;

	private int price;

	private String color;

	public final int index;

	private Player owner;

	private String type;

	public Tile(String n, int p, String c, int i, Player o, String t) {
		name = n;
		price = p;
		color = c;
		index = i;
		type = t;

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

	@Override
	public String toString() {
		return this.name + "\n" + this.price + "\n" + this.color + "\n" + this.owner;
	}

}
