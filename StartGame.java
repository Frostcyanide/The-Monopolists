import java.util.Scanner;
public class StartGame {
	public static void main(String []args)
	{
		 
		int numberOfPlayers = 0;
		System.out.println("How many players (2-4): ");
		Scanner input = new Scanner(System.in);
		numberOfPlayers = input.nextInt();
		if(numberOfPlayers == 2)
		{
			Player player1 = new Player();
			Player player2 = new Player();
		}
		else if(numberOfPlayers == 3)
		{
			Player player1 = new Player();
			Player player2 = new Player();
			Player player3 = new Player();
		}
		else
		{
			Player player1 = new Player();
			Player player2 = new Player();
			Player player3 = new Player();
			Player player4 = new Player();
		}
		
		
		
		
	}
}
