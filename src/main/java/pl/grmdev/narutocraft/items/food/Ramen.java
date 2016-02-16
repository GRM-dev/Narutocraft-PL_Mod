package pl.grmdev.narutocraft.items.food;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import pl.grmdev.narutocraft.NarutoCraft;

public class Ramen extends ItemFood
{

	public Ramen()
	{
		super(10, 0.8F, false);
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.setUnlocalizedName("Ramen");
		this.setAlwaysEdible();
	}
}
