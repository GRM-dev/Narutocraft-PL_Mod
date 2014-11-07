package pl.grm.narutocraft.libs.buffs;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.FMLLog;

public class BuffList {
	private static HashMap<Integer, Class>				classesForBuffID;
	private static final HashMap<Integer, BuffEffect>	utilityBuffs	= new HashMap();
	private static final ArrayList<NCPotion>			ncPotions		= new ArrayList();
	
	public static void Init() {
		classesForBuffID = new HashMap();
		try {
			ExtendPotionsArray();
			int numBuffs = Potion.potionTypes.length;
		}
		catch (Throwable t) {
			FMLLog.severe("NarutoCraft >> Jutsu Buffs failed to initialize!", new Object[0]);
			t.printStackTrace();
		}
	}
	
	public static void Instantiate() {
		// scheme: waterBreathing = createNCPotion(32, "Water Breathing", 0, 0,
		// false, BuffEffectWaterBreathing.class);
	}
	
	public static void setupTextureOverrides() {
		// scheme:
		// waterBreathing.setTextureSheet(ResourceManager.GetGuiTexturePath("buffs_1.png"));
	}
	
	private static void setFinalStatic(Field field, Object newValue) throws Exception {
		field.setAccessible(true);
		
		Field modifiersField = Field.class.getDeclaredField("modifiers");
		modifiersField.setAccessible(true);
		modifiersField.setInt(field, field.getModifiers() & 0xFFFFFFEF);
		
		field.set(null, newValue);
	}
	
	private static void ExtendPotionsArray() throws Exception {
		FMLLog.finer("NarutoCraft [BEGIN]: Extending Potions Array", new Object[0]);
		Potion[] potions = new Potion[Potion.potionTypes.length + 64];
		for (int i = 0; i < Potion.potionTypes.length; i++) {
			potions[i] = Potion.potionTypes[i];
		}
		Field field = null;
		Field[] fields = Potion.class.getDeclaredFields();
		for (Field f : fields) {
			if (f.getType().equals(Potion.class)) {
				field = f;
				break;
			}
		}
		setFinalStatic(field, potions);
		FMLLog.finer("NarutoCraft [END]: Extending Potions Array", new Object[0]);
	}
	
	public static boolean IDIsAMBuff(int potionID) {
		for (NCPotion i : ncPotions) {
			if (i.id == potionID) { return true; }
		}
		return false;
	}
	
	public static void fixPotions(EntityLivingBase ent) {
		Collection<PotionEffect> potions = ent.getActivePotionEffects();
		for (PotionEffect potion : potions) {
			if ((IDIsAMBuff(potion.getPotionID())) && (!(potion instanceof BuffEffect))) {
				BuffEffect utilityEffect = utilityBuffs.get(Integer.valueOf(potion.getPotionID()));
				if (utilityEffect != null) {
					BuffEffect.SetDuration(utilityEffect, potion.getDuration());
					BuffEffect.SetAmplifier(utilityEffect, potion.getAmplifier());
					utilityEffect.performEffect(ent);
				}
			}
		}
	}
}
