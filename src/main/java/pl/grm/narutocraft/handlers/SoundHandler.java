package pl.grm.narutocraft.handlers;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class SoundHandler {
	public static void onEntityPlay(String name, World world, Entity entity,
			float volume, float pitch) {
		world.playSoundAtEntity(entity, ("narutocraftmod:" + name), volume,
				pitch);
	}
}
