package pl.grm.narutocraft.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.libs.References;

/**
 * Adds Armor items
 * 
 * @author Admaster
 *
 */
public class NCPLItemArmor extends ItemArmor {
	private int armorSlot = 0;
	private String modelTexture;
	/**
	 * Create Armor Item
	 * 
	 * @param armormaterial
	 *            materia³ zbroi
	 * @param ID
	 *            ID armora
	 * @param placement
	 *            placement of part of armor from head = 0
	 * @param itemTextureName
	 *            this is the displayed icon of the armor for held and
	 *            inventories
	 * @param modelTextureName
	 *            the base texture name for what is rendered on the player, _1
	 *            is helm, chest, and boots. _2 is pants.
	 */
	public NCPLItemArmor(ArmorMaterial armormaterial, int ID, int placement,
			String itemTextureName, String modelTextureName) {
		super(armormaterial, ID, placement);
		this.setCreativeTab(NarutoCraft.mTabNarutoCraftMod);
		this.setMaxStackSize(1);
		armorSlot = placement;
		modelTexture = modelTextureName;
		switch (placement) {
			case 0 :
				this.setTextureName(References.ModTexturePath + "armor/helmet"
						+ itemTextureName);
				break;
			case 1 :
				this.setTextureName(References.ModTexturePath
						+ "armor/chestplate" + itemTextureName);
				break;
			case 2 :
				this.setTextureName(References.ModTexturePath + "armor/pants"
						+ itemTextureName);
				break;
			case 3 :
				this.setTextureName(References.ModTexturePath + "armor/boots"
						+ itemTextureName);
				break;
		}
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {
		if (armorSlot != 2)
			return "narutocraft:textures/model/" + modelTexture + "_1.png";
		else
			return "narutocraft:textures/model/" + modelTexture + "_2.png";

		/*
		 * if (stack.getItem() == RegItems.helmetBushido || stack.getItem() ==
		 * RegItems.plateBushido || stack.getItem() == RegItems.bootsBushido) {
		 * return "narutocraftmod:textures/model/BushidoArmor.1.png"; } if
		 * (stack.getItem() == RegItems.legsBushido) { return
		 * "narutocraftmod:textures/model/BushidoArmor.2.png"; } if
		 * (stack.getItem() == RegItems.helmetAnbu1 || stack.getItem() ==
		 * RegItems.helmetAnbu2 || stack.getItem() == RegItems.helmetAnbu3 ||
		 * stack.getItem() == RegItems.helmetAnbu4 || stack.getItem() ==
		 * RegItems.plateAnbu || stack.getItem() == RegItems.bootsAnbu) { return
		 * "narutocraftmod:textures/model/AnbuArmor.1.png"; } if
		 * (stack.getItem() == RegItems.legsAnbu) { return
		 * "narutocraftmod:textures/model/AnbuArmor.2.png"; } if
		 * (stack.getItem() == RegItems.plateKiri || stack.getItem() ==
		 * RegItems.legsKiri) { return "narutocraftmod:textures/model/Kiri.png";
		 * } if (stack.getItem() == RegItems.plateSuna || stack.getItem() ==
		 * RegItems.legsSuna) { return "narutocraftmod:textures/model/Suna.png";
		 * } if (stack.getItem() == RegItems.helmetAkatsuki || stack.getItem()
		 * == RegItems.plateAkatsuki || stack.getItem() ==
		 * RegItems.plateAkatsuki2 || stack.getItem() == RegItems.plateAkatsuki3
		 * || stack.getItem() == RegItems.bootsAkatsuki) { return
		 * "narutocraftmod:textures/model/AkatsukiArmor.1.png";
		 * 
		 * }else { return null; }
		 */

	}

}
