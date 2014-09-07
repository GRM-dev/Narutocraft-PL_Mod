package pl.grm.narutocraft.jutsu;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import pl.grm.narutocraft.effects.IEffect;
import pl.grm.narutocraft.effects.Invisible;
import pl.grm.narutocraft.libs.ExtendedProperties;

public class Meisaigakure extends Jutsu implements IJutsu {
	private Map<IJutsu, IEffect> effects;
	private ItemStack stack;
	private World world;
	private EntityPlayer player;
	private boolean active = false;

	public Meisaigakure(int i) {
		this.setUnlocalizedName("Meisaigakure");
		this.setTextureName(jutsuLoc + "Meisaigakure");
		effects = new HashMap<IJutsu, IEffect>();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		this.stack = stack;
		this.world = world;
		this.player = player;

		if (!world.isRemote) {
			uploadEffects();
			effects.get(this).action();
			ExtendedProperties.activeEffects.putAll(effects);
		}
		return stack;
	}

	@Override
	public void uploadEffects() {
		setEffect(new Invisible(14, 200, stack, world, player));
		this.setActive(true);
	}

	@Override
	public Map<IJutsu, IEffect> getEffects() {
		return effects;
	}

	@Override
	public void setEffect(IEffect effect) {
		this.effects.put(this, effect);
	}

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void setActive(boolean par) {
		this.active = par;
	}

	@Override
	public void onJutsuUpdate() {
		effects.get(this).onEffectUpdate();
		if (effects.get(this).isEnded())
			setActive(false);
	}
}