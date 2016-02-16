package pl.grmdev.narutocraft.items.weapons;

import pl.grmdev.narutocraft.libs.config.Materials;

public class Kama  extends SwordMain{

	public Kama() {
		super(Materials.stal);
		this.setAttackDamage(8);
		this.setMaxDamage(400);		
	}

}
