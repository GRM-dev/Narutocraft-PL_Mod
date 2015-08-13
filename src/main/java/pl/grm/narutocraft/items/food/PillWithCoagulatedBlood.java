package pl.grm.narutocraft.items.food;

import pl.grm.narutocraft.NarutoCraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PillWithCoagulatedBlood extends ItemFood
{

	public PillWithCoagulatedBlood()
	{
		super(0, 0.0F, false);
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.setUnlocalizedName("PillWithCoagulatedBlood");
		this.setAlwaysEdible();
	}

	@Override
	public void onFoodEaten(ItemStack itemStack, World worldIn, EntityPlayer player)
	{
		super.onFoodEaten(itemStack, worldIn, player);
		if(!worldIn.isRemote)player.heal(14);
	}
}
