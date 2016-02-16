package pl.grmdev.narutocraft;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import pl.grmdev.narutocraft.gui.chakrabar.GuiChakraBar;
import pl.grmdev.narutocraft.handlers.NCCommandHandler;
import pl.grmdev.narutocraft.handlers.SoundHandler;
import pl.grmdev.narutocraft.items.weapons.projectiles.entities.EntityExplodeKunai;
import pl.grmdev.narutocraft.items.weapons.projectiles.entities.EntityKunai;
import pl.grmdev.narutocraft.items.weapons.projectiles.entities.EntitySenbon;
import pl.grmdev.narutocraft.items.weapons.projectiles.entities.EntityShuriken;
import pl.grmdev.narutocraft.items.weapons.projectiles.entities.render.RenderExplodeKunai;
import pl.grmdev.narutocraft.items.weapons.projectiles.entities.render.RenderKunai;
import pl.grmdev.narutocraft.items.weapons.projectiles.entities.render.RenderSenbon;
import pl.grmdev.narutocraft.items.weapons.projectiles.entities.render.RenderShuriken;
import pl.grmdev.narutocraft.libs.buffs.BuffList;
import pl.grmdev.narutocraft.libs.config.KeyBindings;
import pl.grmdev.narutocraft.mobs.bijuu.EntityKyuubi;
import pl.grmdev.narutocraft.mobs.bijuu.ModelKyuubi;
import pl.grmdev.narutocraft.mobs.bijuu.RenderKyuubi;

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
		RenderingRegistry.registerEntityRenderingHandler(EntityExplodeKunai.class, new RenderExplodeKunai(Minecraft.getMinecraft()
				.getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntitySenbon.class, new RenderSenbon(Minecraft.getMinecraft()
				.getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityShuriken.class, new RenderShuriken(Minecraft
				.getMinecraft().getRenderManager()));
		// Mobs:
		RenderingRegistry.registerEntityRenderingHandler(EntityKyuubi.class, new RenderKyuubi(new ModelKyuubi(), 5.5F));
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