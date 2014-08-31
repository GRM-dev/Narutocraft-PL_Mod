package pl.grm.narutocraftmod.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ChakuraNoMesu extends Jutsu {

	public ChakuraNoMesu(int i) {
		this.setUnlocalizedName("Chakura No Mesu");
		this.setTextureName(jutsuLoc + "Chakura No Mesu");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}