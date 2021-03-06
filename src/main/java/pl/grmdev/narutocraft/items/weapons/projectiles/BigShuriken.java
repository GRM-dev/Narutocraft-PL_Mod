package pl.grmdev.narutocraft.items.weapons.projectiles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import pl.grmdev.narutocraft.NarutoCraft;
import pl.grmdev.narutocraft.items.weapons.projectiles.entities.EntityShuriken;
import pl.grmdev.narutocraft.registry.RegItems;
import pl.grmdev.narutocraft.registry.RegWeapons;

public class BigShuriken extends Item {

	public BigShuriken() {
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 10;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {

		if (par3EntityPlayer.capabilities.isCreativeMode
				|| par3EntityPlayer.inventory.consumeInventoryItem(RegItems.BigShuriken)) {
			par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F,
					0.4F / ((itemRand.nextFloat() * 0.4F) + 0.8F));
			if (!par2World.isRemote) {
				par2World.spawnEntityInWorld(new EntityShuriken(par2World, par3EntityPlayer, 2.0F));
			}
		}
		return par1ItemStack;
	}
}
