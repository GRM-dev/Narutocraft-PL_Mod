package pl.grm.narutocraft.handlers;

import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import pl.grm.narutocraft.gui.math.Vector3D;
import pl.grm.narutocraft.network.DataWriter;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NetHandler {
	private static final String ChannelLabel = "NCPLDataTunnel";
	private static FMLEventChannel Channel;
	private boolean registeredChannels = false;
	public static final NetHandler INSTANCE = new NetHandler();

	public void init() {
		Channel = NetworkRegistry.INSTANCE
				.newEventDrivenChannel("NCPLDataTunnel");
	}

	public void registerChannels(PacketProcessorServer proc) {
		if (!this.registeredChannels) {
			this.registeredChannels = true;
			Channel.register(proc);
			FMLCommonHandler.instance().bus().register(proc);
		} else {
			FMLLog.info("NarutoCraft >> redundant call to register channels.",
					new Object[0]);
		}
	}

	public void sendPacketToClientPlayer(EntityPlayerMP player, byte packetID,
			byte[] data) {
		byte[] pkt_data = new byte[data.length + 1];
		pkt_data[0] = packetID;
		for (int i = 0; i < data.length; i++) {
			pkt_data[(i + 1)] = data[i];
		}
		FMLProxyPacket packet = new FMLProxyPacket(
				Unpooled.copiedBuffer(pkt_data), ChannelLabel);
		packet.setTarget(Side.CLIENT);
		Channel.sendTo(packet, player);
	}

	public void sendPacketToServer(byte packetID, byte[] data) {
		byte[] pkt_data = new byte[data.length + 1];

		pkt_data[0] = packetID;
		for (int i = 0; i < data.length; i++) {
			pkt_data[(i + 1)] = data[i];
		}
		FMLProxyPacket packet = new FMLProxyPacket(
				Unpooled.copiedBuffer(pkt_data), ChannelLabel);
		packet.setTarget(Side.SERVER);
		Channel.sendToServer(packet);
	}

	public void sendPacketToAllClientsNear(int dimension, double ox, double oy,
			double oz, double radius, byte packetID, byte[] data) {
		byte[] pkt_data = new byte[data.length + 1];
		pkt_data[0] = packetID;
		for (int i = 0; i < data.length; i++) {
			pkt_data[(i + 1)] = data[i];
		}
		FMLProxyPacket packet = new FMLProxyPacket(
				Unpooled.copiedBuffer(pkt_data), ChannelLabel);
		packet.setTarget(Side.CLIENT);
		Channel.sendToAllAround(packet, new NetworkRegistry.TargetPoint(
				dimension, ox, oy, oz, radius));
	}

	public void sendVelocityAddPacket(World world, EntityLivingBase target,
			double velX, double velY, double velZ) {
		if (world.isRemote) {
			return;
		}
		byte[] data = new DataWriter().add(target.getEntityId()).add(velX)
				.add(velY).add(velZ).generate();

		sendPacketToAllClientsNear(world.provider.dimensionId, target.posX,
				target.posY, target.posZ, 50.0D, (byte) 7, data);
	}

	@SideOnly(Side.CLIENT)
	public void requestAuras(EntityPlayer player) {
		DataWriter writer = new DataWriter();
		EntityPlayer localPlayer = Minecraft.getMinecraft().thePlayer;
		if (localPlayer == null) {
			return;
		}
		writer.add(localPlayer.getEntityId());
		writer.add(player.getEntityId());

		sendPacketToServer((byte) 31, writer.generate());
	}

	public void requestClientAuras(EntityPlayerMP player) {
		sendPacketToClientPlayer(player, (byte) 17, new byte[0]);
	}

	public void syncWorldName(EntityPlayerMP player, String name) {
		sendPacketToClientPlayer(player, (byte) 47, new DataWriter().add(name)
				.generate());
	}

	public void syncLoginData(EntityPlayerMP player, byte[] data) {
		sendPacketToClientPlayer(player, (byte) 42, data);
	}

	public void sendSpellbookSlotChange(EntityPlayerMP player,
			int inventoryIndex, int subID) {
		sendPacketToServer(
				(byte) 14,
				new DataWriter().add(subID).add(player.getEntityId())
						.add(inventoryIndex).generate());
	}

	public void sendShapeGroupChangePacket(int newCastingMode, int entityid) {
		byte[] packetData = new DataWriter().add(newCastingMode).add(entityid)
				.generate();
		sendPacketToServer((byte) 1, packetData);
	}

	public void sendStarImpactToClients(double x, double y, double z,
			World world, ItemStack spellStack) {
		DataWriter writer = new DataWriter().add(x).add(y).add(z);
		if (spellStack != null) {
			writer.add(true).add(spellStack);
		} else {
			writer.add(false);
		}
		sendPacketToAllClientsNear(world.provider.dimensionId, x, y, z, 64.0D,
				(byte) 48, writer.generate());
	}

	public void sendSilverSkillPointPacket(EntityPlayerMP player) {
		sendPacketToClientPlayer(player, (byte) 49, new byte[0]);
	}

	public void sendSpellApplyEffectToAllAround(EntityLivingBase caster,
			Entity target, double x, double y, double z, World world,
			ItemStack spellStack) {
		DataWriter writer = new DataWriter().add(x).add(y).add(z);
		if (spellStack != null) {
			writer.add(true).add(spellStack);
		} else {
			writer.add(false);
		}
		writer.add(caster.getEntityId());
		writer.add(target.getEntityId());

		sendPacketToAllClientsNear(world.provider.dimensionId, x, y, z, 64.0D,
				(byte) 44, writer.generate());
	}

	public void sendPowerRequestToServer(Vector3D location) {
		DataWriter writer = new DataWriter();
		writer.add((byte) 1);
		writer.add(location.x);
		writer.add(location.y);
		writer.add(location.z);

		sendPacketToServer((byte) 53, writer.generate());
	}

	public void sendPowerResponseToClient(NBTTagCompound powerData,
			EntityPlayerMP player, TileEntity te) {
		DataWriter writer = new DataWriter();
		writer.add((byte) 1);
		writer.add(powerData);
		writer.add(te.xCoord);
		writer.add(te.yCoord);
		writer.add(te.zCoord);

		sendPacketToClientPlayer(player, (byte) 53, writer.generate());
	}

	public void sendCapabilityChangePacket(EntityPlayerMP player,
			int capability, boolean state) {
		DataWriter writer = new DataWriter();
		writer.add(capability);
		writer.add(state);

		sendPacketToClientPlayer(player, (byte) 55, writer.generate());
	}

	public void sendExPropCommandToServer(int flag) {
		DataWriter writer = new DataWriter();
		writer.add(flag);
		sendPacketToServer((byte) 16, writer.generate());
	}

	public void sendCompendiumUnlockPacket(EntityPlayerMP player, String id,
			boolean isCategory) {
		DataWriter writer = new DataWriter();
		writer.add(id);
		writer.add(isCategory);

		sendPacketToClientPlayer(player, (byte) 46, writer.generate());
	}
}
