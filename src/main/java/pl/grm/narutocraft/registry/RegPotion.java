package pl.grm.narutocraft.registry;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionAttackDamage;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod.EventHandler;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.potions.PotionNewAttackDamage;
import pl.grm.narutocraft.potions.PotionNewMoveSpeed;

public class RegPotion extends NarutoCraft
{
	public static PotionNewAttackDamage newAttackDamage;
	public static PotionNewMoveSpeed newMoveSpeed; 

	public static void registerPotions()
	{
		newMoveSpeed = new PotionNewMoveSpeed(1, new ResourceLocation("speed"), false, 8171462);
		newAttackDamage = new PotionNewAttackDamage(5, new ResourceLocation("strength"), false, 9643043);			
	}
}
