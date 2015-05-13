package pl.grm.narutocraft.items.weapons;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraftforge.fml.relauncher.*;
import pl.grm.narutocraft.*;

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
	
	public float func_150931_i() {
		return this.field_150933_b.getDamageVsEntity();
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
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase,
			EntityLivingBase par3EntityLivingBase) {
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
	
	/**
	 * Called whenever this item is equipped and the right mouse button is
	 * pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}
	
	public void onUpdate() {}
}
