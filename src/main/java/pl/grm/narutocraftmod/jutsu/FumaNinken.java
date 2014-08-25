package pl.grm.narutocraftmod.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class FumaNinken extends Jutsu {

	public FumaNinken(int i) {
		this.setUnlocalizedName("Fuma Ninken");
		this.setTextureName("narutocraftmod:Fuma Ninken");
}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}