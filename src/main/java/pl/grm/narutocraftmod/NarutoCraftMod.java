package pl.grm.narutocraftmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import pl.grm.narutocraftmod.Entities.EntityKunai;
import pl.grm.narutocraftmod.Libs.ProxyCommon;
import pl.grm.narutocraftmod.Libs.References;
import pl.grm.narutocraftmod.Mobs.Bijuu.EntityKyuubi;
import pl.grm.narutocraftmod.Powers.KawarimiNoJutsu;
import pl.grm.narutocraftmod.Powers.Rasengan;
import pl.grm.narutocraftmod.Powers.Rasengan2;
import pl.grm.narutocraftmod.Powers.Rasengan3;
import pl.grm.narutocraftmod.Powers.Sharingan;
import pl.grm.narutocraftmod.Powers.ShunshinNoJutsu;
import pl.grm.narutocraftmod.Weapons.Kunai;
import pl.grm.narutocraftmod.Weapons.Shuriken;
import pl.grm.narutocraftmod.Weapons.WKunai;
import pl.grm.narutocraftmod.Weapons.Senbon;

@Mod(modid = References.MODID, version = References.VERSION)

public class NarutoCraftMod
{

	@SidedProxy(clientSide = References.Client, 
    		serverSide = References.Common)
    public static ProxyCommon proxy;
    
    //NarutoCraft Creative Tab
    public static CreativeTabs mTabNarutoCraftMod = new TabClass(CreativeTabs.getNextID(), "NarutoCraftMod");
    
    
    //Items ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
		//public static Item  = new (46);
    public static Item KNoJutsu = new KawarimiNoJutsu(4600);
    public static Item SNoJutsu = new ShunshinNoJutsu(4601);
   	public static Item Sharingan = new Sharingan(4602);
   	public static Item Rasengan = new Rasengan(4603);
   	public static Item Rasengan2 = new Rasengan2(4604);
   	public static Item Rasengan3 = new Rasengan3(4605);
   	public static Item Kunai = new Kunai(4606);
   	public static Item WKunai = new WKunai(4607);
   	public static Item Shuriken = new Shuriken(4608);
   	public static Item Senbon = new Senbon(4609);
   	
//	public static Item  = new (46);
    	
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
    	EntityRegistry.registerModEntity(EntityKunai.class, "WKunai",  id, this, 120, 3, true );
    	id++;
    	
    	
    	EntityRegistry.registerModEntity(EntityKyuubi.class, "Kyuubi", id, this, 80, 1, true);//id is an internal mob id, you can start at 0 and continue adding them up.
    	id++;
    	//EntityRegistry.addSpawn(EntityKyuubi.class, 2, 0, 1, EnumCreatureType.creature, BiomeGenBase.biomeList);//change the values to vary the spawn rarity, biome, etc.              
    	proxy.registerRenderThings();//calls the methods in our proxy, which will do things on client side
    	proxy.registerSound();
    	
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event) {
    	proxy.registerRenderInfomation();
    	//EntityRegistry.registerGlobalEntityID(EntityKyuubi.class, "EntityKyuubi", 1);
    	EntityRegistry.registerGlobalEntityID(EntityKyuubi.class, "EntityKyuubi", 4800, 2, 2);
    }
    
    /*EventHandler                      //depracated
    public void Load(FMLInitializationEvent event) 
    {
         LanguageRegistry.instance().addStringLocalization("itemGroup.NarutoCraftMod", "NarutoCraftMod 1.1.0");
	}*/
    
    
    public NarutoCraftMod() {
    	
    //item game registry
//                GameRegistry.registerItem(, "");
    			GameRegistry.registerItem(KNoJutsu, "KawarimiNoJutsu");
    			GameRegistry.registerItem(SNoJutsu, "ShunshinNoJutsu");
    			GameRegistry.registerItem(Sharingan, "Sharingan");
    			GameRegistry.registerItem(Rasengan, "Rasengan");
    			GameRegistry.registerItem(Rasengan2, "OdamaRasengan");
    			GameRegistry.registerItem(Rasengan3, "ChioOdamaRasengan");
    			GameRegistry.registerItem(Kunai, "Kunai");
    			GameRegistry.registerItem(WKunai, "WybuchowyKunai");
    			GameRegistry.registerItem(Shuriken, "Shuriken");
                GameRegistry.registerItem(Senbon, "Senbon");
                
    //crafting
                ItemStack diamondStack = new ItemStack(Items.diamond);
                ItemStack stickStack = new ItemStack(Items.stick);

                GameRegistry.addRecipe(new ItemStack(NarutoCraftMod.Kunai, 2), 
                		"x  ", 
                		" y ", 
                		"  x",
                        'x', diamondStack, 'y', stickStack);
                //GameRegistry.addShapelessRecipe(ItemStack result, Object... recipe)
                
                
     //Entities
                
    }
}
