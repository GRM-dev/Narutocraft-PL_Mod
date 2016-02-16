package pl.grmdev.narutocraft.player;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import pl.grmdev.narutocraft.ProxyCommon;
import pl.grmdev.narutocraft.handlers.JutsuManager;
import pl.grmdev.narutocraft.jutsu.IJutsu;

public class ExtendedProperties implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "NCPLExtPlayer";
	private final EntityPlayer player;
	/** Jutsu Manager Instance */
	private JutsuManager jManager = JutsuManager.instance;
	private NinjaAttributes ninAttrs = new NinjaAttributes();
	private NinjaStats ninStats = new NinjaStats();
	private static final int CHAKRA_WATCHER = 20;
	/** List of activated buff jutsus */
	public static List<int[]> activeJutsus = new ArrayList<int[]>();
	/** The list of all jutsu initialized by JutsuManager */
	public static Map<Integer, IJutsu> jutsuList;
	public boolean ninjaRun = false;

	public ExtendedProperties(EntityPlayer player) {
		this.player = player;
		this.player.getDataWatcher().addObject(CHAKRA_WATCHER, ninStats.getMaxChakra());
	}

	@Override
	public void init(Entity entity, World world) {}

	@Override
	public final void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		this.jManager.writeToNBT(properties);
		properties.setInteger("CurrentChakra", this.player.getDataWatcher().getWatchableObjectInt(CHAKRA_WATCHER));
		properties.setInteger("MaxChakra", ninStats.getMaxChakra());
		this.ninAttrs.writoToNBT(properties);
		this.ninStats.writoToNBT(properties);
		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public final void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.jManager.readFromNBT(properties);
		this.player.getDataWatcher().updateObject(CHAKRA_WATCHER, properties.getInteger("CurrentChakra"));
		ninStats.setMaxChakra(properties.getInteger("MaxChakra"));
		this.ninAttrs.readFromNBT(properties);
		this.ninStats.readFromNBT(properties);
	}

	public static final void loadProxyData(EntityPlayer player) {
		ExtendedProperties playerData = ExtendedProperties.get(player);
		NBTTagCompound savedData = ProxyCommon.getEntityData(getSaveKey(player));
		if (savedData != null) {
			playerData.loadNBTData(savedData);
		}
	}

	public static final void saveProxyData(EntityPlayer player) {
		NBTTagCompound savedData = new NBTTagCompound();
		ExtendedProperties.get(player).saveNBTData(savedData);
		ProxyCommon.storeEntityData(getSaveKey(player), savedData);
	}

	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(ExtendedProperties.EXT_PROP_NAME, new ExtendedProperties(player));
	}

	private static final String getSaveKey(EntityPlayer player) {
		return player.getCommandSenderEntity().getName() + ":" + EXT_PROP_NAME;
	}

	public void updateMoveSpeed() {
		PlayerCapabilities pc = player.capabilities;
		try {
			Field walkSpeed = PlayerCapabilities.class.getDeclaredField("walkSpeed");
			walkSpeed.setAccessible(true);
			walkSpeed.setFloat(pc, MathHelper.clamp_float(0.45F + ((float) ninAttrs.getAgility() / 31), 0.04f, 1.5f));
		}
		catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		catch (SecurityException e) {
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public void resetMoveSpeed() {
		PlayerCapabilities pc = player.capabilities;
		try {
			Field walkSpeed = PlayerCapabilities.class.getDeclaredField("walkSpeed");
			walkSpeed.setAccessible(true);
			walkSpeed.setFloat(pc, 0.1f);
		}
		catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		catch (SecurityException e) {
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Consumes chakra
	 *
	 * @param value
	 * @return sufficient
	 */
	public final boolean consumeChakra(int value) {
		boolean sufficient = value <= getCurrentChakra();
		setCurrentChakra(getCurrentChakra() - value);
		return sufficient;
	}

	/**
	 * Add amount of chakra to currentChakra.
	 *
	 * @param amount
	 */
	public final void regenChakra(int amount) {
		setCurrentChakra(getCurrentChakra() + amount);
	}

	/**
	 * Sets currentChakra to maxChakra.
	 */
	public final void replenishChakra() {
		this.player.getDataWatcher().updateObject(CHAKRA_WATCHER, ninStats.getMaxChakra());
	}

	public final int getCurrentChakra() {
		return this.player.getDataWatcher().getWatchableObjectInt(CHAKRA_WATCHER);
	}

	/**
	 * Sets current Chakra to value
	 * 
	 * @param value
	 */
	public final void setCurrentChakra(int value) {
		this.player.getDataWatcher().updateObject(CHAKRA_WATCHER,
				value > 0 ? (value < ninStats.getMaxChakra() ? value : ninStats.getMaxChakra()) : 0);
	}

	/**
	 * Sets the max chakra the player can have
	 * 
	 * @param amount
	 *            what number + maxChakraBonus the max chakra will be NOTE: only
	 *            works if overridden
	 * @param overrideBaseValue
	 *            this will use the amount if true, else it will only update the
	 *            baseChakra + bonus Chakra
	 **/
	public final void setMaxChakra(int amount, boolean overrideBaseValue) {
		if (overrideBaseValue) {
			ninStats.setMaxChakra(MathHelper.clamp_int(amount + ninStats.getChakraModifier(), 0,
					StatsSettings.maxChakraCap));
		} else {
			ninStats.setMaxChakra(MathHelper.clamp_int(StatsSettings.chakraBase + ninStats.getChakraModifier(), 0,
					StatsSettings.maxChakraCap));
		}
	}

	public JutsuManager getjManager() {
		return this.jManager;
	}

	public NinjaAttributes getNinAttrs() {
		return this.ninAttrs;
	}

	public NinjaStats getNinStats() {
		return this.ninStats;
	}

	/** Force set the maxChakra + bonus **/
	public final void setMaxChakra(int amount) {
		setMaxChakra(amount, true);
	}

	/** This is basically an update max chakra method **/
	public final void setMaxChakra(boolean overrideBaseValue) {
		setMaxChakra(0, false);
	}

	public static final ExtendedProperties get(EntityPlayer player) {
		return (ExtendedProperties) player.getExtendedProperties(EXT_PROP_NAME);
	}
}