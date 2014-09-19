package pl.grm.narutocraft.jutsu.taijutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.jutsu.Jutsu;

public class KageBuyo extends Jutsu implements IJutsu {
	
	public KageBuyo() {
		this.setUnlocalizedName("Kage Buyo");
		this.setTextureName(textureLoc + "Kage Buyo");
	}
	
	public void consumeChackra(int value) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
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
	
	public void uploadEffects() {
		// TODO Auto-generated method stub
		
	}
	
}