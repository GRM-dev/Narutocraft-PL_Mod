package pl.grm.narutocraft.jutsu;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.libs.config.References;
import pl.grm.narutocraft.player.ExtendedProperties;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class Jutsu extends Item implements IJutsu {
	public static String		textureLoc		= References.JutsuTexturePath;
	private CreativeTabs		tabToDisplayOn	= NarutoCraft.mTabJutsu;
	protected int				maxDamage;
	protected int				chackraOnActivation;
	protected JutsuProperties	jutsuProps;
	protected JutsuParams			jutsuParams;
	protected ItemStack			stack;
	protected World				world;
	protected EntityPlayer		player;
	
	public Jutsu(JutsuParams jutsuParams) {
		this.jutsuParams = jutsuParams;
		this.jutsuProps = new JutsuProperties(jutsuParams.getJutsuID(), this.jutsuParams.getName(),
				0, this.jutsuParams.getDuration(), this.jutsuParams.getChakraConsumption(), false);
		this.setTextureName(textureLoc + this.jutsuParams.getName());
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
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
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
	
	@Override
	protected MovingObjectPosition getMovingObjectPositionFromPlayer(World par1World,
			EntityPlayer par2EntityPlayer, boolean par3) {
		float f = 1.0F;
		float f1 = par2EntityPlayer.prevRotationPitch
				+ ((par2EntityPlayer.rotationPitch - par2EntityPlayer.prevRotationPitch) * f);
		float f2 = par2EntityPlayer.prevRotationYaw
				+ ((par2EntityPlayer.rotationYaw - par2EntityPlayer.prevRotationYaw) * f);
		double d0 = par2EntityPlayer.prevPosX
				+ ((par2EntityPlayer.posX - par2EntityPlayer.prevPosX) * f);
		double d1 = par2EntityPlayer.prevPosY
				+ ((par2EntityPlayer.posY - par2EntityPlayer.prevPosY) * f)
				+ (par1World.isRemote ? par2EntityPlayer.getEyeHeight()
						- par2EntityPlayer.getDefaultEyeHeight() : par2EntityPlayer.getEyeHeight());
		// isRemote check to revert changes to ray trace position due to adding
		// the eyeheight clientside and player yOffset differences
		double d2 = par2EntityPlayer.prevPosZ
				+ ((par2EntityPlayer.posZ - par2EntityPlayer.prevPosZ) * f);
		@SuppressWarnings("deprecation")
		Vec3 vec3 = par1World.getWorldVec3Pool().getVecFromPool(d0, d1, d2);
		float f3 = MathHelper.cos((-f2 * 0.017453292F) - (float) Math.PI);
		float f4 = MathHelper.sin((-f2 * 0.017453292F) - (float) Math.PI);
		float f5 = -MathHelper.cos(-f1 * 0.017453292F);
		float f6 = MathHelper.sin(-f1 * 0.017453292F);
		float f7 = f4 * f5;
		float f8 = f3 * f5;
		double d3 = 5.0D;
		if (par2EntityPlayer instanceof EntityPlayerMP) {
			d3 = ((EntityPlayerMP) par2EntityPlayer).theItemInWorldManager.getBlockReachDistance();
		}
		Vec3 vec31 = vec3.addVector(f7 * d3, f6 * d3, f8 * d3);
		return par1World.func_147447_a(vec3, vec31, par3, !par3, false);
	}
}
