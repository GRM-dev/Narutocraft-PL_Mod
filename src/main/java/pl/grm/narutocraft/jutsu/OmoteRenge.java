package pl.grm.narutocraft.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class OmoteRenge extends Jutsu {

	public OmoteRenge(int i) {
		this.setUnlocalizedName("Omote Renge");
		this.setTextureName(jutsuLoc + "Omote Renge");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}