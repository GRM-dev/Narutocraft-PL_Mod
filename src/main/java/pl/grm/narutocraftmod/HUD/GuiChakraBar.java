package pl.grm.narutocraftmod.HUD;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

public class GuiChakraBar extends Gui {
	private Minecraft mc;
	private final ResourceLocation texture = new ResourceLocation("chakrabar", "textures/gui/chakra_bar.png");

	public ResourceLocation getTexture() {
		return texture;
	}

	public GuiChakraBar() {
		
	}

	public GuiChakraBar(Minecraft mc) {
		super();
		this.mc = mc;
	}

	public Minecraft getMc() {
		mc = Minecraft.getMinecraft();
		return mc;
	}
}
