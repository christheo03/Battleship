package ctheod03.hw2;
/**
 * This is the superclass, ship,which creates different types of ships with
 * different lengths and characters.
 * 
 * @author Christos Theodorou
 * @since 12/03/2023
 *
 */

public class Ship {
	/**
	 * atrributes,which are the length of the ship,the character of the boat and the
	 * direction.
	 */
	protected int length;
	protected char charofboat;
	private char[] selectdirection = { 'R', 'D' };
	private char direction;

	/**
	 * Constructor of class Ship.
	 * 
	 * @param l the length of the ship
	 * @param c the character of the ship
	 */
	public Ship(int l, char c) {
		this.length = l;
		this.charofboat = c;
	}

	/**
	 * This method,randomly chooses the direction of the ship,which will either be
	 * right or down.
	 * 
	 * @return returns the direction in which the ship will be positioned to.
	 */
	public char Selectdirection() {
		int n = (int) (Math.random() * 2);
		direction = selectdirection[n];
		return direction;
	}
}
