package pl.grm.narutocraft.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Iaido extends Jutsu {

	public Iaido(int i) {
		this.setUnlocalizedName("Iaido");
		this.setTextureName(jutsuLoc + "Iaido");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}