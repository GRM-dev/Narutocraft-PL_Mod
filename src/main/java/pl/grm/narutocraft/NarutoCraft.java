package pl.grm.narutocraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import pl.grm.narutocraft.creativetabs.NCJutsuTab;
import pl.grm.narutocraft.creativetabs.NCMainTab;
import pl.grm.narutocraft.handlers.ClientGuiHandler;
import pl.grm.narutocraft.handlers.JutsuEventsHandler;
import pl.grm.narutocraft.handlers.JutsuManager;
import pl.grm.narutocraft.handlers.KeyInputHandler;
import pl.grm.narutocraft.handlers.NCEventHandler;
import pl.grm.narutocraft.handlers.NCFMLEventHandler;
import pl.grm.narutocraft.libs.buffs.BuffList;
import pl.grm.narutocraft.libs.config.ConfigurationHandler;
import pl.grm.narutocraft.libs.config.References;
import pl.grm.narutocraft.libs.network.PacketNinjaAttr;
import pl.grm.narutocraft.libs.network.PacketNinjaAttrSync;
import pl.grm.narutocraft.libs.network.PacketNinjaRun;
import pl.grm.narutocraft.registry.RegArmor;
import pl.grm.narutocraft.registry.RegBlocks;
import pl.grm.narutocraft.registry.RegEntities;
import pl.grm.narutocraft.registry.RegItems;
import pl.grm.narutocraft.registry.RegMobs;
import pl.grm.narutocraft.registry.RegRecipes;
import pl.grm.narutocraft.registry.RegWeapons;

@Mod(modid = References.MODID, version = References.VERSION, name = References.NAME)
/**
 * Main class of Mod
 */
public class NarutoCraft {

	@SidedProxy(clientSide = References.Client, serverSide = References.Common)
	/** Proxy */
	public static ProxyCommon proxy;
	/** Config Handler */
	public static ConfigurationHandler config;
	/** Create mod instance */
	@Instance(References.MODID)
	public static NarutoCraft instance;
	/** Packet Channel */
	public static SimpleNetworkWrapper netHandler;
	/** NarutoCraft Mod Creative Tab */
	public static CreativeTabs mTabNarutoCraft = new NCMainTab(CreativeTabs.getNextID(), "NarutoCraftMod");
	/** Jutsu Creative Tab */
	public static CreativeTabs mTabJutsu = new NCJutsuTab(CreativeTabs.getNextID(), "NC Jutsu's");
	private int packetId = 0;

	/**
	 * Constructor to Registry Lists of mod elements
	 */
	public NarutoCraft() {
		RegMobs.regMobsList();
		RegBlocks.regBlocksList();
		RegItems.regItemsList();
		RegWeapons.regWeaponsList();
		RegArmor.regArmorList();
		RegRecipes.regRecipesList();
		JutsuManager.regJutsusList();
	}

	/** Init event */
	@EventHandler
	public void init(FMLInitializationEvent event) {
		RegEntities.RegEntitiesList();
		RegItems.regRenderers();
		RegBlocks.regRenderers();
		FMLCommonHandler.instance().bus().register(new KeyInputHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new ClientGuiHandler());
		proxy.registerSound();
	}

	/** Load event */
	@EventHandler
	public void load(FMLPostInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new NCEventHandler());
		FMLCommonHandler.instance().bus().register(new NCFMLEventHandler());
		FMLCommonHandler.instance().bus().register(new JutsuEventsHandler());
		proxy.registerRenderInfomation();
		proxy.registerRenderThings();
		proxy.registerCommands();
	}

	/** preInit event */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		BuffList.Init();
		BuffList.Instantiate();

		netHandler = NetworkRegistry.INSTANCE.newSimpleChannel("ncplChannel");
		// Server Packets
		netHandler.registerMessage(PacketNinjaAttr.PacketNinjaAttrHandler.class, PacketNinjaAttr.class,
				this.packetId++, Side.SERVER);
		netHandler.registerMessage(PacketNinjaRun.PacketNinjaRunHandler.class, PacketNinjaRun.class, this.packetId++,
				Side.SERVER);
		// Client Side Packets
		netHandler.registerMessage(PacketNinjaAttrSync.PacketNinjaAttrSyncHandler.class, PacketNinjaAttrSync.class,
				this.packetId++, Side.CLIENT);

		config = new ConfigurationHandler(event.getSuggestedConfigurationFile());
		config.readConfig();
	}
}
