package pl.grm.narutocraft.jutsu.ninjutsu;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import pl.grm.narutocraft.jutsu.*;

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