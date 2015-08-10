package pl.grm.narutocraft.items.weapons;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import pl.grm.narutocraft.libs.config.Materials;

public class Kurosawa extends SwordMain {

	public Kurosawa() {
		super(Materials.metalsamurajow);
		this.setMaxDamage(-1);

	}
}