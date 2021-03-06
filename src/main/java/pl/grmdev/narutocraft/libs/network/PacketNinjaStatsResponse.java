package pl.grmdev.narutocraft.libs.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketNinjaStatsResponse implements IMessage {

	private int[] data;

	public static class PacketNinjaStatsResponseHandler implements IMessageHandler<PacketNinjaStatsResponse, IMessage> {

		@Override
		public IMessage onMessage(PacketNinjaStatsResponse message, MessageContext ctx) {
			// FIXME update
			// ExtendedProperties.get(Minecraft.getMinecraft().thePlayer).psa.setValues(message.data);
			return null;
		}
	}

	// Need a empty constructor just for the network registry to use
	public PacketNinjaStatsResponse() {

	}

	public PacketNinjaStatsResponse(int[] values) {
		this.data = values;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		// FIXME
		// this.data = new int[PlayerSkillsAtrributes.arraySize];
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