package pl.grm.narutocraft.items.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import pl.grm.narutocraft.NarutoCraft;

public class FoodMilitaryPill extends ItemFood
{

	public FoodMilitaryPill()
	{
		super(0, 0.0F, false);
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.setUnlocalizedName("FoodMilitaryPill");
		this.setAlwaysEdible();
	}

	@Override
	public void onFoodEaten(ItemStack itemStack, World worldIn, EntityPlayer player)
	{
		super.onFoodEaten(itemStack, worldIn, player);
		
		player.addPotionEffect(new PotionEffect(1, 6000, 0, false, false));
		player.addPotionEffect(new PotionEffect(30, 6000, 0, false, true));
		player.addPotionEffect(new PotionEffect(10, 6000, 0, false, true));
	}
}
