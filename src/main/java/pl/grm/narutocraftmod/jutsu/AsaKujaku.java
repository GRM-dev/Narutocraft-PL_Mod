package pl.grm.narutocraftmod.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class AsaKujaku extends Jutsu {

	public AsaKujaku(int i) {
		this.setUnlocalizedName("Asa Kujaku");
		this.setTextureName("narutocraftmod:Asa Kujaku");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}