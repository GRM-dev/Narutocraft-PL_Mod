package pl.grm.narutocraftmod.HUD;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import pl.grm.narutocraftmod.Libs.ExtendedPlayer;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GuiChakraBar extends Gui {

	public static ResourceLocation getTexture() {
		return texture;
	}

	private Minecraft mc;

	private static final ResourceLocation texture = new ResourceLocation("chakrabar", "textures/gui/chakra_bar.png");

	public GuiChakraBar() {
		GuiChakraBar gcb = new GuiChakraBar(Minecraft.getMinecraft());
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
