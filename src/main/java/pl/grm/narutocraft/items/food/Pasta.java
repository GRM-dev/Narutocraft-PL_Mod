package pl.grm.narutocraft.items.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import pl.grm.narutocraft.NarutoCraft;

public class Pasta extends ItemFood{

	public Pasta() {
		super(2, 0.5F, false);
		// TODO Auto-generated constructor stub
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.setUnlocalizedName("Pasta");
		this.setAlwaysEdible();
	}
	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
	    super.onFoodEaten(stack, world, player);
}
}