package pl.grm.narutocraft.jutsu.iryojutsu;

import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.jutsu.Jutsu;

public class ChakuraNoMesu extends Jutsu implements IJutsu {

	public ChakuraNoMesu() {
		this.setUnlocalizedName("Chakura No Mesu");
		this.setTextureName(jutsuLoc + "Chakura No Mesu");
	}
	@Override
	public void activateJutsu() {
		// TODO Auto-generated method stub

	}
	public void consumeChackra(int value) {
		// TODO Auto-generated method stub

	}
	@Override
	public int getDurationPass() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getJutsuID() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Map<Integer, IJutsu> getJutsuProps() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getTotalDuration() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
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
	@Override
	public void setActive(boolean par) {
		// TODO Auto-generated method stub

	}
	@Override
	public void updateJutsuProperties() {
		// TODO Auto-generated method stub

	}
	public void uploadEffects() {
		// TODO Auto-generated method stub

	}

}