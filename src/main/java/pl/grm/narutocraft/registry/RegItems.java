package pl.grm.narutocraft.registry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.items.DScroll;
import pl.grm.narutocraft.items.FScroll;
import pl.grm.narutocraft.items.KScroll;
import pl.grm.narutocraft.items.NScroll;
import pl.grm.narutocraft.items.RScroll;
import pl.grm.narutocraft.items.SScroll;
import pl.grm.narutocraft.libs.config.Materials;
import pl.grm.narutocraft.libs.config.References;

public class RegItems extends NarutoCraft {

	public static Item FScroll = new FScroll();
	public static Item KScroll = new KScroll();
	public static Item DScroll = new DScroll();
	public static Item SScroll = new SScroll();
	public static Item RScroll = new RScroll();
	public static Item NScroll = new NScroll();

	public static ArmorMaterial Bushido = Materials.armorBUSHIDO;
	public static ArmorMaterial Anbu = Materials.armorANBU;
	public static ArmorMaterial Kiri = Materials.armorKIRI;
	public static ArmorMaterial Suna = Materials.armorSUNA;
	public static ArmorMaterial Akatsuki = Materials.armorAKATSUKI;
	public static ArmorMaterial Iwa = Materials.armorIWA;
	public static ArmorMaterial Konoha = Materials.armorKONOHA;
	public static ArmorMaterial Oto = Materials.armorOTO;
	public static ArmorMaterial Old = Materials.armorOLD;
	public static ArmorMaterial Kumo = Materials.armorKUMO;
	public static ArmorMaterial Ryuu = Materials.armorRYUU;

	// public static int renderBushidoArmor = proxy.addArmor("Bushido");
	// public static Item = new (id+);

	protected static void registerItem(Item item, String name) {
		GameRegistry.registerItem(item, name);
	}

	protected static void registerRendererToItem(Item item, String name) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
				.register(item, 0, new ModelResourceLocation(References.ModTexturePath + name, "inventory"));
	}

	public static void regItemsList() {
		// registerItem(, "");
		registerItem(FScroll, "FScroll");
		registerItem(KScroll, "KScroll");
		registerItem(DScroll, "DScroll");
		registerItem(SScroll, "SScroll");
		registerItem(RScroll, "RScroll");
		registerItem(NScroll, "NScroll");
		// registerItem(, "");
	}

	public static void regRenderers() {
		registerRendererToItem(KScroll, "KScroll");
	}
}
