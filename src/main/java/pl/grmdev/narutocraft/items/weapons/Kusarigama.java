package pl.grmdev.narutocraft.items.weapons;

import pl.grmdev.narutocraft.libs.config.Materials;

public class Kusarigama extends SwordMain{
	public Kusarigama(){
		super(Materials.stal4);
		this.setAttackDamage(8);
		this.setMaxDamage(500);
	}
}
