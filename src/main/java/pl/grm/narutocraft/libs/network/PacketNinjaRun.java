package pl.grm.narutocraft.libs.network;

import io.netty.buffer.*;
import net.minecraftforge.fml.common.network.simpleimpl.*;
import pl.grm.narutocraft.player.*;

public class PacketNinjaRun implements IMessage {
	private boolean	state;
	
	public static class PacketNinjaRunHandler implements IMessageHandler<PacketNinjaRun, IMessage> {
		
		@Override
		public IMessage onMessage(PacketNinjaRun message, MessageContext ctx) {
			ExtendedProperties.get(ctx.getServerHandler().playerEntity).ninjaRun = message.state;
			return null;
		}
	}
	
	// Need a empty constructor just for the network registry to use
	public PacketNinjaRun() {
		
	}
	
	public PacketNinjaRun(boolean state) {
		this.state = state;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.state = buf.readBoolean();
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeBoolean(state);
	}
}
