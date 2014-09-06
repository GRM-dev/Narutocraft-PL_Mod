package pl.grm.narutocraft.effects;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEffect extends PotionEffect {
	/** ID value of the potion this effect matches. */
	private int effectID;
	/** The duration of the potion effect */
	private int duration;
	/** The amplifier of the potion effect */
	private int amplifier;
	/** Whether the potion is a splash potion */
	private boolean isSplashPotion;
	/** Whether the potion effect came from a beacon */
	private boolean isAmbient;
	/** True if potion effect duration is at maximum, false otherwise. */
	@SideOnly(Side.CLIENT)
	private boolean isPotionDurationMax;
	/** List of ItemStack that can cure the potion effect **/
	private List<ItemStack> curativeItems;

	/**
	 * Add Effect to Item without Ambient and no amplifier.
	 * 
	 * @param effectID
	 * @param duration
	 */
	public ItemEffect(int effectID, int duration) {
		this(effectID, duration, 0);
	}

	/**
	 * Add Effect to Item without Ambient.
	 * 
	 * @param effectID
	 * @param duration
	 * @param amplifier
	 */
	public ItemEffect(int effectID, int duration, int amplifier) {
		this(effectID, duration, amplifier, false);
	}

	/**
	 * Add Effect to Item.
	 * 
	 * @param effectID
	 * @param duration
	 * @param amplifier
	 * @param isAmbient
	 */
	public ItemEffect(int effectID, int duration, int amplifier,
			boolean isAmbient) {
		super(effectID, duration, amplifier, isAmbient);
	}

	/**
	 * merges the input PotionEffect into this one if this.amplifier <=
	 * tomerge.amplifier. The duration in the supplied potion effect is assumed
	 * to be greater.
	 */
	public void combine(ItemEffect par1PotionEffect) {
		if (this.effectID != par1PotionEffect.effectID) {
			System.err
					.println("This method should only be called for matching effects!");
		}

		if (par1PotionEffect.amplifier > this.amplifier) {
			this.amplifier = par1PotionEffect.amplifier;
			this.duration = par1PotionEffect.duration;
		} else if (par1PotionEffect.amplifier == this.amplifier
				&& this.duration < par1PotionEffect.duration) {
			this.duration = par1PotionEffect.duration;
		} else if (!par1PotionEffect.isAmbient && this.isAmbient) {
			this.isAmbient = par1PotionEffect.isAmbient;
		}
	}

	/**
	 * Retrieve the ID of the potion this effect matches.
	 */
	public int getEffectID() {
		return this.effectID;
	}

	@Override
	public int getDuration() {
		return this.duration;
	}

	@Override
	public int getAmplifier() {
		return this.amplifier;
	}

	/**
	 * Set whether this potion is a splash potion.
	 */
	@Override
	public void setSplashPotion(boolean par1) {
		this.isSplashPotion = par1;
	}

	/**
	 * Gets whether this potion effect originated from a beacon
	 */
	@Override
	public boolean getIsAmbient() {
		return this.isAmbient;
	}

	@Override
	public boolean onUpdate(EntityLivingBase par1EntityLivingBase) {
		if (this.duration > 0) {
			if (Potion.potionTypes[this.effectID].isReady(this.duration,
					this.amplifier)) {
				this.performEffect(par1EntityLivingBase);
			}
			this.deincrementDuration();
		}

		return this.duration > 0;
	}

	private int deincrementDuration() {
		return --this.duration;
	}

	@Override
	public void performEffect(EntityLivingBase par1EntityLivingBase) {
		if (this.duration > 0) {
			Potion.potionTypes[this.effectID].performEffect(
					par1EntityLivingBase, this.amplifier);
		}
	}

	@Override
	public String getEffectName() {
		return Potion.potionTypes[this.effectID].getName();
	}

	@Override
	public int hashCode() {
		return this.effectID;
	}

	@Override
	public String toString() {
		String s = "";

		if (this.getAmplifier() > 0) {
			s = this.getEffectName() + " x " + (this.getAmplifier() + 1)
					+ ", Duration: " + this.getDuration();
		} else {
			s = this.getEffectName() + ", Duration: " + this.getDuration();
		}

		if (this.isSplashPotion) {
			s = s + ", Splash: true";
		}

		return Potion.potionTypes[this.effectID].isUsable() ? "(" + s + ")" : s;
	}

	@Override
	public boolean equals(Object par1Obj) {
		if (!(par1Obj instanceof ItemEffect)) {
			return false;
		} else {
			ItemEffect itemeffect = (ItemEffect) par1Obj;
			return this.effectID == itemeffect.effectID
					&& this.amplifier == itemeffect.amplifier
					&& this.duration == itemeffect.duration
					&& this.isSplashPotion == itemeffect.isSplashPotion
					&& this.isAmbient == itemeffect.isAmbient;
		}
	}

	/**
	 * Write a custom potion effect to a potion item's NBT data.
	 */
	@Override
	public NBTTagCompound writeCustomPotionEffectToNBT(
			NBTTagCompound par1NBTTagCompound) {
		par1NBTTagCompound.setByte("Id", (byte) this.getEffectID());
		par1NBTTagCompound.setByte("Amplifier", (byte) this.getAmplifier());
		par1NBTTagCompound.setInteger("Duration", this.getDuration());
		par1NBTTagCompound.setBoolean("Ambient", this.getIsAmbient());
		return par1NBTTagCompound;
	}

	/**
	 * Read a custom potion effect from a potion item's NBT data.
	 */
	public static ItemEffect readCustomPotionEffectFromNBT(
			NBTTagCompound par0NBTTagCompound) {
		byte b0 = par0NBTTagCompound.getByte("Id");

		if (b0 >= 0 && b0 < Potion.potionTypes.length
				&& Potion.potionTypes[b0] != null) {
			byte b1 = par0NBTTagCompound.getByte("Amplifier");
			int i = par0NBTTagCompound.getInteger("Duration");
			boolean flag = par0NBTTagCompound.getBoolean("Ambient");
			return new ItemEffect(b0, i, b1, flag);
		} else {
			return null;
		}
	}

	/**
	 * Toggle the isPotionDurationMax field.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void setPotionDurationMax(boolean par1) {
		this.isPotionDurationMax = par1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean getIsPotionDurationMax() {
		return this.isPotionDurationMax;
	}

	/**
	 * Returns a list of curative items for the potion effect
	 * 
	 * @return The list (ItemStack) of curative items for the potion effect
	 */
	@Override
	public List<ItemStack> getCurativeItems() {
		return this.curativeItems;
	}

	/**
	 * Checks the given ItemStack to see if it is in the list of curative items
	 * for the potion effect
	 * 
	 * @param stack
	 *            The ItemStack being checked against the list of curative items
	 *            for the potion effect
	 * @return true if the given ItemStack is in the list of curative items for
	 *         the potion effect, false otherwise
	 */
	@Override
	public boolean isCurativeItem(ItemStack stack) {
		boolean found = false;
		for (ItemStack curativeItem : this.curativeItems) {
			if (curativeItem.isItemEqual(stack)) {
				found = true;
			}
		}
		return found;
	}

	/***
	 * Sets the array of curative items for the potion effect
	 * 
	 * @param curativeItems
	 *            The list of ItemStacks being set to the potion effect
	 */
	@Override
	public void setCurativeItems(List<ItemStack> curativeItems) {
		this.curativeItems = curativeItems;
	}

	/***
	 * Adds the given stack to list of curative items for the potion effect
	 * 
	 * @param stack
	 *            The ItemStack being added to the curative item list
	 */
	@Override
	public void addCurativeItem(ItemStack stack) {
		boolean found = false;
		for (ItemStack curativeItem : this.curativeItems) {
			if (curativeItem.isItemEqual(stack)) {
				found = true;
			}
		}
		if (!found) {
			this.curativeItems.add(stack);
		}
	}
}