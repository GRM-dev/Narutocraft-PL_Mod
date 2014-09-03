package pl.grm.narutocraft.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Dokugiri extends Jutsu {

	public Dokugiri(int i) {
		this.setUnlocalizedName("Dokugiri");
		this.setTextureName(jutsuLoc + "Dokugiri");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}