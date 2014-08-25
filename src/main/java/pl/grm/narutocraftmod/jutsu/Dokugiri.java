package pl.grm.narutocraftmod.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class Dokugiri extends Jutsu{

	public Dokugiri(int i) {
		this.setUnlocalizedName("Dokugiri");
		this.setTextureName("narutocraftmod:Dokugiri");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}