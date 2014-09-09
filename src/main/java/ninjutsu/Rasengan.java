package ninjutsu;

import java.util.Map;

import pl.grm.narutocraft.effects.IEffect;
import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.jutsu.Jutsu;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Rasengan extends Jutsu implements IJutsu{

	public Rasengan() {
		this.setUnlocalizedName("Rasengan");
		this.setTextureName(jutsuLoc + "Rasengan");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}
	@Override
	public void uploadEffects() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Map<IJutsu, IEffect> getEffects() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setEffect(IEffect effect) {
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
	@Override
	public void consumeChackra(int value) {
		// TODO Auto-generated method stub
		
	}

}