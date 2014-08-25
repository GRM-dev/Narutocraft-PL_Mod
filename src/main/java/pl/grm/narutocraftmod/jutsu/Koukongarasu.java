package pl.grm.narutocraftmod.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class Koukongarasu extends Jutsu {

	public Koukongarasu(int i) {
		this.setUnlocalizedName("Koukongarasu");
		this.setTextureName("narutocraftmod:Koukongarasu");
}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}