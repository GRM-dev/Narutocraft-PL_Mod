package pl.grm.narutocraft.jutsu.ninjutsu;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.world.*;
import pl.grm.narutocraft.jutsu.*;


public class Meisaigakure extends Jutsu implements IJutsu {
	
	public Meisaigakure() {
		super(JutsuParams.MEISAIGAKURE);
	}
	

	@Override
	public void onJutsuActivation() {
		super.onJutsuActivation();
		this.player.addPotionEffect(new PotionEffect( Potion.invisibility.getId(),2400 ));
		 //this.setPotionEffect("Invisible");
	}
	

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
	
		return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
	}
}