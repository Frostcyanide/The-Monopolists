
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
		System.out.println(this.toString());
	}

	public void changeOwner(Player p) {
		owner = p;
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

	@Override
	public String toString() {

		if (owner == null)
			return "Tile name:" + name + "\n" + "Tile color:" + color + "\n" + "Tile price:" + price + "\n"
					+ "This tile is own by:" + " bank ";
		return "Tile name:" + name + "\n" + "Tile color:" + color + "\n" + "Tile price:" + price + "\n"
				+ "This tile is own by:" + owner.getName();
	}

}
