import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

public class StartGame {
	public static void main(String[] args) throws FileNotFoundException {

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
		Tile current; // represents the current tile the player is on
		int playerChoice, numberOfRounds = 20;// maximum number of rounds before game ends
		while (numberOfRounds >= 0) {

			for (Player p : order) {
				System.out.println("Now is " + p.getName() + "'s turn");

				System.out.println("Now rolling dices:");
				p.move();
				current = arena.atIndex(p.getPosition());
				System.out.println(current); // displaying the current tile information

				switch (current.getType()) {
				case "RE":// if the tile is a real_estate
					if (current.getOwner() == null) {
						System.out.println("Buy or Auction?(1/2)");
						playerChoice = input.nextInt();

						switch (playerChoice) {
						case 1:
							// buy
							current.changeOwner(p);
							p.setBalance(p.getBalance() - current.getPrice());
							break;
						case 2:
							// Auction, unfinished
							break;
						}

					}

					else {
						// pay the rent
					}
					break;
				case "S":
					// stock card

					break;
				case "B":
					// bond card
					break;
				case "C":
					// chance card
					break;
				case "F":
					// fate card
					break;
				case "T":
					// special tile
					if (current.index == 4)
						p.setBalance(p.getBalance() + current.getPrice());
					break;
				}

			}

		}

	}
}
