package ctheod03.hw2;

/**
 * This is the subclass, of the class Battlefield, and it is the Field of the
 * player. In this class,each ship is being positioned at the players field.
 * 
 * @author Christos Theodorou
 * @since 12/03/2023
 *
 */

public class Battlefield {
	/**
	 * The attributes which consist of: The String array of the field The position
	 * of the grid x/posi The position of the grid y/posj The counter of hits,which
	 * checks wheather all the ships have sunk or not. The hit counter for each
	 * individual ship And the 5 different types of ships.
	 */
	protected String area[][] = new String[10][10];
	protected int posi;
	protected int posj;
	private int hits = 0;
	private int AirCraft = 0;
	private int Torpedo = 0;
	private int Frigate = 0;
	private int Corvette = 0;
	private int Submarine = 0;
	

	/**
	 * Constructor of class Battlefield,which initializes the array with a null
	 * space.
	 */
	public Battlefield() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++)
				this.area[i][j] = " ";

		}

	}

	/**
	 * This is the method which plays the game.Whenever a player fires at their
	 * opponent, this method checks if a ship has been hit,if all the ships have
	 * sunk, or if the player missed.
	 * 
	 * @param x The x coordinate of the position
	 * @param y The y coordinate of the position
	 * @return returns true if all the ships have sunk
	 */
	public boolean play(int x, int y) {
		if (area[x][y] != " ") {
			if (area[x][y].equals("H"))
				System.out.println("You've already fired at that spot, and hit it.");
			if (area[x][y].equals("1")) {
				hits++;
				AirCraft++;
				if (AirCraft == 5) {
					System.out.println("You just sunk a ship !");
					area[x][y] = "H";
				} else
					hit(x, y);
			}
			if (area[x][y].equals("2")) {
				hits++;
				Torpedo++;
				if (Torpedo == 4) {
					System.out.println("You just sunk a ship !");
					area[x][y] = "H";
				} else
					hit(x, y);
			}
			if (area[x][y].equals("3")) {
				hits++;
				Frigate++;
				if (Frigate == 3) {
					System.out.println("You just sunk a ship !");
					area[x][y] = "H";
				} else
					hit(x, y);
			}
			if (area[x][y].equals("4")) {
				hits++;
				Corvette++;
				if (Corvette == 3) {
					System.out.println("You just sunk a ship !");
					area[x][y] = "H";
				} else
					hit(x, y);
			}
			if (area[x][y].equals("5")) {
				hits++;
				Submarine++;
				if (Submarine == 2) {
					System.out.println("You just sunk a ship !");
					area[x][y] = "H";
				} else
					hit(x, y);
			}

			if (allshipshavesunk(hits) == true)
				return true;

		} else
			miss();
		return false;

	}

	/**
	 * This method,checks if a ship has been hit, and changes the character at that
	 * certain position to H.
	 * 
	 * @param x The x coordinate of the position
	 * @param y The y coordinate of the position
	 */
	public void hit(int x, int y) {
		System.out.println("Hit!");
		this.area[x][y] = ("" + 'H');

	}

	/**
	 * This method checks if the player missed.
	 */

	public void miss() {
		System.out.println("Miss!");
	}

	/**
	 * This method checks,if all the ships have sunk.
	 * 
	 * @param hits the overall number of hits
	 * @return returns true if all the ships have sunk.
	 */

	public boolean allshipshavesunk(int hits) {
		if (hits == 17)
			return true;
		return false;
	}

	/**
	 * Method toString,which prints the field of the player.
	 */
	public String toString() {
		String ret = "";
		ret += "  | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |";
		ret += "\n";
		ret += "--|---+---+---+---+---+---+---+---+---+---+";
		ret += "\n";
		for (int i = 0; i < 10; i++) {
			ret += i + " |";
			for (int j = 0; j < 10; j++) {
				ret += (" " + this.area[i][j]);
				ret += " |";
			}
			ret += "\n";
			ret += "--|---+---+---+---+---+---+---+---+---+---+";
			ret += "\n";
		}

		return ret;

	}

}
