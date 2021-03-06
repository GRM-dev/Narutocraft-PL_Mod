package pl.grmdev.narutocraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import pl.grmdev.narutocraft.creativetabs.*;
import pl.grmdev.narutocraft.handlers.*;
import pl.grmdev.narutocraft.libs.buffs.BuffList;
import pl.grmdev.narutocraft.libs.config.*;
import pl.grmdev.narutocraft.libs.network.*;
import pl.grmdev.narutocraft.registry.*;

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
	public static CreativeTabs mTabNarutoCraft = new NCMainTab(
			CreativeTabs.getNextID(), "NarutoCraftMod");
	/** Jutsu Creative Tab */
	public static CreativeTabs mTabJutsu = new NCJutsuTab(
			CreativeTabs.getNextID(), "NC Jutsu's");
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
		RegPotion.registerPotions();
	}

	/** preInit event */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		BuffList.Init();
		BuffList.Instantiate();

		netHandler = NetworkRegistry.INSTANCE.newSimpleChannel("ncplChannel");
		// Server Packets
		netHandler.registerMessage(PacketNinjaAttr.PacketNinjaAttrHandler.class,
				PacketNinjaAttr.class, this.packetId++, Side.SERVER);
		netHandler.registerMessage(PacketNinjaRun.PacketNinjaRunHandler.class,
				PacketNinjaRun.class, this.packetId++, Side.SERVER);
		// Client Side Packets
		netHandler.registerMessage(
				PacketNinjaAttrSync.PacketNinjaAttrSyncHandler.class,
				PacketNinjaAttrSync.class, this.packetId++, Side.CLIENT);
		
		netHandler.registerMessage(PacketKurosawaAttack.class, PacketKurosawaAttack.class, this.packetId++, Side.SERVER);
		
		config = new ConfigurationHandler(
				event.getSuggestedConfigurationFile());
		config.readConfig();
	}

	/** Init event */
	@EventHandler
	public void init(FMLInitializationEvent event) {
		RegEntities.RegEntitiesList();
		RegItems.regRenderers();
		RegBlocks.regRenderers();
		JutsuManager.regJutsusList();
		FMLCommonHandler.instance().bus().register(new KeyInputHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this,
				new ClientGuiHandler());
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
}
