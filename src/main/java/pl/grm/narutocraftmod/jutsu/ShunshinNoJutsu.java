package pl.grm.narutocraftmod.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class ShunshinNoJutsu extends Jutsu{
	
	public ShunshinNoJutsu(int i) {
		this.setUnlocalizedName("SNoJutsu");
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