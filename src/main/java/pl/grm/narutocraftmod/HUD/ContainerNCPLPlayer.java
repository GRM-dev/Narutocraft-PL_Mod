package pl.grm.narutocraftmod.hud;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import pl.grm.narutocraftmod.jutsu.Jutsu;

public class ContainerNCPLPlayer extends Container {
	private static final int ARMOR_START = JutsuInv.INV_SIZE,
			ARMOR_END = ARMOR_START + 3, INV_START = ARMOR_END + 1,
			INV_END = INV_START + 26, HOTBAR_START = INV_END + 1,
			HOTBAR_END = HOTBAR_START + 8;
	
	private JutsuInv ji;

	public ContainerNCPLPlayer(EntityPlayer player,
			InventoryPlayer inventoryPlayer, JutsuInv inventoryCustom) {
		int i;
		int x = 44, y = 6;
		this.ji = inventoryCustom;
		for (int k = 0; k < ji.INV_SIZE; k++)
		{
			this.addSlotToContainer(new JutsuSlot(ji, k, x + k * 18, y));
		}

		// Add ARMOR slots; needs public version of SlotArmor copy and paste the
		// vanilla code into a new class and change what you need
		// for (i = 0; i < 4; ++i) {
		// this.addSlotToContainer(new SlotArmor(player, inventoryPlayer,
		// inventoryPlayer.getSizeInventory() - 1 - i, 8, 8 + i * 18,
		// i));
		// }
		// Adds PLAYER INVENTORY
		for (i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(inventoryPlayer,
						j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		// Adds ACTION BAR
		for (i = 0; i < 9; ++i) {
			this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18,
					142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

	/**
	 * Called when a player shift-clicks on a slot. You must override this or
	 * you will crash when someone does that. Basically the same as every other
	 * container I make, since I define the same constant indices for all of
	 * them
	 */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (par2 < INV_START) {
				// try to place in player inventory / action bar
				if (!this.mergeItemStack(itemstack1, INV_START, HOTBAR_END + 1,
						true)) {
					return null;
				}
				slot.onSlotChange(itemstack1, itemstack);
			} else {
				// if item is our custom item
				if (itemstack1.getItem() instanceof Jutsu) {
					if (!this.mergeItemStack(itemstack1, 0, JutsuInv.INV_SIZE,
							false)) {
						return null;
					}
				}
				// if item is armor
				else if (itemstack1.getItem() instanceof ItemArmor) {
					int type = ((ItemArmor) itemstack1.getItem()).armorType;
					if (!this.mergeItemStack(itemstack1, ARMOR_START + type,
							ARMOR_START + type + 1, false)) {
						return null;
					}
				}
				// item in player's inventory
				else if (par2 >= INV_START && par2 < HOTBAR_START) {
					// place in action bar
					if (!this.mergeItemStack(itemstack1, HOTBAR_START,
							HOTBAR_START + 1, false)) {
						return null;
					}
				}
				// item in action bar
				else if (par2 >= HOTBAR_START && par2 < HOTBAR_END + 1) {
					if (!this.mergeItemStack(itemstack1, INV_START,
							INV_END + 1, false)) {
						return null;
					}
				}
			}
			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}
			if (itemstack1.stackSize == itemstack.stackSize) {
				return null;
			}
			slot.onPickupFromSlot(player, itemstack1);
		}
		return itemstack;
	}
}
