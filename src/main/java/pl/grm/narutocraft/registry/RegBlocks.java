package pl.grm.narutocraft.registry;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraftforge.fml.common.registry.*;
import pl.grm.narutocraft.*;
import pl.grm.narutocraft.blocks.*;
import pl.grm.narutocraft.libs.config.*;

public class RegBlocks extends NarutoCraft {
	public static Block	byoinBlock;
	
	public static Block	shoji;
	public static Block	tatami;
	
	public static void regBlocksList() {
		byoinBlock = new ByoinBlock();
		shoji = new CustomPane(References.ModTexturePath + "shoji", References.ModTexturePath
				+ "shoji_top", Material.wood, false).setCreativeTab(mTabNarutoCraft);
		tatami = new CustomCarpet().setCreativeTab(mTabNarutoCraft);
		
		GameRegistry.registerBlock(byoinBlock, byoinBlock.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(shoji, shoji.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(tatami, tatami.getUnlocalizedName().substring(5));
		// TODO lang files need to translate shoji and tatami
	}
}