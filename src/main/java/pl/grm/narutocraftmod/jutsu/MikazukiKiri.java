package pl.grm.narutocraftmod.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class MikazukiKiri extends Jutsu {

	public MikazukiKiri(int i) {
		this.setUnlocalizedName("Mikazuki Kiri");
		this.setTextureName("narutocraftmod:Mikazuki Kiri");
}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}