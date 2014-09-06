package pl.grm.narutocraft.network;

import java.util.HashMap;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import pl.grm.narutocraft.handlers.NetHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class ServerTickHandler {
	private boolean firstTick = true;
	public static HashMap<EntityLiving, EntityLivingBase> targetsToSet = new HashMap<EntityLiving, EntityLivingBase>();
	public static String lastWorldName;

	private void gameTick_Start() {
		if (MinecraftServer.getServer().getFolderName() != lastWorldName) {
			lastWorldName = MinecraftServer.getServer().getFolderName();
			this.firstTick = true;
		}
		if (this.firstTick) {
			this.firstTick = false;
		}
		// NarutoCraft.proxy.itemFrameWatcher.checkWatchedFrames();
	}

	private void gameTick_End() {

	}

	@SubscribeEvent
	public void onServerTick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.START) {
			gameTick_Start();
		} else if (event.phase == TickEvent.Phase.END) {
			gameTick_End();
		}
	}

	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {

	}

	public void addDeferredTarget(EntityLiving ent, EntityLivingBase target) {
		targetsToSet.put(ent, target);
	}

	public void blackoutArmorPiece(EntityPlayerMP player, int slot, int cooldown) {
		NetHandler.INSTANCE.sendPacketToClientPlayer(player, (byte) 9,
				new DataWriter().add(slot).add(cooldown).generate());
	}
}
