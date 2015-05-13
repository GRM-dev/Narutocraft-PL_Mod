package pl.grm.narutocraft.libs;

import java.awt.*;

/**
 * Contains elements and their linkage.
 */
public enum Elements {
	NONE(
			0,
			new Color(0x000000)) ,
	KATON(
			1,
			new Color(0xFF0000)) ,
	FUUTON(
			2,
			new Color(0x00FF80)) ,
	RAITON(
			3,
			new Color(0xFFFF00)) ,
	DOTON(
			4,
			new Color(0xFF8000)) ,
	SUITON(
			5,
			new Color(0x0080FF));
	
	private int		ID;
	private Color	color;
	
	private Elements(int ID, Color color) {
		this.ID = ID;
		this.color = color;
	}
	
	/**
	 * Gets element by ID [1-5]
	 *
	 * @param ID
	 * @return Element
	 */
	public static Elements getById(int ID) {
		for (Elements elem : Elements.values()) {
			if (elem.ID == ID) { return elem; }
		}
		return NONE;
	}
	
	/**
	 * Gets Ordered Elements.
	 *
	 * @return Elements[]
	 */
	public static Elements[] getOrderedElements() {
		return new Elements[]{KATON, FUUTON, RAITON, DOTON, SUITON};
	}
	
	/**
	 * @return Color of element
	 */
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * @return ID of element
	 */
	public int getID() {
		return this.ID;
	}
	
	/**
	 * @return stronger element
	 */
	public Elements getStrongerElement() {
		if (this.getID() == 5) { return Elements.getById(1); }
		return Elements.getById(this.ID++);
	}
	
	/**
	 * @return weaker element
	 */
	public Elements getWeakerElement() {
		if (this.getID() == 1) { return Elements.getById(5); }
		return Elements.getById(this.ID--);
	}
}
