package pl.grm.narutocraft;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import pl.grm.narutocraft.creativetabs.NCJutsuTab;
import pl.grm.narutocraft.creativetabs.NCMainTab;
import pl.grm.narutocraft.handlers.ClientGuiHandler;
import pl.grm.narutocraft.handlers.JutsuEventsHandler;
import pl.grm.narutocraft.handlers.JutsuManager;
import pl.grm.narutocraft.handlers.KeyInputHandler;
import pl.grm.narutocraft.handlers.NCEventHandler;
import pl.grm.narutocraft.handlers.NCFMLEventHandler;
import pl.grm.narutocraft.libs.References;
import pl.grm.narutocraft.libs.config.ConfigurationHandler;
import pl.grm.narutocraft.network.PacketExample;
import pl.grm.narutocraft.network.PacketNinjaRun;
import pl.grm.narutocraft.network.PacketNinjaStatsRequest;
import pl.grm.narutocraft.network.PacketNinjaStatsResponse;
import pl.grm.narutocraft.registry.RegArmor;
import pl.grm.narutocraft.registry.RegBlocks;
import pl.grm.narutocraft.registry.RegEntities;
import pl.grm.narutocraft.registry.RegItems;
import pl.grm.narutocraft.registry.RegMobs;
import pl.grm.narutocraft.registry.RegRecipes;
import pl.grm.narutocraft.registry.RegWeapons;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

@Mod(
		modid = References.MODID,
		version = References.VERSION,
		name = References.NAME)
/**
 * Main class of mod
 */
public class NarutoCraft {
	@SidedProxy(
			clientSide = References.Client,
			serverSide = References.Common)
	/** Proxy */
	public static ProxyCommon			proxy;
	/** Config Handler */
	public static ConfigurationHandler	config;
	/** Create mod instance */
	@Instance(References.MODID)
	public static NarutoCraft			instance;
	/** Packet Channel */
	public static SimpleNetworkWrapper	netHandler;
	private int							packetId		= 0;
	/** NarutoCraft Mod Creative Tab */
	public static CreativeTabs			mTabNarutoCraft	= new NCMainTab(CreativeTabs.getNextID(),
																"NarutoCraftMod");
	/** Jutsu Creative Tab */
	public static CreativeTabs			mTabJutsu		= new NCJutsuTab(CreativeTabs.getNextID(),
																"NC Jutsu's");
	
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
	
	/** preInit event */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Potion[] potionTypes = null;
		for (Field f : Potion.class.getDeclaredFields()) {
			f.setAccessible(true);
			try {
				if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
					Field modfield = Field.class.getDeclaredField("modifiers");
					modfield.setAccessible(true);
					modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);
					potionTypes = (Potion[]) f.get(null);
					final Potion[] newPotionTypes = new Potion[256];
					System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
					f.set(null, newPotionTypes);
				}
			}
			catch (Exception e) {
				System.err.println("Severe error, please report this to the mod author:");
				System.err.println(e);
			}
		}
		
		netHandler = NetworkRegistry.INSTANCE.newSimpleChannel("ncplChannel");
		netHandler.registerMessage(PacketExample.PacketExampleHandler.class, PacketExample.class,
				this.packetId++, Side.SERVER);
		netHandler.registerMessage(PacketNinjaStatsRequest.PacketNinjaStatsRequestHandler.class,
				PacketNinjaStatsRequest.class, this.packetId++, Side.SERVER);
		netHandler.registerMessage(PacketNinjaRun.PacketNinjaRunHandler.class,
				PacketNinjaRun.class, this.packetId++, Side.SERVER);
		netHandler.registerMessage(PacketNinjaStatsResponse.PacketNinjaStatsResponseHandler.class,
				PacketNinjaStatsResponse.class, this.packetId++, Side.CLIENT);
		
		config = new ConfigurationHandler(event.getSuggestedConfigurationFile());
		config.readConfig();
	}
	
	/** Init event */
	@EventHandler
	public void init(FMLInitializationEvent event) {
		RegEntities.RegEntitiesList();
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
}
