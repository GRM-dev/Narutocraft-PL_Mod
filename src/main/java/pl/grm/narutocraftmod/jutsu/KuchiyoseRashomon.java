package pl.grm.narutocraftmod.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class KuchiyoseRashomon extends Jutsu {

	public KuchiyoseRashomon(int i) {
		this.setUnlocalizedName("Kuchiyose Rashomon");
		this.setTextureName(jutsuLoc + "Kuchiyose Rashomon");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}