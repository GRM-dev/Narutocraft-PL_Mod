package pl.grm.narutocraft.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class UraRenge extends Jutsu {

	public UraRenge(int i) {
		this.setUnlocalizedName("Ura Renge");
		this.setTextureName("narutocraftmod:Ura Renge");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}