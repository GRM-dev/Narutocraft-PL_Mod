package pl.grm.narutocraft.libs;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import pl.grm.narutocraft.effects.IEffect;
import pl.grm.narutocraft.gui.JutsuInv;
import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.jutsu.Jutsu;
import pl.grm.narutocraft.network.DataWriter;

public class ExtendedProperties implements IExtendedEntityProperties {
	public final static String EXT_PROP_NAME = "NCPLExtPlayer";
	private final EntityPlayer player;
	public final JutsuInv inventory = new JutsuInv();
	public final Jutsu jutsu = new Jutsu();
	// public InventoryPlayer inventoryPanel;
	private int maxChakra;
	private int AuraIndex;
	private int AuraBehaviour;
	private float AuraScale;
	private float AuraAlpha;
	private boolean AuraColorRandomize = true;
	private boolean AuraColorDefault = true;
	private int AuraColor;
	private int AuraQuantity;
	private float AuraSpeed;
	public float TK_Distance = 8.0F;
	public static int[] activeJutsuArray;
	public static int[] activeEffectArray;
	public static int[] effectRemainingDurations;
	public static final int CHAKRA_WATCHER = 20;
	public static Map<IJutsu, IEffect> activeEffects = new HashMap<IJutsu, IEffect>();

	public ExtendedProperties(EntityPlayer player) {
		this.player = player;
		this.maxChakra = 50;
		this.player.getDataWatcher().addObject(CHAKRA_WATCHER, this.maxChakra);
	}

	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(ExtendedProperties.EXT_PROP_NAME,
				new ExtendedProperties(player));
	}

	public static final ExtendedProperties get(EntityPlayer player) {
		return (ExtendedProperties) player.getExtendedProperties(EXT_PROP_NAME);
	}

	@Override
	public final void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();

		inventory.writeToNBT(properties);
		jutsu.writeToNBT(properties);

		properties.setInteger("CurrentChakra", player.getDataWatcher()
				.getWatchableObjectInt(CHAKRA_WATCHER));
		properties.setInteger("MaxChakra", maxChakra);

		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public final void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound
				.getTag(EXT_PROP_NAME);

		inventory.readFromNBT(properties);
		jutsu.readFromNBT(properties);

		player.getDataWatcher().updateObject(CHAKRA_WATCHER,
				properties.getInteger("CurrentChakra"));
		maxChakra = properties.getInteger("MaxChakra");

		System.out.println("bgh: " + activeEffectArray[0]);

		System.out.println("[NCPL Chakra] Chakra from NBT: "
				+ player.getDataWatcher().getWatchableObjectInt(CHAKRA_WATCHER)
				+ "/" + this.maxChakra);
	}

	@Override
	public void init(Entity entity, World world) {

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
	 * Sets currentChakra to maxChakra.
	 */
	public final void replenishChakra() {
		this.player.getDataWatcher().updateObject(CHAKRA_WATCHER,
				this.maxChakra);
	}

	public final int getCurrentChakra() {
		return player.getDataWatcher().getWatchableObjectInt(CHAKRA_WATCHER);
	}

	public final void setCurrentChakra(int value) {
		player.getDataWatcher().updateObject(CHAKRA_WATCHER,
				value > 0 ? (value < maxChakra ? value : maxChakra) : 0);
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
		ExtendedProperties.get(player).saveNBTData(savedData);
		ProxyCommon.storeEntityData(getSaveKey(player), savedData);
	}

	public static final void loadProxyData(EntityPlayer player) {
		ExtendedProperties playerData = ExtendedProperties.get(player);
		NBTTagCompound savedData = ProxyCommon
				.getEntityData(getSaveKey(player));
		if (savedData != null) {
			playerData.loadNBTData(savedData);
		}
	}

	public static ExtendedProperties For(EntityLivingBase living) {
		return (ExtendedProperties) living
				.getExtendedProperties("NarutoCraftExProps");
	}

	public void updateAuraData(int index, int behaviour, float scale,
			float alpha, boolean randomColor, boolean defaultColor, int color,
			int delay, int quantity, float speed) {
		this.AuraIndex = index;
		this.AuraBehaviour = behaviour;
		this.AuraScale = scale;
		this.AuraAlpha = alpha;
		this.AuraColorRandomize = randomColor;
		this.AuraColorDefault = defaultColor;
		this.AuraColor = color;
		this.AuraQuantity = quantity;
		this.AuraSpeed = speed;

	}

	public byte[] getAuraData() {
		DataWriter writer = new DataWriter();
		writer.add(this.AuraIndex);
		writer.add(this.AuraBehaviour);
		writer.add(this.AuraScale);
		writer.add(this.AuraAlpha);
		writer.add(this.AuraColorRandomize);
		writer.add(this.AuraColorDefault);
		writer.add(this.AuraColor);
		writer.add(this.AuraQuantity);
		writer.add(this.AuraSpeed);

		return writer.generate();
	}
}