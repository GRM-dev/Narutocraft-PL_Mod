package pl.grmdev.narutocraft.registry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;
import pl.grmdev.narutocraft.NarutoCraft;
import pl.grmdev.narutocraft.blocks.ByoinBlock;
import pl.grmdev.narutocraft.blocks.CustomCarpet;
import pl.grmdev.narutocraft.blocks.CustomPane;
import pl.grmdev.narutocraft.libs.config.References;

public class RegBlocks extends NarutoCraft {

	public static Block byoinBlock;

	public static Block shoji;
	public static Block tatami;

	public static void regBlocksList() {
		byoinBlock = new ByoinBlock();
		shoji = new CustomPane(References.ModTexturePath + "shoji", References.ModTexturePath + "shoji_top",
				Material.wood, false).setCreativeTab(mTabNarutoCraft);
		tatami = new CustomCarpet().setCreativeTab(mTabNarutoCraft);

		GameRegistry.registerBlock(byoinBlock, byoinBlock.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(shoji, shoji.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(tatami, tatami.getUnlocalizedName().substring(5));
		// TODO lang files need to translate shoji and tatami
	}

	public static void regRenderers() {
		// TODO Auto-generated method stub

	}
}