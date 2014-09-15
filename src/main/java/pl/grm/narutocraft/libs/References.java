package pl.grm.narutocraft.libs;

import net.minecraft.util.ResourceLocation;

public class References {

	public static final String MODID = "NarutoCraft-Pl Mod";
	public static final String VERSION = "1.5.0";
	public static final String Client = "pl.grm.narutocraft.libs.ProxyClient";
	public static final String Common = "pl.grm.narutocraft.libs.ProxyCommon";
	public static final String ModTexturePath = "narutocraft:";
	public static final String ModTag = "ncpl:";
	public static final String jutsuLoc = "narutocraft:jutsu/";
	public static final ResourceLocation[] jutsuGUI = new ResourceLocation[]{
			new ResourceLocation(ModTexturePath + "textures/gui/JutsuPage1.png"),
			new ResourceLocation(ModTexturePath + "textures/gui/JutsuPage2.png"),
			new ResourceLocation(ModTexturePath + "textures/gui/JutsuPage3.png"),
			new ResourceLocation(ModTexturePath + "textures/gui/JutsuPage4.png"),
			new ResourceLocation(ModTexturePath + "textures/gui/JutsuPage5.png"),
			new ResourceLocation(ModTexturePath + "textures/gui/JutsuPage6.png")};
	public static final ResourceLocation stats = new ResourceLocation(
			ModTexturePath + "textures/gui/SkillPoints.png");
	public static final ResourceLocation ninjaWidgets = new ResourceLocation(
			ModTexturePath + "textures/gui/NinjaGuiWidgets.png");
}
