package pl.grmdev.narutocraft.items.weapons;

import pl.grmdev.narutocraft.libs.config.Materials;

public class RyuuKatana extends SwordMain {

	public RyuuKatana() {
		super(Materials.smoczastal);
		this.setAttackDamage(15);
		this.setMaxDamage(1500);

	}
}