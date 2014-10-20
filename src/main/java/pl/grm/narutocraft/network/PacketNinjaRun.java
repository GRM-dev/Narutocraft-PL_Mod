package pl.grm.narutocraft.network;

import io.netty.buffer.ByteBuf;
import pl.grm.narutocraft.stats.ExtendedProperties;
import pl.grm.narutocraft.stats.PlayerSkillsAtrributes;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketNinjaRun implements IMessage {
	public static class PacketNinjaRunHandler implements IMessageHandler<PacketNinjaRun, IMessage> {
		
		@Override
		public IMessage onMessage(PacketNinjaRun message, MessageContext ctx) {
				ExtendedProperties.get(ctx.getServerHandler().playerEntity).ninjaRun = message.state;				
				return null;
		}
	}	
	private boolean	state;
	
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
