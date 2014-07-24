package pl.grm.narutocraftmod.Libs;

import net.minecraftforge.common.MinecraftForge;
import pl.grm.narutocraftmod.Entities.EntityKunai;
import pl.grm.narutocraftmod.Entities.Render.RenderKunai;
import pl.grm.narutocraftmod.Libs.Sound.KyuubiSoundEvent;
import pl.grm.narutocraftmod.Libs.Sound.Sounds;
import pl.grm.narutocraftmod.Mobs.Bijuu.EntityKyuubi;
import pl.grm.narutocraftmod.Mobs.Bijuu.ModelKyuubi;
import pl.grm.narutocraftmod.Mobs.Bijuu.RenderKyuubi;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ProxyClient extends ProxyCommon{
	
	public void registerRenderInfomation() {
		
	}
	
	@Override
    public void registerRenderThings() 
    {
		RenderingRegistry.registerEntityRenderingHandler(EntityKunai.class, new RenderKunai());
		RenderingRegistry.registerEntityRenderingHandler(EntityKyuubi.class, new RenderKyuubi(new ModelKyuubi(), 0.5F));
		//the 0.5F is the shadow size
		
    }
	
    @Override
    public void registerSound() {
          MinecraftForge.EVENT_BUS.register(new KyuubiSoundEvent());  //register the sound event handling class
          MinecraftForge.EVENT_BUS.register(new Sounds());
    }
	 
    @Override
    public int addArmor(String armor)
    {
        return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
    
}
