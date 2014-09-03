package pl.grm.narutocraft.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Enmakugire extends Jutsu {

	public Enmakugire(int i) {
		this.setUnlocalizedName("Enmakugire");
		this.setTextureName(jutsuLoc + "Enmakugire");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}