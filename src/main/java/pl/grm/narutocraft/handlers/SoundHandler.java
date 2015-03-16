package pl.grm.narutocraft.handlers;

import net.minecraft.entity.*;
import net.minecraft.world.*;

public class SoundHandler {
	public static void onEntityPlay(String name, World world, Entity entity,
			float volume, float pitch) {
		world.playSoundAtEntity(entity, ("narutocraftmod:" + name), volume, pitch);
	}
}
