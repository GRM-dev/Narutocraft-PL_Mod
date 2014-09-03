package pl.grm.narutocraft.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FukimiHari extends Jutsu {

	public FukimiHari(int i) {
		this.setUnlocalizedName("Fukimi Hari");
		this.setTextureName(jutsuLoc + "Fukimi Hari");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}
