package pl.grm.narutocraftmod;

import net.minecraft.creativetab.CreativeTabs;
import pl.grm.narutocraftmod.Libs.ProxyCommon;
import pl.grm.narutocraftmod.Libs.References;
import pl.grm.narutocraftmod.Libs.Registry.RegEntities;
import pl.grm.narutocraftmod.Libs.Registry.RegItems;
import pl.grm.narutocraftmod.Libs.Registry.RegMobs;
import pl.grm.narutocraftmod.Libs.Registry.RegPowers;
import pl.grm.narutocraftmod.Libs.Registry.RegRecipes;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.MODID, version = References.VERSION)

public class NarutoCraftMod
{
	@SidedProxy(clientSide = References.Client, serverSide = References.Common)
    public static ProxyCommon proxy;
    
    public static CreativeTabs mTabNarutoCraftMod = new TabClass(CreativeTabs.getNextID(), "NarutoCraftMod");
        	
    @Instance(References.MODID)
    public static NarutoCraftMod instance;
    	
    private ConfigurationHandler config;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
         config = new ConfigurationHandler(event.getSuggestedConfigurationFile());
         config.readConfig();
         
    }
    	
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	RegEntities.RegEntitiesList();
    	proxy.registerSound();
    	
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event) {
    	proxy.registerRenderInfomation();
    	proxy.registerRenderThings();
    	RegMobs.RegMobsList();
    	
    }
    
    public NarutoCraftMod() {
    			RegItems.RegItemsList();
    			RegPowers.RegPowersList();
                RegRecipes.RegRecipesList();
                
    }
}
