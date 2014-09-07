package pl.grm.narutocraft.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class InyuShometsu extends Jutsu {

	public InyuShometsu(int i) {
		this.setUnlocalizedName("Inyu Shometsu");
		this.setTextureName(jutsuLoc + "Inyu Shometsu");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}