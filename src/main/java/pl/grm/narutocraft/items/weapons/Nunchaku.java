package pl.grm.narutocraft.items.weapons;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import pl.grm.narutocraft.libs.config.Materials;

public class Nunchaku extends SwordMain {

	public Nunchaku() {
		super(Materials.stal);
		this.setAttackDamage(8);
		this.setMaxDamage(400);
		
	}
	
	/**
	 * Current implementations of this method in child classes do not use the
	 * entry argument beside ev. They just raise the damage on the stack.
	 */
	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		par1ItemStack.damageItem(1, par3EntityLivingBase);
		
		if(random.nextInt(3) == 0)	par2EntityLivingBase.addPotionEffect(new PotionEffect(2, 100));
		
		return true;
	}
}
