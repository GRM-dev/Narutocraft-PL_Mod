package pl.grm.narutocraft.weapons.projectiles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import pl.grm.narutocraft.NarutoCraftMod;
import pl.grm.narutocraft.itementities.EntityShuriken;
import pl.grm.narutocraft.libs.registry.RegItems;

public class Shuriken extends Item {
	public Shuriken() {
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 10;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer) {
	    
		if(par3EntityPlayer.capabilities.isCreativeMode||par3EntityPlayer.inventory.consumeInventoryItem(RegItems.Shuriken))
	    {
	        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	        if (!par2World.isRemote)
	        {
	            par2World.spawnEntityInWorld(new EntityShuriken(par2World, par3EntityPlayer, 2.0F));
	        }
	    }
	    return par1ItemStack;
	}
}
