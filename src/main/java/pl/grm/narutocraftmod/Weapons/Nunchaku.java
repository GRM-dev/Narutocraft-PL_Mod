package pl.grm.narutocraftmod.Weapons;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.Libs.Materials;

public class Nunchaku extends SwordMain {
	public Nunchaku (int i) {
		super(Materials.stal);

		this.setUnlocalizedName("Nunchaku");
		this.setTextureName("narutocraftmod:Nunchaku");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);

	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,EntityPlayer player) {
		super.onItemRightClick(stack, world, player);
		
    	return stack;
	}
	
	public void onUpdate(){}
}
