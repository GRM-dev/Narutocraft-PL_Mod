package pl.grm.narutocraftmod.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class KageBuyo extends Jutsu {

	public KageBuyo(int i) {
		this.setUnlocalizedName("Kage Buyo");
		this.setTextureName(jutsuLoc + "Kage Buyo");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}