package pl.grm.narutocraft.libs.buffs;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.FMLLog;
import pl.grm.narutocraft.jutsu.IJutsu;

public class BuffList {

	private static HashMap<Integer, Class<IJutsu>> classesForBuffID;
	private static NCPotion magicShield;
	private static final HashMap<Integer, BuffEffect> utilityBuffs = new HashMap<Integer, BuffEffect>();
	private static final ArrayList<NCPotion> ncPotions = new ArrayList<NCPotion>();

	/**
	 * Inits mod custom buffList
	 */
	public static void Init() {
		classesForBuffID = new HashMap<Integer, Class<IJutsu>>();
		try {
			ExtendPotionsArray();
		}
		catch (Throwable t) {
			FMLLog.severe("NarutoCraft >> Jutsu Buffs failed to initialize!", new Object[0]);
			t.printStackTrace();
		}

	}

	public static void Instantiate() {
		magicShield = createNCPotion(30, "test Effect", 1, 1, false, testEff.class);
		// scheme: waterBreathing = createNCPotion(32, "Water Breathing", 0, 0,
		// false, BuffEffectWaterBreathing.class);
	}

	/**
	 * @param index
	 * @param name
	 * @param iconRow
	 * @param iconCol
	 * @param isBadEffect
	 * @param buffEffectClass
	 * @return NCPotion
	 */
	private static NCPotion createNCPotion(int index, String name, int iconRow, int iconCol, boolean isBadEffect,
			Class buffEffectClass) {
		NCPotion potion = new NCPotion(index, isBadEffect, 0);
		potion.setPotionName(name);
		potion.setIconIndex(iconCol, iconRow);
		classesForBuffID.put(Integer.valueOf(index), buffEffectClass);
		ncPotions.add(potion);
		return potion;
	}

	public static void setupTextureOverrides() {
		// scheme:
		// waterBreathing.setTextureSheet(ResourceManager.GetGuiTexturePath("buffs_1.png"));
	}

	static void setFinalStatic(Class clazz, String fieldName, Object newValue) throws NoSuchFieldException,
			IllegalAccessException {
		Field field = clazz.getDeclaredField(fieldName);
		field.setAccessible(true);
		Field modifiers = field.getClass().getDeclaredField("modifiers");
		modifiers.setAccessible(true);
		modifiers.setInt(field, field.getModifiers() & 0xFFFFFFEF);
		field.set(null, newValue);
	}

	/**
	 * Extends array in Potion
	 * 
	 * @throws Exception
	 */
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
		setFinalStatic(Potion.class, "potionTypes", potions);
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
					BuffEffect.setAmplifier(utilityEffect, potion.getAmplifier());
					utilityEffect.performEffect(ent);
				}
			}
		}
	}
}
