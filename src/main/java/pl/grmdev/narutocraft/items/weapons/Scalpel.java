package pl.grmdev.narutocraft.items.weapons;

import pl.grmdev.narutocraft.libs.config.Materials;

public class Scalpel extends SwordMain {

	public Scalpel() {
		super(Materials.stal5);		
		this.maxStackSize = 1;
		this.setAttackDamage(8);
		this.setMaxDamage(-1);
		
	}
}