package pl.grmdev.narutocraft.jutsu.bukijutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import pl.grmdev.narutocraft.jutsu.IJutsu;
import pl.grmdev.narutocraft.jutsu.Jutsu;
import pl.grmdev.narutocraft.jutsu.JutsuParams;

public class Iaido extends Jutsu implements IJutsu {

	public Iaido() {
		super(JutsuParams.IAIDO);
	}

	@Override
	public void onJutsuActivation() {
		super.onJutsuActivation();
		this.player.addPotionEffect(new PotionEffect(10, 10));
		// this.setPotionEffect("Invisible");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
	}
}