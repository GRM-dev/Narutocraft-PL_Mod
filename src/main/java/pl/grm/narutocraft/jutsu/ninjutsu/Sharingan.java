package pl.grm.narutocraft.jutsu.ninjutsu;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import pl.grm.narutocraft.jutsu.*;

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
