
public class Tile {

	protected String name;

	protected int price;

	protected String color;

	protected final int index;

	protected Player owner;

	public Tile(String n, int p, String c, int i, Player o) {
		name = n;
		price = p;
		color = c;
		index = i;

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

	@Override
	public String toString() {
		return this.name + "\n" + this.price + "\n" + this.color + "\n" + this.owner;
	}

}
