package pl.grm.narutocraftmod.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class FukimiHari extends Jutsu {

	public FukimiHari(int i) {
		this.setUnlocalizedName("Fukimi Hari");
		this.setTextureName("narutocraftmod:Fukimi Hari");
}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}
