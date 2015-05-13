package pl.grm.narutocraft.items.weapons.projectiles;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import pl.grm.narutocraft.*;
import pl.grm.narutocraft.items.weapons.projectiles.entities.*;
import pl.grm.narutocraft.registry.*;

public class Kunai extends Item implements IProjectileCast {
	
	public Kunai() {
		super();
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 16;
	}
	
	/*
	 * create Kunai Entity
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		
		if (par3EntityPlayer.capabilities.isCreativeMode
				|| par3EntityPlayer.inventory.consumeInventoryItem(RegWeapons.Kunai)) {
			par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F,
					0.4F / ((itemRand.nextFloat() * 0.4F) + 0.8F));
			if (!par2World.isRemote) {
				par2World.spawnEntityInWorld(new EntityKunai(par2World, par3EntityPlayer,
						2.0F));
			}
		}
		return par1ItemStack;
	}
	
}
