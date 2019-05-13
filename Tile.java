
public abstract class Tile {

	public String name;

	public int price;

	public String color;

	public final int index;

	public Tile(String n, int p, String c, int i) {
		name = n;
		price = p;
		color = c;
		index = i;

	}

	private void setName(String n) {
		name = n;
	}

	private void setPrice(int p) {
		price = p;
	}

	private void setColor(String c) {
		color = c;
	}

}
