package pl.grm.narutocraft.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import pl.grm.narutocraft.effects.Effect;
import pl.grm.narutocraft.effects.ItemEffect;

public class Meisaigakure extends Jutsu {

	public Meisaigakure(int i) {
		this.setUnlocalizedName("Meisaigakure");
		this.setTextureName(jutsuLoc + "Meisaigakure");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {
			player.addPotionEffect(new ItemEffect(Effect.INVISIBLE.effectID,
					200, 4));
		}
		return stack;
	}
}