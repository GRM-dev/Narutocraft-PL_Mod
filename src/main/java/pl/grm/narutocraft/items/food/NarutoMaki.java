package pl.grm.narutocraft.items.food;

import pl.grm.narutocraft.NarutoCraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class NarutoMaki extends ItemFood{

	public NarutoMaki() {
		super(1, 0.5F, false);
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


