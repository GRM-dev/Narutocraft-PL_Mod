package pl.grm.narutocraft.blocks;

import java.util.*;

import net.minecraft.block.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraftforge.fml.relauncher.*;

/**
 * Carpet block class.
 */
public class CustomCarpet extends BlockCarpet {
	public CustomCarpet() {
		super();
		this.setUnlocalizedName("Carpet");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
	}
}
