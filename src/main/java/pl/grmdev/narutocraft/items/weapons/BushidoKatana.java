package pl.grmdev.narutocraft.items.weapons;

import pl.grmdev.narutocraft.libs.config.Materials;

public class BushidoKatana extends SwordMain {

	public BushidoKatana() {
		super(Materials.tytan2);
		this.setAttackDamage(11);
		this.setMaxDamage(850);
	}
}