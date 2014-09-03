package pl.grm.narutocraftmod.libs;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import pl.grm.narutocraftmod.handlers.SoundHandler;
import pl.grm.narutocraftmod.hud.chakrabar.GuiChakraBar;
import pl.grm.narutocraftmod.itementities.EntityKunai;
import pl.grm.narutocraftmod.itementities.EntitySenbon;
import pl.grm.narutocraftmod.itementities.EntityShuriken;
import pl.grm.narutocraftmod.itementities.EntityWKunai;
import pl.grm.narutocraftmod.itementities.render.RenderKunai;
import pl.grm.narutocraftmod.itementities.render.RenderSenbon;
import pl.grm.narutocraftmod.itementities.render.RenderShuriken;
import pl.grm.narutocraftmod.itementities.render.RenderWKunai;
import pl.grm.narutocraftmod.libs.config.KeyBindings;
import pl.grm.narutocraftmod.libs.registry.RegItems;
import pl.grm.narutocraftmod.mobs.bijuu.EntityKyuubi;
import pl.grm.narutocraftmod.mobs.bijuu.ModelKyuubi;
import pl.grm.narutocraftmod.mobs.bijuu.RenderKyuubi;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ProxyClient extends ProxyCommon{
	
	@Override
	public void registerRenderInfomation() {
		
	}
	
	@Override
    public void registerRendering()
    {
        //ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTestContainer.class, new RenderTestContainer());
    }
	
	@Override
    public void registerRenderThings() 
    {
		//Scaled Items
		//MinecraftForgeClient.registerItemRenderer(item, new ItemRendererScaled(.75f)); .75f is about 2x
		MinecraftForgeClient.registerItemRenderer(RegItems.Kubiki, new ItemRendererScaled(.875f));
		//Projectiles:
		RenderingRegistry.registerEntityRenderingHandler(EntityKunai.class, new RenderKunai());
		RenderingRegistry.registerEntityRenderingHandler(EntityWKunai.class, new RenderWKunai());
		RenderingRegistry.registerEntityRenderingHandler(EntitySenbon.class, new RenderSenbon());
		RenderingRegistry.registerEntityRenderingHandler(EntityShuriken.class, new RenderShuriken());
		//Mobs:
		RenderingRegistry.registerEntityRenderingHandler(EntityKyuubi.class, new RenderKyuubi(new ModelKyuubi(), 5.5F));
		//the last param is the shadow size
		//GUI:
		MinecraftForge.EVENT_BUS.register(new GuiChakraBar(Minecraft.getMinecraft()));
		//Keys:
		KeyBindings.init();
		
    }

    @Override
    public void registerSound() {
          MinecraftForge.EVENT_BUS.register(new SoundHandler());  //register the sound event handling class
    }

    @Override
    public int addArmor(String armor)
    {
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }

}