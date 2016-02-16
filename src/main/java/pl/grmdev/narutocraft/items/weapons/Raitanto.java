package pl.grmdev.narutocraft.items.weapons;

import pl.grmdev.narutocraft.libs.config.Materials;

public class Raitanto extends SwordMain {

	public Raitanto() {
		super(Materials.smoczastal4);
		this.setAttackDamage(20);
        this.setMaxDamage(750);
	}
}
