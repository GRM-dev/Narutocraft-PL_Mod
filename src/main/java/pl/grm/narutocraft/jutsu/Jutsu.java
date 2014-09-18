package pl.grm.narutocraft.jutsu;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.RegistryNamespaced;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.libs.ExtendedProperties;
import pl.grm.narutocraft.libs.References;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Jutsu extends Item implements IJutsu {
	public static String jutsuLoc = References.jutsuLoc;
	private static final RegistryNamespaced itemRegistry = GameData
			.getItemRegistry();
	private CreativeTabs tabToDisplayOn = NarutoCraft.mTabJutsu;
	private int maxDamage;
	private boolean bFull3D;
	private boolean hasSubtypes;
	private Item containerItem;
	private String potionEffect;
	private String unlocalizedName;
	@SideOnly(Side.CLIENT)
	private IIcon itemIcon;
	private String iconString;
	private List<int[]> activeJutsus = new ArrayList<int[]>();
	private int chackraConsumption = 0;
	private int jutsuID;
	private boolean activated;
	private int[] jutsuProps;
	private int[] jutsuLine;
	private int totalDuration, passDuration;

	@Override
	public void activateJutsu() {
		this.setActive(true);
	}

	@SuppressWarnings("rawtypes")
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
	}

	@Override
	public boolean canItemEditBlocks() {
		return true;
	}

	@Override
	public void consumeChackra(EntityPlayer player, int value) {
		ExtendedProperties props = ExtendedProperties.get(player);
		if (props.getCurrentChakra() < this.chackraConsumption) {
			setActive(false);
		} else {
			ExtendedProperties.get(player).consumeChakra(value);
		}
	}

	/**
	 * This function should return a new entity to replace the dropped item.
	 * Returning null here will not kill the EntityItem and will leave it to
	 * function normally. Called when the item it placed in a world.
	 *
	 * @param world
	 *            The world object
	 * @param location
	 *            The EntityItem object, useful for getting the position of the
	 *            entity
	 * @param itemstack
	 *            The current item stack
	 * @return A new Entity object to spawn or null
	 */
	@Override
	public Entity createEntity(World world, Entity location, ItemStack itemstack) {
		return null;
	}

	/**
	 * If this returns true, after a recipe involving this item is crafted the
	 * container item will be added to the player's inventory instead of
	 * remaining in the crafting grid.
	 */
	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack) {
		return true;
	}

	/**
	 *
	 * Should this item, when held, allow sneak-clicks to pass through to the
	 * underlying block?
	 *
	 * @param world
	 *            The world
	 * @param x
	 *            The X Position
	 * @param y
	 *            The X Position
	 * @param z
	 *            The X Position
	 * @param player
	 *            The Player that is wielding the item
	 * @return false
	 */
	@Override
	public boolean doesSneakBypassUse(World world, int x, int y, int z,
			EntityPlayer player) {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack par1ItemStack, int par2) {
		return 16777215;
	}

	@Override
	public Item getContainerItem() {
		return this.containerItem;
	}

	/**
	 * ItemStack sensitive version of getContainerItem. Returns a full ItemStack
	 * instance of the result.
	 *
	 * @param itemStack
	 *            The current ItemStack
	 * @return The resulting ItemStack
	 */
	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		if (!hasContainerItem(itemStack)) {
			return null;
		}
		return new ItemStack(getContainerItem());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTab() {
		return this.tabToDisplayOn;
	}

	/**
	 * Queries the percentage of the 'Durability' bar that should be drawn.
	 *
	 * @param stack
	 *            The current ItemStack
	 * @return 1.0 for 100% 0 for 0%
	 */
	@Override
	public double getDurabilityForDisplay(ItemStack stack) {
		return (double) stack.getItemDamageForDisplay()
				/ (double) stack.getMaxDamage();
	}

	/**
	 * Retrieves the normal 'lifespan' of this item when it is dropped on the
	 * ground as a EntityItem. This is in ticks, standard result is 6000, or 5
	 * mins.
	 *
	 * @param itemStack
	 *            The current ItemStack
	 * @param world
	 *            The world the entity is in
	 * @return The normal lifespan in ticks.
	 */
	@Override
	public int getEntityLifespan(ItemStack itemStack, World world) {
		return 6000;
	}

	/**
	 * Returns the font renderer used to render tooltips and overlays for this
	 * item. Returning null will use the standard font renderer.
	 *
	 * @param stack
	 *            The current item stack
	 * @return A instance of FontRenderer or null to use default
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public FontRenderer getFontRenderer(ItemStack stack) {
		return null;
	}

	@Override
	public boolean getHasSubtypes() {
		return this.hasSubtypes;
	}

	/**
	 * Return the correct icon for rendering based on the supplied ItemStack and
	 * render pass.
	 *
	 * Defers to {@link #getIconFromDamageForRenderPass(int, int)}
	 *
	 * @param stack
	 *            to render for
	 * @param pass
	 *            the multi-render pass
	 * @return the icon
	 */
	@Override
	public IIcon getIcon(ItemStack stack, int pass) {
		/**
		 * Gets an icon index based on an item's damage value and the given
		 * render pass
		 */
		return getIconFromDamageForRenderPass(stack.getItemDamage(), pass);
	}

	/**
	 * Player, Render pass, and item usage sensitive version of getIconIndex.
	 *
	 * @param stack
	 *            The item stack to get the icon for. (Usually this, and
	 *            usingItem will be the same if usingItem is not null)
	 * @param renderPass
	 *            The pass to get the icon for, 0 is default.
	 * @param player
	 *            The player holding the item
	 * @param usingItem
	 *            The item the player is actively using. Can be null if not
	 *            using anything.
	 * @param useRemaining
	 *            The ticks remaining for the active item.
	 * @return The icon index
	 */
	@Override
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player,
			ItemStack usingItem, int useRemaining) {
		return getIcon(stack, renderPass);
	}

	/**
	 * Gets an icon index based on an item's damage value
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1) {
		return this.itemIcon;
	}

	/**
	 * Gets an icon index based on an item's damage value and the given render
	 * pass
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamageForRenderPass(int par1, int par2) {
		return this.getIconFromDamage(par1);
	}

	/**
	 * Returns the icon index of the stack given as argument.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconIndex(ItemStack par1ItemStack) {
		return this.getIconFromDamage(par1ItemStack.getItemDamage());
	}

	@Override
	@SideOnly(Side.CLIENT)
	protected String getIconString() {
		return this.iconString == null ? "MISSING_ICON_ITEM_"
				+ itemRegistry.getIDForObject(this) + "_"
				+ this.unlocalizedName : this.iconString;
	}

	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack,
			ItemStack par2ItemStack) {
		return false;
	}

	@Override
	public int getItemEnchantability() {
		return 0;
	}

	@Override
	public String getItemStackDisplayName(ItemStack par1ItemStack) {
		return ("" + StatCollector.translateToLocal(this
				.getUnlocalizedNameInefficiently(par1ItemStack) + ".name"))
				.trim();
	}

	/**
	 * returns the action that specifies what animation to play when the items
	 * is being used
	 */
	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.none;
	}

	@Override
	public int getJutsuID() {
		return this.jutsuID;
	}

	@Override
	public int[] getJutsuProps() {
		return this.jutsuProps;
	}

	@Override
	public int getMaxDamage() {
		return this.maxDamage;
	}

	/**
	 * Returns the metadata of the block which this Item (ItemBlock) can place
	 */
	@Override
	public int getMetadata(int par1) {
		return 0;
	}

	@Override
	protected MovingObjectPosition getMovingObjectPositionFromPlayer(
			World par1World, EntityPlayer par2EntityPlayer, boolean par3) {
		float f = 1.0F;
		float f1 = par2EntityPlayer.prevRotationPitch
				+ ((par2EntityPlayer.rotationPitch - par2EntityPlayer.prevRotationPitch) * f);
		float f2 = par2EntityPlayer.prevRotationYaw
				+ ((par2EntityPlayer.rotationYaw - par2EntityPlayer.prevRotationYaw) * f);
		double d0 = par2EntityPlayer.prevPosX
				+ ((par2EntityPlayer.posX - par2EntityPlayer.prevPosX) * f);
		double d1 = par2EntityPlayer.prevPosY
				+ ((par2EntityPlayer.posY - par2EntityPlayer.prevPosY) * f)
				+ (par1World.isRemote
						? par2EntityPlayer.getEyeHeight()
								- par2EntityPlayer.getDefaultEyeHeight()
						: par2EntityPlayer.getEyeHeight()); // isRemote check to
															// revert changes to
															// ray trace
															// position due to
															// adding the eye
															// height clientside
															// and player
															// yOffset
															// differences
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
			d3 = ((EntityPlayerMP) par2EntityPlayer).theItemInWorldManager
					.getBlockReachDistance();
		}
		Vec3 vec31 = vec3.addVector(f7 * d3, f6 * d3, f8 * d3);
		return par1World.func_147447_a(vec3, vec31, par3, !par3, false);
	}

	@Override
	public String getPotionEffect(ItemStack p_150896_1_) {
		return this.potionEffect;
	}

	/**
	 * Returns the number of render passes/layers this item has. Usually equates
	 * to ItemRenderer.renderItem being called for this many passes. Does not
	 * get called unless requiresMultipleRenderPasses() is true;
	 *
	 * @param metadata
	 *            The item's metadata
	 * @return The number of passes to run.
	 */
	@Override
	public int getRenderPasses(int metadata) {
		return requiresMultipleRenderPasses() ? 2 : 1;
	}

	/**
	 * If this function returns true (or the item is damageable), the
	 * ItemStack's NBT tag will be sent to the client.
	 */
	@Override
	public boolean getShareTag() {
		return true;
	}

	/**
	 * Determines the base experience for a player when they remove this item
	 * from a furnace slot. This number must be between 0 and 1 for it to be
	 * valid. This number will be multiplied by the stack size to get the total
	 * experience.
	 *
	 * @param item
	 *            The item stack the player is picking up.
	 * @return The amount to award for each item.
	 */
	@Override
	public float getSmeltingExperience(ItemStack item) {
		return -1; // -1 will default to the old lookups.
	}

	/*
	 * ======================================== FORGE END
	 * =====================================
	 */

	/**
	 * returns a list of items with the same ID, but different meta (eg: dye
	 * returns 16 items)
	 */
	@Override
	@SuppressWarnings({"rawtypes", "unchecked"})
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item p_150895_1_, CreativeTabs p_150895_2_,
			List p_150895_3_) {
		p_150895_3_.add(new ItemStack(p_150895_1_, 1, 0));
	}

	@Override
	public String getUnlocalizedName() {
		return "item." + this.unlocalizedName;
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return "item." + this.unlocalizedName;
	}

	@Override
	public String getUnlocalizedNameInefficiently(ItemStack par1ItemStack) {
		String s = this.getUnlocalizedName(par1ItemStack);
		return s == null ? "" : StatCollector.translateToLocal(s);
	}

	/**
	 * Determines if this Item has a special entity for when they are in the
	 * world. Is called when a EntityItem is spawned in the world, if true and
	 * Item#createCustomEntity returns non null, the EntityItem will be
	 * destroyed and the new Entity will be added to the world.
	 *
	 * @param stack
	 *            The current item stack
	 * @return True of the item has a custom entity, If true,
	 *         Item#createCustomEntity will be called
	 */
	@Override
	public boolean hasCustomEntity(ItemStack stack) {
		return false;
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack,
			EntityLivingBase par2EntityLivingBase,
			EntityLivingBase par3EntityLivingBase) {
		return false;
	}

	@Override
	public boolean isActive() {
		return this.activated;
	}

	@Override
	public boolean isDamageable() {
		return false;
	}

	/**
	 * Return if this itemstack is damaged. Note only called if
	 * {@link #isDamageable()} is true.
	 *
	 * @param stack
	 *            the stack
	 * @return if the stack is damaged
	 */
	@Override
	public boolean isDamaged(ItemStack stack) {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return this.bFull3D;
	}

	/**
	 * Checks isDamagable and if it cannot be stacked
	 */
	@Override
	public boolean isItemTool(ItemStack par1ItemStack) {
		return false;
	}

	@Override
	public boolean isPotionIngredient(ItemStack p_150892_1_) {
		return false;
	}

	/**
	 * Called by CraftingManager to determine if an item is reparable.
	 *
	 * @return True if reparable
	 */
	@Override
	public boolean isRepairable() {
		return false;
	}

	/**
	 * Returns true if the item can be used on the given entity, e.g. shears on
	 * sheep.
	 */
	@Override
	public boolean itemInteractionForEntity(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, EntityLivingBase par3EntityLivingBase) {
		return false;
	}

	@Override
	public void jutsuEnd() {

		this.setActive(false);
	}

	@Override
	public void onCreated(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
	}

	/*
	 * ======================================== FORGE START
	 * =====================================
	 */
	/**
	 * Called when a player drops the item into the world, returning false from
	 * this will prevent the item from being removed from the players inventory
	 * and spawning in the world
	 *
	 * @param player
	 *            The player that dropped the item
	 * @param item
	 *            The item stack, before the item is removed.
	 */
	@Override
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) {
		return true;
	}

	/**
	 * Called by the default implemetation of EntityItem's onUpdate method,
	 * allowing for cleaner control over the update of the item without having
	 * to write a subclass.
	 *
	 * @param entityItem
	 *            The entity Item
	 * @return Return true to skip any further update code.
	 */
	@Override
	public boolean onEntityItemUpdate(EntityItem entityItem) {
		return false;
	}

	/**
	 * Called when a entity tries to play the 'swing' animation.
	 *
	 * @param entityLiving
	 *            The entity swinging the item.
	 * @param stack
	 *            The Item stack
	 * @return True to cancel any further processing by EntityLiving
	 */
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		return false;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		return par1ItemStack;
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, World par3World, int par4, int par5,
			int par6, int par7, float par8, float par9, float par10) {
		return false;
	}

	/**
	 * This is called when the item is used, before the block is activated.
	 *
	 * @param stack
	 *            The Item Stack
	 * @param player
	 *            The Player that used the item
	 * @param world
	 *            The Current World
	 * @param x
	 *            Target X Position
	 * @param y
	 *            Target Y Position
	 * @param z
	 *            Target Z Position
	 * @param side
	 *            The side of the target hit
	 * @return Return true to prevent any further processing.
	 */
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player,
			World world, int x, int y, int z, int side, float hitX, float hitY,
			float hitZ) {
		return false;
	}

	@Override
	public void onJutsuUpdate() {
		this.passDuration++;
		this.updateJutsuProperties();
		if (passDuration > totalDuration) {
			this.jutsuEnd();
		}
	}

	/**
	 * Called when the player Left Clicks (attacks) an entity. Processed before
	 * damage is done, if return value is true further processing is canceled
	 * and the entity is not attacked.
	 *
	 * @param stack
	 *            The Item being used
	 * @param player
	 *            The player that is attacking
	 * @param entity
	 *            The entity being attacked
	 * @return True to cancel the rest of the interaction.
	 */
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player,
			Entity entity) {
		return false;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public int getChackraConsumption() {
		return chackraConsumption;
	}

	public int getTotalDuration() {
		return totalDuration;
	}

	public int getPassDuration() {
		return passDuration;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer, int par4) {
	}

	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World,
			Entity par3Entity, int par4, boolean par5) {
	}

	/**
	 * Called each tick while using an item.
	 *
	 * @param stack
	 *            The Item being used
	 * @param player
	 *            The Player using the item
	 * @param count
	 *            The amount of time in tick the item has been used for
	 *            continuously
	 */
	@Override
	public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		NBTTagList jutsus = compound.getTagList("JutsuManager",
				compound.getId());

		int jCount = jutsus.tagCount();
		System.out.println("JCount: " + jCount);
		if (jCount > 0) {
			for (int i = 0; i < jCount; i++) {
				NBTTagCompound jutsu = jutsus.getCompoundTagAt(jCount);
				this.activeJutsus.add(jutsu.getIntArray("Jutsu" + i));
			}
		}
		ExtendedProperties.activeJutsus = activeJutsus;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon(this.getIconString());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return false;
	}

	@Override
	public void setActive(boolean par) {
		this.activated = par;
	}

	@Override
	public Item setContainerItem(Item par1Item) {
		this.containerItem = par1Item;
		return this;
	}

	@Override
	public Item setCreativeTab(CreativeTabs par1CreativeTabs) {
		this.tabToDisplayOn = par1CreativeTabs;
		return this;
	}

	@Override
	public Item setFull3D() {
		this.bFull3D = true;
		return this;
	}

	@Override
	public Item setHasSubtypes(boolean par1) {
		this.hasSubtypes = par1;
		return this;
	}

	@Override
	public Item setMaxDamage(int par1) {
		this.maxDamage = par1;
		return this;
	}

	@Override
	public Item setMaxStackSize(int par1) {
		this.maxStackSize = par1;
		return this;
	}
	/**
	 * Call to disable repair recipes.
	 *
	 * @return The current Item instance
	 */
	@Override
	public Item setNoRepair() {
		this.canRepair = false;
		return this;
	}

	@Override
	public Item setPotionEffect(String par1Str) {
		this.potionEffect = par1Str;
		return this;
	}

	@Override
	public Item setTextureName(String par1Str) {
		this.iconString = par1Str;
		return this;
	}

	@Override
	public Item setUnlocalizedName(String par1Str) {
		this.unlocalizedName = par1Str;
		return this;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldRotateAroundWhenRendering() {
		return false;
	}

	@Override
	public void updateJutsuProperties() {
		this.jutsuProps[0] = jutsuID;
		this.jutsuProps[1] = totalDuration;
		this.jutsuProps[2] = passDuration;
		this.jutsuProps[3] = chackraConsumption;
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		NBTTagList jutsuList = new NBTTagList();
		NBTTagCompound jutsus = new NBTTagCompound();

		this.activeJutsus = ExtendedProperties.activeJutsus;
		if (!this.activeJutsus.isEmpty()) {
			while (this.activeJutsus.iterator().hasNext()) {
				this.jutsuLine = this.activeJutsus.iterator().next();
				jutsus.setIntArray("Jutsu" + this.jutsuLine[0], this.jutsuLine);
				jutsuList.appendTag(jutsus);
			}
		}
		compound.setTag("JutsuManager", jutsus);
	}
}
