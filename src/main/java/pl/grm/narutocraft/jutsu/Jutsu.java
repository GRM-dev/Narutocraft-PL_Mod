package pl.grm.narutocraft.jutsu;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.libs.config.References;
import pl.grm.narutocraft.player.ExtendedProperties;

public abstract class Jutsu extends Item implements IJutsu {

	public static String textureLoc = References.JutsuTexturePath;
	private CreativeTabs tabToDisplayOn = NarutoCraft.mTabJutsu;
	protected int maxDamage;
	protected int chackraOnActivation;
	protected JutsuProperties jutsuProps;
	protected JutsuParams jutsuParams;
	protected ItemStack stack;
	protected World world;
	protected EntityPlayer player;

	public Jutsu(JutsuParams jutsuParams) {
		this.jutsuParams = jutsuParams;
		this.jutsuProps = new JutsuProperties(jutsuParams.getJutsuID(), this.jutsuParams.getName(), 0,
				this.jutsuParams.getDuration(), this.jutsuParams.getChakraConsumption(), false);
	}

	@Override
	public void onJutsuActivation() {
		this.setActive(true);
		consumeChackra(player, chackraOnActivation);
	}

	public JutsuProperties getJutsuProps() {
		return this.jutsuProps;
	}

	public boolean consumeChackra(EntityPlayer player, int value) {
		ExtendedProperties props = ExtendedProperties.get(player);
		if (props.getCurrentChakra() < this.jutsuProps.getChakraConsumption()) {
			setActive(false);
			return false;
		}
		ExtendedProperties.get(player).consumeChakra(value);
		return true;
	}

	/**
	 * Check if Jutsu is Active
	 *
	 * @return true if Jutsu is activated.
	 */
	public boolean isActive() {
		return this.jutsuProps.isActivated();
	}

	@Override
	public void onJutsuUpdate() {
		jutsuProps.setPassDuration(this.jutsuProps.getPassDuration() + 1);
		if (this.jutsuProps.getPassDuration() > this.jutsuProps.getTotalDuration()) {
			this.onJutsuEnd();
		}
	}

	@Override
	public void onJutsuEnd() {
		this.setActive(false);
	}

	public int getChackraOnActivation() {
		return this.chackraOnActivation;
	}

	public void setChackraOnActivation(int chackraOnActivation) {
		this.chackraOnActivation = chackraOnActivation;
	}

	@Override
	public boolean canItemEditBlocks() {
		return false;
	}

	public long getChackraConsumption() {
		return this.jutsuProps.getChakraConsumption();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTab() {
		return this.tabToDisplayOn;
	}

	@Override
	public int getEntityLifespan(ItemStack itemStack, World world) {
		return 6000;
	}

	@Override
	public int getMaxDamage() {
		return this.maxDamage;
	}

	public long getTotalDuration() {
		return this.jutsuProps.getTotalDuration();
	}

	@Override
	public String getUnlocalizedName() {
		return "item." + this.jutsuProps.getUnlocalizedName();
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return "item." + this.jutsuProps.getUnlocalizedName();
	}

	@Override
	public String getUnlocalizedNameInefficiently(ItemStack par1ItemStack) {
		String s = this.getUnlocalizedName(par1ItemStack);
		return s == null ? "" : StatCollector.translateToLocal(s);
	}

	@Override
	public boolean isDamageable() {
		return false;
	}

	@Override
	public boolean isDamaged(ItemStack stack) {
		return false;
	}

	@Override
	public boolean isItemTool(ItemStack par1ItemStack) {
		return false;
	}

	@Override
	public boolean isPotionIngredient(ItemStack p_150892_1_) {
		return false;
	}

	@Override
	public boolean isRepairable() {
		return false;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		this.stack = par1ItemStack;
		this.world = par2World;
		this.player = par3EntityPlayer;

		if (!this.world.isRemote) {
			this.onJutsuActivation();
		}
		return this.stack;
	}

	public void setActive(boolean activated) {
		this.jutsuProps.setActivated(activated);
	}

	@Override
	public Item setCreativeTab(CreativeTabs par1CreativeTabs) {
		this.tabToDisplayOn = par1CreativeTabs;
		return this;
	}
}
