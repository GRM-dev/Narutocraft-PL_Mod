package pl.grm.narutocraft.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Omotegiri extends Jutsu {

	public Omotegiri(int i) {
		this.setUnlocalizedName("Omotegiri");
		this.setTextureName(jutsuLoc + "Omotegiri");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}