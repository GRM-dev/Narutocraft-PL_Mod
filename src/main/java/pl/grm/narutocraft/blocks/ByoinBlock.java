package pl.grm.narutocraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import pl.grm.narutocraft.NarutoCraft;

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
