import java.awt.FlowLayout;
import java.util.Scanner;
import javax.swing.*;

public class StartGame {
	public static void main(String[] args) {

		Board arena = new Board();
		int numberOfPlayers = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("How many players (2-4): ");

		numberOfPlayers = input.nextInt();

		Player player1 = null;
		Player player2 = null;
		Player player3 = null;
		Player player4 = null;

		if (numberOfPlayers == 2) {
			player1 = new Player();
			player2 = new Player();

		} else if (numberOfPlayers == 3) {
			player1 = new Player();
			player2 = new Player();
			player3 = new Player();
		} else {
			player1 = new Player();
			player2 = new Player();
			player3 = new Player();
			player4 = new Player();
		}

		JFrame window = new JFrame();
		ImageIcon icon = new ImageIcon("Monopoly-board.png");
		JLabel label = new JLabel(icon);

		window.setLayout(new FlowLayout());
		window.setSize(1500, 1500);
		window.add(label);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Player[] order = { player1, player2, player3, player4 };
		Tile current;
		int playerChoice;
		while (numberOfPlayers > 1) {

			for (Player p : order) {
				System.out.println("Now is " + p.getName() + "'s turn");

				System.out.println("Now rolling dices:");
				p.move();
				current = arena.atIndex(p.getPosition());
				System.out.println(current);

				if (arena.atIndex(p.getPosition()) == null) {
					System.out.println("Buy or Auction?(1/2)");
					playerChoice = input.nextInt();
					
					switch(playerChoice) {
					case 1:
						current.
					}
				}

				if (arena.atIndex(p.getPosition()).getOwner() != p) {
					// lose this amount of money etc
				}

			}

		}

	}
}
