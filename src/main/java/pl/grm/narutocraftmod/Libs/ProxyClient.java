package pl.grm.narutocraftmod.Libs;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import pl.grm.narutocraftmod.Entities.EntityKunai;
import pl.grm.narutocraftmod.Entities.EntitySenbon;
import pl.grm.narutocraftmod.Entities.EntityShuriken;
import pl.grm.narutocraftmod.Entities.EntityWKunai;
import pl.grm.narutocraftmod.Entities.Render.RenderKunai;
import pl.grm.narutocraftmod.Entities.Render.RenderSenbon;
import pl.grm.narutocraftmod.Entities.Render.RenderShuriken;
import pl.grm.narutocraftmod.Entities.Render.RenderWKunai;
import pl.grm.narutocraftmod.HUD.GuiChakraBar;
import pl.grm.narutocraftmod.handlers.SoundHandler;
import pl.grm.narutocraftmod.Mobs.Bijuu.EntityKyuubi;
import pl.grm.narutocraftmod.Mobs.Bijuu.ModelKyuubi;
import pl.grm.narutocraftmod.Mobs.Bijuu.RenderKyuubi;
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