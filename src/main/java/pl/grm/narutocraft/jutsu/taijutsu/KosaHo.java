package pl.grm.narutocraft.jutsu.taijutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.jutsu.Jutsu;

public class KosaHo extends Jutsu implements IJutsu {

	public KosaHo() {
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
	public void uploadEffects() {
		// TODO Auto-generated method stub

	}
	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setActive(boolean par) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onJutsuUpdate() {
		// TODO Auto-generated method stub

	}
	public void consumeChackra(int value) {
		// TODO Auto-generated method stub

	}

}