package pl.grm.narutocraft.jutsu.ninjutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import pl.grm.narutocraft.jutsu.Jutsu;
//import pl.grm.narutocraft.effects.IEffect;

public class Rasengan extends Jutsu {

	public Rasengan() {
		this.setUnlocalizedName("Rasengan");
		this.setTextureName(textureLoc + "Rasengan");
	}
	@Override
	public void activateJutsu() {
		// TODO Auto-generated method stub

	}

	@Override
	public void jutsuEnd() {
		// TODO Auto-generated method stub

	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

	@Override
	public void onJutsuUpdate() {
		// TODO Auto-generated method stub

	}

}