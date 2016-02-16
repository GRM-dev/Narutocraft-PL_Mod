package pl.grmdev.narutocraft.items.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import pl.grmdev.narutocraft.NarutoCraft;

public class Pasta extends ItemFood
{

	public Pasta()
	{
		super(2, 0.6F, false);
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.setUnlocalizedName("Pasta");
		this.setAlwaysEdible();
	}
}