package pl.grm.narutocraft.libs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.hud.JutsuInv;

public class ExtendedPlayer implements IExtendedEntityProperties {
	public final static String EXT_PROP_NAME = "ExtendedPlayer";
	private final EntityPlayer player;
	public final JutsuInv inventory = new JutsuInv();
	// public InventoryPlayer inventoryPanel;
	private int maxChakra; // chakraRegenTimer;
	public static final int CHAKRA_WATCHER = 20;

	public ExtendedPlayer(EntityPlayer player) {
		this.player = player;
		this.maxChakra = 50;
		// this.chakraRegenTimer = 0;
		this.player.getDataWatcher().addObject(CHAKRA_WATCHER, this.maxChakra);
	}

	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME,
				new ExtendedPlayer(player));
	}

	public static final ExtendedPlayer get(EntityPlayer player) {
		return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}

	@Override
	public final void saveNBTData(NBTTagCompound compound) {
		// inventoryPanel = new InventoryPlayer(player);
		NBTTagCompound properties = new NBTTagCompound();
		inventory.writeToNBT(properties);
		// NBTTagList props = new NBTTagList();
		// this.inventoryPanel.writeToNBT(props);
		properties.setInteger("CurrentChakra", player.getDataWatcher()
				.getWatchableObjectInt(CHAKRA_WATCHER));
		properties.setInteger("MaxChakra", maxChakra);
		// properties.setInteger("ChakraRegenTimer", chakraRegenTimer);
		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public final void loadNBTData(NBTTagCompound compound) {
		// inventoryPanel = new InventoryPlayer(player);
		NBTTagCompound properties = (NBTTagCompound) compound
				.getTag(EXT_PROP_NAME);
		inventory.readFromNBT(properties);
		// NBTTagList props = new NBTTagList();
		// this.inventoryPanel.readFromNBT(props);
		player.getDataWatcher().updateObject(CHAKRA_WATCHER,
				properties.getInteger("CurrentChakra"));
		maxChakra = properties.getInteger("MaxChakra");
		// chakraRegenTimer = properties.getInteger("ChakraRegenTimer");
		System.out.println("[TUT PROPS] Chakra from NBT: "
				+ player.getDataWatcher().getWatchableObjectInt(CHAKRA_WATCHER)
				+ "/" + this.maxChakra);
	}

	@Override
	public void init(Entity entity, World world) {
	}

	/*
	 * public void onUpdate() { if (!player.worldObj.isRemote) { if
	 * (updateChakraTimer()) { regenChakra(1); } } }
	 * 
	 * private boolean updateChakraTimer() { if (chakraRegenTimer > 0) {
	 * --chakraRegenTimer; } if (chakraRegenTimer == 0) { chakraRegenTimer =
	 * getCurrentChakra() < getMaxChakra() ? 100 : 0; return true; }
	 * 
	 * return false; }
	 */

	public final void regenChakra(int amount) {
		setCurrentChakra(getCurrentChakra() + amount);
	}

	public final boolean consumeChakra(int amount) {
		boolean sufficient = amount <= getCurrentChakra();
		setCurrentChakra(getCurrentChakra() - amount);
		return sufficient;
	}

	public final void replenishChakra() {
		this.player.getDataWatcher().updateObject(CHAKRA_WATCHER,
				this.maxChakra);
	}

	public final int getCurrentChakra() {
		return player.getDataWatcher().getWatchableObjectInt(CHAKRA_WATCHER);
	}
	public final void setCurrentChakra(int amount) {
		player.getDataWatcher().updateObject(CHAKRA_WATCHER,
				amount > 0 ? (amount < maxChakra ? amount : maxChakra) : 0);
	}
	public final int getMaxChakra() {
		return maxChakra;
	}

	public final void setMaxChakra(int amount) {
		maxChakra = (amount > 0 ? amount : 0);
		// NarutoCraftMod.packetPipeline.sendTo(new
		// SyncPlayerPropsPacket(player), (EntityPlayerMP) player);
	}

	private static final String getSaveKey(EntityPlayer player) {
		return player.getCommandSenderName() + ":" + EXT_PROP_NAME;
	}

	public static final void saveProxyData(EntityPlayer player) {
		NBTTagCompound savedData = new NBTTagCompound();
		ExtendedPlayer.get(player).saveNBTData(savedData);
		ProxyCommon.storeEntityData(getSaveKey(player), savedData);
	}

	public static final void loadProxyData(EntityPlayer player) {
		ExtendedPlayer playerData = ExtendedPlayer.get(player);
		NBTTagCompound savedData = ProxyCommon
				.getEntityData(getSaveKey(player));
		if (savedData != null) {
			playerData.loadNBTData(savedData);
		}
	}
}