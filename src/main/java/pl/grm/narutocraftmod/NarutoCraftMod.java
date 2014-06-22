package pl.grm.narutocraftmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import pl.grm.narutocraftmod.items.KawarimiNoJutsu;
import pl.grm.narutocraftmod.items.ShunshinNoJutsu;
import pl.grm.narutocraftmod.items.Sharingan;
import pl.grm.narutocraftmod.items.Rasengan;
import pl.grm.narutocraftmod.items.Rasengan2;
import pl.grm.narutocraftmod.items.Rasengan3;
import pl.grm.narutocraftmod.items.Kunai;
import pl.grm.narutocraftmod.items.Shuriken;
import pl.grm.narutocraftmod.items.WKunai;
import pl.grm.narutocraftmod.lib.ProxyCommon;
import pl.grm.narutocraftmod.lib.References;

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
    	
//		public static Item  = new (46);
    	
    	
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event) {
    	proxy.registerRenderInfomation();
    }
    
    /*EventHandler
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
    			
    }
}