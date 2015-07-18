package pl.grm.narutocraft.items.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.registry.RegArmor;

/**
 * Adds Armor items
 *
 * @author Admaster
 */
public class NCPLItemArmor extends ItemArmor {

	
	

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
	public NCPLItemArmor(ArmorMaterial armormaterial, int ID, int placement) {
		super(armormaterial, ID, placement);
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.setMaxStackSize(1);
		
		
		
	}

	

	
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		
		if(stack.getItem() == RegArmor.HelmetRyu)
		{
			return "narutocraft:textures/models/armors/RyuArmor_layer_1.png";
		}
		else if(stack.getItem() == RegArmor.ChestplateRyu)
		{
			return "narutocraft:textures/models/armors/RyuArmor_layer_1.png";
			
		}
		else if(stack.getItem() == RegArmor.LegginsRyu)
		{
			return "narutocraft:textures/models/armors/RyuArmor_layer_2.png";
		}
		else if(stack.getItem() == RegArmor.BootsRyu)
		{
			return "narutocraft:textures/models/armors/RyuArmor_layer_1.png";
		}
		else
		{
			return null;
		}
		/*if (this.armorSlot != 2) { return "narutocraft:textures/model/" + this.modelTexture + "_1.png"; }
		return "narutocraft:textures/model/" + this.modelTexture + "_2.png";*/
	}
}
