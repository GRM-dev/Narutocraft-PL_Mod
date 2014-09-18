package pl.grm.narutocraft.jutsu.ninjutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.jutsu.Jutsu;
import pl.grm.narutocraft.jutsu.JutsuList;

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
	public void activateJutsu() {
		this.player.addPotionEffect(new PotionEffect(10, 10));
		this.setPotionEffect("Invisible");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		this.stack = stack;
		this.world = world;
		this.player = player;

		if (!world.isRemote) {
			this.activateJutsu();
		}
		return stack;
	}
}