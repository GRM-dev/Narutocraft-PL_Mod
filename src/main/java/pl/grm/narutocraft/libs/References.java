package pl.grm.narutocraft.libs;

import net.minecraft.util.ResourceLocation;

/**
 * Parameters/References to mod constants and info
 */
public class References {
	public static final String				MODID			= "NarutoCraft-Pl Mod";
	public static final String				NAME			= "NarutoCraft-Pl Mod";
	public static final String				VERSION			= "0.6.0";
	public static final String				Client			= "pl.grm.narutocraft.ProxyClient";
	public static final String				Common			= "pl.grm.narutocraft.ProxyCommon";
	public static final String				ModTexturePath	= "narutocraft:";
	public static final String				ModTag			= "ncpl:";
	public static final String				JUTSUTEXTURELOC	= "narutocraft:jutsu/";
	public static final ResourceLocation[]	jutsuGUI		= new ResourceLocation[]{
			new ResourceLocation(ModTexturePath + "textures/gui/JutsuPage1.png"),
			new ResourceLocation(ModTexturePath + "textures/gui/JutsuPage2.png"),
			new ResourceLocation(ModTexturePath + "textures/gui/JutsuPage3.png"),
			new ResourceLocation(ModTexturePath + "textures/gui/JutsuPage4.png"),
			new ResourceLocation(ModTexturePath + "textures/gui/JutsuPage5.png"),
			new ResourceLocation(ModTexturePath + "textures/gui/JutsuPage6.png")};
	public static final ResourceLocation	stats			= new ResourceLocation(
																	ModTexturePath
																			+ "textures/gui/SkillPoints.png");
	public static final ResourceLocation	ninjaWidgets	= new ResourceLocation(
																	ModTexturePath
																			+ "textures/gui/NinjaGuiWidgets.png");
}
