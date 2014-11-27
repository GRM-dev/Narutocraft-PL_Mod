package pl.grm.narutocraft.libs.config;

import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import pl.grm.narutocraft.jutsu.Jutsu;
import pl.grm.narutocraft.jutsu.JutsuParams;
import pl.grm.narutocraft.player.ExtendedProperties;

/**
 * Parameters/References to mod constants and info
 */
public class References {
	/** Mod_ID */
	public static final String				MODID				= "NarutoCraft-Pl Mod";
	/** Mod Name */
	public static final String				NAME				= "NarutoCraft-Pl Mod";
	/** Mod Version */
	public static final String				VERSION				= "0.6.0";
	public static final String				Client				= "pl.grm.narutocraft.ProxyClient";
	public static final String				Common				= "pl.grm.narutocraft.ProxyCommon";
	public static final String				ModTexturePath		= "narutocraft:";
	public static final String				GUI_TEXTURE_PATH		= ModTexturePath + "textures/gui/";
	public static final String				ModTag				= "narutocraft:";
	public static final String				JutsuTexturePath	= ModTag + "jutsu/";
	public static final ResourceLocation[]	jutsuGUILocation	= new ResourceLocation[]{
			new ResourceLocation(GUI_TEXTURE_PATH + "JutsuPage1.png"),
			new ResourceLocation(GUI_TEXTURE_PATH + "JutsuPage2.png"),
			new ResourceLocation(GUI_TEXTURE_PATH + "JutsuPage3.png"),
			new ResourceLocation(GUI_TEXTURE_PATH + "JutsuPage4.png"),
			new ResourceLocation(GUI_TEXTURE_PATH + "JutsuPage5.png"),
			new ResourceLocation(GUI_TEXTURE_PATH + "JutsuPage6.png")};
	public static final ResourceLocation	statsPath			= new ResourceLocation(
																		GUI_TEXTURE_PATH
																				+ "SkillPoints.png");
	public static final ResourceLocation	ninjaWidgetsPath	= new ResourceLocation(
																		GUI_TEXTURE_PATH
																				+ "NinjaGuiWidgets.png");
	/** GUI IDs */
	public static final int					OPTS				= 1, STATS = 2, SKILL_TREE = 3,
			SETTS = 4;
	
	public static IIcon getIconFromJutsu(JutsuParams jutsuE) {
		if (!ExtendedProperties.jutsuList.containsKey((jutsuE.getJutsuID()))) { return null; }
		IIcon icon = ((Jutsu) ExtendedProperties.jutsuList.get(jutsuE.getJutsuID()))
				.getIconFromDamage(0);
		return icon;
	}
	
	public static IIcon getIconFromJutsu(Jutsu jutsu) {
		IIcon icon;
		if (!ExtendedProperties.jutsuList.containsKey((jutsu.getJutsuProps().getID()))) { return null; }
		icon = ((Jutsu) ExtendedProperties.jutsuList.get(jutsu.getJutsuProps().getID()))
				.getIconFromDamage(0);
		return icon;
	}
}
