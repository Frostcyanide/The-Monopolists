import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
	
	private int balance;
	
	private List<Tile> tiles;
	
	private String name;
	
	public Player() {
		balance=1500;
		
		tiles=new ArrayList<Tile>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	private int roll() {
		Random gen = new Random();
		return (gen.nextInt(6)+1)*2;
		
	}	
}
