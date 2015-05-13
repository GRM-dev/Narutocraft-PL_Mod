package pl.grm.narutocraft.gui.stats;

import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;

public class ContainerNull extends Container {
	public ContainerNull() {}
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}
	
	@Override
	public Slot getSlot(int par1) {
		return null;
	}
	
	@Override
	public void putStackInSlot(int par1, ItemStack par2ItemStack) {}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		return null;
	}
}
