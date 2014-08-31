package pl.grm.narutocraftmod.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Haykkaroran extends Jutsu {

	public Haykkaroran(int i) {
		this.setUnlocalizedName("Hyakkaroran");
		this.setTextureName(jutsuLoc + "Hyakkaroran");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}