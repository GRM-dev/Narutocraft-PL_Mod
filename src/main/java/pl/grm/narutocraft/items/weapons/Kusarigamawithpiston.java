package pl.grm.narutocraft.items.weapons;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import pl.grm.narutocraft.libs.config.Materials;

public class Kusarigamawithpiston extends SwordMain{
	public Kusarigamawithpiston(){
	super(Materials.stal2);
	this.setAttackDamage(6);
	this.setMaxDamage(500);
	}
	
	/**
	 * Current implementations of this method in child classes do not use the
	 * entry argument beside ev. They just raise the damage on the stack.
	 */
	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase,
			EntityLivingBase par3EntityLivingBase) {
		par1ItemStack.damageItem(1, par3EntityLivingBase);
		
		if(random.nextInt(2) == 0)	par2EntityLivingBase.addPotionEffect(new PotionEffect(2, 60));
		
		return true;
	}
}
