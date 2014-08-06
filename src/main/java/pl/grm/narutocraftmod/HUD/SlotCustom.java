package pl.grm.narutocraftmod.HUD;

import javax.swing.Icon;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import pl.grm.narutocraftmod.Powers.Sharingan;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SlotCustom extends Slot {
	public SlotCustom(IInventory inventory, int slotIndex, int x, int y)
	{
	super(inventory, slotIndex, x, y);
	}

	/**
	* Check if the stack is a valid item for this slot. Always true beside for the armor slots
	* (and now also not always true for our custom inventory slots)
	*/
	@Override
	public boolean isItemValid(ItemStack itemstack)
	{
	// We only want our custom item to be storable in this slot
	return itemstack.getItem() instanceof Sharingan;
	}
}
	// Armor Slot:
	/*public class SlotArmor extends Slot
	{
	final int armorType;
	final EntityPlayer player;

	SlotArmor(EntityPlayer player, IInventory inventory, int slotIndex, int x, int y, int armorType)
	{
	super(inventory, slotIndex, x, y);
	this.player = player;
	this.armorType = armorType;
	}

	public int getSlotStackLimit()
	{
	return 1;
	}

	public boolean isItemValid(ItemStack itemstack)
	{
	Item item = (itemstack == null ? null : itemstack.getItem());
	return item != null && item.isValidArmor(itemstack, armorType, player);
	}

	@SideOnly(Side.CLIENT)
	public Icon getBackgroundIconIndex()
	{
	return ItemArmor.func_94602_b(this.armorType);
	}
}*/
