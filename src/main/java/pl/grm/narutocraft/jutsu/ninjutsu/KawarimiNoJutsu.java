package pl.grm.narutocraft.jutsu.ninjutsu;

import pl.grm.narutocraft.jutsu.Jutsu;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class KawarimiNoJutsu extends Jutsu {

	public KawarimiNoJutsu() {
		this.setUnlocalizedName("KNoJutsu");
		this.setTextureName(jutsuLoc + "NoJutsu");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}