package pl.grm.narutocraftmod.Weapons.Projectiles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.Entities.EntityWKunai;
import pl.grm.narutocraftmod.Libs.registry.RegItems;

public class WKunai extends Item {
	public WKunai(int i) {
		this.setUnlocalizedName("WybuchowyKunai");
		this.setTextureName("narutocraftmod:Wybuchowy Kunai");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 16;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer) {
	    
		if(par3EntityPlayer.capabilities.isCreativeMode||par3EntityPlayer.inventory.consumeInventoryItem(RegItems.WKunai))
	    {
	        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	        if (!par2World.isRemote)
	        {
	            par2World.spawnEntityInWorld(new EntityWKunai(par2World, par3EntityPlayer, 2.0F));
	        }
	    }
	    return par1ItemStack;
	}
}
