package pl.grm.narutocraftmod.weapons;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import pl.grm.narutocraftmod.libs.Materials;

public class Kubiki extends SwordMain 
{
	public Kubiki() 
	{
		super(Materials.metalshinobi);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer)
	{
		// TODO Auto-generated method stub
		return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
	}
}