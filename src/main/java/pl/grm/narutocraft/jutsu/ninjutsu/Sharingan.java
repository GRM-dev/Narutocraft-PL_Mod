package pl.grm.narutocraft.jutsu.ninjutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import pl.grm.narutocraft.jutsu.Jutsu;
import pl.grm.narutocraft.jutsu.JutsuEnum;

public class Sharingan extends Jutsu {
	
	public Sharingan() {
		super(JutsuEnum.SHARINGAN);
		this.setUnlocalizedName("Sharingan");
		this.setTextureName(textureLoc + "Sharingan");
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 1;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			
		}
		return stack;
	}
	
}
