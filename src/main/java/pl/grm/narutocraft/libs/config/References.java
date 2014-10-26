package pl.grm.narutocraft.libs.config;

import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.jutsu.Jutsu;
import pl.grm.narutocraft.jutsu.JutsuEnum;
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
	public static final String				GuiTexturePath		= ModTexturePath + "textures/gui/";
	public static final String				ModTag				= "narutocraft:";
	public static final String				JutsuTexturePath	= ModTag + "jutsu/";
	public static final ResourceLocation[]	jutsuGUILocation	= new ResourceLocation[]{
			new ResourceLocation(GuiTexturePath + "JutsuPage1.png"),
			new ResourceLocation(GuiTexturePath + "JutsuPage2.png"),
			new ResourceLocation(GuiTexturePath + "JutsuPage3.png"),
			new ResourceLocation(GuiTexturePath + "JutsuPage4.png"),
			new ResourceLocation(GuiTexturePath + "JutsuPage5.png"),
			new ResourceLocation(GuiTexturePath + "JutsuPage6.png")};
	public static final ResourceLocation	statsPath			= new ResourceLocation(
																		GuiTexturePath
																				+ "SkillPoints.png");
	public static final ResourceLocation	ninjaWidgetsPath	= new ResourceLocation(
																		GuiTexturePath
																				+ "NinjaGuiWidgets.png");
	/** GUI IDs */
	public static final int					STATS				= 1, OPTS = 2, SKILL_TREE = 3;
	
	public static IIcon getIconFromJutsu(JutsuEnum jutsuE) {
		IIcon icon = ((Jutsu) ExtendedProperties.jutsuList.get(jutsuE.getJutsuID()))
				.getIconFromDamage(0);
		return icon;
	}
	
	public static IIcon getIconFromJutsu(IJutsu jutsu) {
		IIcon icon = ((Jutsu) ExtendedProperties.jutsuList.get(jutsu.getJutsuProps().getID()))
				.getIconFromDamage(0);
		return icon;
	}
}
