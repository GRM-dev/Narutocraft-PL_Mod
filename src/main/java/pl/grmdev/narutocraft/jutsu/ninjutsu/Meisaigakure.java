package pl.grmdev.narutocraft.jutsu.ninjutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import pl.grmdev.narutocraft.jutsu.IJutsu;
import pl.grmdev.narutocraft.jutsu.Jutsu;
import pl.grmdev.narutocraft.jutsu.JutsuParams;

public class Meisaigakure extends Jutsu implements IJutsu {

	public Meisaigakure() {
		super(JutsuParams.MEISAIGAKURE);
	}

	

	
	public void onJutsuActivation(EntityPlayer par1EntityPlayer) {
		super.onJutsuActivation();
		this.player.addPotionEffect(new PotionEffect(Potion.invisibility.getId(), 2400));
		this.setPotionEffect("Invisible");
	  
		
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {

		return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
	}
}