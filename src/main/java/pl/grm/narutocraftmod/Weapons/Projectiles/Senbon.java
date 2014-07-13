package pl.grm.narutocraftmod.Weapons.Projectiles;

import net.minecraft.item.Item;
import pl.grm.narutocraftmod.NarutoCraftMod;

public class Senbon extends Item{
	public Senbon(int i) {
		this.setUnlocalizedName("Senbon");
		this.setTextureName("narutocraftmod:Senbon");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 30;
	}
}
