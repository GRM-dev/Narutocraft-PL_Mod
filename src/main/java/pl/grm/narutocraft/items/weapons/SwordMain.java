package pl.grm.narutocraft.items.weapons;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import pl.grm.narutocraft.NarutoCraft;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SwordMain extends Item {
	private float					field_150934_a;
	private final Item.ToolMaterial	field_150933_b;
	
	public SwordMain(Item.ToolMaterial p_i45356_1_) {
		this.field_150933_b = p_i45356_1_;
		this.maxStackSize = 1;
		this.setMaxDamage(p_i45356_1_.getMaxUses());
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.field_150934_a = 4.0F + p_i45356_1_.getDamageVsEntity();
	}
	
	@Override
	public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_) {
		if (p_150893_2_ == Blocks.web) {
			return 15.0F;
		} else {
			Material material = p_150893_2_.getMaterial();
			return (material != Material.plants) && (material != Material.vine)
					&& (material != Material.coral) && (material != Material.leaves)
					&& (material != Material.gourd) ? 1.0F : 1.5F;
		}
	}
	
	@Override
	public boolean func_150897_b(Block p_150897_1_) {
		return p_150897_1_ == Blocks.web;
	}
	
	public float func_150931_i() {
		return this.field_150933_b.getDamageVsEntity();
	}
	
	/**
	 * Return whether this item is repairable in an anvil.
	 */
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
		return this.field_150933_b.func_150995_f() == par2ItemStack.getItem() ? true
				: super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
	
	/**
	 * Gets a map of item attribute modifiers, used by ItemSword to increase hit
	 * damage.
	 */
	@Override
	@SuppressWarnings({"rawtypes", "unchecked"})
	public Multimap getItemAttributeModifiers() {
		@SuppressWarnings("deprecation")
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(),
				new AttributeModifier(field_111210_e, "Weapon modifier",
						this.field_150934_a, 0));
		return multimap;
	}
	
	/**
	 * Return the enchantability factor of the item, most of the time is based
	 * on material.
	 */
	@Override
	public int getItemEnchantability() {
		return this.field_150933_b.getEnchantability();
	}
	
	/**
	 * returns the action that specifies what animation to play when the items
	 * is being used
	 */
	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.block;
	}
	
	/**
	 * How long it takes to use or consume an item
	 */
	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 72000;
	}
	
	/**
	 * Return the name for this tool's material.
	 */
	public String getToolMaterialName() {
		return this.field_150933_b.toString();
	}
	
	/**
	 * Current implementations of this method in child classes do not use the
	 * entry argument beside ev. They just raise the damage on the stack.
	 */
	@Override
	public boolean hitEntity(ItemStack par1ItemStack,
			EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {
		par1ItemStack.damageItem(1, par3EntityLivingBase);
		return true;
	}
	
	/**
	 * Returns True is the item is renderer in full 3D when hold.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_,
			Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_,
			EntityLivingBase p_150894_7_) {
		if (p_150894_3_.getBlockHardness(p_150894_2_, p_150894_4_, p_150894_5_,
				p_150894_6_) != 0.0D) {
			p_150894_1_.damageItem(2, p_150894_7_);
		}
		
		return true;
	}
	
	/**
	 * Called whenever this item is equipped and the right mouse button is
	 * pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		par3EntityPlayer.setItemInUse(par1ItemStack,
				this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}
	
	public void onUpdate() {}
}
