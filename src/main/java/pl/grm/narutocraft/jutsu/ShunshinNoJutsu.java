package pl.grm.narutocraft.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ShunshinNoJutsu extends Jutsu {

	public ShunshinNoJutsu() {
		this.setUnlocalizedName("SNoJutsu");
		this.setTextureName(jutsuLoc + "NoJutsu");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}