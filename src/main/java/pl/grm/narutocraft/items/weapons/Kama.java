package pl.grm.narutocraft.items.weapons;

import pl.grm.narutocraft.libs.config.Materials;

public class Kama  extends SwordMain{

	public Kama() {
		super(Materials.stal);
		this.setAttackDamage(8);
		this.setMaxDamage(400);		
	}

}
