package pl.grm.narutocraft.registry;

import net.minecraft.util.ResourceLocation;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.potions.PotionNewAttackDamage;
import pl.grm.narutocraft.potions.PotionNewMoveSpeed;

public class RegPotion extends NarutoCraft
{
	public static PotionNewAttackDamage newAttackDamage;
	public static PotionNewMoveSpeed newMoveSpeed; 

	public static void registerPotions()
	{
		newMoveSpeed = new PotionNewMoveSpeed(1, new ResourceLocation("newspeed"), false, 8171462);
		newAttackDamage = new PotionNewAttackDamage(2, new ResourceLocation("newstrength"), false, 9643043);
	}
}
