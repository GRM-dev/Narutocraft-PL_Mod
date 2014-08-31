package pl.grm.narutocraftmod.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class KokuangyoNoJutsu extends Jutsu {

	public KokuangyoNoJutsu(int i) {
		this.setUnlocalizedName("Kokuangyo No Jutsu");
		this.setTextureName(jutsuLoc + "Kokuangyo No Jutsu");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}