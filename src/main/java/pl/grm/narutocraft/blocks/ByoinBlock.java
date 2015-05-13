package pl.grm.narutocraft.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraftforge.fml.relauncher.*;
import pl.grm.narutocraft.*;

/**
 * Hospital block. You cure when you stand on it.
 */
public class ByoinBlock extends Block {
	
	@SideOnly(Side.CLIENT)
	public ByoinBlock() {
		super(Material.rock);
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.setUnlocalizedName("byoin");
	}
	
}
