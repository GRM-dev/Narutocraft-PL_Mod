package pl.grm.narutocraft.items.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.libs.References;

/**
 * Adds Armor items
 *
 * @author Admaster
 */
public class NCPLItemArmor extends ItemArmor {
	private int		armorSlot	= 0;
	private String	modelTexture;
	
	public NCPLItemArmor(ArmorMaterial armormaterial, int ID, int placement) {
		this(armormaterial, ID, placement, "Test");
	}
	
	public NCPLItemArmor(ArmorMaterial armormaterial, int ID, int placement,
			String modelTextureName) {
		this(armormaterial, ID, placement, "Test", modelTextureName);
	}
	
	/**
	 * Create Armor Item
	 *
	 * @param armormaterial
	 *            material zbroi
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
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.setMaxStackSize(1);
		this.armorSlot = placement;
		this.modelTexture = modelTextureName;
		
		switch (placement) {
			case 0 :
				this.setTextureName(References.ModTexturePath + "armor/helmet"
						+ itemTextureName);
				break;
			case 1 :
				this.setTextureName(References.ModTexturePath + "armor/chestplate"
						+ itemTextureName);
				break;
			case 2 :
				this.setTextureName(References.ModTexturePath + "armor/pants"
						+ itemTextureName);
				break;
			case 3 :
				this.setTextureName(References.ModTexturePath + "armor/boots"
						+ itemTextureName);
				break;
			default :
				break;
		}
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (this.armorSlot != 2) { return "narutocraft:textures/model/"
				+ this.modelTexture + "_1.png"; }
		return "narutocraft:textures/model/" + this.modelTexture + "_2.png";
	}
}
