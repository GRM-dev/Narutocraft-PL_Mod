package pl.grm.narutocraft.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class Yosakugiri extends Jutsu {

	public Yosakugiri(int i) {
		this.setUnlocalizedName("Yosakugiri");
		this.setTextureName("narutocraftmod:Yosakugiri");
}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}