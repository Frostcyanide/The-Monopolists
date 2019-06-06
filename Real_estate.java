import java.util.ArrayList;
import java.util.List;
import java.math.*;

public class Real_estate extends Tile {

	private int rent;

	private int numberOfHouse;

	private int numberOfHotel;

	public Real_estate(String name, int price, String color, int index, Player owner, String type) {
		super(name, price, color, index, owner, type);
		rent = price / 10;
	}

	public int getRent() {
		return this.rent;
	}
	
	public void moreRoom(int n) {
		numberOfHouse=n;
		rent *=(int) Math.pow(1.2, numberOfHouse);
	}

}
