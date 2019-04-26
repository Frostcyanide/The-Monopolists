import java.util.ArrayList;
import java.util.List;

public class Fate {
	private List<String> deck = new ArrayList<String>();

	public Fate() {

		deck.add("You are responsible for a car crash, pay $100");
		deck.add("You made a trip to the grocery store, pay $50");
		deck.add("Uh oh! You broke your arm and had to make a visit to the emergency room, pay $75");
		deck.add("EARTHQUAKE!!! You must hire someone to fix the damages, pay $50\n");
		deck.add(
				"Family Vacation! You have prepaid for the hotel, rental car, food, and all of the activities you plan to do, pay $150\n"
						+ "");
		deck.add("Luck is on your side, you just won the lottery! Collect $100\n" + "");
		deck.add("Your hardwork has paid off, your boss is giving you a bonus! Collect $50\n" + "");
		deck.add("Your own Lemonade Stand has finally made a sale! Collect $25\n" + "");
		deck.add(
				"You were fired by your boss, you will not receive your $200 paycheck after you pass Payday this time around\n"
						+ "");
		deck.add("You were caught vandalizing town property, pay $30 to repair the damages, and go unemployed\n" + "");

	}
}
