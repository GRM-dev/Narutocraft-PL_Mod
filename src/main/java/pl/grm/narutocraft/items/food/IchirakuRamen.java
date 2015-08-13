package pl.grm.narutocraft.items.food;

import pl.grm.narutocraft.NarutoCraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class IchirakuRamen extends ItemFood
{

	public IchirakuRamen()
	{
		super(20, 1.0F, false);
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.setUnlocalizedName("IchirakuRamen");
		this.setAlwaysEdible();
	}
	
	@Override
	public void onFoodEaten(ItemStack itemStack, World worldIn, EntityPlayer player)
	{
		super.onFoodEaten(itemStack, worldIn, player);
		if(!worldIn.isRemote)player.heal(20);
	}
}
