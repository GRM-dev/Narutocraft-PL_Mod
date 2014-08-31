package pl.grm.narutocraftmod.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Rasengan extends Jutsu {

	public Rasengan(int i) {
		this.setUnlocalizedName("Rasengan");
		this.setTextureName(jutsuLoc + "Rasengan");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}