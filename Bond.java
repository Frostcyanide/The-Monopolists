import java.util.ArrayList;
import java.util.List;

public class Bond extends Tile {

	private boolean paid = false;
	private int remainT;

	public Bond(String name, int price, String color, int index, Player owner, String type) {
		super(name, price, color, index, owner, type);
		remainT = 3;

	}

	public int payday() {

		if (remainT == 0) {
			if (paid == false) {
				paid = true;
				remainT = -1;
				return this.getPrice() * 2;
			}
		}
		return 0;

	}

	public void remainT() {
		remainT--;
	}

}
