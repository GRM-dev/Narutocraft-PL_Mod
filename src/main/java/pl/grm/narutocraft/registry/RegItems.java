package pl.grm.narutocraft.registry;

import net.minecraft.item.*;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.fml.common.registry.*;
import pl.grm.narutocraft.*;
import pl.grm.narutocraft.items.*;
import pl.grm.narutocraft.libs.config.*;

public class RegItems extends NarutoCraft {
	/** Zwoj - scroll **/
	public static Item			FZwoj		= new FScroll();
	
	public static Item			KZwoj		= new KScroll();
	
	public static Item			DZwoj		= new DScroll();
	public static Item			SZwoj		= new SScroll();
	public static Item			RZwoj		= new RScroll();
	public static Item			NZwoj		= new NScroll();
	
	public static ArmorMaterial	Bushido		= Materials.armorBUSHIDO;
	public static ArmorMaterial	Anbu		= Materials.armorANBU;
	public static ArmorMaterial	Kiri		= Materials.armorKIRI;
	public static ArmorMaterial	Suna		= Materials.armorSUNA;
	public static ArmorMaterial	Akatsuki	= Materials.armorAKATSUKI;
	public static ArmorMaterial	Iwa			= Materials.armorIWA;
	public static ArmorMaterial	Konoha		= Materials.armorKONOHA;
	public static ArmorMaterial	Oto			= Materials.armorOTO;
	public static ArmorMaterial	Old			= Materials.armorOLD;
	public static ArmorMaterial	Kumo		= Materials.armorKUMO;
	public static ArmorMaterial	Ryuu		= Materials.armorRYUU;
	
	// public static int renderBushidoArmor = proxy.addArmor("Bushido");
	// public static Item = new (id+);
	
	public static void registerItem(Item item, String name) {
		GameRegistry.registerItem(item, name);
	}
	
	public static void regItemsList() {
		
		// registerItem(, "");
		registerItem(FZwoj, "FZwoj");
		registerItem(KZwoj, "KZwoj");
		registerItem(DZwoj, "DZwoj");
		registerItem(SZwoj, "SZwoj");
		registerItem(RZwoj, "RZwoj");
		registerItem(NZwoj, "NZwoj");
		// registerItem(, "");
	}
}
