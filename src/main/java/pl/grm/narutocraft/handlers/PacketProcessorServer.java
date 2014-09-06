package pl.grm.narutocraft.handlers;

import io.netty.buffer.ByteBufInputStream;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.world.WorldServer;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.items.ItemJutsuBook;
import pl.grm.narutocraft.libs.ExtendedPlayer;
import pl.grm.narutocraft.libs.registry.RegJutsus;
import pl.grm.narutocraft.network.DataReader;
import pl.grm.narutocraft.network.DataWriter;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.server.FMLServerHandler;

public class PacketProcessorServer {
	@SubscribeEvent
	public void onServerPacketData(FMLNetworkEvent.ServerCustomPacketEvent event) {
		ByteBufInputStream bbis = new ByteBufInputStream(event.packet.payload());
		byte packetID = -1;
		try {
			if (event.packet.getTarget() != Side.SERVER) {
				return;
			}
			packetID = bbis.readByte();
			NetHandlerPlayServer srv = (NetHandlerPlayServer) event.packet
					.handler();
			EntityPlayerMP player = srv.playerEntity;
			byte[] remaining = new byte[bbis.available()];
			bbis.readFully(remaining);
			switch (packetID) {
				case 1 :
					handleCastingModeChange(remaining, player);
					break;
				case 3 :
					handleMagicLevelUp(remaining, player);
					break;
				case 17 :
					handleSyncBetaParticles(remaining, player);
					break;
				case 29 :
					handlePossibleClientExpropDesync(remaining);
					break;
				case 31 :
					handleRequestBetaParticles(remaining, player);
					break;
				case 14 :
					handleSpellBookChangeActiveSlot(remaining, player);
					break;
				case 27 :
					handleSyncJutsuKnowledge(remaining, player);
					break;
				case 39 :
					ExtendedPlayer.For(player).TK_Distance = new DataReader(
							remaining).getFloat();
					break;
				case 16 :
					handleExpropOperation(remaining, player);
			}
			return;
		} catch (Throwable t) {
			FMLLog.severe("Ars Magica >> Server Packet Failed to Handle!",
					new Object[0]);
			FMLLog.severe("Ars Magica >> Packet Type: " + packetID,
					new Object[0]);
			t.printStackTrace();
		} finally {
			try {
				if (bbis != null) {
					bbis.close();
				}
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
	}

	private void handleExpropOperation(byte[] data, EntityPlayerMP player) {
		// ExtendedPlayer.For(player).performRemoteOp(
		// new DataReader(data, false).getInt());
	}

	private void handleSyncJutsuKnowledge(byte[] data, EntityPlayerMP player) {
		// Jutsu.For(player).handlePacketData(data);
	}

	private void handleSpellBookChangeActiveSlot(byte[] data,
			EntityPlayerMP player) {
		DataReader rdr = new DataReader(data, false);
		byte subID = rdr.getByte();
		int entityID = rdr.getInt();
		int inventorySlot = rdr.getInt();

		ItemStack stack = player.inventory.getStackInSlot(inventorySlot);
		if ((stack == null) || (!(stack.getItem() instanceof ItemJutsuBook))) {
			return;
		}
		// int newIndex = 0;
		// if (subID == 0) {
		// newIndex = RegItems.jutsuBook.SetNextSlot(stack);
		// } else if (subID == 1) {
		// newIndex = RegItems.jutsuBook.SetPrevSlot(stack);
		// } else {
		// }
	}

	private void handleRequestBetaParticles(byte[] data, EntityPlayerMP player) {
		DataReader rdr = new DataReader(data, false);
		int requesterID = rdr.getInt();
		int entityID = rdr.getInt();
		EntityLivingBase entity = getEntityByID(entityID);
		if ((player == null) || (entity == null)
				|| (!(entity instanceof EntityPlayer))) {
			return;
		}
		if (!NarutoCraft.proxy.playerTracker.hasAA((EntityPlayer) entity)) {
			return;
		}
		byte[] expropData = ExtendedPlayer.For(entity).getAuraData();

		DataWriter writer = new DataWriter();
		writer.add(entity.getEntityId());
		writer.add(expropData);

		NetHandler.INSTANCE.sendPacketToClientPlayer(player, (byte) 31,
				writer.generate());
	}

	private void handlePossibleClientExpropDesync(byte[] data) {
		DataReader rdr = new DataReader(data, false);
		int entityID = rdr.getInt();

		EntityLivingBase e = getEntityByID(entityID);
		if ((e != null) && ((e instanceof EntityPlayer))) {
			ExtendedPlayer props = ExtendedPlayer.For(e);
			// if (!props.detectPossibleDesync()) {
			// props.setFullSync();
			// props.forceSync();
			// }
		}
	}

	private void handleSyncBetaParticles(byte[] data, EntityPlayerMP player) {
		DataReader rdr = new DataReader(data, false);
		if ((player == null)
				|| (!NarutoCraft.proxy.playerTracker.hasAA(player))) {
			return;
		}
		int index = rdr.getInt();
		int behaviour = rdr.getInt();
		float scale = rdr.getFloat();
		float alpha = rdr.getFloat();
		boolean randomColor = rdr.getBoolean();
		boolean defaultColor = rdr.getBoolean();
		int color = rdr.getInt();
		int delay = rdr.getInt();
		int quantity = rdr.getInt();
		float speed = rdr.getFloat();

		ExtendedPlayer.For(player)
				.updateAuraData(index, behaviour, scale, alpha, randomColor,
						defaultColor, color, delay, quantity, speed);
	}

	private void handleCastingModeChange(byte[] data, EntityPlayerMP player) {
		DataReader rdr = new DataReader(data, false);
		int newShapeGroupOrdinal = rdr.getInt();
		int index = rdr.getInt();

		ItemStack stack = player.getCurrentEquippedItem();
		if (stack != null) {
			if (stack.getItem() == RegJutsus.jutsu) {

			}
		}
	}

	private void handleMagicLevelUp(byte[] data, EntityPlayerMP player) {
	}

	public WorldServer[] getWorldServers() {
		return FMLServerHandler.instance().getServer().worldServers;
	}

	public EntityLivingBase getEntityByID(int entityID) {
		return NarutoCraft.proxy.getEntityByID(entityID);
	}
}
