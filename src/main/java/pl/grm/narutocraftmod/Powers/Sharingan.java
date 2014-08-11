package pl.grm.narutocraftmod.Powers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.HUD.GuiBasic;

public class Sharingan extends Item{

	public Sharingan(int i) {
		super();
		this.setUnlocalizedName("Sharingan");
		this.setTextureName("narutocraftmod:Sharingan");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 1;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 1; 
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,EntityPlayer player) {
		if (!world.isRemote)
        {
			player.openGui(NarutoCraftMod.instance, GuiBasic.GUI_CUSTOM_INV, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
        }
    	return stack;
	}
	
}
