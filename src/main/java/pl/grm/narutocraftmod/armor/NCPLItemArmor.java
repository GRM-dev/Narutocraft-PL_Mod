package pl.grm.narutocraftmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.libs.registry.RegItems;

/**
 * Adds Armor items
 * @author Admaster
 *
 */
public class NCPLItemArmor extends ItemArmor {
	private String armorTex = "narutocraftmod:armor/";
	/**
	 * Create Armor Item
	 * @param armormaterial materia³ zbroi
	 * @param ID ID armora
	 * @param placement placement of part of armor from head = 0
	 */
	public NCPLItemArmor(ArmorMaterial armormaterial, int ID, int placement) {
		super(armormaterial, ID, placement);
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		
		if (placement == 0) {
			this.setTextureName(armorTex + "helmet" + armormaterial);
		} else if (placement == 1) {
			this.setTextureName(armorTex + "chestplate" + armormaterial);
		} else if (placement == 2) {
			this.setTextureName(armorTex + "leggins" + armormaterial);
		} else if (placement == 3) {
			this.setTextureName(armorTex + "boots" + armormaterial);
		}
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {
		if (stack.getItem() == RegItems.helmetBushido
				|| stack.getItem() == RegItems.plateBushido
				|| stack.getItem() == RegItems.bootsBushido) {
			return "narutocraftmod:textures/model/BushidoArmor.1.png";
		}
		if (stack.getItem() == RegItems.legsBushido) {
			return "narutocraftmod:textures/model/BushidoArmor.2.png";
		}
		if (stack.getItem() == RegItems.helmetAnbu1
				|| stack.getItem() == RegItems.helmetAnbu2
				|| stack.getItem() == RegItems.helmetAnbu3
				|| stack.getItem() == RegItems.helmetAnbu4
				|| stack.getItem() == RegItems.plateAnbu
				|| stack.getItem() == RegItems.bootsAnbu) {
			return "narutocraftmod:textures/model/AnbuArmor.1.png";
		}
		if (stack.getItem() == RegItems.legsAnbu) {
			return "narutocraftmod:textures/model/AnbuArmor.2.png";
		}
		if (stack.getItem() == RegItems.plateKiri
				|| stack.getItem() == RegItems.legsKiri) {
			return "narutocraftmod:textures/model/Kiri.png";
		}
		if (stack.getItem() == RegItems.plateSuna
				|| stack.getItem() == RegItems.legsSuna) {
			return "narutocraftmod:textures/model/Suna.png";
		}
		if (stack.getItem() == RegItems.helmetAkatsuki
				|| stack.getItem() == RegItems.plateAkatsuki
				|| stack.getItem() == RegItems.plateAkatsuki2
				|| stack.getItem() == RegItems.plateAkatsuki3
				|| stack.getItem() == RegItems.bootsAkatsuki) {
			return "narutocraftmod:textures/model/AkatsukiArmor.1.png";
		
		}else {
			return null;
		}
		
	}

}
