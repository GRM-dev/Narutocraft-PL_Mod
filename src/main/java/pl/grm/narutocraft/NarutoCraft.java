package pl.grm.narutocraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import pl.grm.narutocraft.handlers.GuiHandler;
import pl.grm.narutocraft.handlers.KeyInputHandler;
import pl.grm.narutocraft.handlers.NCPLEventHandler;
import pl.grm.narutocraft.handlers.NCPLFMLEventHandler;
import pl.grm.narutocraft.libs.PacketExample;
import pl.grm.narutocraft.libs.ProxyCommon;
import pl.grm.narutocraft.libs.References;
import pl.grm.narutocraft.libs.config.ConfigurationHandler;
import pl.grm.narutocraft.libs.registry.RegEntities;
import pl.grm.narutocraft.libs.registry.RegItems;
import pl.grm.narutocraft.libs.registry.RegJutsus;
import pl.grm.narutocraft.libs.registry.RegMobs;
import pl.grm.narutocraft.libs.registry.RegRecipes;
import pl.grm.narutocraft.network.PacketPipeline;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = References.MODID, version = References.VERSION)
/**
 * Main class
 */
public class NarutoCraft {
	@SidedProxy(clientSide = References.Client, serverSide = References.Common)
	public static ProxyCommon proxy;
	private ConfigurationHandler config;
	public static final PacketPipeline packetPipeline = new PacketPipeline();
	/**
	 * Create Creative Tab named NarutoCraft Mod
	 */
	public static CreativeTabs mTabNarutoCraftMod = new NCPLCreativeTab(
			CreativeTabs.getNextID(), "NarutoCraftMod");
	/**
	 * Create mod instance
	 */
	@Instance(References.MODID)
	public static NarutoCraft instance;
	
	//Packet Channel
	public static SimpleNetworkWrapper netHandler;
	private int packetId = 0;
	

	/**
	 * preInit
	 */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		netHandler = NetworkRegistry.INSTANCE.newSimpleChannel("ncplChannel");
		
		netHandler.registerMessage(PacketExample.PacketExampleHandler.class, PacketExample.class, packetId++, Side.SERVER);
		
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
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
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
	public NarutoCraft() {
		RegItems.RegItemsList();
		RegJutsus.RegPowersList();
		RegRecipes.RegRecipesList();
	}
}
