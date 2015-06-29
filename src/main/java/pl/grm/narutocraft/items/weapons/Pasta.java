package pl.grm.narutocraft.items.weapons;

import pl.grm.narutocraft.NarutoCraft;
import net.minecraft.item.ItemFood;

public class Pasta extends ItemFood{

	public Pasta() {
		super(0, 0.0F, false);
		// TODO Auto-generated constructor stub
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.setUnlocalizedName("Pasta");
	}

}
