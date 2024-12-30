package ctheod03.hw2;

import java.util.Scanner;

/**
 * This is our main class, in which objects are being created and then sent to
 * different classes.
 * 
 * @author Christos Theodorou
 * @since 12/03/2023
 *
 */
public class BattleShipGame {

	/**
	 * main class
	 * 
	 * @param args string array
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to the BattleShip game!");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

		/**
		 * Creates an array of type Battlefield,which is being downcasted to
		 * PlayerField(the reference type gets changed)
		 */
		Battlefield[] players = new Playerfield[2];
		players[0] = new Playerfield();
		players[1] = new Playerfield();

		String status = "";
		/**
		 * boolean variables which check if all the ships have sunk, or if the game is
		 * over.
		 */
		boolean flag = false;
		boolean gameover = false;

		int i = 0;
		int winner = -1;
		while (status != "exit" && flag == false) {
			System.out.println("Player: " + i + " your Ships: ");
			System.out.println(players[i]);
			System.out.println("Player: " + i + " Please select 2 coordinates(0-9) to attack Enemy:");
			status = scan.nextLine();
			if (status.equals("exit")) {
				System.out.println("Game Over!");
				gameover = true;
				break;
			}
			int x = status.charAt(0) - '0';
			int y = status.charAt(2) - '0';
			/**
			 * if the inputs length is bigger than 3 it means that one, or both of the
			 * numbers are greater than 9,or less than 0 and a new input is required. Also,
			 * if either of the numbers is <0 , a new input is required.
			 */
			while (status.length() > 3 || x < 0 || y < 0 || x > 9 || y > 9) {
				System.out.println("Wrong input-select new coordinates(0-9) to attack enemy !");
				status = scan.nextLine();
				x = status.charAt(0) - '0';
				y = status.charAt(2) - '0';

			}

			/**
			 * this if, checks which player is about to fire,and calls the method play, to
			 * make changes on the other players field.
			 */
			if (i == 0)
				flag = players[i + 1].play(x, y);
			else if (i == 1)
				flag = players[i - 1].play(x, y);
			if (flag == true)
				winner = i;
			i++;
			if (i == 2)
				i = 0;
		}
		/**
		 * Checks, if the input was "exit".
		 */
		if (status == "exit")
			System.out.println("Game over!");
		/**
		 * shows who the winner is
		 */
		if (gameover == false)
			System.out.println("Winner is player : " + winner);

		scan.close();
	}
}
