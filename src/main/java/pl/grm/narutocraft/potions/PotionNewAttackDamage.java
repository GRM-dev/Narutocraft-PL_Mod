package pl.grm.narutocraft.potions;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionAttackDamage;
import net.minecraft.util.ResourceLocation;

public class PotionNewAttackDamage extends PotionAttackDamage
{
	public PotionNewAttackDamage(int p_i45900_1_, ResourceLocation p_i45900_2_, boolean p_i45900_3_, int p_i45900_4_)
    {
        super(p_i45900_1_, p_i45900_2_, p_i45900_3_, p_i45900_4_);
        setPotionName("potion.damageBoost");
        setIconIndex(4, 0);
        registerPotionAttributeModifier(SharedMonsterAttributes.attackDamage, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 2.5D, 2);
    }

	@Override
    public double getAttributeModifierAmount(int p_111183_1_, AttributeModifier p_111183_2_)
    {
        return this.id == Potion.weakness.id ? (double)(-0.5F * (float)(p_111183_1_ + 1)) : 0.05D * (double)(p_111183_1_ + 1);
    }
}