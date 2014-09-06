package pl.grm.narutocraft.gui;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import pl.grm.narutocraft.jutsu.Jutsu;

public class JutsuSlot extends Slot {
	public JutsuSlot(IInventory inventory, int slotIndex, int x, int y) {
		super(inventory, slotIndex, x, y);
	}

	@Override
	public boolean isItemValid(ItemStack itemstack) {
		return itemstack.getItem() instanceof Jutsu;
	}
}
// Armor Slot:
/*
 * public class SlotArmor extends Slot { final int armorType; final EntityPlayer
 * player;
 * 
 * SlotArmor(EntityPlayer player, IInventory inventory, int slotIndex, int x,
 * int y, int armorType) { super(inventory, slotIndex, x, y); this.player =
 * player; this.armorType = armorType; }
 * 
 * public int getSlotStackLimit() { return 1; }
 * 
 * public boolean isItemValid(ItemStack itemstack) { Item item = (itemstack ==
 * null ? null : itemstack.getItem()); return item != null &&
 * item.isValidArmor(itemstack, armorType, player); }
 * 
 * @SideOnly(Side.CLIENT) public Icon getBackgroundIconIndex() { return
 * ItemArmor.func_94602_b(this.armorType); } }
 */
