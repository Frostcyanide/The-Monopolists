import java.awt.FlowLayout;
import java.util.Scanner;
import javax.swing.*;

public class StartGame {
	public static void main(String[] args) {

		int numberOfPlayers = 0;
		System.out.println("How many players (2-4): ");
		Scanner input = new Scanner(System.in);
		numberOfPlayers = input.nextInt();
		if (numberOfPlayers == 2) {
			Player player1 = new Player();
			Player player2 = new Player();
		} else if (numberOfPlayers == 3) {
			Player player1 = new Player();
			Player player2 = new Player();
			Player player3 = new Player();
		} else {
			Player player1 = new Player();
			Player player2 = new Player();
			Player player3 = new Player();
			Player player4 = new Player();
		}

		JFrame window = new JFrame();
		ImageIcon icon = new ImageIcon("C:\\Users\\richa\\OneDrive\\Desktop\\board1.jpg");
		JLabel label = new JLabel(icon);

		window.setLayout(new FlowLayout());
		window.setSize(1500, 1500);
		window.add(label);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
