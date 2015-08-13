package pl.grm.narutocraft.items.food;

import pl.grm.narutocraft.NarutoCraft;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

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
