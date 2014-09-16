package pl.grm.narutocraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import pl.grm.narutocraft.blocks.ByoinBlock;
import pl.grm.narutocraft.blocks.Shoji;
import pl.grm.narutocraft.blocks.Tatami;
import pl.grm.narutocraft.creativetabs.JutsuTab;
import pl.grm.narutocraft.creativetabs.NCPLCreativeTab;
import pl.grm.narutocraft.handlers.ClientGuiHandler;
import pl.grm.narutocraft.handlers.JutsuEventsHandler;
import pl.grm.narutocraft.handlers.KeyInputHandler;
import pl.grm.narutocraft.handlers.NCPLEventHandler;
import pl.grm.narutocraft.handlers.NCPLFMLEventHandler;
import pl.grm.narutocraft.libs.ProxyCommon;
import pl.grm.narutocraft.libs.References;
import pl.grm.narutocraft.libs.config.ConfigurationHandler;
import pl.grm.narutocraft.libs.registry.RegEntities;
import pl.grm.narutocraft.libs.registry.RegItems;
import pl.grm.narutocraft.libs.registry.RegJutsus;
import pl.grm.narutocraft.libs.registry.RegMobs;
import pl.grm.narutocraft.libs.registry.RegRecipes;
import pl.grm.narutocraft.network.PacketExample;
import pl.grm.narutocraft.network.PacketNinjaStatsRequest;
import pl.grm.narutocraft.network.PacketNinjaStatsResponse;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = References.MODID, version = References.VERSION)
/**
 * Main class
 */
public class NarutoCraft {
	@SidedProxy(clientSide = References.Client, serverSide = References.Common)
	public static ProxyCommon proxy;
	public static ConfigurationHandler config;
	/** Create Creative Tabs named NarutoCraft Mod and Jutsu's */
	public static CreativeTabs mTabNarutoCraft = new NCPLCreativeTab(
			CreativeTabs.getNextID(), "NarutoCraftMod");
	public static CreativeTabs mTabJutsu = new JutsuTab(
			CreativeTabs.getNextID(), "NarutoCraftMod Jutsu's");
	/** Reg Blocks */
	public static Block byoinBlock;
	public static Block shoji;
	public static Block tatami;

	/** Create mod instance */
	@Instance(References.MODID)
	public static NarutoCraft instance;

	/** Packet Channel */
	public static SimpleNetworkWrapper netHandler;
	private int packetId = 0;

	/** preInit */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		netHandler = NetworkRegistry.INSTANCE.newSimpleChannel("ncplChannel");

		netHandler.registerMessage(PacketExample.PacketExampleHandler.class,
				PacketExample.class, packetId++, Side.SERVER);
		// Register Ninja Stat Handling packets
		netHandler.registerMessage(
				PacketNinjaStatsRequest.PacketNinjaStatsRequestHandler.class,
				PacketNinjaStatsRequest.class, packetId++, Side.SERVER);
		netHandler.registerMessage(
				PacketNinjaStatsResponse.PacketNinjaStatsResponseHandler.class,
				PacketNinjaStatsResponse.class, packetId++, Side.CLIENT);

		proxy.registerRendering();
		config = new ConfigurationHandler(event.getSuggestedConfigurationFile());
		config.readConfig();
	}

	/** Init */
	@EventHandler
	public void init(FMLInitializationEvent event) {
		RegEntities.RegEntitiesList();
		FMLCommonHandler.instance().bus().register(new KeyInputHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this,
				new ClientGuiHandler());
		proxy.registerSound();
	}

	/** Load */
	@EventHandler
	public void load(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new NCPLEventHandler());
		FMLCommonHandler.instance().bus().register(new NCPLFMLEventHandler());
		FMLCommonHandler.instance().bus().register(new JutsuEventsHandler());
		proxy.registerRenderInfomation();
		proxy.registerRenderThings();
		RegMobs.RegMobsList();
	}

	/**
	 * Constructor to Registry Lists of mod elements
	 */
	public NarutoCraft() {
		byoinBlock = new ByoinBlock();
		shoji = new Shoji(References.ModTexturePath+"shoji", References.ModTexturePath+"shoji_top", Material.wood, false)
			.setBlockName("shoji")
			.setCreativeTab(mTabNarutoCraft);
		tatami = new Tatami().setBlockName("tatami").setBlockTextureName(References.ModTexturePath+"tatami").setCreativeTab(mTabNarutoCraft);
		
		GameRegistry.registerBlock(byoinBlock, byoinBlock.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerBlock(shoji, shoji.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerBlock(tatami, tatami.getUnlocalizedName()
				.substring(5));
		RegItems.RegItemsList();
		RegJutsus.RegPowersList();
		RegRecipes.RegRecipesList();
	}
}
