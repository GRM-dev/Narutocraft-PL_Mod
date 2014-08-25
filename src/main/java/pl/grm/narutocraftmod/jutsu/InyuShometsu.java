package pl.grm.narutocraftmod.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class InyuShometsu extends Jutsu{

	public InyuShometsu(int i) {
		this.setUnlocalizedName("InyuShometsu");
		this.setTextureName("narutocraftmod:InyuShometsu");
}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}