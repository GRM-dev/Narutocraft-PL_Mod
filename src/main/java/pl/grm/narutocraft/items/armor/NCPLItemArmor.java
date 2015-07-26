package pl.grm.narutocraft.items.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.registry.RegArmor;
import pl.grm.narutocraft.registry.RegItems;

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
		
		if(stack.getItem() == RegItems.HelmetRyu)
		{
			return "narutocraft:textures/models/armors/RyuArmor_layer_1.png";
		}
		else if(stack.getItem() == RegItems.ChestplateRyu)
		{
			return "narutocraft:textures/models/armors/RyuArmor_layer_1.png";
			
		}
		else if(stack.getItem() == RegItems.LegginsRyu)
		{
			return "narutocraft:textures/models/armors/RyuArmor_layer_2.png";
		}
		else if(stack.getItem() == RegItems.BootsRyu)
		{
			return "narutocraft:textures/models/armors/RyuArmor_layer_1.png";
		}
		else if(stack.getItem() == RegItems.HelmetBushido)
		{
			return "narutocraft:textures/models/armors/BushidoArmor_layer_1.png";
		}
		else if(stack.getItem() == RegItems.ChestplateBushido)
		{
			return "narutocraft:textures/models/armors/BushidoArmor_layer_1.png";
		}
		else if(stack.getItem() == RegItems.LegginsBushido)
		{
			return "narutocraft:textures/models/armors/BushidoArmor_layer_2.png";
		}
		else if(stack.getItem() == RegItems.BootsBushido)
		{
			return "narutocraft:textures/models/armors/BushidoArmor_layer_1.png";
		}
		else if(stack.getItem() == RegItems.HelmetAnbu)
		{
			return "narutocraft:textures/models/armors/HelmetAnbu.png";
		}
		else if(stack.getItem() == RegItems.HelmetAnbu2)
		{
			return "narutocraft:textures/models/armors/HelmetAnbu2.png";
		}
		else if(stack.getItem() == RegItems.HelmetAnbu3)
		{
			return "narutocraft:textures/models/armors/HelmetAnbu3.png";
		}
		else if(stack.getItem() == RegItems.HelmetAnbu4)
		{
			return "narutocraft:textures/models/armors/HelmetAnbu4.png";
		}
		else if(stack.getItem() == RegItems.ChestplateAnbu)
		{
			return "narutocraft:textures/models/armors/AnbuArmor_layer_1,png";
		}
		else if(stack.getItem() == RegItems.LegginsAnbu)
		{
			return "narutocraft:textures/models/armors/AnbuArmor_layer_2.png";
		}
		else if(stack.getItem() == RegItems.BootsAnbu)
		{
			return "narutocraft:textures/models/armors/AnbuArmor_layer_1.png";
		}
		else if(stack.getItem() == RegItems.HelmetAkatsuki)
		{
			return "narutocraft:textures/models/armors/AkatsukiArmor1_layer_1.png";
		}
		else if(stack.getItem() == RegItems.HelmetAkatsuki2)
		{
			return "narutocraft:textures/models/armors/AkatsukiArmor2_layer_1.png";
		}
		else if(stack.getItem() == RegItems.HelmetAkatsuki3)
		{
			return "narutocraft:textures/models/armors/AkatsukiArmor3_layer_1.png";
		}
		else if(stack.getItem() == RegItems.ChestplateAkatsuki)
		{
			return "narutocraft:textures/models/armors/AkatsukiArmor1_layer_1.png";
		}
		else if(stack.getItem() == RegItems.ChestplateAkatsuki2)
		{
			return "narutocraft:textures/models/armors/AkatsukiArmor2_layer_1.png";
		}
		else if(stack.getItem() ==RegItems.ChestplateAkatsuki3)
		{
			return "narutocraft:textures/models/armors/AkatsukiArmor3_layer_1.png";
		}
		else if(stack.getItem() == RegItems.ChestplateAkatsuki4)
		{
			return "narutocraft:textures/models/armors/AkatsukiArmor4_layer_1.png";
		}
		else if(stack.getItem() == RegItems.LegginsAkatsuki)
		{
			return "narutocraft:textures/models/armors/AkatsukiArmor_layer_2.png";
		}
		else if(stack.getItem()== RegItems.BootsAkatsuki)
		{
			return "narutocraft:textures/models/armors/AkatsukiArmor1_layer_1.png";
		}
		else if(stack.getItem() == RegItems.ChestplateKonoha)
		{
			return "narutocraft:textures/models/armors/KonohaArmor_layer_1.png";
		}
		else if(stack.getItem() ==RegItems.LegginsKonoha)
		{
			return "narutocraft:textures/models/armors/KonohaArmor_layer_2.png";
		}
		else if(stack.getItem() ==RegItems.BootsKonoha)
		{
			return "narutocraft:textures/models/armors/KonohaArmor_layer_1.png";
		}
		else if(stack.getItem() ==RegItems.ChestplateIwa)
		{
			return "narutocraft:textures/models/armors/IwaArmor_layer_1.png";
		}
		else if(stack.getItem() ==RegItems.LegginsIwa)
		{
			return "narutocraft:textures/models/armors/IwaArmor_layer_2.png";
		}
		else if(stack.getItem() ==RegItems.BootsIwa)
		{
			return "narutocraft:textures/models/armors/IwaArmor_layer_1.png";
		}
		else if(stack.getItem() ==RegItems.ChestplateKiri)
		{
			return "narutocraft:textures/models/armors/KiriArmor_layer_1.png";
		}
		else if(stack.getItem() ==RegItems.LegginsKiri)
		{
			return "narutocraft:textures/models/armors/KiriArmor_layer_2.png";
		}
		else if(stack.getItem() ==RegItems.BootsKiri)
		{
			return "narutocraft:/texutres/models/armors/KiriArmor_layer_1.png";
		}
		else if(stack.getItem() ==RegItems.ChestplateKumo)
		{
			return "narutocraft:textures/models/armors/KumoArmor_layer_1.png";
		}
		else if(stack.getItem() ==RegItems.LegginsKumo)
		{
			return "narutocraft:textures/models/armors/KumoArmor_layer_2.png";
		}
		else if(stack.getItem() ==RegItems.BootsKumo)
		{
			return "narutocraft:textures/models/armors/KumoArmor_layer_1.png";
		}
		else if(stack.getItem() ==RegItems.ChestplateOld)
		{
			return "narutocraft:textures/models/armors/OldArmor_layer_1.png";
		}
		else if(stack.getItem() ==RegItems.LegginsOld)
		{
			return "narutocraft:textures/models/armors/OldArmor_layer_2.png";
		}
		else if(stack.getItem() == RegItems.BootsOld)
		{
			return "narutocraft:textures/models/armors/OldArmor_layer_1.png";
		}
		else if(stack.getItem() == RegItems.ChestplateOto)
		{
			return "narutocraft:textures/models/armors/OtoArmor_layer_1.png";
		}
		else if(stack.getItem() ==RegItems.LegginsOto)
		{
			return "narutocraft:textures/models/armors/OtoArmor_layer_2.png";
		}
		else if(stack.getItem() ==RegItems.BootsOto)
		{
			return "narutocraft:textures/models/armors/OtoArmor_layer_1.png";
		}
		else if(stack.getItem() ==RegItems.ChestplateSuna)
		{
			return "narutocraft:textures/models/armors/SunaArmor_layer_1.png";
		}
		else if(stack.getItem() ==RegItems.LegginsSuna)
		{
			return "narutocraft:textures/models/armors/SunaArmor_layer_2.png";
		}
		else if(stack.getItem() ==RegItems.BootsSuna)
		{
			return "narutocraft:textures/models/armors/SunaArmor_layer_1.png";
		}
		else
		{
			return null;
		}
		
	}
}
