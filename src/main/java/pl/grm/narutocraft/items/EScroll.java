package pl.grm.narutocraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.world.World;
import pl.grm.narutocraft.NarutoCraft;

public class EScroll extends Item {

	public EScroll() {
		this.setUnlocalizedName("EarthScroll");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 1;

	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {

		par3EntityPlayer.onKillCommand();
		return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
	}

}
