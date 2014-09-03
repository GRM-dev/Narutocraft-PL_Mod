package pl.grm.narutocraft.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Hirudora extends Jutsu {

	public Hirudora(int i) {
		this.setUnlocalizedName("Hirudora");
		this.setTextureName(jutsuLoc + "Hirudora");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}