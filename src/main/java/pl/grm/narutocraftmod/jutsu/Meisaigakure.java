package pl.grm.narutocraftmod.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class Meisaigakure extends Jutsu {

	public Meisaigakure(int i) {
		this.setUnlocalizedName("Meisaigakure");
		this.setTextureName("narutocraftmod:Meisaigakure");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}