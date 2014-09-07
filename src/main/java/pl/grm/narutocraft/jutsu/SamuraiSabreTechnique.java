package pl.grm.narutocraft.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SamuraiSabreTechnique extends Jutsu {

	public SamuraiSabreTechnique(int i) {
		this.setUnlocalizedName("Samurai Sabre Technique");
		this.setTextureName(jutsuLoc + "Samurai Sabre Technique");
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (!world.isRemote) {

		}
		return stack;
	}

}