package pl.grmdev.narutocraft.jutsu.ninjutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import pl.grmdev.narutocraft.jutsu.Jutsu;
import pl.grmdev.narutocraft.jutsu.JutsuParams;

public class Sharingan extends Jutsu {

	public Sharingan() {
		super(JutsuParams.SHARINGAN);
		this.setUnlocalizedName("Sharingan");
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 1;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}
