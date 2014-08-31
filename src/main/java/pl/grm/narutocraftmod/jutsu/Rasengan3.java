package pl.grm.narutocraftmod.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Rasengan3 extends Jutsu {

	public Rasengan3(int i) {
		this.setUnlocalizedName("CORasengan");
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