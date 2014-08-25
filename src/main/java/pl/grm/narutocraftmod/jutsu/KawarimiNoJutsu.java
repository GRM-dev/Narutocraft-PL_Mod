package pl.grm.narutocraftmod.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class KawarimiNoJutsu extends Jutsu {

	public KawarimiNoJutsu(int i) {
		this.setUnlocalizedName("KNoJutsu");
		this.setTextureName("narutocraftmod:NoJutsu");
}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}