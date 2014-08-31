package pl.grm.narutocraftmod.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class NawanukeNoJutsu extends Jutsu {

	public NawanukeNoJutsu(int i) {
		this.setUnlocalizedName("Nawanuke No Jutsu");
		this.setTextureName(jutsuLoc + "Nawanuke No Jutsu");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}