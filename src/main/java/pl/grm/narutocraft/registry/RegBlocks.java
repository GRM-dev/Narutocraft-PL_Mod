package pl.grm.narutocraft.registry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.blocks.ByoinBlock;
import pl.grm.narutocraft.blocks.CustomPane;
import pl.grm.narutocraft.blocks.CustomCarpet;
import pl.grm.narutocraft.libs.config.References;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegBlocks extends NarutoCraft {
	public static Block	byoinBlock;
	
	public static Block	shoji;
	public static Block	tatami;
	
	public static void regBlocksList() {
		byoinBlock = new ByoinBlock();
		shoji = new CustomPane(References.ModTexturePath + "shoji", References.ModTexturePath
				+ "shoji_top", Material.wood, false).setBlockName("shoji")
				.setCreativeTab(mTabNarutoCraft);
		tatami = new CustomCarpet().setBlockName("tatami")
				.setBlockTextureName(References.ModTexturePath + "tatami")
				.setCreativeTab(mTabNarutoCraft);
		
		GameRegistry.registerBlock(byoinBlock,
				byoinBlock.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(shoji, shoji.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(tatami, tatami.getUnlocalizedName().substring(5));
		//TODO lang files need to translate shoji and tatami
	}
}