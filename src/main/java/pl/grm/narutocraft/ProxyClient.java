package pl.grm.narutocraft;

import net.minecraft.client.*;
import net.minecraftforge.client.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.client.registry.*;
import pl.grm.narutocraft.gui.chakrabar.*;
import pl.grm.narutocraft.handlers.*;
import pl.grm.narutocraft.items.weapons.projectiles.entities.*;
import pl.grm.narutocraft.items.weapons.projectiles.entities.render.*;
import pl.grm.narutocraft.libs.buffs.*;
import pl.grm.narutocraft.libs.config.*;
import pl.grm.narutocraft.mobs.bijuu.*;

public class ProxyClient extends ProxyCommon {
	
	@Override
	public void registerCommands() {
		ClientCommandHandler manager = ClientCommandHandler.instance;
		NCCommandHandler commandHandler = new NCCommandHandler(manager);
		commandHandler.registerCommands(true);
	}
	
	@Override
	public void registerRenderInfomation() {
		
	}
	
	@Override
	public void registerRendering() {
		// ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTestContainer.class,
		// new RenderTestContainer());
	}
	
	@Override
	public void registerRenderThings() {
		// Scaled Items
		// MinecraftForgeClient.registerItemRenderer(item, new
		// ItemRendererScaled(.75f)); .75f is about 2x
		// MinecraftForgeClient
		// .registerItemRenderer(RegWeapons.Kubiki, new
		// ItemRendererSizeable(0.7f));
		// MinecraftForgeClient.registerItemRenderer(RegWeapons.ChioRyuuGatana,
		// new ItemRendererSizeable(0.7f));
		// MinecraftForgeClient.registerItemRenderer(RegWeapons.Raitanto, new
		// ItemRendererSizeable(
		// 0.7f));
		// Projectiles:
		RenderingRegistry.registerEntityRenderingHandler(EntityKunai.class, new RenderKunai());
		RenderingRegistry.registerEntityRenderingHandler(EntityWKunai.class, new RenderWKunai(
				Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntitySenbon.class, new RenderSenbon(
				Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityShuriken.class, new RenderShuriken(
				Minecraft.getMinecraft().getRenderManager()));
		// Mobs:
		RenderingRegistry.registerEntityRenderingHandler(EntityKyuubi.class, new RenderKyuubi(
				new ModelKyuubi(), 5.5F));
		// the last param is the shadow size
		// GUI:
		MinecraftForge.EVENT_BUS.register(new GuiChakraBar(Minecraft.getMinecraft()));
		// Keys:
		KeyBindings.init();
		BuffList.setupTextureOverrides();
	}
	
	/**
	 * register the sound event handling class
	 */
	@Override
	public void registerSound() {
		MinecraftForge.EVENT_BUS.register(new SoundHandler());
	}
}