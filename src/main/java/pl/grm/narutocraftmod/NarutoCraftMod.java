package pl.grm.narutocraftmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

import pl.grm.narutocraftmod.Libs.ProxyCommon;
import pl.grm.narutocraftmod.Libs.References;
import pl.grm.narutocraftmod.Libs.config.ConfigurationHandler;
import pl.grm.narutocraftmod.Libs.registry.RegEntities;
import pl.grm.narutocraftmod.Libs.registry.RegItems;
import pl.grm.narutocraftmod.Libs.registry.RegJutsus;
import pl.grm.narutocraftmod.Libs.registry.RegMobs;
import pl.grm.narutocraftmod.Libs.registry.RegRecipes;
import pl.grm.narutocraftmod.Network.PacketPipeline;
import pl.grm.narutocraftmod.handlers.KeyInputHandler;
import pl.grm.narutocraftmod.handlers.NCPLEventHandler;
import pl.grm.narutocraftmod.handlers.NCPLFMLEventHandler;

@Mod(modid = References.MODID, version = References.VERSION)
/**
 * Main class
 */
public class NarutoCraftMod {
	@SidedProxy(clientSide = References.Client, serverSide = References.Common)
	public static ProxyCommon proxy;
	private ConfigurationHandler config;
	public static final PacketPipeline packetPipeline = new PacketPipeline();
	/**
	 * Create Creative Tab named NarutoCraft Mod
	 */
	public static CreativeTabs mTabNarutoCraftMod = new TabClass(
			CreativeTabs.getNextID(), "NarutoCraftMod");
	/**
	 * Create mod instance
	 */
	@Instance(References.MODID)
	public static NarutoCraftMod instance;

	/**
	 * preInit
	 */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.registerRendering();
		config = new ConfigurationHandler(event.getSuggestedConfigurationFile());
		config.readConfig();
	}

	/**
	 * Init
	 */
	@EventHandler
	public void init(FMLInitializationEvent event) {
		RegEntities.RegEntitiesList();
		FMLCommonHandler.instance().bus().register(new KeyInputHandler());
		proxy.registerSound();
		packetPipeline.initialise();
	}

	/**
	 * Load
	 */
	@EventHandler
	public void load(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new NCPLEventHandler());
		FMLCommonHandler.instance().bus().register(new NCPLFMLEventHandler());
		packetPipeline.postInitialise();
		proxy.registerRenderInfomation();
		proxy.registerRenderThings();
		RegMobs.RegMobsList();
		NetworkRegistry.INSTANCE
				.registerGuiHandler(instance, new ProxyCommon());
	}

	/**
	 * Constructor to Registry Lists of mod elements
	 */
	public NarutoCraftMod() {
		RegItems.RegItemsList();
		RegJutsus.RegPowersList();
		RegRecipes.RegRecipesList();
	}
}
