package pl.grm.narutocraft.items.weapons.projectiles;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.world.*;

public interface IProjectileCast {
	
	public abstract ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer);
	
}