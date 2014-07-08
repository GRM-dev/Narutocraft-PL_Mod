package pl.grm.narutocraftmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import pl.grm.narutocraftmod.Entities.EntityKunai;
import pl.grm.narutocraftmod.Libs.ProxyCommon;
import pl.grm.narutocraftmod.Libs.References;
import pl.grm.narutocraftmod.Libs.RegItems;
import pl.grm.narutocraftmod.Libs.RegPowers;
import pl.grm.narutocraftmod.Mobs.Bijuu.EntityKyuubi;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = References.MODID, version = References.VERSION)

public class NarutoCraftMod
{

	@SidedProxy(clientSide = References.Client, 
    		serverSide = References.Common)
    public static ProxyCommon proxy;
    
    //NarutoCraft Creative Tab
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
    public void init(FMLInitializationEvent event)
    {
    	int id =0;
    	EntityRegistry.registerModEntity(EntityKunai.class, "Kunai", id, this, 80, 1, true); id++;
    	EntityRegistry.registerModEntity(EntityKyuubi.class, "Kyuubi", id, this, 80, 1, true);
    	id++;
    	//EntityRegistry.addSpawn(EntityKyuubi.class, 2, 0, 1, EnumCreatureType.creature, BiomeGenBase.biomeList);//change the values to vary the spawn rarity, biome, etc.              
    	proxy.registerRenderThings();
    	proxy.registerSound();
    	
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event) {
    	proxy.registerRenderInfomation();
    	//EntityRegistry.registerGlobalEntityID(EntityKyuubi.class, "EntityKyuubi", 1);
    	EntityRegistry.registerGlobalEntityID(EntityKyuubi.class, "EntityKyuubi", 4800, 2, 2);
    }
    
    
    public NarutoCraftMod() {
    			RegItems.RegItems();
    			RegPowers.RegPowers();
                
    //crafting
                ItemStack diamondStack = new ItemStack(Items.diamond);
                ItemStack stickStack = new ItemStack(Items.stick);

                GameRegistry.addRecipe(new ItemStack(RegItems.Kunai, 2), 
                		"x  ", 
                		" y ", 
                		"  x",
                        'x', diamondStack, 'y', stickStack);
                //GameRegistry.addShapelessRecipe(ItemStack result, Object... recipe)
                              
    }
}
