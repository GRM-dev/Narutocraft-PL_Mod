package pl.grm.narutocraft.potions;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class PotionNewMoveSpeed extends Potion
{

	public PotionNewMoveSpeed(int p_i45897_1_, ResourceLocation p_i45897_2_, boolean p_i45897_3_, int p_i45897_4_)
	{
		super(p_i45897_2_, p_i45897_3_, p_i45897_4_);
		setPotionName("potion.newMoveSpeed");
		setIconIndex(0, 0);
		registerPotionAttributeModifier(SharedMonsterAttributes.movementSpeed, "91AEAA56-376B-4498-935B-2F7F68070635", 0.20000000298023224D, 2);
	}	
	
	@Override
    public double getAttributeModifierAmount(int p_111183_1_, AttributeModifier p_111183_2_)
    {
        return 0.05D * (p_111183_1_ + 1);
    }
}
