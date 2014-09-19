package pl.grm.narutocraft.jutsu.ninjutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import pl.grm.narutocraft.jutsu.Jutsu;
import pl.grm.narutocraft.jutsu.JutsuEnum;

// import pl.grm.narutocraft.effects.IEffect;

public class Rasengan extends Jutsu {
	
	public Rasengan() {
		super(JutsuEnum.RASENGAN);
		this.setUnlocalizedName("Rasengan");
		this.setTextureName(textureLoc + "Rasengan");
	}
	
	@Override
	public void activateJutsu() {
		super.activateJutsu();
		this.player.addPotionEffect(new PotionEffect(10, 10));
		// this.setPotionEffect("Invisible");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		return super.onItemRightClick(par1ItemStack, par2World, par3EntityPlayer);
	}
}