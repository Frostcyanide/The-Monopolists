import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class StartGame {

	public static ArrayList<Player> players = new ArrayList<Player>();

	public static void main(String[] args) throws FileNotFoundException {

		Board arena = new Board();
		int numberOfPlayers = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the world of Monopolists!" + "\nThe game will began shortly...");
		System.out.println("How many players (2-4): ");

		numberOfPlayers = input.nextInt();

		/*
		 * Creating a list of players
		 */
		for (int i = 1; i <= numberOfPlayers; i++)
			players.add(new Player(Integer.toString(i)));

		/*
		 * Initialize a window
		 */

		JFrame window = new JFrame();
		ImageIcon icon = new ImageIcon("FinalBoard.jpg");
		JLabel label = new JLabel(icon);

		window.setLayout(new FlowLayout());
		window.setSize(1000, 1000);
		window.add(label);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int maxNumberOfRounds = 20;

		while (maxNumberOfRounds >= 0) {

			for (Player p : players) {
				if (p.haveJob()) {
					System.out.println("\n*****************It is now  " + p.getName() + "'s turn*********************");

					System.out.println("Now rolling dices:");
					p.checkBeforeMove(p.roll());
					maxNumberOfRounds--;
					arena.atIndex(p.getPosition()).display();
					// displaying the current tile information

					System.out.println("Your balance: " + p.getBalance());
					System.out.println();

					CheckTile(arena, p);

					System.out.println("You are at "); // displaying the current tile information
					arena.atIndex(p.getPosition()).display();
					System.out.println("Your balance at the end of round: " + p.getBalance());
					System.out.println();

					menu(p, arena, players);

				} else {
					System.out.println("***************It is now  " + p.getName() + "'s turn*****************");
					p.findJob();

					if (p.haveJob()) {
						System.out.println("Now rolling dices:");
						p.checkBeforeMove(p.roll());
						maxNumberOfRounds--;
						arena.atIndex(p.getPosition()).display(); // displaying the current tile information
						System.out.println("Your balance: " + p.getBalance());
						System.out.println();

						CheckTile(arena, p);

						arena.atIndex(p.getPosition()).display(); // displaying the current tile information
						System.out.println("Your balance at the end of round: " + p.getBalance());
						System.out.println();
						menu(p, arena, players);

					}

				}

			}

		}
	}

	public static void CheckTile(Board arena, Player p) {
		int playerChoice;
		Scanner input = new Scanner(System.in);
		switch (arena.atIndex(p.getPosition()).getClass().getSimpleName()) {

		case "Real_estate":
			if (arena.atIndex(p.getPosition()).getOwner() == null) {
				System.out.println("Buy or Auction?(1/2)");
				playerChoice = input.nextInt();

				switch (playerChoice) {
				case 1:
					p.buyTile(arena.atIndex(p.getPosition()));
					break;
				case 2:
					arena.hostAuction(players, arena.atIndex(p.getPosition()));
					break;
				}

			}

			else {
				// pay the rent
				p.payRent((Real_estate) arena.atIndex(p.getPosition()));
				arena.atIndex(p.getPosition()).getOwner().receiveRent((Real_estate) arena.atIndex(p.getPosition()));
			}
			break;
		case "Stock":
			// stock card
			if (arena.atIndex(p.getPosition()).getOwner() == null) {
				System.out.println("Buy or Auction?(1/2)");
				playerChoice = input.nextInt();

				switch (playerChoice) {
				case 1:
					// buy
					p.buyTile(arena.atIndex(p.getPosition()));
					break;
				case 2:
					arena.hostAuction(players, arena.atIndex(p.getPosition()));
					break;
				}

			} else if (arena.atIndex(p.getPosition()).getOwner() == p) {
				p.returnInvestment((Stock) arena.atIndex(p.getPosition()));
			}
			break;

		case "Bond":
			// bond card
			if (arena.atIndex(p.getPosition()).getOwner() == null) {
				System.out.println("Buy or Auction?(1/2)");
				playerChoice = input.nextInt();

				switch (playerChoice) {
				case 1:
					// buy
					p.buyTile(arena.atIndex(p.getPosition()));
					break;
				case 2:
					arena.hostAuction(players, arena.atIndex(p.getPosition()));
					break;
				}

			} else if (arena.atIndex(p.getPosition()).getOwner() == p) {
				p.returnBond((Bond) arena.atIndex(p.getPosition()));
			}
			break;

		case "Chance":
			// chance card
			((Chance) arena.atIndex(p.getPosition())).generateChance(p, arena, players);

			break;
		case "Fate":
			// fate card
			// ((Fate) current).generateFate(p, arena);
			((Fate) arena.atIndex(p.getPosition())).generateFate(p, arena, players);
			break;
		case "Tile":
			// special tile
			p.setBalance(p.getBalance() + arena.atIndex(p.getPosition()).getPrice());
			// go to jail
			if (p.getPosition() == 29) {
				p.loseJob();
			}
			break;
		}
	}

	/*
	 * Player makes choice of what they will do in their round
	 */
	public static void menu(Player p, Board arena, ArrayList<Player> players) {
		Scanner input = new Scanner(System.in);
		int playerChoice = 0;

		while (playerChoice != 8) {
			System.out.println(
					"1. Buy this tile" + "\n2. Sell your tiles back to the bank" + "\n3. Trade with other players"
							+ "\n4. Mortgage" + "\n5. Check your properties" + "\n6.Check other players' properties"
							+ "\n7. Build more rooms at your properties" + "\n8. Next player");
			playerChoice = input.nextInt();
			switch (playerChoice) {
			case 1:
				if (arena.atIndex(p.getPosition()).getOwner() != null)
					System.out.println("This tile is already purchased by" + arena.atIndex(p.getPosition()).getOwner());
				else {
					p.buyTile(arena.atIndex(p.getPosition()));
					System.out.println("Purchase complete!");
				}
				break;
			case 2:
				p.displayProperty();
				System.out.println(
						"Pick a number to sell back to the bank, you only receive 60% of the amount of money you paid");
				int choice = input.nextInt();
				p.sellTile(p.returnProperty(choice));
				System.out.println("Action complete!");
				System.out.println("New balance: " + p.getBalance());
				break;
			case 3:
				// trade with others, unfinished
				break;
			case 4:

				System.out.println("Get mortgage or redeem properties?(1/2)");
				int mchoice = input.nextInt();
				if (mchoice == 1)
					p.getMortgage(arena);
				else
					p.redeemProperty(arena);

				break;
			case 5:
				p.displayProperty();
				break;
			case 6:
				for (Player pl : players) {
					pl.displayProperty();
				}
				break;
			case 7:
				p.buildRoom(arena);
				break;
			case 8:

				break;

			}
		}
	}
}
