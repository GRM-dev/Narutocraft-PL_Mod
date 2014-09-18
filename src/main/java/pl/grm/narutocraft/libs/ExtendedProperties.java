package pl.grm.narutocraft.libs;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import pl.grm.narutocraft.ProxyCommon;
import pl.grm.narutocraft.gui.JutsuInv;
import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.jutsu.Jutsu;
import pl.grm.narutocraft.network.DataWriter;

public class ExtendedProperties implements IExtendedEntityProperties {
	public static ExtendedProperties For(EntityLivingBase living) {
		return (ExtendedProperties) living
				.getExtendedProperties("NarutoCraftExProps");
	}
	public static final ExtendedProperties get(EntityPlayer player) {
		return (ExtendedProperties) player.getExtendedProperties(EXT_PROP_NAME);
	}
	private static final String getSaveKey(EntityPlayer player) {
		return player.getCommandSenderName() + ":" + EXT_PROP_NAME;
	}
	public static final void loadProxyData(EntityPlayer player) {
		ExtendedProperties playerData = ExtendedProperties.get(player);
		NBTTagCompound savedData = ProxyCommon
				.getEntityData(getSaveKey(player));
		if (savedData != null) {
			playerData.loadNBTData(savedData);
		}
	}
	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(ExtendedProperties.EXT_PROP_NAME,
				new ExtendedProperties(player));
	}
	public static final void saveProxyData(EntityPlayer player) {
		NBTTagCompound savedData = new NBTTagCompound();
		ExtendedProperties.get(player).saveNBTData(savedData);
		ProxyCommon.storeEntityData(getSaveKey(player), savedData);
	}
	public final static String EXT_PROP_NAME = "NCPLExtPlayer";
	private final EntityPlayer player;
	public final JutsuInv inventory = new JutsuInv();
	public IJutsu jutsu = new Jutsu();
	public PlayerSkillsAtrributes psa = new PlayerSkillsAtrributes();
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

	public static final int CHAKRA_WATCHER = 20;

	public static List<int[]> activeJutsus = new ArrayList<int[]>();

	public ExtendedProperties(EntityPlayer player) {
		this.player = player;
		this.maxChakra = 50;
		this.player.getDataWatcher().addObject(CHAKRA_WATCHER, this.maxChakra);
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

	public final int getCurrentChakra() {
		return this.player.getDataWatcher().getWatchableObjectInt(
				CHAKRA_WATCHER);
	}

	public final int getMaxChakra() {
		return this.maxChakra;
	}

	@Override
	public void init(Entity entity, World world) {

	}

	@Override
	public final void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound
				.getTag(EXT_PROP_NAME);

		this.inventory.readFromNBT(properties);
		this.jutsu.readFromNBT(properties);

		this.player.getDataWatcher().updateObject(CHAKRA_WATCHER,
				properties.getInteger("CurrentChakra"));
		this.maxChakra = properties.getInteger("MaxChakra");

		/*
		 * NBTTagList stats = properties .getTagList("psaStats",
		 * properties.getId()); int[] statList = new int[stats.tagCount()]; for
		 * (int i = 0; i < stats.tagCount(); ++i) { NBTTagCompound stat =
		 * stats.getCompoundTagAt(i); statList[i] = stat.getInteger("psaStat" +
		 * i); }
		 */
		// New PSA loading
		this.psa.setValues(properties.getIntArray("psaStats"));

		System.out.println("[NCPL Chakra] Chakra from NBT: "
				+ this.player.getDataWatcher().getWatchableObjectInt(
						CHAKRA_WATCHER) + "/" + this.maxChakra);
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
		this.player.getDataWatcher().updateObject(CHAKRA_WATCHER,
				this.maxChakra);
	}

	@Override
	public final void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();

		this.inventory.writeToNBT(properties);
		this.jutsu.writeToNBT(properties);

		properties.setInteger("CurrentChakra", this.player.getDataWatcher()
				.getWatchableObjectInt(CHAKRA_WATCHER));
		properties.setInteger("MaxChakra", this.maxChakra);

		// New PSA data saving
		properties.setIntArray("psaStats", this.psa.getValues());
		// Save stats
		/*
		 * NBTTagList stats = new NBTTagList();
		 *
		 * for (int i = 0; i < psa.getValues().length; ++i) { NBTTagCompound
		 * stat = new NBTTagCompound(); stat.setInteger("psaStat" + i,
		 * psa.getValues()[i]); stats.appendTag(stat); }
		 * properties.setTag("psaStats", stats);
		 */
		compound.setTag(EXT_PROP_NAME, properties);
	}

	public final void setCurrentChakra(int value) {
		this.player.getDataWatcher().updateObject(
				CHAKRA_WATCHER,
				value > 0
						? (value < this.maxChakra ? value : this.maxChakra)
						: 0);
	}

	public final void setMaxChakra(int amount) {
		this.maxChakra = (amount > 0 ? amount : 0);
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
}