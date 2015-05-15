package pl.grm.narutocraft.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.IChatComponent;

public class JutsuInv implements IInventory {

	private final String name = "Jutsu Panel";
	private final String tagName = "JutsuPanel";
	public static final int INV_SIZE = 5;
	private ItemStack[] inventory = new ItemStack[INV_SIZE];

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			if (stack.stackSize > amount) {
				stack = stack.splitStack(amount);
				if (stack.stackSize == 0) {
					setInventorySlotContents(slot, null);
				}
			} else {
				setInventorySlotContents(slot, null);
			}

			this.markDirty();
		}
		return stack;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public int getSizeInventory() {
		return this.inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.inventory[slot];
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			setInventorySlotContents(slot, null);
		}
		return stack;
	}

	@Override
	public boolean hasCustomName() {
		return this.name.length() > 0;
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		// If different kinds of slots, then check them here:
		// if (slot == SLOT_SHIELD && itemstack.getItem() instance of
		// ItemShield) return true;
		// return itemstack.getItem() instanceof Jutsu;
		return true;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return true;
	}

	@Override
	public void markDirty() {
		for (int i = 0; i < this.getSizeInventory(); ++i) {
			if ((this.getStackInSlot(i) != null) && (this.getStackInSlot(i).stackSize == 0)) {
				this.setInventorySlotContents(i, null);
			}
		}
	}

	public void readFromNBT(NBTTagCompound compound) {
		NBTTagList items = compound.getTagList(this.tagName, compound.getId());
		for (int i = 0; i < items.tagCount(); ++i) {
			NBTTagCompound item = items.getCompoundTagAt(i);
			byte slot = item.getByte("Slot");
			if ((slot >= 0) && (slot < getSizeInventory())) {
				this.inventory[slot] = ItemStack.loadItemStackFromNBT(item);
			}
		}
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
		this.inventory[slot] = itemstack;

		if ((itemstack != null) && (itemstack.stackSize > this.getInventoryStackLimit())) {
			itemstack.stackSize = this.getInventoryStackLimit();
		}
		this.markDirty();
	}

	public void writeToNBT(NBTTagCompound compound) {
		NBTTagList items = new NBTTagList();

		for (int i = 0; i < getSizeInventory(); ++i) {
			if (getStackInSlot(i) != null) {
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Slot", (byte) i);
				getStackInSlot(i).writeToNBT(item);
				items.appendTag(item);
			}
		}
		compound.setTag(this.tagName, items);
	}

	@Override
	public IChatComponent getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void openInventory(EntityPlayer playerIn) {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeInventory(EntityPlayer playerIn) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}
}
