package pl.grmdev.narutocraft.jutsu.ninjutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import pl.grmdev.narutocraft.jutsu.Jutsu;
import pl.grmdev.narutocraft.jutsu.JutsuParams;

public class KawarimiNoJutsu extends Jutsu {

	public KawarimiNoJutsu() {
		super(JutsuParams.KAWARIMINOJUTSU);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}
}