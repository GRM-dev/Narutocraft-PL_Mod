package pl.grm.narutocraft.jutsu.ninjutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.jutsu.Jutsu;
import pl.grm.narutocraft.jutsu.JutsuParams;
import pl.grm.narutocraft.libs.buffs.testEff;

public class Meisaigakure extends Jutsu implements IJutsu {
	
	public Meisaigakure() {
		super(JutsuParams.MEISAIGAKURE);
	}
	
	@Override
	public void onJutsuActivation() {
		super.onJutsuActivation();
		this.player.addPotionEffect(new testEff(30, 100, 0));
		// this.setPotionEffect("Invisible");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
	}
}