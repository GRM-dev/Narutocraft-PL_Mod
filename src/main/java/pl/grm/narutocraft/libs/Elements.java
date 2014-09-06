package pl.grm.narutocraft.libs;

import java.awt.Color;

/**
 * Contains elements and their linkage.
 */
public enum Elements {
	NONE(0, new Color(0x000000)), KATON(1, new Color(0xFF0000)), FUUTON(2,
			new Color(0x00FF80)), RAITON(3, new Color(0xFFFF00)), DOTON(4,
			new Color(0xFF8000)), SUITON(5, new Color(0x0080FF));

	private int ID;
	private Color color;

	private Elements(int ID, Color color) {
		this.ID = ID;
		this.color = color;
	}

	public Elements getWeakerElement() {
		if (this.getID() == 1)
			return Elements.getById(5);
		else
			return Elements.getById(ID--);
	}

	public Elements getStrongerElement() {
		if (this.getID() == 5)
			return Elements.getById(1);
		else
			return Elements.getById(ID++);
	}

	/**
	 * Gets element by ID [1-5]
	 * 
	 * @param ID
	 * @return Element
	 */
	public static Elements getById(int ID) {
		for (Elements elem : Elements.values())
			if (elem.ID == ID)
				return elem;
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

	public int getID() {
		return ID;
	}

	public Color getColor() {
		return color;
	}
}
