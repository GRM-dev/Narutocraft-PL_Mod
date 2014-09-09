package pl.grm.narutocraft.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Meisaigakure extends Jutsu implements IJutsu {
	private ItemStack stack;
	private World world;
	private EntityPlayer player;
	private int chackraConsumption = 5;
	private boolean active = false;
	private int jutsuID;
	private int totalDuration;
	private int passDuration;

	public Meisaigakure() {
		this.setUnlocalizedName("Meisaigakure");
		this.setTextureName(jutsuLoc + "Meisaigakure");
		this.jutsuID = JutsuList.MEISAIGAKURE.getID();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		this.stack = stack;
		this.world = world;
		this.player = player;

		if (!world.isRemote) {
			activateJutsu();
			// ExtendedProperties.activeJutsus.put(passDuration);
		}
		return stack;
	}
}