package pl.grmdev.narutocraft.items.weapons;

import pl.grmdev.narutocraft.NarutoCraft;
import pl.grmdev.narutocraft.libs.config.Materials;

public class Knuckleduster extends SwordMain{
	public Knuckleduster(){
		super(Materials.stal6);
		this.setAttackDamage(10);
		this.setMaxDamage(3000);
	}

}
