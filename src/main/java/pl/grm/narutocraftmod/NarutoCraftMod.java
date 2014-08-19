package pl.grm.narutocraftmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import pl.grm.narutocraftmod.Handlers.KeyInputHandler;
import pl.grm.narutocraftmod.Handlers.NCPLEventHandler;
import pl.grm.narutocraftmod.Handlers.NCPLFMLEventHandler;
import pl.grm.narutocraftmod.Libs.KeyBindings;
import pl.grm.narutocraftmod.Libs.ProxyCommon;
import pl.grm.narutocraftmod.Libs.References;
import pl.grm.narutocraftmod.Libs.Config.ConfigurationHandler;
import pl.grm.narutocraftmod.Libs.Registry.RegEntities;
import pl.grm.narutocraftmod.Libs.Registry.RegItems;
import pl.grm.narutocraftmod.Libs.Registry.RegMobs;
import pl.grm.narutocraftmod.Libs.Registry.RegPowers;
import pl.grm.narutocraftmod.Libs.Registry.RegRecipes;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = References.MODID, version = References.VERSION)
public class NarutoCraftMod {
	@SidedProxy(clientSide = References.Client, serverSide = References.Common)
	public static ProxyCommon proxy;

	public static CreativeTabs mTabNarutoCraftMod = new TabClass(
			CreativeTabs.getNextID(), "NarutoCraftMod");

	@Instance(References.MODID)
	public static NarutoCraftMod instance;

	private ConfigurationHandler config;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.registerRendering();
		config = new ConfigurationHandler(event.getSuggestedConfigurationFile());
		config.readConfig();

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		RegEntities.RegEntitiesList();
		FMLCommonHandler.instance().bus().register(new KeyInputHandler());
		proxy.registerSound();

	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new NCPLEventHandler());
		FMLCommonHandler.instance().bus().register(new NCPLFMLEventHandler());
		proxy.registerRenderInfomation();
		proxy.registerRenderThings();
		RegMobs.RegMobsList();
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new ProxyCommon());

	}

	public NarutoCraftMod() {
		RegItems.RegItemsList();
		RegPowers.RegPowersList();
		RegRecipes.RegRecipesList();

	}
}
