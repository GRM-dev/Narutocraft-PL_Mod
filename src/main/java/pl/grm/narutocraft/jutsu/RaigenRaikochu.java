package pl.grm.narutocraft.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RaigenRaikochu extends Jutsu {

	public RaigenRaikochu(int i) {
		this.setUnlocalizedName("Raigen Raikochu");
		this.setTextureName(jutsuLoc + "Raigen Raikochu");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}