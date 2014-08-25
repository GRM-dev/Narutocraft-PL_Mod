package pl.grm.narutocraftmod.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class JikukanKekkai extends Jutsu {

	public JikukanKekkai(int i) {
		this.setUnlocalizedName("Jikukan Kekkai");
		this.setTextureName("narutocraftmod:Jikukan Kekkai");
}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}