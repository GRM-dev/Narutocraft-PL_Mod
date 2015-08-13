package pl.grm.narutocraft.items.weapons;

import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.libs.config.Materials;

public class Knuckleduster extends SwordMain{
	public Knuckleduster(){
		super(Materials.stal6);
		this.setAttackDamage(10);
		this.setMaxDamage(3000);
	}

}
