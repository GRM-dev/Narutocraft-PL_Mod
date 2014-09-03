package pl.grm.narutocraft.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class KosaHo extends Jutsu {

	public KosaHo(int i) {
		this.setUnlocalizedName("Kosa Ho");
		this.setTextureName(jutsuLoc + "Kosa Ho");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}