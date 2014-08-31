package pl.grm.narutocraftmod.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Ranshinsho extends Jutsu {

	public Ranshinsho(int i) {
		this.setUnlocalizedName("Ranshinsho");
		this.setTextureName(jutsuLoc + "Ranshinsho");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}