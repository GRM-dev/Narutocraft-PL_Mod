package pl.grm.narutocraftmod.jutsu;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.RegistryNamespaced;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.google.common.collect.Multimap;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import pl.grm.narutocraftmod.NarutoCraftMod;

public class Jutsu extends Item {
    public static final RegistryNamespaced itemRegistry = GameData.getItemRegistry();
    protected static final UUID field_111210_e = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
    private CreativeTabs tabToDisplayOn= NarutoCraftMod.mTabNarutoCraftMod;
    protected static Random itemRand = new Random();
    protected int maxStackSize = 1;
    private int maxDamage;
    protected boolean bFull3D;
    protected boolean hasSubtypes;
    private Item containerItem;
    private String potionEffect;
    private String unlocalizedName;

    @SideOnly(Side.CLIENT)
    protected IIcon itemIcon;
    protected String iconString;

    public static int getIdFromItem(Item p_150891_0_)
    {
        return p_150891_0_ == null ? 0 : itemRegistry.getIDForObject(p_150891_0_);
    }

    public static Item getItemById(int p_150899_0_)
    {
        return (Item)itemRegistry.getObjectById(p_150899_0_);
    }

    public static Item getItemFromBlock(Block p_150898_0_)
    {
        return getItemById(Block.getIdFromBlock(p_150898_0_));
    }
    
    public Item setMaxStackSize(int par1)
    {
        this.maxStackSize = par1;
        return this;
    }

    /**
     * Returns 0 for /terrain.png, 1 for /gui/items.png
     */
    @SideOnly(Side.CLIENT)
    public int getSpriteNumber()
    {
        return 1;
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1)
    {
        return this.itemIcon;
    }

    /**
     * Returns the icon index of the stack given as argument.
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIconIndex(ItemStack par1ItemStack)
    {
        return this.getIconFromDamage(par1ItemStack.getItemDamage());
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        return false;
    }

    public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_)
    {
        return 1.0F;
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return par1ItemStack;
    }

    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int getMetadata(int par1)
    {
        return 0;
    }

    public boolean getHasSubtypes()
    {
        return this.hasSubtypes;
    }

    public Item setHasSubtypes(boolean par1)
    {
        this.hasSubtypes = par1;
        return this;
    }

    public int getMaxDamage()
    {
        return this.maxDamage;
    }

    public Item setMaxDamage(int par1)
    {
        this.maxDamage = par1;
        return this;
    }

    public boolean isDamageable()
    {
        return this.maxDamage > 0 && !this.hasSubtypes;
    }

    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        return false;
    }

    public boolean func_150897_b(Block p_150897_1_)
    {
        return false;
    }

    /**
     * Returns true if the item can be used on the given entity, e.g. shears on sheep.
     */
    public boolean itemInteractionForEntity(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, EntityLivingBase par3EntityLivingBase)
    {
        return false;
    }

    public Item setFull3D()
    {
        this.bFull3D = true;
        return this;
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return this.bFull3D;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldRotateAroundWhenRendering()
    {
        return false;
    }

    public Item setUnlocalizedName(String par1Str)
    {
        this.unlocalizedName = par1Str;
        return this;
    }

    public String getUnlocalizedNameInefficiently(ItemStack par1ItemStack)
    {
        String s = this.getUnlocalizedName(par1ItemStack);
        return s == null ? "" : StatCollector.translateToLocal(s);
    }

    public String getUnlocalizedName()
    {
        return "item." + this.unlocalizedName;
    }

    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        return "item." + this.unlocalizedName;
    }

    public Item setContainerItem(Item par1Item)
    {
        this.containerItem = par1Item;
        return this;
    }

    /**
     * If this returns true, after a recipe involving this item is crafted the container item will be added to the
     * player's inventory instead of remaining in the crafting grid.
     */
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
    {
        return true;
    }

    /**
     * If this function returns true (or the item is damageable), the ItemStack's NBT tag will be sent to the client.
     */
    public boolean getShareTag()
    {
        return true;
    }

    public Item getContainerItem()
    {
        return this.containerItem;
    }

    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
    {
        return 16777215;
    }

    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {}

    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {}

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.none;
    }

    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 0;
    }

    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {}

    public Item setPotionEffect(String par1Str)
    {
        this.potionEffect = par1Str;
        return this;
    }

    public String getPotionEffect(ItemStack p_150896_1_)
    {
        return this.potionEffect;
    }

    public boolean isPotionIngredient(ItemStack p_150892_1_)
    {
        return this.getPotionEffect(p_150892_1_) != null;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {}

    public String getItemStackDisplayName(ItemStack par1ItemStack)
    {
        return ("" + StatCollector.translateToLocal(this.getUnlocalizedNameInefficiently(par1ItemStack) + ".name")).trim();
    }

    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return par1ItemStack.isItemEnchanted() ? EnumRarity.rare : EnumRarity.common;
    }

    /**
     * Checks isDamagable and if it cannot be stacked
     */
    public boolean isItemTool(ItemStack par1ItemStack)
    {
        return this.getItemStackLimit(par1ItemStack) == 1 && this.isDamageable();
    }

    protected MovingObjectPosition getMovingObjectPositionFromPlayer(World par1World, EntityPlayer par2EntityPlayer, boolean par3)
    {
        float f = 1.0F;
        float f1 = par2EntityPlayer.prevRotationPitch + (par2EntityPlayer.rotationPitch - par2EntityPlayer.prevRotationPitch) * f;
        float f2 = par2EntityPlayer.prevRotationYaw + (par2EntityPlayer.rotationYaw - par2EntityPlayer.prevRotationYaw) * f;
        double d0 = par2EntityPlayer.prevPosX + (par2EntityPlayer.posX - par2EntityPlayer.prevPosX) * (double)f;
        double d1 = par2EntityPlayer.prevPosY + (par2EntityPlayer.posY - par2EntityPlayer.prevPosY) * (double)f + (double)(par1World.isRemote ? par2EntityPlayer.getEyeHeight() - par2EntityPlayer.getDefaultEyeHeight() : par2EntityPlayer.getEyeHeight()); // isRemote check to revert changes to ray trace position due to adding the eye height clientside and player yOffset differences
        double d2 = par2EntityPlayer.prevPosZ + (par2EntityPlayer.posZ - par2EntityPlayer.prevPosZ) * (double)f;
        @SuppressWarnings("deprecation")
		Vec3 vec3 = par1World.getWorldVec3Pool().getVecFromPool(d0, d1, d2);
        float f3 = MathHelper.cos(-f2 * 0.017453292F - (float)Math.PI);
        float f4 = MathHelper.sin(-f2 * 0.017453292F - (float)Math.PI);
        float f5 = -MathHelper.cos(-f1 * 0.017453292F);
        float f6 = MathHelper.sin(-f1 * 0.017453292F);
        float f7 = f4 * f5;
        float f8 = f3 * f5;
        double d3 = 5.0D;
        if (par2EntityPlayer instanceof EntityPlayerMP)
        {
            d3 = ((EntityPlayerMP)par2EntityPlayer).theItemInWorldManager.getBlockReachDistance();
        }
        Vec3 vec31 = vec3.addVector((double)f7 * d3, (double)f6 * d3, (double)f8 * d3);
        return par1World.func_147447_a(vec3, vec31, par3, !par3, false);
    }

    public int getItemEnchantability()
    {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses()
    {
        return false;
    }

    /**
     * Gets an icon index based on an item's damage value and the given render pass
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamageForRenderPass(int par1, int par2)
    {
        return this.getIconFromDamage(par1);
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item p_150895_1_, CreativeTabs p_150895_2_, List p_150895_3_)
    {
        p_150895_3_.add(new ItemStack(p_150895_1_, 1, 0));
    }

    public Item setCreativeTab(CreativeTabs par1CreativeTabs)
    {
        this.tabToDisplayOn = par1CreativeTabs;
        return this;
    }

    @SideOnly(Side.CLIENT)
    public CreativeTabs getCreativeTab()
    {
        return this.tabToDisplayOn;
    }

    public boolean canItemEditBlocks()
    {
        return true;
    }

    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(this.getIconString());
    }

    public Item setTextureName(String par1Str)
    {
        this.iconString = par1Str;
        return this;
    }

    @SideOnly(Side.CLIENT)
    protected String getIconString()
    {
        return this.iconString == null ? "MISSING_ICON_ITEM_" + itemRegistry.getIDForObject(this) + "_" + this.unlocalizedName : this.iconString;
    }

    /* ======================================== FORGE START =====================================*/
    /**
     * ItemStack sensitive version of getItemAttributeModifiers
     */
    public Multimap getAttributeModifiers(ItemStack stack)
    {
        return this.getItemAttributeModifiers();
    }

    /**
     * Called when a player drops the item into the world,
     * returning false from this will prevent the item from
     * being removed from the players inventory and spawning
     * in the world
     *
     * @param player The player that dropped the item
     * @param item The item stack, before the item is removed.
     */
    public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
    {
        return true;
    }

    /**
     * This is called when the item is used, before the block is activated.
     * @param stack The Item Stack
     * @param player The Player that used the item
     * @param world The Current World
     * @param x Target X Position
     * @param y Target Y Position
     * @param z Target Z Position
     * @param side The side of the target hit
     * @return Return true to prevent any further processing.
     */
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        return false;
    }

    /**
     * Metadata-sensitive version of getStrVsBlock
     * @param itemstack The Item Stack
     * @param block The block the item is trying to break
     * @param metadata The items current metadata
     * @return The damage strength
     */
    public float getDigSpeed(ItemStack itemstack, Block block, int metadata)
    {
        return func_150893_a(itemstack, block);
    }

    protected boolean canRepair = true;
    /**
     * Called by CraftingManager to determine if an item is reparable.
     * @return True if reparable
     */
    public boolean isRepairable()
    {
        return canRepair && isDamageable();
    }

    /**
     * Call to disable repair recipes.
     * @return The current Item instance
     */
    public Item setNoRepair()
    {
        canRepair = false;
        return this;
    }

    /**
     * Called each tick while using an item.
     * @param stack The Item being used
     * @param player The Player using the item
     * @param count The amount of time in tick the item has been used for continuously
     */
    public void onUsingTick(ItemStack stack, EntityPlayer player, int count)
    {
    }

    /**
     * Called when the player Left Clicks (attacks) an entity.
     * Processed before damage is done, if return value is true further processing is canceled
     * and the entity is not attacked.
     *
     * @param stack The Item being used
     * @param player The player that is attacking
     * @param entity The entity being attacked
     * @return True to cancel the rest of the interaction.
     */
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        return false;
    }

    /**
     * Player, Render pass, and item usage sensitive version of getIconIndex.
     *
     * @param stack The item stack to get the icon for. (Usually this, and usingItem will be the same if usingItem is not null)
     * @param renderPass The pass to get the icon for, 0 is default.
     * @param player The player holding the item
     * @param usingItem The item the player is actively using. Can be null if not using anything.
     * @param useRemaining The ticks remaining for the active item.
     * @return The icon index
     */
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
    {
        return getIcon(stack, renderPass);
    }

    /**
     * Returns the number of render passes/layers this item has.
     * Usually equates to ItemRenderer.renderItem being called for this many passes.
     * Does not get called unless requiresMultipleRenderPasses() is true;
     *
     * @param metadata The item's metadata
     * @return The number of passes to run.
     */
    public int getRenderPasses(int metadata)
    {
        return requiresMultipleRenderPasses() ? 2 : 1;
    }

    /**
     * ItemStack sensitive version of getContainerItem.
     * Returns a full ItemStack instance of the result.
     *
     * @param itemStack The current ItemStack
     * @return The resulting ItemStack
     */
    public ItemStack getContainerItem(ItemStack itemStack)
    {
        if (!hasContainerItem(itemStack))
        {
            return null;
        }
        return new ItemStack(getContainerItem());
    }

    /**
     * ItemStack sensitive version of hasContainerItem
     * @param stack The current item stack
     * @return True if this item has a 'container'
     */
    public boolean hasContainerItem(ItemStack stack)
    {
        /**
         * True if this Item has a container item (a.k.a. crafting result)
         */
        return hasContainerItem();
    }

    /**
     * Retrieves the normal 'lifespan' of this item when it is dropped on the ground as a EntityItem.
     * This is in ticks, standard result is 6000, or 5 mins.
     *
     * @param itemStack The current ItemStack
     * @param world The world the entity is in
     * @return The normal lifespan in ticks.
     */
    public int getEntityLifespan(ItemStack itemStack, World world)
    {
        return 6000;
    }

    /**
     * Determines if this Item has a special entity for when they are in the world.
     * Is called when a EntityItem is spawned in the world, if true and Item#createCustomEntity
     * returns non null, the EntityItem will be destroyed and the new Entity will be added to the world.
     *
     * @param stack The current item stack
     * @return True of the item has a custom entity, If true, Item#createCustomEntity will be called
     */
    public boolean hasCustomEntity(ItemStack stack)
    {
        return false;
    }

    /**
     * This function should return a new entity to replace the dropped item.
     * Returning null here will not kill the EntityItem and will leave it to function normally.
     * Called when the item it placed in a world.
     *
     * @param world The world object
     * @param location The EntityItem object, useful for getting the position of the entity
     * @param itemstack The current item stack
     * @return A new Entity object to spawn or null
     */
    public Entity createEntity(World world, Entity location, ItemStack itemstack)
    {
        return null;
    }

    /**
     * Called by the default implemetation of EntityItem's onUpdate method, allowing for cleaner 
     * control over the update of the item without having to write a subclass.
     * 
     * @param entityItem The entity Item
     * @return Return true to skip any further update code.
     */
    public boolean onEntityItemUpdate(EntityItem entityItem)
    {
        return false;
    }

    /**
     * Gets a list of tabs that items belonging to this class can display on,
     * combined properly with getSubItems allows for a single item to span
     * many sub-items across many tabs.
     *
     * @return A list of all tabs that this item could possibly be one.
     */
    public CreativeTabs[] getCreativeTabs()
    {
        return new CreativeTabs[]{ getCreativeTab() };
    }

    /**
     * Determines the base experience for a player when they remove this item from a furnace slot.
     * This number must be between 0 and 1 for it to be valid.
     * This number will be multiplied by the stack size to get the total experience.
     *
     * @param item The item stack the player is picking up.
     * @return The amount to award for each item.
     */
    public float getSmeltingExperience(ItemStack item)
    {
        return -1; //-1 will default to the old lookups.
    }

    /**
     * Return the correct icon for rendering based on the supplied ItemStack and render pass.
     *
     * Defers to {@link #getIconFromDamageForRenderPass(int, int)}
     * @param stack to render for
     * @param pass the multi-render pass
     * @return the icon
     */
    public IIcon getIcon(ItemStack stack, int pass)
    {
        /**
         * Gets an icon index based on an item's damage value and the given render pass
         */
        return getIconFromDamageForRenderPass(stack.getItemDamage(), pass);
    }    

    /**
     *
     * Should this item, when held, allow sneak-clicks to pass through to the underlying block?
     *
     * @param world The world 
     * @param x The X Position
     * @param y The X Position
     * @param z The X Position
     * @param player The Player that is wielding the item
     * @return
     */
    public boolean doesSneakBypassUse(World world, int x, int y, int z, EntityPlayer player)
    {
        return false;
    }

    /**
     * Returns the font renderer used to render tooltips and overlays for this item.
     * Returning null will use the standard font renderer.
     * 
     * @param stack The current item stack
     * @return A instance of FontRenderer or null to use default
     */
    @SideOnly(Side.CLIENT)
    public FontRenderer getFontRenderer(ItemStack stack)
    {
        return null;
    }

    /**
     * Called when a entity tries to play the 'swing' animation.
     *  
     * @param entityLiving The entity swinging the item.
     * @param stack The Item stack
     * @return True to cancel any further processing by EntityLiving 
     */
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
    {
        return false;
    }

    /**
     * Determines if the durability bar should be rendered for this item.
     * Defaults to vanilla stack.isDamaged behavior.
     * But modders can use this for any data they wish.
     * 
     * @param stack The current Item Stack
     * @return True if it should render the 'durability' bar.
     */
    public boolean showDurabilityBar(ItemStack stack)
    {
        return stack.isItemDamaged();
    }

    /**
     * Queries the percentage of the 'Durability' bar that should be drawn.
     * 
     * @param stack The current ItemStack
     * @return 1.0 for 100% 0 for 0%
     */
    public double getDurabilityForDisplay(ItemStack stack)
    {
        return (double)stack.getItemDamageForDisplay() / (double)stack.getMaxDamage();
    }
    
    /**
     * Return the maxDamage for this ItemStack. Defaults to the maxDamage field in this item, 
     * but can be overridden here for other sources such as NBT.
     *
     * @param stack The itemstack that is damaged
     * @return the damage value
     */
    public int getMaxDamage(ItemStack stack)
    {
        /**
         * Returns the maximum damage an item can take.
         */
        return getMaxDamage();
    }

    /**
     * Return if this itemstack is damaged. Note only called if {@link #isDamageable()} is true.
     * @param stack the stack
     * @return if the stack is damaged
     */
    public boolean isDamaged(ItemStack stack)
    {
        return stack.getItemDamage() > 0;
    }

    /**
     * Set the damage for this itemstack. Note, this method is responsible for zero checking.
     * @param stack the stack
     * @param damage the new damage value
     */

    /**
     * Render Pass sensitive version of hasEffect()
     */
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack, int pass)
    {
        return hasEffect(par1ItemStack) && (pass == 0 || this != Jutsu.getItemById(getItemEnchantability()));
    }

    /**
     * Gets the maximum number of items that this stack should be able to hold. 
     * This is a ItemStack (and thus NBT) sensitive version of Item.getItemStackLimit()
     * 
     * @param stack The ItemStack
     * @return THe maximum number this item can be stacked to
     */
    public int getItemStackLimit(ItemStack stack)
    {
        return this.getItemStackLimit();
    }

    private HashMap<String, Integer> toolClasses = new HashMap<String, Integer>();

    public Set<String> getToolClasses(ItemStack stack)
    {
        return toolClasses.keySet();
    }
    /* ======================================== FORGE END   =====================================*/
}
