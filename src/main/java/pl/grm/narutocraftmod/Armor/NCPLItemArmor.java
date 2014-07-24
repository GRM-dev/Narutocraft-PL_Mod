package pl.grm.narutocraftmod.Armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.Libs.RegItems;

public class NCPLItemArmor extends ItemArmor {
	
	public NCPLItemArmor (ArmorMaterial armormaterial, int ID, int placement) {
		
		super(armormaterial, ID, placement);
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		
		if (placement == 0) { this.setTextureName("narutocraftmod:helmetBushido"); }
		else if (placement == 1) { this.setTextureName("narutocraftmod:chestplateBushido"); }
		else if (placement == 2) { this.setTextureName("narutocraftmod:legginsBushido"); }
		else if (placement == 3) { this.setTextureName("narutocraftmod:bootsBushido"); }
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem() == RegItems.helmetBushido || stack.getItem() == RegItems.plateBushido || stack.getItem() == RegItems.bootsBushido) 
		{		
			return "narutocraftmod:textures/model/BushidoArmor.1.png";
		}
		if (stack.getItem() == RegItems.legsBushido)
		{
			return "narutocraftmod:textures/model/BushidoArmor.2.png";
		} 
		else
			return null;
	}
	
}
