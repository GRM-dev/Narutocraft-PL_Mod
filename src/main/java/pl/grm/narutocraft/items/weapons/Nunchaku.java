package pl.grm.narutocraft.items.weapons;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import pl.grm.narutocraft.libs.Materials;

public class Nunchaku extends SwordMain {
	public Nunchaku() {
		super(Materials.stal);

	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		super.onItemRightClick(stack, world, player);

		return stack;
	}

	@Override
	public void onUpdate() {
	}
}
