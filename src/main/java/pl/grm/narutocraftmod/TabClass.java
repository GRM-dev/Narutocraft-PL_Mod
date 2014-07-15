package pl.grm.narutocraftmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import pl.grm.narutocraftmod.Libs.RegPowers;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabClass extends CreativeTabs {

public TabClass(int par1, String par2Str) {
super(par1, par2Str);

}

@SideOnly(Side.CLIENT)
public ItemStack getIconItemStack()
{
return (new ItemStack(RegPowers.Sharingan));

}

public String getTranslatedTabLabel()
{
return "NarutoCraft";
}

@Override
public Item getTabIconItem() {
	// TODO Auto-generated method stub
	return null;
}


}