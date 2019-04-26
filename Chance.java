import java.util.ArrayList;
import java.util.List;

public class Chance {
	private List<String> deck = new ArrayList<String>();

	public Chance() {
		deck.add("Advance to Payday, collect $200\n" + "");
		deck.add("Advance to the nearest unowned property, you can buy it if you wish\n" + "");
		deck.add("Move backwards 5 spots\n" + "");
		deck.add(
				"Move to the nearest property that an opponent owns, if no opponents own any properties, then you do not move\n"
						+ "");
		deck.add("Advance to the Castle, if it is unowned, you may purchase it.\n" + "");
	}
}
