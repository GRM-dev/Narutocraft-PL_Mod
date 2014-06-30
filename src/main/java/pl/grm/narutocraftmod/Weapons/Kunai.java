package pl.grm.narutocraftmod.Weapons;

import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.Entities.EntityKunai;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class Kunai extends Item{
	
	public Kunai(int i) {
		super();
		this.setUnlocalizedName("Kunai");
		this.setTextureName("narutocraftmod:Kunai");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 16;
		
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer) {
	    
		if(par3EntityPlayer.capabilities.isCreativeMode||par3EntityPlayer.inventory.consumeInventoryItem(NarutoCraftMod.Kunai))
	    {
	        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	        if (!par2World.isRemote)
	        {
	            par2World.spawnEntityInWorld(new EntityKunai(par2World, par3EntityPlayer));
	        }
	    }
	    return par1ItemStack;
	}

}
