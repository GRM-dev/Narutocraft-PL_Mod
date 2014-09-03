package pl.grm.narutocraft.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class NanKaizou extends Jutsu {

	public NanKaizou(int i) {
		this.setUnlocalizedName("Nan Kaizou");
		this.setTextureName(jutsuLoc + "Nan Kaizou");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}