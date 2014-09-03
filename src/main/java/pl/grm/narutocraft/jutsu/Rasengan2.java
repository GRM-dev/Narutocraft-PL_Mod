package pl.grm.narutocraft.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Rasengan2 extends Jutsu {

	public Rasengan2(int i) {
		this.setUnlocalizedName("ORasengan");
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