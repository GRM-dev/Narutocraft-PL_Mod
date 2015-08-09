package pl.grm.narutocraft.items.food;

import pl.grm.narutocraft.NarutoCraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class IchirakuRamen extends ItemFood{

	public IchirakuRamen() {
		super(0, 0.0F, false);
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.setUnlocalizedName("IchirakuRamen");
		// TODO Auto-generated constructor stub
	
	}
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		par3EntityPlayer.heal(20);
		return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
	}

}
