package pl.grm.narutocraft.libs.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import pl.grm.narutocraft.stats.ExtendedProperties;
import pl.grm.narutocraft.stats.PlayerSkillsAtrributes;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketNinjaStatsResponse implements IMessage {
	public static class PacketNinjaStatsResponseHandler implements IMessageHandler<PacketNinjaStatsResponse, IMessage> {
		@Override
		public IMessage onMessage(PacketNinjaStatsResponse message, MessageContext ctx) {
			ExtendedProperties.get(Minecraft.getMinecraft().thePlayer).psa
					.setValues(message.data);
			return null;
		}
		
	}
	
	private int[]	data;
	
	// Need a empty constructor just for the network registry to use
	public PacketNinjaStatsResponse() {
		
	}
	
	public PacketNinjaStatsResponse(int[] values) {
		this.data = values;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.data = new int[PlayerSkillsAtrributes.arraySize];
		for (int v = 0; v < this.data.length; v++) {
			this.data[v] = buf.readInt();
		}
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		for (int v : this.data) {
			buf.writeInt(v);
		}
	}
}
