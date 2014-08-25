package pl.grm.narutocraftmod.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;



public class RaigenRaikochu extends Jutsu {

	public RaigenRaikochu (int i) {
		this.setUnlocalizedName("Raigen Raikochu");
		this.setTextureName("narutocraftmod:Raigen Raikochu");
}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}