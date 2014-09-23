package pl.grm.narutocraft;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import pl.grm.narutocraft.creativetabs.JutsuTab;
import pl.grm.narutocraft.creativetabs.NCPLMainTab;
import pl.grm.narutocraft.handlers.ClientGuiHandler;
import pl.grm.narutocraft.handlers.JutsuEventsHandler;
import pl.grm.narutocraft.handlers.KeyInputHandler;
import pl.grm.narutocraft.handlers.NCPLEventHandler;
import pl.grm.narutocraft.handlers.NCPLFMLEventHandler;
import pl.grm.narutocraft.jutsu.JutsuManager;
import pl.grm.narutocraft.libs.References;
import pl.grm.narutocraft.libs.config.ConfigurationHandler;
import pl.grm.narutocraft.network.PacketExample;
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
		version = References.VERSION)
/**
 * Main class
 */
public class NarutoCraft {
	@SidedProxy(
			clientSide = References.Client,
			serverSide = References.Common)
	public static ProxyCommon			proxy;
	public static ConfigurationHandler	config;
	/** Create mod instance */
	@Instance(References.MODID)
	public static NarutoCraft			instance;
	/** Packet Channel */
	public static SimpleNetworkWrapper	netHandler;
	private int							packetId		= 0;
	/** Create Creative Tabs named NarutoCraft Mod and Jutsu's */
	public static CreativeTabs			mTabNarutoCraft	= new NCPLMainTab(
																CreativeTabs.getNextID(),
																"NarutoCraftMod");
	public static CreativeTabs			mTabJutsu		= new JutsuTab(
																CreativeTabs.getNextID(),
																"NarutoCraftMod Jutsu's");
	
	/**
	 * Constructor to Registry Lists of mod elements
	 */
	public NarutoCraft() {
		RegMobs.regMobsList();
		RegBlocks.regBlocksList();
		RegItems.regItemsList();
		RegWeapons.regWeaponsList();
		RegArmor.regArmorList();
		JutsuManager.regJutsusList();
		RegRecipes.regRecipesList();
	}
	
	/** preInit */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Potion[] potionTypes = null;
		for (Field f : Potion.class.getDeclaredFields()) {
			f.setAccessible(true);
			try {
				if (f.getName().equals("potionTypes")
						|| f.getName().equals("field_76425_a")) {
					Field modfield = Field.class.getDeclaredField("modifiers");
					modfield.setAccessible(true);
					modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);
					
					potionTypes = (Potion[]) f.get(null);
					final Potion[] newPotionTypes = new Potion[256];
					System.arraycopy(potionTypes, 0, newPotionTypes, 0,
							potionTypes.length);
					f.set(null, newPotionTypes);
				}
			}
			catch (Exception e) {
				System.err.println("Severe error, please report this to the mod author:");
				System.err.println(e);
			}
		}
		
		netHandler = NetworkRegistry.INSTANCE.newSimpleChannel("ncplChannel");
		netHandler.registerMessage(PacketExample.PacketExampleHandler.class,
				PacketExample.class, this.packetId++, Side.SERVER);
		// Register Ninja Stat Handling packets
		netHandler.registerMessage(
				PacketNinjaStatsRequest.PacketNinjaStatsRequestHandler.class,
				PacketNinjaStatsRequest.class, this.packetId++, Side.SERVER);
		netHandler.registerMessage(
				PacketNinjaStatsResponse.PacketNinjaStatsResponseHandler.class,
				PacketNinjaStatsResponse.class, this.packetId++, Side.CLIENT);
		
		MinecraftForge.EVENT_BUS.register(new NCPLEventHandler());
		FMLCommonHandler.instance().bus().register(new NCPLFMLEventHandler());
		FMLCommonHandler.instance().bus().register(new JutsuEventsHandler());
		
		proxy.registerRendering();
		proxy.registerRenderInfomation();
		proxy.registerRenderThings();
		config = new ConfigurationHandler(event.getSuggestedConfigurationFile());
		config.readConfig();
	}
	
	/** Init */
	@EventHandler
	public void init(FMLInitializationEvent event) {
		RegEntities.RegEntitiesList();
		FMLCommonHandler.instance().bus().register(new KeyInputHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new ClientGuiHandler());
		proxy.registerSound();
	}
	
	/** Load */
	@EventHandler
	public void load(FMLPostInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new NCPLEventHandler());
		FMLCommonHandler.instance().bus().register(new NCPLFMLEventHandler());
		FMLCommonHandler.instance().bus().register(new JutsuEventsHandler());
		proxy.registerRenderInfomation();
		proxy.registerRenderThings();
		proxy.registerCommands();
	}
}
