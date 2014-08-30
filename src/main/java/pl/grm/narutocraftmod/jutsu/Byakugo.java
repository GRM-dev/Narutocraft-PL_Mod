package pl.grm.narutocraftmod.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Byakugo extends Jutsu {

	public Byakugo(int i) {
		this.setUnlocalizedName("Byakugo");
		this.setTextureName("narutocraftmod:Byakugo");

	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}
