package pl.grm.narutocraft.jutsu.iryojutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.jutsu.Jutsu;
import pl.grm.narutocraft.jutsu.JutsuParams;

public class InyuShometsu extends Jutsu implements IJutsu {
	
	public InyuShometsu() {
		super(JutsuParams.INYUSHOMETSU);
	}
	
	@Override
	public void onJutsuActivation() {
		super.onJutsuActivation();
		player.addPotionEffect(new PotionEffect(10, 40));
		 this.setPotionEffect("Heal"); //Fix Me
	
	}
	
	
		
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		

		
			
		return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
	}
}