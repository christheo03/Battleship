package ctheod03.hw2;


/**
 * This is the subclass, of the class Battlefield, and it is the Field of the
 * player. In this class,each ship is being positioned at the players field.
 * 
 * @author Christos Theodorou
 * @since 12/03/2023
 *
 */

public class Playerfield extends Battlefield {

	/**
	 * The attributes,are the five ships.
	 */
	Ship ship1 = new AircraftCarrier();
	Ship ship2 = new TorpedoShip();
	Ship ship3 = new FrigateShip();
	Ship ship4 = new CorvetteShip();
	Ship ship5 = new SubmarineShip();

	/**
	 * Constructor of subclass, which refers and invokes the superclass constructor.
	 */
	public Playerfield() {
		super();

		placetheships();

	}

	/**
	 * This method,randomly selects a coordinate.
	 * 
	 * @return returns the randomly chosen coordinate.
	 */

	public int coordinates() {
		return (int) (Math.random() * 10);

	}

	/**
	 * This void method,sends each ship to the method Positions.
	 */
	public void placetheships() {
		Positions(ship1);
		Positions(ship2);
		Positions(ship3);
		Positions(ship4);
		Positions(ship5);
	}

	/**
	 * This method,randomly positions each ship on the players field.
	 * 
	 * @param myship The ship that is going to be positioned.
	 */
	public void Positions(Ship myship) {

		char dir = myship.Selectdirection();
		super.posi = coordinates();
		super.posj = coordinates();
		if (dir == 'R') {
			while (CheckBounds(posj, myship.length) == false
					|| CheckRAvailability(posi, posj, myship.length) == false) {
				posj = coordinates();
				posi = coordinates();

			}
		}

		if (dir == 'D') {
			while (CheckBounds(posi, myship.length) == false
					|| CheckDAvailability(posi, posj, myship.length) == false) {
				posi = coordinates();
				posj = coordinates();
			}
		}

		if (dir == 'R') {
			for (int k = posj; k < posj + myship.length; k++)
				super.area[posi][k] = (myship.charofboat + "");

		}

		if (dir == 'D') {
			for (int j = posi; j < posi + myship.length; j++)
				super.area[j][posj] = (myship.charofboat + "");

		}

	}

	/**
	 * This method,checks if the randomly chosen coordinate, fits on the grid, and
	 * is inside of bounds.
	 * 
	 * @param n The coordinate.
	 * @param r The length of the ship.
	 * @return returns true if the coordinate is inside the bounds of the grid.
	 */
	public boolean CheckBounds(int n, int r) {
		if (n + r >= 10 || n + r < 0)
			return false;
		return true;
	}

	/**
	 * This method is specifically used, when the direction of the ship will be
	 * Right. The method checks, if those certain positions are available for
	 * placing a ship.
	 * 
	 * @param posi The x coordinate
	 * @param posj The y coordinate.
	 * @param r    The length of the ship.
	 * @return returns true if the positions are available for placing a ship.
	 */
	public boolean CheckRAvailability(int posi, int posj, int r) {

		for (int i = posj; i < posj + r; i++) {
			if (super.area[posi][i] != " ") {

				return false;
			}

		}

		return true;

	}

	/**
	 * This method is specifically used, when the direction of the ship will be
	 * DOWN. The method checks, if those certain positions are available for placing
	 * a ship.
	 * 
	 * @param posi The x coordinate.
	 * @param posj The y coordinate.
	 * @param r    The length of the ship.
	 * @return returns true if the positions are available for placing a ship.
	 */

	public boolean CheckDAvailability(int posi, int posj, int r) {
		for (int i = posi; i < posi + r; i++) {
			if (super.area[i][posj] != " ") {
				return false;
			}
		}

		return true;

	}

	/**
	 * Method toString,which refers to the superclass's method toString.
	 */
	public String toString() {
		return super.toString();
	}

}
